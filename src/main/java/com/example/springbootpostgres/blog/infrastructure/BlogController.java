package com.example.springbootpostgres.blog.infrastructure;

import com.example.springbootpostgres.blog.api.BlogDto;
import com.example.springbootpostgres.blog.api.CreateBlogDto;
import com.example.springbootpostgres.blog.service.BlogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/blog")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    public String createBlog(CreateBlogDto createBlogDto) {
        return this.blogService.createBlog(createBlogDto);
    }

    @GetMapping
    public List<BlogDto> getBlogs() {
            return this.blogService.getBlogs();
    }
}
