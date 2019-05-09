package com.JessZuchowski.codefellowship.database;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String username;

    private String password;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String bio;

    @OneToMany(mappedBy = "applicationUser")
    public List<UserPost> userPost;

    public ApplicationUser() {
        userPost = new ArrayList<>();
    }

    public long getId() {
        return this.id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //change role to admin
//        List<GrantedAuthority> list = new ArrayList<>();
//        list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return null;
    }

    //setters and getters
    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String getPassword() {
        return this.password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
    public String getBio() {
        return bio;
    }

    //prevent default account expiration of web security
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
