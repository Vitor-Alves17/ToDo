package com.list.todo.repository;

import com.list.todo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByName(String username);
    public User findByEmail(String email);

}
