package com.permutator.model.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jobs")
@Getter
public class Job {

    @Id
    @GeneratedValue
    private Long id;

    private String fileName;

    private int minLength;

    private int maxLength;

    private String letters;

    private int stringAmount;
}
