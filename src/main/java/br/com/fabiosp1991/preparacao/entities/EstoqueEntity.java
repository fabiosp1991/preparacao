package br.com.fabiosp1991.preparacao.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity(name = EstoqueEntity.ENTITY_NAME)
@Table(name = EstoqueEntity.TABLE_NAME)
public class EstoqueEntity {
    public static final String ENTITY_NAME = "Estoque";
    public static final String TABLE_NAME = "estoque";
    public static final String COLUMN_ID_NAME = "idEstoque";
    public static final String COLUMN_QUANTIDADE_NAME = "quantidade";
    public static final String COLUMN_DATAVALIDADEORIGINAL_NAME = "dataValidadeOriginal";
    public static final String COLUMN_DATAVALIDADEPESSOAL_NAME = "dataValidadePessoal";


    private Integer id;

    private ProdutoEntity idProduto;

    private CompartimentoEntity idCompartimento;

    private Integer quantidade;

    private LocalDate dataValidadeOriginal;

    private LocalDate dataValidadePessoal;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)
    public Integer getId() {
        return id;
    }

    public EstoqueEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idProduto", nullable = false)
    public ProdutoEntity getIdProduto() {
        return idProduto;
    }

    public EstoqueEntity setIdProduto(ProdutoEntity idProduto) {
        this.idProduto = idProduto;
        return this;
    }

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idCompartimento", nullable = false)
    public CompartimentoEntity getIdCompartimento() {
        return idCompartimento;
    }

    public EstoqueEntity setIdCompartimento(CompartimentoEntity idCompartimento) {
        this.idCompartimento = idCompartimento;
        return this;
    }

    @NotNull
    @Column(name = COLUMN_QUANTIDADE_NAME, nullable = false)
    public Integer getQuantidade() {
        return quantidade;
    }

    public EstoqueEntity setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    @Column(name = COLUMN_DATAVALIDADEORIGINAL_NAME)
    public LocalDate getDataValidadeOriginal() {
        return dataValidadeOriginal;
    }

    public EstoqueEntity setDataValidadeOriginal(LocalDate dataValidadeOriginal) {
        this.dataValidadeOriginal = dataValidadeOriginal;
        return this;
    }

    @Column(name = COLUMN_DATAVALIDADEPESSOAL_NAME)
    public LocalDate getDataValidadePessoal() {
        return dataValidadePessoal;
    }

    public EstoqueEntity setDataValidadePessoal(LocalDate dataValidadePessoal) {
        this.dataValidadePessoal = dataValidadePessoal;
        return this;
    }

}