package br.com.via.varejo.produto.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.via.varejo.util.model.BaseEntity;

/**
 * Classe onde será armazeda as informações da quantidade de parcelas para
 * determinado produto
 * 
 * @author rapha
 * @version 1.0
 *
 */
@Entity
@Table(name = "produto")
public class Produto extends BaseEntity {

	@Column(name = "prod_nm_nome")
	private String nome;

	@Column(name = "prod_nr_valor")
	private BigDecimal valor;

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

}
