package com.stylist.rest.webservices.restfulwebservices.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.util.Arrays.asList;

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

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "name", column = @Column(name = "colour_name"))
    })
    @Column(name = "colour")
    private BasicColour colour;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "type", column = @Column(name = "file_type"))
    })
    private FileDB image;

    private static final List<String> tops = new ArrayList<>(asList("t-shirt", "top", "shirt", "blouse", "body", "pullover"));
    private static final List<String> bottoms = new ArrayList<>(asList("trousers", "shorts", "skirt", "dungarees"));
    private static final List<String> onePiece = new ArrayList<>(asList("dress", "overall"));

    public Apparel(String type, BasicColour colour, FileDB image) {
        this.type = type;
        this.colour = colour;
        this.image = image;
    }

    public boolean isTop() {
        return tops.contains(this.type.toLowerCase());
    }

    public boolean isBottom() {
        return bottoms.contains(this.type.toLowerCase());
    }

    public boolean isOnePiece() {
        return onePiece.contains(this.type.toLowerCase());
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

