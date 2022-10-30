package com.permutator.model.entity;

import lombok.*;



import javax.persistence.*;

@Entity
@Table(name = "jobs")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private int minLength;

    private int maxLength;

    private String letters;

    private int stringAmount;

    private boolean isRunning = true;
}
