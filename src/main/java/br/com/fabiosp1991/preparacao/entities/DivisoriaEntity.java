package br.com.fabiosp1991.preparacao.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = DivisoriaEntity.ENTITY_NAME)
@Table(name = DivisoriaEntity.TABLE_NAME)
public class DivisoriaEntity {
    public static final String ENTITY_NAME = "Divisoria";
    public static final String TABLE_NAME = "divisoria";
    public static final String COLUMN_ID_NAME = "idDivisoria";
    public static final String COLUMN_DESCRICAODIVISORIA_NAME = "descricaoDivisoria";


    private Integer id;

    private String descricaoDivisoria;

    private ArmarioEntity idArmario;

    private Set<CompartimentoEntity> compartimentoEntities = new LinkedHashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)
    public Integer getId() {
        return id;
    }

    public DivisoriaEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    @Size(max = 45)
    @NotNull
    @Column(name = COLUMN_DESCRICAODIVISORIA_NAME, nullable = false, length = 45)
    public String getDescricaoDivisoria() {
        return descricaoDivisoria;
    }

    public DivisoriaEntity setDescricaoDivisoria(String descricaoDivisoria) {
        this.descricaoDivisoria = descricaoDivisoria;
        return this;
    }

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idArmario", nullable = false)
    public ArmarioEntity getIdArmario() {
        return idArmario;
    }

    public DivisoriaEntity setIdArmario(ArmarioEntity idArmario) {
        this.idArmario = idArmario;
        return this;
    }

    @OneToMany(mappedBy = "idDivisoria")
    public Set<CompartimentoEntity> getCompartimentos() {
        return compartimentoEntities;
    }

    public DivisoriaEntity setCompartimentos(Set<CompartimentoEntity> compartimentoEntities) {
        this.compartimentoEntities = compartimentoEntities;
        return this;
    }

}