package org.atividadeeng2.imoveisalugel.repositories;

import org.atividadeeng2.imoveisalugel.entities.Aluguel;
import org.atividadeeng2.imoveisalugel.entities.Locacao;
import org.atividadeeng2.imoveisalugel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

    List<Aluguel> findByPayment(Float valorPago);
}
