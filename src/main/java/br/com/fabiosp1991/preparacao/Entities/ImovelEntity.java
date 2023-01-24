package br.com.fabiosp1991.preparacao.Entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = ImovelEntity.ENTITY_NAME)
@Table(name = ImovelEntity.TABLE_NAME)
public class ImovelEntity {
    public static final String ENTITY_NAME = "Imovel_Entity";
    public static final String TABLE_NAME = "imovel";
    public static final String COLUMN_ID_NAME = "idImovel";
    public static final String COLUMN_CEP_NAME = "cep";
    public static final String COLUMN_LOGRADOURO_NAME = "logradouro";
    public static final String COLUMN_NUMERO_NAME = "numero";
    public static final String COLUMN_COMPLEMENTO_NAME = "complemento";
    public static final String COLUMN_BAIRRO_NAME = "bairro";
    public static final String COLUMN_CIDADE_NAME = "cidade";
    public static final String COLUMN_ESTADO_NAME = "estado";
    public static final String COLUMN_PAIS_NAME = "pais";


    private Integer id;

    private String cep;

    private String logradouro;

    private Integer numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private String estado;

    private String pais;

    private Set<AmbienteEntity> ambientes = new LinkedHashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)
    public Integer getId() {
        return id;
    }

    public ImovelEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    @Column(name = COLUMN_CEP_NAME, nullable = false, length = 45)
    public String getCep() {
        return cep;
    }

    public ImovelEntity setCep(String cep) {
        this.cep = cep;
        return this;
    }

    @Column(name = COLUMN_LOGRADOURO_NAME, nullable = false, length = 45)
    public String getLogradouro() {
        return logradouro;
    }

    public ImovelEntity setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    @Column(name = COLUMN_NUMERO_NAME, nullable = false)
    public Integer getNumero() {
        return numero;
    }

    public ImovelEntity setNumero(Integer numero) {
        this.numero = numero;
        return this;
    }

    @Column(name = COLUMN_COMPLEMENTO_NAME, length = 45)
    public String getComplemento() {
        return complemento;
    }

    public ImovelEntity setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    @Column(name = COLUMN_BAIRRO_NAME, nullable = false, length = 45)
    public String getBairro() {
        return bairro;
    }

    public ImovelEntity setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    @Column(name = COLUMN_CIDADE_NAME, nullable = false, length = 45)
    public String getCidade() {
        return cidade;
    }

    public ImovelEntity setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    @Column(name = COLUMN_ESTADO_NAME, nullable = false, length = 45)
    public String getEstado() {
        return estado;
    }

    public ImovelEntity setEstado(String estado) {
        this.estado = estado;
        return this;
    }

    @Column(name = COLUMN_PAIS_NAME, nullable = false, length = 45)
    public String getPais() {
        return pais;
    }

    public ImovelEntity setPais(String pais) {
        this.pais = pais;
        return this;
    }

    @OneToMany(mappedBy = "idImovel")
    public Set<AmbienteEntity> getAmbientes() {
        return ambientes;
    }

    public ImovelEntity setAmbientes(Set<AmbienteEntity> ambientes) {
        this.ambientes = ambientes;
        return this;
    }

}