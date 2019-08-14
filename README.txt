a. Summary of the purpose of this repo.
This application will consume a CSV file, parse the data and insert valid records into a SQLite database named CodeChallenge.md.
Valid records correspond to the entries that contain all the data to fill all of the columns for the records.
The invalid records will be inserted into a SQLite database named CodeChallenge_bad.md.
Invalid entries are the ones that are missing some fields in the lists of records.

b. Steps for getting this app running
	Maven project is created with Eclipse.
	1. We have to connect to the SQLite database using SQLite driver JDBC driver. 
	-Download the SQL JDBC Driver can be found here: https://bitbucket.org/xerial/sqlite-jdbc/downloads/
	-Add driver JAR file to your project: 
		copy JAR into java folder of the project
		right click on source folder-> build path -> configure build path -> libraries -> add external path -> select the copied JAR
	
	2. When creating tables we need to specify the connection string
		The SQLite JDBC driver allows you to load an SQLite database from the file system using the following connection string
		jdbc:sqlite:C: (here add the file path of your project)
		
	
	3. In insert.java, we have to add the file path plus the name of the database that will be created. The file created will be placed into sqlite 
	(folder manually created)
	String url = "jdbc:sqlite:C: your file path  + /sqlite/codingChallenge.db";
	for invalid entries we have
	String url = "jdbc:sqlite:C: your file path  + e/sqlite/codingChallenge_bad.db";

	4. In ParseContents.java we import the file with:
	private static final String file = "C: your directory path /codingChallenge.csv";
	
	5. Add the following to pom.xml file
	<dependency>
		<groupId>com.opencsv</groupId>
		<artifactId>opencsv</artifactId>
		<version>4.0</version>
	</dependency>