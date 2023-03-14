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
@Table(indexes = @Index(columnList = "organization"))
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(unique = true)
    private String organization;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE)
    @JsonIgnore
    List<Course> courses;

}
