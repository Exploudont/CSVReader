# CSVFileReader

Simple CSV reader

## How it works
This package use the basic interface `Record`.

All data in a CSV file are `Record`.

a csv file row is a `CSVRecord` Object that can get all camps.

## What you can do
You can Create `CSVRecord` Objects.

Example of creating a `CSVRecord` Object.
``` Java
import record.Record;
import record.csv.CSVRecord;

...

String[] datas = new String[] {"fist camp", "second camp", "third camp"};
Record r = new CSVRecord(datas);
```

You can read and write `CSVRecord` Objects from/to file.



### Examples

Reading operation: 

``` Java
import java.util.Collection;
import java.util.List;

import record.Record;
import record.csv.CSVRecord;
import record.csv.io.CSVReader;

...

String file = "input_file.csv";
List<Record> r = CSVReader.readAll(file);
```


Writing operation:
``` Java
import java.util.Collection;
import java.util.List;

import record.Record;
import record.csv.CSVRecord;
import record.csv.io.CSVWriter;

...

List<Record> r;
String file = "output_file.csv";
CSVWriter.writeAll(file, r);
```