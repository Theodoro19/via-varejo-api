package br.com.via.varejo.condicao.pagamento.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import br.com.via.varejo.produto.model.Produto;

public interface CondicaoPagamentoRepository
		extends CrudRepository<CondicaoPagamento, Long>, JpaSpecificationExecutor<CondicaoPagamento> {

	List<CondicaoPagamento> findByProduto(Produto produto);
}
