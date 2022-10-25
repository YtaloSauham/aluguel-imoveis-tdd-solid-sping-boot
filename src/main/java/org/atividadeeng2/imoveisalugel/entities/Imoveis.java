package org.atividadeeng2.imoveisalugel.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.atividadeeng2.imoveisalugel.entities.enums.ImoveisTipoStatus;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name= "tb_imoveis")
public class Imoveis implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "imovel")
    @JsonIgnore
    private List<Locacao> locacao;

    private String endereco;

    private String bairro;

    private String cep;

    private String metragem;

    private String dormitorios;

    private String banheiros;

    private String suites;

    private String vagasGaragem;

    private Double valorAluguelSugerido;

    private String observacao;

    private Integer tipoImovel;


    public Imoveis(){

    }

    public Imoveis(Long id, String endereco, String bairro, String cep, String metragem, String dormitorios, String banheiros, String suites, String vagasGaragem, Double valorAluguelSugerido, String observacao,ImoveisTipoStatus tipoImovel) {
        this.id = id;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.metragem = metragem;
        this.dormitorios = dormitorios;
        this.banheiros = banheiros;
        this.suites = suites;
        this.vagasGaragem = vagasGaragem;
        this.valorAluguelSugerido = valorAluguelSugerido;
        this.observacao = observacao;
        setTipoImovel(tipoImovel);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Locacao> getLocacao() {
        return locacao;
    }



    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public ImoveisTipoStatus getTipoImovel() {
        return  ImoveisTipoStatus.valueOf(tipoImovel);
    }

    public void setTipoImovel( ImoveisTipoStatus  imoveisTipoStatusStatus) {
        this.tipoImovel = imoveisTipoStatusStatus.getCode();
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getMetragem() {
        return metragem;
    }

    public void setMetragem(String metragem) {
        this.metragem = metragem;
    }

    public String getDormitorios() {
        return dormitorios;
    }

    public void setDormitorios(String dormitorios) {
        this.dormitorios = dormitorios;
    }

    public String getBanheiros() {
        return banheiros;
    }

    public void setBanheiros(String banheiros) {
        this.banheiros = banheiros;
    }

    public String getSuites() {
        return suites;
    }

    public void setSuites(String suites) {
        this.suites = suites;
    }

    public String getVagasGaragem() {
        return vagasGaragem;
    }

    public void setVagasGaragem(String vagasGaragem) {
        this.vagasGaragem = vagasGaragem;
    }

    public Double getValorAluguelSugerido() {
        return valorAluguelSugerido;
    }

    public void setValorAluguelSugerido(Double valorAluguelSugerido) {
        this.valorAluguelSugerido = valorAluguelSugerido;
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
        Imoveis imoveis = (Imoveis) o;
        return id.equals(imoveis.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
