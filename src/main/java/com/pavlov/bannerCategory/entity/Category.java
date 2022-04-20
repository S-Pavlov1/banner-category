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

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String requestId;

    @ManyToMany(mappedBy = "categories")
    private Set<Banner> banners;
}
