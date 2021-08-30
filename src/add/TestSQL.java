import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;

public class TestSQL {

    private Connection con;
    private Statement st;
    private ResultSet rs;


    private int SELECT_INDEX = 0;
    private int INSERT_INDEX = 0;
    private int UPDATE_INDEX = 0;
    private int DELETE_INDEX = 0;

    private int idx;

    public void executeSQL(SQLParser.ParseContext ctx){

        try{
            String url = "jdbc:h2:tcp://localhost/~/test";
            String user = "sa";
            String pwd = "";

            con = DriverManager.getConnection(url,user,pwd);
            st = con.createStatement();

            SQLParser.SqlContext SQL = ctx.sql();
            for(int i=0;i<SQL.getChildCount();i+=2){

                String checkCOM = SQL.getChild(i).getChild(0).getText();  // check SELECT OR INSERT SQL
                String exSQL = "";

                if(checkCOM.equals("select") || checkCOM.equals("SELECT") ){
                    SQLParser.Select_stmtContext SELECT = SQL.select_stmt(SELECT_INDEX++);
                    for(int idx=0;idx<SELECT.getChildCount();idx++){
                        exSQL+=SELECT.getChild(idx).getText()+' ';
                    }
                    exSQL+=';';


                    System.out.println(exSQL);
                    rs = st.executeQuery(exSQL);

                    ResultSetMetaData rsmd = rs.getMetaData();
                    String[] columnNames = null;
                    int columnCnt = rsmd.getColumnCount();
                    columnNames = new String[columnCnt];

                    // column
                    for(int j=0;j<columnCnt;j++){
                        columnNames[j] = rsmd.getColumnName(j+1);
                        System.out.print(columnNames[j]+'\t');
                    }

                    // value
                    System.out.println();
                    while(rs.next()) {
                        for (String columnName: columnNames) {
                            // Print Column Name and value
                            System.out.print(rs.getObject(columnName));
                            System.out.print('\t');
                        }
                        System.out.println();
                    }

                }
                else {
                    try{
                        if(checkCOM.equals("insert into") || checkCOM.equals("INSERT INTO")) {
                            SQLParser.Insert_stmtContext CONTEXT = SQL.insert_stmt(INSERT_INDEX++);
                            for(int j=0;j<CONTEXT.getChildCount();j++) exSQL+=CONTEXT.getChild(j).getText()+' ';
                            exSQL+=';';
                        }
                        else if(checkCOM.equals("update") || checkCOM.equals("UPDATE")){
                            SQLParser.Update_stmtContext CONTEXT = SQL.update_stmt(UPDATE_INDEX++);
                            for(int j=0;j<CONTEXT.getChildCount();j++) exSQL+=CONTEXT.getChild(j).getText()+' ';
                            exSQL+=';';
                        }
                        else if(checkCOM.equals("delete") || checkCOM.equals("DELETE")){
                            SQLParser.Delete_stmtContext CONTEXT = SQL.delete_stmt(DELETE_INDEX++);
                            for(int j=0;j<CONTEXT.getChildCount();j++) exSQL+=CONTEXT.getChild(j).getText()+' ';
                            exSQL+=';';
                        }
                        System.out.println(exSQL);
                        st.executeUpdate(exSQL);
                    }
                    catch(Exception e){
                        System.out.println("SQL error : "+e.getMessage());
                    }
                }
            }
            con.close();
            st.close();
            rs.close();
        }
        catch(SQLException e) {
            System.out.println("DB error : " + e.getMessage());
        }
    }

    public ParseTree makeTree(String[] args) throws Exception {
        System.out.println("file input success");
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
        return tree;
    }
}