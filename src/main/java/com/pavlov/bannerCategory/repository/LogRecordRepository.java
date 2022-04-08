package com.pavlov.bannerCategory.repository;

import com.pavlov.bannerCategory.model.Banner;
import com.pavlov.bannerCategory.model.LogRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRecordRepository extends JpaRepository<LogRecord, Integer>{


}
