package com.candemirhan._321monoliticcoding.service.model;

import com.candemirhan._321monoliticcoding.repository.entity.BaseObject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public class ServiceMenager<T extends BaseObject,ID> implements IService<T,ID>{

    private final JpaRepository<T,ID> repository;

    public ServiceMenager(JpaRepository<T,ID> repository)
    {
        this.repository = repository;
    }

    @Override
    public T save(T entity) {
        entity.setCreatedAt(System.currentTimeMillis());
        entity.setCreatedBy("Developer");
        entity.setUpdatedAt(System.currentTimeMillis());
        entity.setUpdatedBy("Developer");
        entity.setState(0);
        return repository.save(entity);
    }
    @Override
    public Iterable<T> saveAll(Iterable<T> entities) {
        Arrays.asList(entities)
                .stream()
                .forEach((s) -> s.forEach((e) -> {
                    e.setCreatedAt(System.currentTimeMillis());
                    e.setCreatedBy("Developer");
                    e.setUpdatedAt(System.currentTimeMillis());
                    e.setUpdatedBy("Developer");
                    })
                );
        return repository.saveAll(entities);
    }
    @Override
    public T findById(ID id) {
        return repository.getReferenceById(id);
    }
    @Override
    public List<T> findAll() {
        return repository.findAll();
    }
    @Override
    public T update(T entity) {
        entity.setUpdatedAt(System.currentTimeMillis());
        entity.setUpdatedBy("Developer");
        return repository.save(entity);
    }
    @Override
    public void delete(T entity) {
        entity.setState(2);
        entity.setUpdatedAt(System.currentTimeMillis());
        entity.setUpdatedBy("Developer");
        repository.save(entity);
    }
    @Override
    public void deleteById(ID id) {
        T entity = repository.getReferenceById(id);
        entity.setState(2);
        entity.setUpdatedAt(System.currentTimeMillis());
        entity.setUpdatedBy("Developer");
        repository.save(entity);
    }
}
