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
@Table(name = "banners")
public class Banner extends DeletableObject {

    private String name;

    @Column(nullable = false)
    private Integer price;

    @ManyToMany
    @JoinColumn(name = "categoryId")
    private Set<Category> categories;

    private String content;
}
