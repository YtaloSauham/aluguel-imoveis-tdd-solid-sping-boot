package org.atividadeeng2.imoveisalugel.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name= "tb_locacao")
public class Locacao implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private Imoveis imovel;

    @ManyToOne
    @JoinColumn(name = "inquilino_id")
    private User inquilino ;



    @ManyToOne
    @JoinColumn(name = "aluguel_id")
    private Aluguel aluguel ;
    private Double valorAluguel;

    private Double percentualMulta;

    private LocalDate diaVencimento;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    private Boolean ativo;

    private String observacao;

    public Locacao(){}


    public Locacao(Long id, Imoveis imovel, User inquilino, Double valorAluguel, Double percentualMulta, LocalDate diaVencimento, LocalDate dataInicio, LocalDate dataFim, Boolean ativo, String observacao) {
        this.id = id;
        this.valorAluguel = valorAluguel;
        this.imovel = imovel;
        this.inquilino=inquilino;
        this.percentualMulta = percentualMulta;
        this.diaVencimento = diaVencimento;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.ativo = ativo;
        this.observacao = observacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Imoveis getImovel() {
        return imovel;
    }

    public void setImovel(Imoveis imovel) {
        this.imovel = imovel;
    }

    public User getInquilino() {
        return inquilino;
    }

    public void setInquilino(User inquilino) {
        this.inquilino = inquilino;
    }
    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    public Double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(Double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public Double getPercentualMulta() {
        return percentualMulta;
    }

    public void setPercentualMulta(Double percentualMulta) {
        this.percentualMulta = percentualMulta;
    }

    public LocalDate getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(LocalDate diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locacao locacao = (Locacao) o;
        return id.equals(locacao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
