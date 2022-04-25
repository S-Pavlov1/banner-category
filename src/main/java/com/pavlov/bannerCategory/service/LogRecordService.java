package com.pavlov.bannerCategory.service;

import com.pavlov.bannerCategory.entity.Banner;
import com.pavlov.bannerCategory.entity.Category;
import com.pavlov.bannerCategory.entity.IdentifiableObject;
import com.pavlov.bannerCategory.entity.LogRecord;
import com.pavlov.bannerCategory.repository.BannerRepository;
import com.pavlov.bannerCategory.repository.LogRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
public class LogRecordService{

    @Autowired
    private LogRecordRepository logRecordRepository;

    @Autowired
    private BannerRepository bannerRepository;

    public List<Banner> findTodayUserBanners (String userAgent, String ipAddress) {
        return bannerRepository.findBannersByUserAgentAndIp(userAgent, ipAddress);
    }

    public void addLogRecord (Banner banner, String userAgent, String ipAddress) {
        logRecordRepository.save(new LogRecord(ipAddress,userAgent,LocalDateTime.now(),banner));
    }


}
