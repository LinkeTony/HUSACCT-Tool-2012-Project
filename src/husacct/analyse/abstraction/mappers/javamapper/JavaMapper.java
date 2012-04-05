package husacct.analyse.abstraction.mappers.javamapper;

import husacct.analyse.abstraction.mappers.codemapper.GenericMapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.tree.CommonTree;


public class JavaMapper implements GenericMapper{
	public static String programmingLanguage = "Java";
	JavaASTGenerator astGenerator = new JavaASTGenerator();
	ASTScanner astScanner = new ASTScanner();
	
	@Override
	public void analyseApplication(String workspacePath) {
		try {
			analyse(workspacePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	
	private void analyse(String workspacePath) throws Exception {
		List<MetaFile> paths = walk(workspacePath);
		int linenumbers = 0;
		for (MetaFile metaFile : paths){
			System.out.println(metaFile.getPath() + " file " + paths.indexOf(metaFile) + "/" + paths.size());
			System.out.println("Number of lines: " + metaFile.getLineNumber());
			JavaASTGenerator astGenerator = new JavaASTGenerator();
			CommonTree ast = astGenerator.generateAST(metaFile.getPath());
			astScanner.generateFamixModelFromAST(ast);
			linenumbers += metaFile.getLineNumber();
			System.out.println(linenumbers);
		}
	}
	private List<MetaFile> walk(String path) throws IOException {
		File root = new File(path);
		File[] list = root.listFiles();
		List<MetaFile> paths = new ArrayList<MetaFile>();
		for (File f : list) {
			if (f.isDirectory()) {
				paths.addAll(walk(f.getAbsolutePath()));
			}
			else {
				if (getSourceFiles(f.getAbsolutePath())){
					LineNumberReader  lnr = new LineNumberReader(new FileReader(f));
					lnr.skip(Long.MAX_VALUE);
					paths.add(new MetaFile(f.getAbsolutePath(),lnr.getLineNumber()));
				}
			}
		}
		return paths;
	}

	private List<MetaFile> walkEveryFile(File f, List<MetaFile> paths) throws IOException {
		if (f.isDirectory()) {
			paths.addAll(walk(f.getAbsolutePath()));
		}
		else {
			if (getSourceFiles(f.getAbsolutePath())){
				LineNumberReader  lnr = new LineNumberReader(new FileReader(f));
				lnr.skip(Long.MAX_VALUE);
				paths.add(new MetaFile(f.getAbsolutePath(),lnr.getLineNumber()));
			}
		}
		return paths;
	}

	private boolean getSourceFiles(String filepath) {
		int extensionIndex = filepath.lastIndexOf(".");
		String extension = filepath.substring(extensionIndex, filepath.length());
		return extension.equals(".java");
	}

}
