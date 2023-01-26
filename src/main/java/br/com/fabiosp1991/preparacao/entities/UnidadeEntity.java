package br.com.fabiosp1991.preparacao.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = UnidadeEntity.ENTITY_NAME)
@Table(name = UnidadeEntity.TABLE_NAME)
public class UnidadeEntity {
    public static final String ENTITY_NAME = "Unidade";
    public static final String TABLE_NAME = "unidade";
    public static final String COLUMN_ID_NAME = "idUnidade";
    public static final String COLUMN_NOMEUNIDADE_NAME = "nomeUnidade";


    private Integer id;

    private String nomeUnidade;

    private Set<ProdutoEntity> produtoEntities = new LinkedHashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)
    public Integer getId() {
        return id;
    }

    public UnidadeEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    @Size(max = 45)
    @NotNull
    @Column(name = COLUMN_NOMEUNIDADE_NAME, nullable = false, length = 45)
    public String getNomeUnidade() {
        return nomeUnidade;
    }

    public UnidadeEntity setNomeUnidade(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
        return this;
    }

    @OneToMany(mappedBy = "idUnidade")
    public Set<ProdutoEntity> getProdutos() {
        return produtoEntities;
    }

    public UnidadeEntity setProdutos(Set<ProdutoEntity> produtoEntities) {
        this.produtoEntities = produtoEntities;
        return this;
    }

}