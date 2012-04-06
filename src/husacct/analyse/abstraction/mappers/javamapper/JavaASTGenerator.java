package husacct.analyse.abstraction.mappers.javamapper;

import husacct.analyse.infrastructure.antlr.*;
import husacct.analyse.infrastructure.antlr.JavaParser.javaSource_return;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.TreeAdaptor;




public class JavaASTGenerator {
	
	public JavaTreeParser generateAST(String filePath) throws Exception {
        // Read the source

        CharStream c = new ANTLRFileStream(filePath,"UTF-8");

        // create the lexer attached to stdin
        Lexer lexer = new JavaLexer(c);

        // create the buffer of tokens between the lexer and parser
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        JavaParser parser = new JavaParser(tokens);
        
        javaSource_return javasource = parser.javaSource();
        
        CommonTree t = (CommonTree)javasource.getTree();
        
        CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
        
        nodes.setTokenStream(tokens);
        
        JavaTreeParser treeParser = new JavaTreeParser(nodes);
        
        treeParser.javaSource();
        // Get the associated tree
        return treeParser;
        // Print the tree
    }

    static final TreeAdaptor adaptor = new CommonTreeAdaptor() {
        public Object create(Token payload) {
            return new CommonTree(payload);
        }
    };
}
