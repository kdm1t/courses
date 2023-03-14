package com.kdm1t.courses.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(nullable = false)
    private String name;

    private Integer duration;

    private Double price;

    @ManyToOne
    private Owner owner;

    @ManyToOne
    private JobGuarantee jobGuarantee;

    @ManyToOne
    private Direction directionOfStudy;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Credit credit;

}
