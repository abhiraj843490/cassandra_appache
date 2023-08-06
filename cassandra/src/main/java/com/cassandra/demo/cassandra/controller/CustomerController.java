package com.cassandra.demo.cassandra.controller;

import com.cassandra.demo.cassandra.service.CusDataImoprtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class CustomerController {
    @Autowired
    private CusDataImoprtService imoprtService;
    @PostMapping("/import")
    public Object importData(@RequestParam("file")MultipartFile file) throws IOException {
            return imoprtService.importJsonToData(file);
    }

}
