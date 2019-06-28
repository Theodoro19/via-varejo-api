package br.com.via.varejo.condicao.pagamento.model;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface CondicaoPagamentoRepository
		extends CrudRepository<CondicaoPagamento, Long>, JpaSpecificationExecutor<CondicaoPagamento> {

}
