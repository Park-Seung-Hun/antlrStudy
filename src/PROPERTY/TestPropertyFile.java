import org.antlr.v4.misc.OrderedHashMap;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.util.Map;

public class TestPropertyFile {
    public static class PropertyFileLoader extends PropertyFileBaseListener {
        Map<String, String> props = new OrderedHashMap<String, String>();

        public void exitProp(PropertyFileParser.PropContext ctx) {
            // ctx를 통해 parse tree의 요소에 접근 가능
            System.out.println(ctx.ID().getText() + ' '+ ctx.ID().getText());
            String id = ctx.ID().getText();
            String value = ctx.STRING().getText();
            props.put(id, value);
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
            PropertyFileLexer lexer = new PropertyFileLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            PropertyFileParser parser = new PropertyFileParser(tokens);
            ParseTree tree = parser.file();

            // create a standard ANTLR parse tree walker
            ParseTreeWalker walker = new ParseTreeWalker();
            // create listener then feed to walker
            PropertyFileLoader loader = new PropertyFileLoader();
            walker.walk(loader, tree);        // walk parse tree
            System.out.println(loader.props); // print results
        }
}

