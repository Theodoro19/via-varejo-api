package br.com.via.varejo.condicao.pagamento.model;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import br.com.via.varejo.produto.model.Produto;

public interface CondicaoPagamentoRepository
		extends CrudRepository<CondicaoPagamento, Long>, JpaSpecificationExecutor<CondicaoPagamento> {

	CondicaoPagamento findByProduto(Produto produto);
}
