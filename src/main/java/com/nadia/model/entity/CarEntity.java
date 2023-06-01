package com.nadia.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Yevhenii Filatov
 * @since 6/1/23
 */

@Entity
@Getter
@Setter
@Table(name = "cars")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "mark_id", referencedColumnName = "id")
    private MarkEntity mark;

    private String model;

    private int price;
}
