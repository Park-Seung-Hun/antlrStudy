import org.antlr.v4.misc.OrderedHashMap;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.util.List;
import java.util.Map;

public class TestSQLListener {

    public static class SQLLoader extends SQLBaseListener {
        Map<String,String> props = new OrderedHashMap<String,String>();

        private int SELECT_INDEX =0;
        private int INSERT_INDEX =0;
        private int idx;
        public void exitParse(SQLParser.ParseContext ctx) {
            // ctx를 통해 parse tree의 요소에 접근 가능


            // 구현해야될 사항
            // 1. 해당 SQL 문이 insert인지 select인지 판별
            // 2-1. insert 문인 경우 table 과 values 값 추출
            // 2-2. select 문인 경우 column 과 table 값 추출

            for(int i=0;i<ctx.getChildCount();i+=2){ // SCOL(;) 때문에 인덱스+2, SQL 문이 들어간 파일
                String checkCOM = ctx.getChild(i).getChild(0).getText();  // 어떤 SQL인지 check

                if(checkCOM.equals("select") || checkCOM.equals("SELECT") ){
                   System.out.println("Select 문입니다.");

                   SQLParser.Select_stmtContext SELECT = ctx.select_stmt(SELECT_INDEX);
                   for(idx=0;idx<SELECT.table().size();idx++){
                       System.out.println("테이블 입니다 : " + SELECT.table(idx).table_name().getText());
                   }
                   for(idx=0;idx<SELECT.result_column().size();idx++){
                        System.out.println("컬럼 입니다 : " + SELECT.result_column(idx).getText());
                   }

                   SELECT_INDEX++;
                }
                else if (checkCOM.equals("insert into") || checkCOM.equals("INSERT INTO")){
                    System.out.println("Insert 문입니다.");

                    SQLParser.Insert_stmtContext INSERT = ctx.insert_stmt(INSERT_INDEX);

                    System.out.println("테이블 입니다 : " + INSERT.table_name().getText() );
                    for(idx=0;idx<INSERT.column_name().size();idx++){
                        System.out.println("컬럼 입니다 : " + INSERT.column_name(idx).getText());
                    }
                    for(idx=0;idx< INSERT.expr().size();idx++){
                        System.out.println("값 입니다 : " + INSERT.expr(idx).getText());
                    }


                    INSERT_INDEX++;
                }
                else {
                    // 에러가 발생할 경우 처리과정!!
                    System.out.println("꽝");
                }
            }

        }
    }

    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if( args.length >0) inputFile=args[0];
        InputStream is =System.in;
        if(inputFile != null){
            is = new FileInputStream(inputFile);
        }

        ANTLRInputStream input = new ANTLRInputStream(is);
        SQLLexer lexer = new SQLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SQLParser parser = new SQLParser(tokens);
        ParseTree tree = parser.parse();

        // create a standard ANTLR parse tree walker
        ParseTreeWalker walker = new ParseTreeWalker();
        // create listener then feed to walker
        SQLLoader loader = new SQLLoader();
        walker.walk(loader, tree);        // walk parse tree
        //System.out.println(loader.props); // print results
    }
}
