package org.atividadeeng2.imoveisalugel.repositories;

import org.atividadeeng2.imoveisalugel.entities.Aluguel;
import org.atividadeeng2.imoveisalugel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
}
