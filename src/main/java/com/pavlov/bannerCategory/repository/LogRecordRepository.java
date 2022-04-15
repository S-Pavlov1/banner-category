package com.pavlov.bannerCategory.repository;

import com.pavlov.bannerCategory.entity.LogRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRecordRepository extends JpaRepository<LogRecord, Integer>{

}
