package com.example.demodemo;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MyData> query = builder.createQuery(MyData.class);
        Root<MyData> root = query.from(MyData.class);
        query.select(root);
        List<MyData> list = entityManager
                .createQuery(query)
                .getResultList();
        return list;
    }

    @Override
    public MyData findById(Long id) {
        return null;
    }

    @Override
    public List<MyData> findByName(String name) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MyData> query = builder.createQuery(MyData.class);
        Root<MyData> root = query.from(MyData.class);
        query.select(root)
                .where(builder.equal(root.get("name"), name));

        List<MyData> list = entityManager
                .createQuery(query)
                .getResultList();
        return list;
    }
}
