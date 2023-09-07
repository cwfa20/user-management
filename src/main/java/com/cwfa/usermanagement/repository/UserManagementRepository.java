package com.cwfa.usermanagement.repository;

import com.cwfa.usermanagement.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserManagementRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
    Optional<List<User>> findUsers();
    User save(User user);
    void deleteByUsername(String username);
}
