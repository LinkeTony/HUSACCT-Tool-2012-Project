package main;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;

import analyse.abstraction.mappers.javamapper.antlr.javaLexer;
import analyse.abstraction.mappers.javamapper.antlr.javaParser;

public class Main {

    public static void main(String[] args) throws Exception {
        new Main().init();
    }
    

    public void init() throws Exception {
        // Read the source

        CharStream c = new ANTLRFileStream(
            "/Users/Erik/Documents/Hogeschool Utrecht/Jaar 3/Specialisatie/ThemaOpdracht/Soccerapp/Workspace/Soccer/src/controller/ExceptionController.java","UTF-8");

        // create the lexer attached to stdin
        Lexer lexer = new javaLexer(c);

        // create the buffer of tokens between the lexer and parser
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // create the parser attached to the token buffer
        // and tell it which debug event listener to use
        javaParser parser = new javaParser(tokens);

        // launch the parser using the treeadaptor
        parser.setTreeAdaptor(adaptor);

        // Get the compilation unit item
        javaParser.compilationUnit_return ret = parser.compilationUnit();

        // Get the associated tree
        CommonTree tree = (CommonTree) ret.getTree();
        
        // Print the tree
        printTree(tree, 1);
    }

    static final TreeAdaptor adaptor = new CommonTreeAdaptor() {
        public Object create(Token payload) {
            return new CommonTree(payload);
        }
    };

    public void printTree(CommonTree t, int indent) {
        System.out.println(t.toString());
        printTreeHelper(t, indent);
    }

    private void printTreeHelper(CommonTree t, int indent) {
        if (t != null) {
            StringBuffer sb = new StringBuffer(indent);
            for (int i = 0; i < indent; i++)
                sb = sb.append("   ");
            for (int i = 0; i < t.getChildCount(); i++) {
                //if (t.getChild(i).getType()==4)
                System.out.println(sb.toString() + t.getChild(i).toString()
                + " [" + javaParser.tokenNames[t.getChild(i).getType()]
                + "]");
                printTreeHelper((CommonTree) t.getChild(i), indent + 1);
            }
        }
    }
}