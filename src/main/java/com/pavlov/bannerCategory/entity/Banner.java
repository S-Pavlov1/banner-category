package com.pavlov.bannerCategory.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "banners")
public class Banner extends DeletableObject {

    @Column(unique = true)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @ManyToMany
    private Set<Category> categories;

    private String content;
}
