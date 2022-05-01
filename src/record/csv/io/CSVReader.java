package record.csv.io;


import record.Record;
import record.csv.CSVRecord;

import java.io.Closeable;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

import java.io.IOException;

import java.util.Collection;
import java.util.List;
import java.util.LinkedList;

/**
CSV File Reader.
*/
public class CSVReader
				implements Closeable
	{
	
	/**
	Default regex for CSV Files.
	*/
	public static final String DEFAULT_REGEX = ";";
	
	/**
	Create a CSVReader Object.
	@params file_path the path for the csv file
	@params the regex used to separe the camps values
	*/
	public CSVReader(String file_path, String regex) throws Exception {
		br = new BufferedReader(new FileReader(new File(file_path)));
		this.regex = regex;
	}
	
	/**
	Create a CSVReader Object.
	By default use the default regex.
	@params file_path the path for the csv file
	*/
	public CSVReader(String file_path) throws Exception {
		this(file_path, DEFAULT_REGEX);
	}
	
	/**
	Read a single CSVRecord Object.
	@return the readed CSVRecord Object
	*/
	public CSVRecord read() throws Exception {
		String line = br.readLine();
		if(line != null)
			return new CSVRecord(line.split(regex));
		return null;
	}
	
	/**
	Read all CSVRecord Objects from file.
	@params file_path the path for the csv file
	@params the regex used to separe the camps values
	@return list of readed CSVRecord
	*/
	public static List<Record> readAll(String file_path, String regex) throws Exception {
		CSVReader reader = new CSVReader(file_path, regex);
		List<Record> l = new LinkedList<Record>();
		
		CSVRecord tmp;
		while((tmp = reader.read()) != null)
			l.add(tmp);
		reader.close();
		return l;
	}
	
	/**
	Read all CSVRecord Objects from file.
	By default use the default regex.
	@params file_path the path for the csv file
	@return list of readed CSVRecord
	*/
	public static List<Record> readAll(String file_path) throws Exception {
		return readAll(file_path, CSVReader.DEFAULT_REGEX); 
	}
	
	@Override
	public void close() throws IOException {
		br.close();
	}
	
	
	private BufferedReader br;
	private String regex;
}