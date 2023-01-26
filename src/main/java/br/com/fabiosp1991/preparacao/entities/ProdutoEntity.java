package br.com.fabiosp1991.preparacao.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = ProdutoEntity.ENTITY_NAME)
@Table(name = ProdutoEntity.TABLE_NAME)
public class ProdutoEntity {
    public static final String ENTITY_NAME = "Produto";
    public static final String TABLE_NAME = "produto";
    public static final String COLUMN_ID_NAME = "idProduto";
    public static final String COLUMN_NOMEPRODUTO_NAME = "nomeProduto";
    public static final String COLUMN_DESCRICAOPRODUTO_NAME = "descricaoProduto";
    public static final String COLUMN_QUANTIDADE_NAME = "quantidade";
    public static final String COLUMN_CODIGOBARRASPRODUTO_NAME = "codigoBarrasProduto";
    public static final String COLUMN_CONSUMODIARIO_NAME = "consumoDiario";


    private Integer id;

    private String nomeProduto;

    private String descricaoProduto;

    private UnidadeEntity idUnidade;

    private Integer quantidade;

    private String codigoBarrasProduto;

    private CategoriaProdutoEntity idCategoriaProduto;

    private Integer consumoDiario;

    private Set<EstoqueEntity> estoqueEntities = new LinkedHashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)
    public Integer getId() {
        return id;
    }

    public ProdutoEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    @Size(max = 45)
    @NotNull
    @Column(name = COLUMN_NOMEPRODUTO_NAME, nullable = false, length = 45)
    public String getNomeProduto() {
        return nomeProduto;
    }

    public ProdutoEntity setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
        return this;
    }

    @Size(max = 45)
    @Column(name = COLUMN_DESCRICAOPRODUTO_NAME, length = 45)
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public ProdutoEntity setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUnidade")
    public UnidadeEntity getIdUnidade() {
        return idUnidade;
    }

    public ProdutoEntity setIdUnidade(UnidadeEntity idUnidade) {
        this.idUnidade = idUnidade;
        return this;
    }

    @Column(name = COLUMN_QUANTIDADE_NAME)
    public Integer getQuantidade() {
        return quantidade;
    }

    public ProdutoEntity setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    @Size(max = 45)
    @Column(name = COLUMN_CODIGOBARRASPRODUTO_NAME, length = 45)
    public String getCodigoBarrasProduto() {
        return codigoBarrasProduto;
    }

    public ProdutoEntity setCodigoBarrasProduto(String codigoBarrasProduto) {
        this.codigoBarrasProduto = codigoBarrasProduto;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCategoriaProduto")
    public CategoriaProdutoEntity getIdCategoriaProduto() {
        return idCategoriaProduto;
    }

    public ProdutoEntity setIdCategoriaProduto(CategoriaProdutoEntity idCategoriaProduto) {
        this.idCategoriaProduto = idCategoriaProduto;
        return this;
    }

    @Column(name = COLUMN_CONSUMODIARIO_NAME)
    public Integer getConsumoDiario() {
        return consumoDiario;
    }

    public ProdutoEntity setConsumoDiario(Integer consumoDiario) {
        this.consumoDiario = consumoDiario;
        return this;
    }

    @OneToMany(mappedBy = "idProduto")
    public Set<EstoqueEntity> getEstoques() {
        return estoqueEntities;
    }

    public ProdutoEntity setEstoques(Set<EstoqueEntity> estoqueEntities) {
        this.estoqueEntities = estoqueEntities;
        return this;
    }

}