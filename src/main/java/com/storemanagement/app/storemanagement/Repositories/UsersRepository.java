package com.storemanagement.app.storemanagement.Repositories;

import com.storemanagement.app.storemanagement.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
