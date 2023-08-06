package com.cassandra.demo.cassandra.repo;

import com.cassandra.demo.cassandra.model.Customer;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CassandraRepository<Customer, Integer> {
}
