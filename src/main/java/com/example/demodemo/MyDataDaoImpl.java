package com.example.demodemo;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public class MyDataDaoImpl implements MyDataDao<MyData> {
    private static final Long serialVersionUID = 1L;

    private EntityManager entityManager;


    public MyDataDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<MyData> getAll() {
        Query query = entityManager.createQuery("from MyData", MyData.class);
        List<MyData> list = query.getResultList();
        entityManager.close();
        return list;
    }

    @Override
    public MyData findById(Long id) {
        Query query = entityManager.createQuery("from MyData where id = " + id, MyData.class);
        MyData data = (MyData) query.getSingleResult();
        return data;
    }

    @Override
    public List<MyData> findByName(String name) {
        Query query = entityManager.createQuery("from MyData where name = " + name, MyData.class)
        return query.getResultList();
    }
}
