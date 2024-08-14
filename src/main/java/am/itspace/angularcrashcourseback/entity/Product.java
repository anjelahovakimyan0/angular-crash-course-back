package am.itspace.angularcrashcourseback.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String price;

    private String name;

    private String image;

    private int rating;

}
