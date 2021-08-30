import org.antlr.v4.runtime.tree.ParseTree;

public class TestSQLVisitor {

    public static class SQLVisitor extends SQLBaseVisitor<Void> {
        public Void visitParse(SQLParser.ParseContext ctx) {
            TestSQL vt = new TestSQL();
            vt.executeSQL(ctx);
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        TestSQL input = new TestSQL();
        System.out.println("Visitor");
        ParseTree tree = input.makeTree(args);

        SQLVisitor visitor = new SQLVisitor();
        visitor.visit(tree);

    }

}