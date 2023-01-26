package br.com.fabiosp1991.preparacao.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link br.com.fabiosp1991.preparacao.entities.ImovelEntity} entity
 */
public class ImovelDto implements Serializable {
    private final String apelido;
    private final Integer id;
    @Size(max = 45)
    @NotNull
    private final String cep;
    @Size(max = 45)
    @NotNull
    private final String logradouro;
    @NotNull
    private final Integer numero;
    @Size(max = 45)
    private final String complemento;
    @Size(max = 45)
    @NotNull
    private final String bairro;
    @Size(max = 45)
    @NotNull
    private final String cidade;
    @Size(max = 45)
    @NotNull
    private final String estado;
    @Size(max = 45)
    @NotNull
    private final String pais;

    public ImovelDto(String apelido, Integer id, String cep, String logradouro, Integer numero, String complemento, String bairro, String cidade, String estado, String pais) {
        this.apelido = apelido;
        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public String getApelido() {
        return apelido;
    }

    public Integer getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getPais() {
        return pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImovelDto entity = (ImovelDto) o;
        return Objects.equals(this.apelido, entity.apelido) &&
                Objects.equals(this.id, entity.id) &&
                Objects.equals(this.cep, entity.cep) &&
                Objects.equals(this.logradouro, entity.logradouro) &&
                Objects.equals(this.numero, entity.numero) &&
                Objects.equals(this.complemento, entity.complemento) &&
                Objects.equals(this.bairro, entity.bairro) &&
                Objects.equals(this.cidade, entity.cidade) &&
                Objects.equals(this.estado, entity.estado) &&
                Objects.equals(this.pais, entity.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apelido, id, cep, logradouro, numero, complemento, bairro, cidade, estado, pais);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "apelido = " + apelido + ", " +
                "id = " + id + ", " +
                "cep = " + cep + ", " +
                "logradouro = " + logradouro + ", " +
                "numero = " + numero + ", " +
                "complemento = " + complemento + ", " +
                "bairro = " + bairro + ", " +
                "cidade = " + cidade + ", " +
                "estado = " + estado + ", " +
                "pais = " + pais + ")";
    }
}