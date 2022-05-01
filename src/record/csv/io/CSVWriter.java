package record.csv.io;

import record.Record;
import record.csv.CSVRecord;

import java.io.Closeable;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

import java.io.IOException;

import java.util.Collection;
import java.util.List;

/**
CSV File Writer.
*/
public class CSVWriter
				implements Closeable
	{
	
	/**
	Default regex for CSV Files.
	*/
	public static final String DEFAULT_REGEX = ";";
	
	
	/**
	Create a CSVWriter Object.
	@params file_path the path for the csv file
	@params append if true, then bytes will be written to the end of the file rather than the beginning
	@params regex the regex used to separe the camps values
	*/
	public CSVWriter(String file_path, String regex, boolean append) throws Exception {
		bw = new BufferedWriter(new FileWriter(new File(file_path), append));
		this.regex = regex;
	}
	
	/**
	Create a CSVWriter Object.
	@params file_path the path for the csv file
	@params regex the regex used to separe the camps values
	*/
	public CSVWriter(String file_path, String regex) throws Exception {
		this(file_path, regex, false);
	}
	
	
	/**
	Create a CSVWriter Object.
	By default use the default regex.
	@params file_path the path for the csv file
	@params append if true, then bytes will be written to the end of the file rather than the beginning
	*/
	public CSVWriter(String file_path, boolean append) throws Exception {
		this(file_path, DEFAULT_REGEX, append);
	}
	
	
	/**
	Create a CSVWriter Object.
	By default use the default regex.
	@params file_path the path for the csv file
	*/
	public CSVWriter(String file_path) throws Exception {
		this(file_path, DEFAULT_REGEX, false);
	}
	
	
	/**
	Write a single CSVRecord Object.
	@params csv_rec the CSVRecord Object
	*/
	public void write(CSVRecord csv_rec) throws Exception {
		bw.write(to_csv_string(csv_rec));
	}
	
	/**
	Used to split the encode from the write operation.
	@params csv_rec the CSVRecord Object
	*/
	private String to_csv_string(CSVRecord csv_rec) {
		String[] values = csv_rec.getStringArray();
		
		StringBuilder sb = new StringBuilder();
		sb.append(values[0]);
		for(int i=1; i<values.length ; i++)
			sb.append(regex + values[i]);
		
		return sb.toString() + "\n";
	}
	
	/**
	Write on file all Record Object
	@params file_path the path for the csv file
	@params append if true, then bytes will be written to the end of the file rather than the beginning
	@params regex the regex used to separe the camps values
	@params records list of Record Objects
	*/
	public static void writeAll(String file_path, String regex, boolean append, List<Record> records) throws Exception {
		CSVWriter writer = new CSVWriter(file_path, regex, append);
		
		for(Record r : records)
			writer.write(new CSVRecord(r));
		
		writer.close();
	}
	
	/**
	Write on file all Record Object
	By default use the default regex.
	@params file_path the path for the csv file
	@params append if true, then bytes will be written to the end of the file rather than the beginning
	@params records list of Record Objects
	*/
	public static void writeAll(String file_path, boolean append, List<Record> records) throws Exception {
		writeAll(file_path, CSVWriter.DEFAULT_REGEX, append, records);
	}

	/**
	Write on file all Record Object
	@params file_path the path for the csv file
	@params regex the regex used to separe the camps values
	@params records list of Record Objects
	*/
	public static void writeAll(String file_path, String regex, List<Record> records) throws Exception {
		writeAll(file_path, regex, false, records);
	}
	
	/**
	Write on file all Record Object
	By default use the default regex.
	@params file_path the path for the csv file
	@params records list of Record Objects
	*/
	public static void writeAll(String file_path, List<Record> records) throws Exception {
		writeAll(file_path, CSVWriter.DEFAULT_REGEX, false, records);
	}
	
	
	@Override
	public void close() throws IOException {
		bw.close();
	}
	
	
	private BufferedWriter bw;
	private String regex;
}