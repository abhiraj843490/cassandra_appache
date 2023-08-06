package com.cassandra.demo.cassandra.controller;

import com.cassandra.demo.cassandra.csvToData.CsvToData;
import com.cassandra.demo.cassandra.model.CsvModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("init")
public class HomeController {
    @Autowired
    CsvToData csvToData;

    @GetMapping("/csvtodatabase")
    public List<CsvModel> csvToDatabase() {
        return csvToData.csvBlogToDatabase();
    }
}
