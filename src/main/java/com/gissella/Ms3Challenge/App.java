package com.gissella.Ms3Challenge;

import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
 * * 1. We need a Java application that will consume a CSV file, parse the data,
 * and insert valid records into a SQLite database. a. Database name:
 * <input-filename>.db b. It should have 1 table with 10 columns, A, B, C, D, E,
 * F, G, H, I, J, that correspond to the CSV file column header names.
 *
 * 2. Each record needs to be verified to contain the right number of data
 * elements to match the columns. a. Records that do not match the column count
 * must be written to: <input-filename>-bad.csv
 */

public class App {

	public static void main(String[] args) throws IOException {
		List<String[]> records;

		// create tables for valid entries and invalid entries
		NewTable valid = new NewTable();
		valid.validTableEntries();
		NewTable invalid = new NewTable();
		invalid.invalidTableEntries();

		// parse contents of the given file into records
		ParseContents content = new ParseContents();
		records = content.lists();

		// insert records into the databases
		Insert app = new Insert();
		app.insertValid(records);
		app.insertInvalid(records);

		// write to log
		log();
	}

	/*
	 * write statistics to a log file
	 */
	public static void log() throws IOException {
		// write to log
		Logger log = Logger.getLogger("MyLog");
		FileHandler fh;

		try {
			// This block configure the logger with handler and formatter
			fh = new FileHandler("C:/Users/Gichelli/eclipse-workspace/Ms3Challenge/sqlite/log.txt");
			log.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

			// the following statement is used to log any messages
			log.info("# of records received " + ParseContents.records.size());
			log.info("# of records sucessful " + (ParseContents.records.size() - ParseContents.invalidIndex.length));
			log.info("# of records failed " + ParseContents.invalidIndex.length);
			log.info("\"Databases have been updated sucessfully");

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
