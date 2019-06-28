package br.com.via.varejo.parcela.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import br.com.via.varejo.produto.model.Produto;
import br.com.via.varejo.util.model.BaseEntity;

/**
 * Classe onde será armazeda as informações da quantidade de parcelas para
 * determinado produto
 * 
 * @author rapha
 * @version 1.3
 *
 */
@Entity
@Table(name = "parcela")
@Where(clause = "parc_in_ativo='t'")
public class Parcela extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "parc_prod_cd_id")
	private Produto produto;

	@Column(name = "parc_nr_numero_parcela")
	private Integer numeroParcela;

	@Column(name = "parc_nr_valor")
	private BigDecimal valor;

	@Column(name = "parc_nr_taxa_juros")
	private Integer taxaJurosAoMes;

	@Column(name = "parc_in_ativo")
	private Boolean ativo = Boolean.TRUE;

	/**
	 * @return the produto
	 */
	public Produto getProduto() {
		return produto;
	}

	/**
	 * @param produto the produto to set
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	/**
	 * @return the numeroParcela
	 */
	public Integer getNumeroParcela() {
		return numeroParcela;
	}

	/**
	 * @param numeroParcela the numeroParcela to set
	 */
	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	/**
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	/**
	 * @return the taxaJurosAoMes
	 */
	public Integer getTaxaJurosAoMes() {
		return taxaJurosAoMes;
	}

	/**
	 * @param taxaJurosAoMes the taxaJurosAoMes to set
	 */
	public void setTaxaJurosAoMes(Integer taxaJurosAoMes) {
		this.taxaJurosAoMes = taxaJurosAoMes;
	}

	/**
	 * @return the ativo
	 */
	public Boolean getAtivo() {
		return ativo;
	}

	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}
