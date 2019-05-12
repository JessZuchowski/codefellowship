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
    public ApplicationUser isBeingFollowed;

    @ManyToOne(fetch = FetchType.EAGER)
    public ApplicationUser isFollowing;

    public Date followedOn;

    public UserFollow() {

    }

    public UserFollow(ApplicationUser followed, ApplicationUser following, Date followedOn) {
        this.isBeingFollowed = followed;
        this.isFollowing = following;
        this.followedOn = followedOn;
    }

    public long getId() {
        return id;
    }

    public ApplicationUser getIsBeingFollowed() {
        return isBeingFollowed;
    }

    public void setIsBeingFollowed(ApplicationUser isBeingFollowed) {
        this.isBeingFollowed = isBeingFollowed;
    }

    public ApplicationUser getIsFollowing() {
        return isFollowing;
    }

    public void setIsFollowing(ApplicationUser isFollowing) {
        this.isFollowing = isFollowing;
    }

   public Date getFollowedOn() {
        return followedOn;
   }
}
