package org.atividadeeng2.imoveisalugel.repositories;

import org.atividadeeng2.imoveisalugel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);
}
