package br.com.fabiosp1991.preparacao.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = CategoriaProdutoEntity.ENTITY_NAME)
@Table(name = CategoriaProdutoEntity.TABLE_NAME)
public class CategoriaProdutoEntity {
    public static final String ENTITY_NAME = "Categoriaproduto";
    public static final String TABLE_NAME = "categoriaproduto";
    public static final String COLUMN_ID_NAME = "idCategoriaProduto";
    public static final String COLUMN_NAME_NAME = "name";


    private Integer id;

    private String name;

    private Set<ProdutoEntity> produtoEntities = new LinkedHashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)
    public Integer getId() {
        return id;
    }

    public CategoriaProdutoEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    @Size(max = 255)
    @NotNull
    @Column(name = COLUMN_NAME_NAME, nullable = false)
    public String getName() {
        return name;
    }

    public CategoriaProdutoEntity setName(String name) {
        this.name = name;
        return this;
    }

    @OneToMany(mappedBy = "idCategoriaProduto")
    public Set<ProdutoEntity> getProdutos() {
        return produtoEntities;
    }

    public CategoriaProdutoEntity setProdutos(Set<ProdutoEntity> produtoEntities) {
        this.produtoEntities = produtoEntities;
        return this;
    }

}