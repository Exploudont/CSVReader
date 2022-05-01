import record.Record;
import record.csv.CSVRecord;
import record.csv.io.CSVReader;
import record.csv.io.CSVWriter;

import java.util.Collection;
import java.util.List;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws Exception {
		List<Record> r = CSVReader.readAll(args[0]);
		r.forEach(tmp -> System.out.println(tmp.toString()));
		CSVWriter.writeAll("prova.csv", r);
	}
}