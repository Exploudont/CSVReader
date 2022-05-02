# CSVFileReader

Simple CSV reader

## How it works
This package use the basic interface Record.
All data in a CSV file are Records.
a csv file row is a CSVRecord Object that can get all camps.

## What you can do
You can Create CSVRecord Objects.
You can read and write CSVRecord Objects from/to file.

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