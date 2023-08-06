package com.cassandra.demo.cassandra.repo;

import com.cassandra.demo.cassandra.model.User;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public interface UserRepo extends CassandraRepository<User, Integer> {
    @AllowFiltering
    Object findByName(String name);
}
