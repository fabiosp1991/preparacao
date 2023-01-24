package br.com.fabiosp1991.preparacao.Entities;

import jakarta.persistence.*;

@Entity(name = ArmarioEntity.ENTITY_NAME)
@Table(name = ArmarioEntity.TABLE_NAME)
public class ArmarioEntity {
    public static final String ENTITY_NAME = "Armario_Entity";
    public static final String TABLE_NAME = "armario";
    public static final String COLUMN_ID_NAME = "idArmario";
    public static final String COLUMN_DESCRICAOARMARIO_NAME = "descricaoArmario";


    private Integer id;

    private String descricaoArmario;

    private AmbienteEntity ambiente;

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

    @Column(name = COLUMN_DESCRICAOARMARIO_NAME, nullable = false, length = 45)
    public String getDescricaoArmario() {
        return descricaoArmario;
    }

    public ArmarioEntity setDescricaoArmario(String descricaoArmario) {
        this.descricaoArmario = descricaoArmario;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ambiente", nullable = false)
    public AmbienteEntity getAmbiente() {
        return ambiente;
    }

    public ArmarioEntity setAmbiente(AmbienteEntity ambiente) {
        this.ambiente = ambiente;
        return this;
    }

}