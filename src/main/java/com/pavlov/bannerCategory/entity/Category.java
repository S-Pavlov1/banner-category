package com.pavlov.bannerCategory.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends DeletableObject {

    @Column(unique = true)
    @NotBlank(message = "Name may not be empty")
    private String name;

    @Column(unique = true)
    @NotBlank(message = "RequestId may not be empty")
    private String requestId;

    @ManyToMany(mappedBy = "categories")
    private Set<Banner> banners;
}
