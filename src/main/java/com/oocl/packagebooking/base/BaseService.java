package com.oocl.packagebooking.base;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BaseService<T, ID> {

    T save(T t);
    T update(T t);
    List<T> saveAll(List<T> ts);
    List<T> findAll();
    List<T> findAll(Sort sort);
    Page<T> findAll(int page, int size);
    Page<T> findAll(int page);
    T findById(ID id);
    Page<T> findAllByKeyword(Example<T> example, int page, int size, Sort sort);
    void delete(T t);
}