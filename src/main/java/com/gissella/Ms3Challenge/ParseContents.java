package com.gissella.Ms3Challenge;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ParseContents {
	private static final String file = "C:/Users/Gichelli/eclipse-workspace/Ms3Challenge/codingChallenge.csv";
	private static int size = 0;	
	static int invalidIndex[];
	static List<String[]> records;
	
/*
 * Calculate size of array of invalid entries
 */
	public static int size() throws IOException {
		int i = 0;
		
		try (Reader reader = Files.newBufferedReader(Paths.get(file));
				CSVReader skipHeader = new CSVReaderBuilder(reader).withSkipLines(1).build();) {
			records = skipHeader.readAll();
			//calculate size of invalid entries			
			for (int x = 0; x < records.size() - 1; x++) {				
				if (records.get(i)[0].equals("") || records.get(i)[1].equals("") || records.get(i)[2].equals("")
						|| records.get(i)[3].equals("") || records.get(i)[4].equals("") || records.get(i)[5].equals("")
						|| records.get(i)[6].equals("") || records.get(i)[7].equals("") || records.get(i)[8].equals("")
						|| records.get(i)[9].equals("")) {
					size++;
				}
				i++;
			}
		}
		return size;
	}
	
	/*
	 * This method has a list that contains all the entries in the database
	 */
	public List<String[]> lists() throws IOException {	
		int i = 0;
		int j = 0;
		//array that has the indexes of invalid entries for the database-bad
		invalidIndex = new int[size()];
		
		try (Reader reader = Files.newBufferedReader(Paths.get(file));
				CSVReader skipHeader = new CSVReaderBuilder(reader).withSkipLines(1).build();) {
			// Reading all the queries contained in the csv file at once. The result will be
			// a list of strings
			records = skipHeader.readAll();
				
			for (int x = 0; x < records.size() - 1; x++) {
				// if one of the queries is an empty string add it to an invalidIndex array.
				// This array will be
				// used to populate the invalid database entries
				if (records.get(i)[0].equals("") || records.get(i)[1].equals("") || records.get(i)[2].equals("")
						|| records.get(i)[3].equals("") || records.get(i)[4].equals("") || records.get(i)[5].equals("")
						|| records.get(i)[6].equals("") || records.get(i)[7].equals("") || records.get(i)[8].equals("")
						|| records.get(i)[9].equals("")) {
					invalidIndex[j] = i;
					size++;
					j++;
				}
				i++;
			}
		}
		return records;
	}
}
