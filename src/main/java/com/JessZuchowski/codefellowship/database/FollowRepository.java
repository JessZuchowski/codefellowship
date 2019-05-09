package com.JessZuchowski.codefellowship.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<UserFollow, Long> {
}
