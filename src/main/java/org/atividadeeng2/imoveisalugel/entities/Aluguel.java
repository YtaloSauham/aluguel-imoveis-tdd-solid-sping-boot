package org.atividadeeng2.imoveisalugel.entities;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_alugueis")
public class Aluguel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataVencimento;

    private Double valorPago;

    private LocalDate dataPagamento;

    private String observacao;


    public Aluguel(Long id, LocalDate dataVencimento, Double valorPago, LocalDate dataPagamento, String observacao) {
        this.id = id;
        this.dataVencimento = dataVencimento;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.observacao = observacao;
    }

    public Aluguel(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluguel aluguel = (Aluguel) o;
        return id.equals(aluguel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
