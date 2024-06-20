package com.wang.crud.backend.repositories;

import com.wang.crud.backend.entities.GymRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymRecordsRepo extends JpaRepository<GymRecord, Long> {
}
