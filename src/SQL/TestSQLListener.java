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
            // ctx�� ���� parse tree�� ��ҿ� ���� ����


            // �����ؾߵ� ����
            // 1. �ش� SQL ���� insert���� select���� �Ǻ�
            // 2-1. insert ���� ��� table �� values �� ����
            // 2-2. select ���� ��� column �� table �� ����

            for(int i=0;i<ctx.getChildCount();i+=2){ // SCOL(;) ������ �ε���+2, SQL ���� �� ����
                String checkCOM = ctx.getChild(i).getChild(0).getText();  // � SQL���� check

                if(checkCOM.equals("select") || checkCOM.equals("SELECT") ){
                   System.out.println("Select ���Դϴ�.");

                   SQLParser.Select_stmtContext SELECT = ctx.select_stmt(SELECT_INDEX);
                   for(idx=0;idx<SELECT.table().size();idx++){
                       System.out.println("���̺� �Դϴ� : " + SELECT.table(idx).table_name().getText());
                   }
                   for(idx=0;idx<SELECT.result_column().size();idx++){
                        System.out.println("�÷� �Դϴ� : " + SELECT.result_column(idx).getText());
                   }

                   SELECT_INDEX++;
                }
                else if (checkCOM.equals("insert into") || checkCOM.equals("INSERT INTO")){
                    System.out.println("Insert ���Դϴ�.");

                    SQLParser.Insert_stmtContext INSERT = ctx.insert_stmt(INSERT_INDEX);

                    System.out.println("���̺� �Դϴ� : " + INSERT.table_name().getText() );
                    for(idx=0;idx<INSERT.column_name().size();idx++){
                        System.out.println("�÷� �Դϴ� : " + INSERT.column_name(idx).getText());
                    }
                    for(idx=0;idx< INSERT.expr().size();idx++){
                        System.out.println("�� �Դϴ� : " + INSERT.expr(idx).getText());
                    }


                    INSERT_INDEX++;
                }
                else {
                    // ������ �߻��� ��� ó������!!
                    System.out.println("��");
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
