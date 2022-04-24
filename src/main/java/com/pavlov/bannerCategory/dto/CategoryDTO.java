package com.pavlov.bannerCategory.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO implements DTO{

    private Integer id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String requestId;


    @Override
    public String toString() {
        return "name: " + name + " requestId: " + requestId;
    }
}
