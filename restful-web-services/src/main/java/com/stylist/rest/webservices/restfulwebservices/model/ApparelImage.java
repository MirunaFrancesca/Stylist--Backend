package com.stylist.rest.webservices.restfulwebservices.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "ApparelImage")
public class ApparelImage {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    //image bytes can have large lengths so we specify a value
    //which is more than the default length for picByte column
    @Column(name = "picByte", length = 500000)
    private byte[] picByte;

    @OneToOne(mappedBy = "apparelImage")
    private ClothingItem clothingItem;

    public ApparelImage() {
        super();
    }

    public ApparelImage(String name, String type, byte[] picByte) {
        this.name = name;
        this.type = type;
        System.out.println(picByte.length);
        this.picByte = picByte;
    }
}
