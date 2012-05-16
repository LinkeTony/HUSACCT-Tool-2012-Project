# HUSACCT Java Recognition Test (White-Box Test Analyse Java Component)


This is the recognition test for the analyse-component of the HUSACCT. This tests is used for
checking the correctness of the recognised dependencies in java-code. All kinds of calls to classes, enumerations,
generics, interfaces, abstract classes etcetera are embedded in the source. This test enables developers and testers
for the java-analyser to test the correctness of the Analyse Java Component. 


## Why this recognition test?

The important difference with the benchmark application for the Husacct-project, is that
this test is really about checking the correctness of detecting dependencies, based on imports
that are used and how the type is declared in the source code. 

An example of the test-case is the difference between the following calls:


1. import package.TheClass    .....   private Class AClass extends TheClass
2. ................................   private Class AClass extends package.TheClass

## Important : Preperation & Rules

This tests uses a pre-defined source-code to check to correctness of the java-analyser. Implemented in the HUSACCT-tool. The following things have to be done, before or after performing this test. 

###Loading the ‘Java Recognition Test’-application

1.	Open Eclipse IDE. Create a new Java-project with name ‘Java Recognition Test’
2.	Open your command prompt and ‘cd’ to until you are in the project folder. 
3.	Type the following commands now:
	a.	git init    <ENTER>
	b.	git remote add origin git@github.com:HUSACCT/HUSACCT-RecognitionTest.git  <ENTER>
	c.	git pull origin master   <ENTER>
	d.	Go back to eclipse, select the project and click ‘project->refresh’   
	e.	The Application, including this document and a result-folder, should now be loaded successfully.


###Publishing a Test-Result

One important thing to always keep in mind: Do not overwrite the file ‘Recognition Test Java.docx’, but save your results in the ‘results’-folder in the java-project. The name for your document should consist of the following parts: ‘Results <Day>-<Month>-<Year>.docx’. 



### Eclipse IDE

This tests needs to be performed, using Eclipse IDE.