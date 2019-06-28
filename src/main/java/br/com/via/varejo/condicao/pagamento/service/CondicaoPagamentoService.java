package br.com.via.varejo.condicao.pagamento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.via.varejo.condicao.pagamento.model.CondicaoPagamento;

/**
 * 
 * @author rapha
 * @version 1.0
 */
@Service
public interface CondicaoPagamentoService {

	List<CondicaoPagamento> obterTodos(Long idProduto);

	CondicaoPagamento salvar(CondicaoPagamento condicaoPagamento);

	String deletar(Long idCondicaoPagamento);

}
