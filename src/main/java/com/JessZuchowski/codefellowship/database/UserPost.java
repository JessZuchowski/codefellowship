package com.JessZuchowski.codefellowship.database;

import org.springframework.jmx.export.annotation.ManagedMetric;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserPost {

    @Id
    @GeneratedValue
    private long id;

    private String addAPost;

    @ManyToOne
    public ApplicationUser applicationUser;
}
