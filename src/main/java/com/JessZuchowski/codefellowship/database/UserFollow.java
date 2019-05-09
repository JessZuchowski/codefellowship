package com.JessZuchowski.codefellowship.database;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UserFollow {

    @Id
    @GeneratedValue
    public long id;

    //use eager to prevent those lazy errors
    @ManyToOne(fetch = FetchType.EAGER)
    public ApplicationUser isFollowing;

    @ManyToOne(fetch = FetchType.EAGER)
    public ApplicationUser isBeingFollowed;

    public Date followedOn;

    public String message;

}
