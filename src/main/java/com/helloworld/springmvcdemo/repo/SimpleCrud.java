package com.helloworld.springmvcdemo.repo;

import java.util.List;

public interface SimpleCrud<T> {

    int save(T object);

    int update(T object);

    int delete(Long id);

    T find(Long id);

    List<T> findAll();
}
