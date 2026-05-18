package com.rodolfo.jobtracker.Repository;

import com.rodolfo.jobtracker.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
