package com.cassandra.demo.cassandra.csvToData;

import com.cassandra.demo.cassandra.model.CsvModel;

import java.util.List;

public interface CsvToData {
    public enum HEADERS {
        id, series_reference, period, data_value, status,units,magnitude,subject,group
    }

    public void initDatabase();
    public List<CsvModel> csvBlogToDatabase();
}
