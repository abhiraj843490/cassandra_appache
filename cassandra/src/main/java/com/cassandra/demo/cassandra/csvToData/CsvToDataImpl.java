package com.cassandra.demo.cassandra.csvToData;

import com.cassandra.demo.cassandra.model.CsvModel;
import com.cassandra.demo.cassandra.repo.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Repository
public class CsvToDataImpl implements CsvToData{
    @Autowired
    BlogPostRepository blogpostRepository;
    @Override
    public void initDatabase() {
        csvBlogToDatabase();
        return;
    }

    @Override
    public List<CsvModel> csvBlogToDatabase() {
        List<CsvModel> blogPosts = new ArrayList<>();
        try(Reader in = new FileReader(getClass().getClassLoader()
                .getResource("data_balance.csv").getPath()))
        {
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader(HEADERS.class).parse(in);
            records.iterator().next();
            ExecutorService s = Executors.newFixedThreadPool(10);
            while(records.iterator().hasNext())
            {
                CSVRecord record = records.iterator().next();
                CsvModel cm = new CsvModel();

                cm.setId(record.get(HEADERS.id));
                cm.setSeries_reference(record.get(HEADERS.series_reference));
                cm.setData_value(record.get(HEADERS.data_value));
                cm.setGroup(record.get(HEADERS.group));
                cm.setPeriod(record.get(HEADERS.period));
                cm.setMagnitude(record.get(HEADERS.magnitude));
                cm.setSubject(record.get(HEADERS.subject));
                cm.setStatus(record.get(HEADERS.status));
                cm.setUnits(record.get(HEADERS.units));
                blogPosts.add(cm);
                s.submit(()->{
                    blogpostRepository.save(cm);
                });
            }
            s.shutdown();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }
//        blogpostRepository.saveAll(blogPosts);
        return blogPosts;
    }
}
