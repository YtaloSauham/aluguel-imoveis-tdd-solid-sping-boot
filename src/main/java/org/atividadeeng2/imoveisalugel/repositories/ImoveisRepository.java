package org.atividadeeng2.imoveisalugel.repositories;

import org.atividadeeng2.imoveisalugel.entities.Aluguel;
import org.atividadeeng2.imoveisalugel.entities.Imoveis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImoveisRepository extends JpaRepository<Imoveis, Long> {
}
