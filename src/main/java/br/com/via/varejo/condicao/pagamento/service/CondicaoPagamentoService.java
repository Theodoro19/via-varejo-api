package br.com.via.varejo.condicao.pagamento.service;

import org.springframework.stereotype.Service;

import br.com.via.varejo.condicao.pagamento.model.CondicaoPagamento;

/**
 * 
 * @author rapha
 * @version 1.2
 */
@Service
public interface CondicaoPagamentoService {

	CondicaoPagamento obterTodos(Long idProduto);

	CondicaoPagamento salvar(CondicaoPagamento condicaoPagamento);

	String deletar(Long idCondicaoPagamento);

}
