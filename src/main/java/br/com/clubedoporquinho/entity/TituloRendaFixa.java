package br.com.clubedoporquinho.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "TITULO_RENDA_FIXA")
public class TituloRendaFixa implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String indexador;

    private String tipo;

    private String nome;

    private String vendimento;

    private String taxa;

    private String valor;

    private String corretora;

    private String emissor;

    private String liquidez;

    private String amortizacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndexador() {
        return indexador;
    }

    public void setIndexador(String indexador) {
        this.indexador = indexador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVendimento() {
        return vendimento;
    }

    public void setVendimento(String vendimento) {
        this.vendimento = vendimento;
    }

    public String getTaxa() {
        return taxa;
    }

    public void setTaxa(String taxa) {
        this.taxa = taxa;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getCorretora() {
        return corretora;
    }

    public void setCorretora(String corretora) {
        this.corretora = corretora;
    }

    public String getEmissor() {
        return emissor;
    }

    public void setEmissor(String emissor) {
        this.emissor = emissor;
    }

    public String getLiquidez() {
        return liquidez;
    }

    public void setLiquidez(String liquidez) {
        this.liquidez = liquidez;
    }

    public String getAmortizacao() {
        return amortizacao;
    }

    public void setAmortizacao(String amortizacao) {
        this.amortizacao = amortizacao;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TituloRendaFixa{");
        sb.append("id=").append(id);
        sb.append(", indexador='").append(indexador).append('\'');
        sb.append(", tipo='").append(tipo).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", vendimento='").append(vendimento).append('\'');
        sb.append(", taxa='").append(taxa).append('\'');
        sb.append(", valor='").append(valor).append('\'');
        sb.append(", corretora='").append(corretora).append('\'');
        sb.append(", emissor='").append(emissor).append('\'');
        sb.append(", liquidez='").append(liquidez).append('\'');
        sb.append(", amortizacao='").append(amortizacao).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
