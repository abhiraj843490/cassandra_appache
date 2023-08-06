package com.cassandra.demo.cassandra.controller;
import java.util.ArrayList;
import java.util.List;
import com.cassandra.demo.cassandra.model.CsvModel;
import com.cassandra.demo.cassandra.repo.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogPostController {

    @Autowired
    BlogPostRepository blogspotrepo;

    @GetMapping("/all")
    public List<CsvModel> getBlogPosts() {
        Iterable<CsvModel> result = blogspotrepo.findAll();
        List<CsvModel> blogpostList = new ArrayList<CsvModel>();
        result.forEach(blogpostList::add);
        return blogpostList;
    }

    @PostMapping("/")
    public CsvModel addBlogSpot(@RequestBody CsvModel bp) {
        blogspotrepo.save(bp);
        return bp;
    }
    @PutMapping
    public CsvModel updateInfo(){
        CsvModel model = new CsvModel();
        return model;
    }
    @GetMapping("/get/{id}")
    public CsvModel getInfo(@PathVariable(name = "id")String id ){
        CsvModel model = new CsvModel();
        blogspotrepo.findById(id);
        return model;
    }



}
