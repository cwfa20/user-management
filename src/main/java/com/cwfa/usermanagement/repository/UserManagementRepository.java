package com.cwfa.usermanagement.repository;

import com.cwfa.usermanagement.domain.entity.WebsiteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserManagementRepository extends JpaRepository<WebsiteUser, UUID> {
    Optional<WebsiteUser> findUserByUsername(String username);
    void deleteByUsername(String username);
}
