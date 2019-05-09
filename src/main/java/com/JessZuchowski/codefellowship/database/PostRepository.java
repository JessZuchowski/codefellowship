package com.JessZuchowski.codefellowship.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<UserPost, Long> {

}
