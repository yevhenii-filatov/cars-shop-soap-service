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
@Table(name = "marks")
public class MarkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String mark;
}
