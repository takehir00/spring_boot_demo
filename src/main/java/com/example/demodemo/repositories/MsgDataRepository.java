package com.example.demodemo.repositories;

import com.example.demodemo.MsgData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MsgDataRepository extends JpaRepository<MsgData, Long> {
}
