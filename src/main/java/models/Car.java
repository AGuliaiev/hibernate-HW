package models;

import enams.Type;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    @Enumerated(EnumType.STRING)
    private Type body;
    private int power;
    private double price;
    private int year;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Owner owner;

    public Car(String model, Type body, int power, double price, int year, Owner owner) {
        this.model = model;
        this.body = body;
        this.power = power;
        this.price = price;
        this.year = year;
        this.owner = owner;
    }
}
