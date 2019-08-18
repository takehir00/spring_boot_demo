package com.example.demodemo;

import java.util.List;

public interface MsgDataDao<T> {

    public List<MsgData> getAll();

    MsgData findById();
}
