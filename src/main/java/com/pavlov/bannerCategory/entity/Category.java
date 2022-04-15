package com.pavlov.bannerCategory.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends DeletableObject {

    private String name;

    private String requestId;

    @ManyToMany(mappedBy = "banners")
    private Set<Banner> banners;
}
