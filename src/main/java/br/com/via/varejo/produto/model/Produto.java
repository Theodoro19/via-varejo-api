package br.com.via.varejo.produto.model;

import static java.lang.Boolean.TRUE;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Where;

import br.com.via.varejo.condicao.pagamento.model.CondicaoPagamento;
import br.com.via.varejo.parcela.model.Parcela;
import br.com.via.varejo.util.model.BaseEntity;

/**
 * Classe onde será armazeda as informações sobre determinado produto
 *
 * @author rapha
 * @version 1.2
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
	private Boolean ativo = TRUE;

	@OneToOne(mappedBy = "produto", fetch = LAZY, cascade = ALL)
	@Fetch(FetchMode.SELECT)
	@BatchSize(size = 100)
	private CondicaoPagamento condicaoPagamento;

	@OneToMany(mappedBy = "produto", fetch = LAZY, cascade = ALL)
	@Fetch(FetchMode.SELECT)
	@BatchSize(size = 100)
	private List<Parcela> listaParcelas;

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

	/**
	 * @return the condicaoPagamento
	 */
	public CondicaoPagamento getCondicaoPagamento() {
		return condicaoPagamento;
	}

	/**
	 * @param condicaoPagamento the condicaoPagamento to set
	 */
	public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}

	/**
	 * @return the listaParcelas
	 */
	public List<Parcela> getListaParcelas() {
		return listaParcelas;
	}

	/**
	 * @param listaParcelas the listaParcelas to set
	 */
	public void setListaParcelas(List<Parcela> listaParcelas) {
		this.listaParcelas = listaParcelas;
	}

}
