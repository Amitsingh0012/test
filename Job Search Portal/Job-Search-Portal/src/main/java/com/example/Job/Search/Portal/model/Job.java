package com.example.Job.Search.Portal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Job {
    @Id
    private Long id;
    private String title;
    private String description;
    private String location;
    private Double salary; //(hint @min for salary : should be above 20,000 )
    private String companyEmail;
    private String companyName;
    private String employerName;
    private JobType jobType;
    private LocalDate appliedDate;
}
