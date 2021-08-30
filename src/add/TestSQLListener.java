import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class TestSQLListener {

    public static class SQLLoader extends SQLBaseListener {
        public void exitParse(SQLParser.ParseContext ctx) {
            TestSQL lt = new TestSQL();
            lt.executeSQL(ctx);
        }
    }

    public static void main(String[] args) throws Exception {

        TestSQL input = new TestSQL();
        System.out.println("Listener");
        ParseTree tree = input.makeTree(args);

        ParseTreeWalker walker = new ParseTreeWalker();
        SQLLoader loader = new SQLLoader();
        walker.walk(loader, tree);

    }
}