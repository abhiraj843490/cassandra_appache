//package com.cassandra.demo.cassandra.service;
//
//import com.cassandra.demo.cassandra.model.Customer;
//import com.cassandra.demo.cassandra.repo.CustomerRepo;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.UUID;
//
//@Service
//public class CusDataImoprtService {
//    @Autowired
//    CustomerRepo customerRepo;
//    public Object importJsonToData(MultipartFile file) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//
//
//        List<Customer>customers = objectMapper
//                .readValue(file.getInputStream(),
//                objectMapper.getTypeFactory()
//                        .constructCollectionType(List.class, Customer.class));
//        customerRepo.saveAll(customers);
//        return customerRepo.saveAll(customers);
//
//    }
//}
package com.cassandra.demo.cassandra.service;

import com.cassandra.demo.cassandra.model.Customer;
import com.cassandra.demo.cassandra.repo.CustomerRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class CusDataImoprtService {
    @Autowired
    CustomerRepo customerRepo;

    public List<Future<Customer>> importJsonToData(MultipartFile file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Customer> customers = objectMapper.readValue(file.getInputStream(),
                objectMapper
                        .getTypeFactory()
                        .constructCollectionType(List.class, Customer.class));

        ExecutorService executorService = Executors
                .newFixedThreadPool(10);

        List<Future<Customer>> futures = new ArrayList<>();

        for (Customer customer : customers) {
            Future<Customer> future = executorService.submit(() -> customerRepo.save(customer));
            futures.add(future);
        }

        executorService.shutdown();

        return futures;
    }
}