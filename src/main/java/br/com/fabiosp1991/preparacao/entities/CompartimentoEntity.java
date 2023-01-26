package br.com.fabiosp1991.preparacao.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = CompartimentoEntity.ENTITY_NAME)
@Table(name = CompartimentoEntity.TABLE_NAME)
public class CompartimentoEntity {
    public static final String ENTITY_NAME = "Compartimento";
    public static final String TABLE_NAME = "compartimento";
    public static final String COLUMN_ID_NAME = "idCompartimento";
    public static final String COLUMN_DESCRICAOCOMPARTIMENTO_NAME = "descricaoCompartimento";
    public static final String COLUMN_LARGURACOMPARTIMENTO_NAME = "larguraCompartimento";
    public static final String COLUMN_COMPRIMENTOCOMPARTIMENTO_NAME = "comprimentoCompartimento";
    public static final String COLUMN_ALTURACOMPARTIMENTO_NAME = "alturaCompartimento";


    private Integer id;

    private String descricaoCompartimento;

    private Integer larguraCompartimento;

    private Integer comprimentoCompartimento;

    private Integer alturaCompartimento;

    private DivisoriaEntity idDivisoria;

    private ArmarioEntity idArmario;

    private AmbienteEntity idAmbiente;

    private Set<EstoqueEntity> estoqueEntities = new LinkedHashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)
    public Integer getId() {
        return id;
    }

    public CompartimentoEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    @Size(max = 45)
    @NotNull
    @Column(name = COLUMN_DESCRICAOCOMPARTIMENTO_NAME, nullable = false, length = 45)
    public String getDescricaoCompartimento() {
        return descricaoCompartimento;
    }

    public CompartimentoEntity setDescricaoCompartimento(String descricaoCompartimento) {
        this.descricaoCompartimento = descricaoCompartimento;
        return this;
    }

    @Column(name = COLUMN_LARGURACOMPARTIMENTO_NAME)
    public Integer getLarguraCompartimento() {
        return larguraCompartimento;
    }

    public CompartimentoEntity setLarguraCompartimento(Integer larguraCompartimento) {
        this.larguraCompartimento = larguraCompartimento;
        return this;
    }

    @Column(name = COLUMN_COMPRIMENTOCOMPARTIMENTO_NAME)
    public Integer getComprimentoCompartimento() {
        return comprimentoCompartimento;
    }

    public CompartimentoEntity setComprimentoCompartimento(Integer comprimentoCompartimento) {
        this.comprimentoCompartimento = comprimentoCompartimento;
        return this;
    }

    @Column(name = COLUMN_ALTURACOMPARTIMENTO_NAME)
    public Integer getAlturaCompartimento() {
        return alturaCompartimento;
    }

    public CompartimentoEntity setAlturaCompartimento(Integer alturaCompartimento) {
        this.alturaCompartimento = alturaCompartimento;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDivisoria")
    public DivisoriaEntity getIdDivisoria() {
        return idDivisoria;
    }

    public CompartimentoEntity setIdDivisoria(DivisoriaEntity idDivisoria) {
        this.idDivisoria = idDivisoria;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idArmario")
    public ArmarioEntity getIdArmario() {
        return idArmario;
    }

    public CompartimentoEntity setIdArmario(ArmarioEntity idArmario) {
        this.idArmario = idArmario;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAmbiente")
    public AmbienteEntity getIdAmbiente() {
        return idAmbiente;
    }

    public CompartimentoEntity setIdAmbiente(AmbienteEntity idAmbiente) {
        this.idAmbiente = idAmbiente;
        return this;
    }

    @OneToMany(mappedBy = "idCompartimento")
    public Set<EstoqueEntity> getEstoques() {
        return estoqueEntities;
    }

    public CompartimentoEntity setEstoques(Set<EstoqueEntity> estoqueEntities) {
        this.estoqueEntities = estoqueEntities;
        return this;
    }

}