package br.com.fabiosp1991.preparacao.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = ArmarioEntity.ENTITY_NAME)
@Table(name = ArmarioEntity.TABLE_NAME)
public class ArmarioEntity {
    public static final String ENTITY_NAME = "Armario";
    public static final String TABLE_NAME = "armario";
    public static final String COLUMN_ID_NAME = "idArmario";
    public static final String COLUMN_DESCRICAOARMARIO_NAME = "descricaoArmario";


    private Integer id;

    private String descricaoArmario;

    private AmbienteEntity ambienteEntity;

    private Set<DivisoriaEntity> divisoriaEntities = new LinkedHashSet<>();

    private Set<CompartimentoEntity> compartimentoEntities = new LinkedHashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)
    public Integer getId() {
        return id;
    }

    public ArmarioEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    @Size(max = 45)
    @NotNull
    @Column(name = COLUMN_DESCRICAOARMARIO_NAME, nullable = false, length = 45)
    public String getDescricaoArmario() {
        return descricaoArmario;
    }

    public ArmarioEntity setDescricaoArmario(String descricaoArmario) {
        this.descricaoArmario = descricaoArmario;
        return this;
    }

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ambiente", nullable = false)
    public AmbienteEntity getAmbiente() {
        return ambienteEntity;
    }

    public ArmarioEntity setAmbiente(AmbienteEntity ambienteEntity) {
        this.ambienteEntity = ambienteEntity;
        return this;
    }

    @OneToMany(mappedBy = "idArmario")
    public Set<DivisoriaEntity> getDivisorias() {
        return divisoriaEntities;
    }

    public ArmarioEntity setDivisorias(Set<DivisoriaEntity> divisoriaEntities) {
        this.divisoriaEntities = divisoriaEntities;
        return this;
    }

    @OneToMany(mappedBy = "idArmario")
    public Set<CompartimentoEntity> getCompartimentos() {
        return compartimentoEntities;
    }

    public ArmarioEntity setCompartimentos(Set<CompartimentoEntity> compartimentoEntities) {
        this.compartimentoEntities = compartimentoEntities;
        return this;
    }

}