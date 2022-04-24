package com.pavlov.bannerCategory.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class BannerDTO implements DTO {

    private Integer id;

    @NotEmpty
    private String name;

    @NotEmpty
    private Integer price;

    @NotNull
    private Set<Integer> categories;

    @NotEmpty
    private String content;


    @Override
    public String toString() {
        return " name: " + name + " price: " + price + " content: " + content + " categories: " +
                categories.stream().map(Object::toString).reduce("",String::concat);
    }
}
