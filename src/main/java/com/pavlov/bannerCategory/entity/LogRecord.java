package com.pavlov.bannerCategory.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name ="logRecords")
@AllArgsConstructor
public class LogRecord extends IdentifiableObject{

    private String ipAddress;
    private String userAgent;
    private LocalDateTime requestTime;

    @ManyToOne
    @JoinColumn(name = "bannerId")
    private Banner banner;
}
