package com.example.springbootpostgres.blog.service;

import com.example.springbootpostgres.blog.api.BlogDto;
import com.example.springbootpostgres.blog.domain.Blog;
import com.example.springbootpostgres.blog.api.CreateBlogDto;
import com.example.springbootpostgres.blog.domain.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public String createBlog(CreateBlogDto createBlogDto) {
        var blog = new Blog(UUID.randomUUID().toString(), createBlogDto.title(), createBlogDto.content());
        return this.blogRepository.save(blog).getId();
     }

    public List<BlogDto> getBlogs() {
        var blogs = this.blogRepository.findAll();
        return blogs.stream().map(b -> new BlogDto(b.getId(), b.getTitle(), b.getContent())).collect(Collectors.toList());
    }
}
