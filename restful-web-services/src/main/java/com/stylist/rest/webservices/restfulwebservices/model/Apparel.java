package com.stylist.rest.webservices.restfulwebservices.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "Apparel")
public class Apparel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "colour")
    private String colour;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "type", column = @Column(name = "file_type"))
    })
    private FileDB image;

    public Apparel(String type, String colour, FileDB image) {
        this.type = type;
        this.colour = colour;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Apparel{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }

}

