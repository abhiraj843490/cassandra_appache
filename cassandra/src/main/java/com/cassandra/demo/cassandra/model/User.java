package com.cassandra.demo.cassandra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @PrimaryKey
    private Integer id;
    private String name;
    private String address;
    private Integer age;

    public User(int i, String name, String address, int age) {
    }
}
