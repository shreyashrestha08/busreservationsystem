package com.blume.busbackend.repo;
import com.blume.busbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
    User findByEmailAndPasswordAndRole(String email, String password, String role);
    void deleteByEmail(String email);
}
