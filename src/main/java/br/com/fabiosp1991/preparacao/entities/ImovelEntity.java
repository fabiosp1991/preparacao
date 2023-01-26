package br.com.fabiosp1991.preparacao.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = ImovelEntity.ENTITY_NAME)
@Table(name = ImovelEntity.TABLE_NAME, indexes = {
        @Index(name = "idx_imovelentity_idimovel", columnList = "idImovel")
})
public class ImovelEntity {
    public static final String ENTITY_NAME = "Imovel";
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
    public static final String COLUMN_APELIDO_NAME = "apelido";


    private Integer id;

    private String cep;

    private String logradouro;

    private Integer numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private String estado;

    private String pais;

    private String apelido;

    private Set<AmbienteEntity> ambienteEntities = new LinkedHashSet<>();

    @Column(name = COLUMN_APELIDO_NAME, nullable = false, unique = true, length = 45)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    public String getApelido() {
        return apelido;
    }

    public ImovelEntity setApelido(String apelido) {
        this.apelido = apelido;
        return this;
    }

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

    @Size(max = 45)
    @NotNull
    @Column(name = COLUMN_CEP_NAME, nullable = false, length = 45)
    public String getCep() {
        return cep;
    }

    public ImovelEntity setCep(String cep) {
        this.cep = cep;
        return this;
    }

    @Size(max = 45)
    @NotNull
    @Column(name = COLUMN_LOGRADOURO_NAME, nullable = false, length = 45)
    public String getLogradouro() {
        return logradouro;
    }

    public ImovelEntity setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    @NotNull
    @Column(name = COLUMN_NUMERO_NAME, nullable = false)
    public Integer getNumero() {
        return numero;
    }

    public ImovelEntity setNumero(Integer numero) {
        this.numero = numero;
        return this;
    }

    @Size(max = 45)
    @Column(name = COLUMN_COMPLEMENTO_NAME, length = 45)
    public String getComplemento() {
        return complemento;
    }

    public ImovelEntity setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    @Size(max = 45)
    @NotNull
    @Column(name = COLUMN_BAIRRO_NAME, nullable = false, length = 45)
    public String getBairro() {
        return bairro;
    }

    public ImovelEntity setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    @Size(max = 45)
    @NotNull
    @Column(name = COLUMN_CIDADE_NAME, nullable = false, length = 45)
    public String getCidade() {
        return cidade;
    }

    public ImovelEntity setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    @Size(max = 45)
    @NotNull
    @Column(name = COLUMN_ESTADO_NAME, nullable = false, length = 45)
    public String getEstado() {
        return estado;
    }

    public ImovelEntity setEstado(String estado) {
        this.estado = estado;
        return this;
    }

    @Size(max = 45)
    @NotNull
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
        return ambienteEntities;
    }

    public ImovelEntity setAmbientes(Set<AmbienteEntity> ambienteEntities) {
        this.ambienteEntities = ambienteEntities;
        return this;
    }

    @Override
    public String toString() {
        return "ImovelEntity{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", pais='" + pais + '\'' +
                ", apelido='" + apelido + '\'' +
                ", ambienteEntities=" + ambienteEntities +
                '}';
    }
}