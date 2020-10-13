package me.timur.docs.repository;

import me.timur.docs.domain.Employee;
import me.timur.docs.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

//    List<User> findAllByActive(Boolean isActive);
    User findByEmployee(Employee employee);
}
