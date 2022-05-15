package com.stylist.rest.webservices.restfulwebservices.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.util.List;

@Setter
@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class BasicColour {
    private String name;

    @Override
    public String toString() {
        return "BasicColour{" +
                "name='" + name + '\'' +
                '}';
    }
}
