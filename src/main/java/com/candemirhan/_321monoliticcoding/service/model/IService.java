package com.candemirhan._321monoliticcoding.service.model;

import com.candemirhan._321monoliticcoding.repository.entity.BaseObject;

import java.util.List;

public interface IService<T extends BaseObject,ID> {

    T save(T entity);
    Iterable<T> saveAll(Iterable<T> entities);
    T findById(ID id);
    List<T> findAll();
    T update(T entity);
    void delete(T entity);
    void deleteById(ID id);
}
