package com.kdm1t.courses.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString(exclude = {"courses"})
@Entity
@Table(indexes = @Index(columnList = "directionOfStudy"))
public class Direction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(unique = true)
    private String directionOfStudy;

    @OneToMany(mappedBy = "directionOfStudy")
    @JsonIgnore
    private List<Course> courses;


}
