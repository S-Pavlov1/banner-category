package com.pavlov.bannerCategory.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;

@Getter
@Setter
@Entity
@Table(name ="logRecords")
public class LogRecord extends IdentifiableObject{

    private String idAddress;
    private Time requestTime;

    @ManyToOne
    @JoinColumn(name = "bannerId")
    private Banner banner;
}
