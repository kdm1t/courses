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
@Table(indexes = @Index(columnList = "jobGuarantee"))
public class JobGuarantee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(unique = true)
    private Boolean jobGuarantee;

    @OneToMany(mappedBy = "jobGuarantee")
    @JsonIgnore
    private List<Course> courses;

}
