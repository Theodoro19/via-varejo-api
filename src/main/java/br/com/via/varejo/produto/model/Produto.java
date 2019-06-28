package br.com.via.varejo.produto.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import br.com.via.varejo.util.model.BaseEntity;

/**
 * Classe onde será armazeda as informações sobre determinado produto
 *
 * @author rapha
 * @version 1.1
 *
 */
@Entity
@Table(name = "produto")
@Where(clause = "prod_in_ativo='t'")
public class Produto extends BaseEntity {

	@Column(name = "prod_nm_nome")
	private String nome;

	@Column(name = "prod_nr_valor")
	private BigDecimal valor;

	@Column(name = "prod_in_ativo")
	private Boolean ativo = Boolean.TRUE;

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
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
