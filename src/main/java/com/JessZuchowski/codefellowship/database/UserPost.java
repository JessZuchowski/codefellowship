package com.JessZuchowski.codefellowship.database;

import org.springframework.jmx.export.annotation.ManagedMetric;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class UserPost {

    @Id
    @GeneratedValue
    private long id;

    private String addAPost;
    public Date postedAt;

    @ManyToOne
    public ApplicationUser applicationUser;

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }
    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getAddAPost() {
        return addAPost;
    }
    public void setAddAPost(String addAPost) {
        this.addAPost = addAPost;
    }

    public Date getPostedAt() {
        return postedAt;
    }
    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }
}
