package com.backend.Restro.repository;

import com.backend.Restro.entity.UserDetail;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface UserDetailRepository extends JpaRepository<UserDetail, Integer> {
}