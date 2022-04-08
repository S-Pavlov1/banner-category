package com.pavlov.bannerCategory.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;

@Getter
@Setter
@Entity
@Table(name ="logRecords")
public class LogRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String idAddress;
    private Time requestTime;
    private Banner banner;
}
