package analyse.abstraction.mappers.javamapper;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;

import analyse.infrastructure.antlr.javaLexer;
import analyse.infrastructure.antlr.javaParser;

public class JavaASTGenerator {
	
	public CommonTree generateAST(String filePath) throws Exception {
        // Read the source

        CharStream c = new ANTLRFileStream(filePath,"UTF-8");

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
        return (CommonTree) ret.getTree();
        
        // Print the tree
    }

    static final TreeAdaptor adaptor = new CommonTreeAdaptor() {
        public Object create(Token payload) {
            return new CommonTree(payload);
        }
    };
}
