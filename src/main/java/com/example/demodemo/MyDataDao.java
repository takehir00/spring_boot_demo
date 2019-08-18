package com.example.demodemo;

import java.io.Serializable;
import java.util.List;

public interface MyDataDao <T> extends Serializable {

    public List<T> getAll();

    T findById(Long id);

    List<T> findByName(String name);
}
