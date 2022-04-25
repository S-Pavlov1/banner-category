package com.pavlov.bannerCategory.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "banners")
public class Banner extends DeletableObject {

    @Column(unique = true)
    @NotBlank(message = "Name may not be empty")
    private String name;

    @Column(nullable = false)
    @NotNull(message= "Price may not be empty")
    @Range(min = 1)
    private Integer price;

    @ManyToMany
    @NotEmpty(message = "Need at least 1 category")
    private List<Category> categories;

    @NotBlank(message = "Content may not be empty")
    private String content;
}
