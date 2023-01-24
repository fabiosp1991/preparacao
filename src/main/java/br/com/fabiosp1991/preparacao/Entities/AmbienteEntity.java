package br.com.fabiosp1991.preparacao.Entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = AmbienteEntity.ENTITY_NAME)
@Table(name = AmbienteEntity.TABLE_NAME)
public class AmbienteEntity {
    public static final String ENTITY_NAME = "Ambiente_Entity";
    public static final String TABLE_NAME = "ambiente";
    public static final String COLUMN_ID_NAME = "idAmbiente";
    public static final String COLUMN_DESCRICAOAMBIENTE_NAME = "descricaoAmbiente";


    private Integer id;

    private String descricaoAmbiente;

    private ImovelEntity idImovel;

    private Set<ArmarioEntity> armarios = new LinkedHashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)
    public Integer getId() {
        return id;
    }

    public AmbienteEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    @Column(name = COLUMN_DESCRICAOAMBIENTE_NAME, nullable = false, length = 45)
    public String getDescricaoAmbiente() {
        return descricaoAmbiente;
    }

    public AmbienteEntity setDescricaoAmbiente(String descricaoAmbiente) {
        this.descricaoAmbiente = descricaoAmbiente;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idImovel", nullable = false)
    public ImovelEntity getIdImovel() {
        return idImovel;
    }

    public AmbienteEntity setIdImovel(ImovelEntity idImovel) {
        this.idImovel = idImovel;
        return this;
    }

    @OneToMany(mappedBy = "ambiente")
    public Set<ArmarioEntity> getArmarios() {
        return armarios;
    }

    public AmbienteEntity setArmarios(Set<ArmarioEntity> armarios) {
        this.armarios = armarios;
        return this;
    }

}