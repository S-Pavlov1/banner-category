package com.pavlov.bannerCategory.service;

import com.pavlov.bannerCategory.repository.LogRecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LogRecordService {

    private LogRecordRepository logRecordRepository;
}
