package com.stylist.rest.webservices.restfulwebservices.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "ClothingItem")
public class ClothingItem {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "colour")
    private String colour;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "imageId", referencedColumnName = "id")
    private ApparelImage apparelImage;

    public ClothingItem(String name, String type, String colour) {
        this.name = name;
        this.type = type;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "ClothingItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }

}

