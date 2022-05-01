package record.csv;

import record.Record;

/**
Descrive a line into CSV File.
*/
public class CSVRecord implements Record {
	
	/**
	Create a CSV Object passing the camp values.
	@params values the camp values
	*/
	public CSVRecord(String[] values) {
		this.values = values;
	}
	
	/**
	Create a CSV Object passing an existing Record.
	@params record another Record istance
	*/
	public CSVRecord(Record record) {
		this.values = record.getStringArray();
	}
	
	/**
	Return a specific camp.
	@params pos the position of the camp
	@return the value of the camp
	*/
	public String get(int pos) {
		return this.values[pos];
	}
	
	@Override
	public String[] getStringArray() {
		return this.values;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<values.length ; i++)
			sb.append(values[i] + " ");
		
		return sb.toString();
	}
	
	private String[] values;
}