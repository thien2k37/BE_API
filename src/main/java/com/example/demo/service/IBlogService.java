package com.example.demo.service;

import com.example.demo.model.Blog;

public interface BlogService extends IService<Blog> {
    Iterable<Blog> findAllByTitleContaining(String title);
    Iterable<Blog> findAllByUserId(Long id);
    Iterable<Blog> findAllByStatusPublic();

}
