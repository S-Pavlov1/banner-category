package com.pavlov.bannerCategory.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class DeletableObject extends IdentifiableObject{

    private boolean isDeleted;
}
