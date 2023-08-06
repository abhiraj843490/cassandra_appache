package com.cassandra.demo.cassandra.repo;

import com.cassandra.demo.cassandra.model.CsvModel;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface BlogPostRepository extends CassandraRepository<CsvModel,String> {
}
