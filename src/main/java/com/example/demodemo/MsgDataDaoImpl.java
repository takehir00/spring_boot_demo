package com.example.demodemo;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@SuppressWarnings("rawtypes")
@Repository
public class MsgDataDaoImpl implements MsgDataDao<MsgData> {

    private EntityManager entityManager;

    public MsgDataDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<MsgData> getAll() {
        return entityManager
                .createQuery("from MsgData")
                .getResultList();
    }

    @Override
    public MsgData findById(Long id) {
        return (MsgData) entityManager
                .createQuery("from MsgData where id = " + id)
                .getSingleResult();
    }
}
