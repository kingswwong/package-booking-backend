package com.oocl.packagebooking.base;


import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

public class BaseServiceImpl<T, ID> implements BaseService<T, ID> {

    private BaseRepository<T, ID> baseRepository;

    public BaseServiceImpl(BaseRepository<T, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public T save(T t) {
        return baseRepository.save(t);
    }

    @Override
    public T update(T t) {
        return baseRepository.save(t);
    }


    @Override
    public List<T> saveAll(List<T> ts) {
        return baseRepository.saveAll(ts);
    }

    @Override
    public List<T> findAll(Sort sort) {
        return baseRepository.findAll(sort);
    }

    @Override
    public T findById(ID id) {
        return baseRepository.findById(id).orElse(null);
    }


    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public Page<T> findAll(int page) {
        return baseRepository.findAll(PageRequest.of(page,15));
    }

    @Override
    public Page<T> findAll(int page, int size) {
        return baseRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Page<T> findAllByKeyword(Example<T> example, int page, int size, Sort sort) {
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return baseRepository.findAll(example, pageRequest);
    }

    @Override
    public void delete(T t) {
        baseRepository.delete(t);
    }


}