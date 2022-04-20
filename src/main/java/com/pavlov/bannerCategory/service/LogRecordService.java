package com.pavlov.bannerCategory.service;

import com.pavlov.bannerCategory.entity.Banner;
import com.pavlov.bannerCategory.entity.IdentifiableObject;
import com.pavlov.bannerCategory.entity.LogRecord;
import com.pavlov.bannerCategory.repository.LogRecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class LogRecordService{

    private LogRecordRepository logRecordRepository;

    public void addLogRecord (IdentifiableObject banner, String ipAddress, String userAgent) {
        LogRecord logRecord = new LogRecord();
        if(banner instanceof Banner)
            logRecord.setBanner((Banner) banner);
        else
            logRecord.setBanner(null);
        logRecord.setIdAddress(ipAddress);
        logRecord.setUserAgent(userAgent);
        logRecord.setRequestTime(LocalDateTime.now());
        logRecordRepository.save(logRecord);
    }
}
