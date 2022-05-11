package com.stylist.rest.webservices.restfulwebservices.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "files")
public class FileDB {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Lob
    @Column(name = "data")
    private byte[] data;

    @OneToOne(mappedBy = "apparelImage")
    private ClothingItem clothingItem;

    public FileDB(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

}
