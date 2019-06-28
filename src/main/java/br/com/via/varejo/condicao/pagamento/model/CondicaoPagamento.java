package br.com.via.varejo.condicao.pagamento.model;

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
 * Classe onde será armazenadas as condições de pagamento de determinado produto
 * 
 * @author rapha
 * @version 1.0
 */
@Entity
@Table(name = "condicao_pagamento")
@Where(clause = "copa_in_ativo='t'")
public class CondicaoPagamento extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "copa_prod_cd_id")
	private Produto produto;

	@Column(name = "copa_nr_valor_entrada")
	private BigDecimal valorEntrada;

	@Column(name = "copa_nr_qtde_parcelas")
	private Integer quantidadeParcelas;

	@Column(name = "copa_in_ativo")
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
	 * @return the valorEntrada
	 */
	public BigDecimal getValorEntrada() {
		return valorEntrada;
	}

	/**
	 * @param valorEntrada the valorEntrada to set
	 */
	public void setValorEntrada(BigDecimal valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	/**
	 * @return the quantidadeParcelas
	 */
	public Integer getQuantidadeParcelas() {
		return quantidadeParcelas;
	}

	/**
	 * @param quantidadeParcelas the quantidadeParcelas to set
	 */
	public void setQuantidadeParcelas(Integer quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
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
