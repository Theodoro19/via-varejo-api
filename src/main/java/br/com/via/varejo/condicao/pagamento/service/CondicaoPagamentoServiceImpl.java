package br.com.via.varejo.condicao.pagamento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.via.varejo.condicao.pagamento.model.CondicaoPagamento;

/**
 * @author rapha
 * @version 1.0
 */
@Service
public class CondicaoPagamentoServiceImpl implements CondicaoPagamentoService{

	// MÉTODO PARA BUSCAR TODAS AS CONDIÇÕES DE PAGAMENTOS COM BASE NO ID DO PRODUTO
	@Override
	public List<CondicaoPagamento> obterTodos(Long idProduto) {
		// TODO Auto-generated method stub
		return null;
	}

	// MÉTODO PARA SALVAR UMA CONDIÇÃO DE PAGAMENTO
	@Override
	public CondicaoPagamento salvar(CondicaoPagamento condicaoPagamento) {
		// TODO Auto-generated method stub
		return null;
	}

	// MÉTODO PARA ATUALIZAR UMA CONDIÇÃO DE PAGAMENTO
	@Override
	public CondicaoPagamento atualizar(CondicaoPagamento condicaoPagamento) {
		// TODO Auto-generated method stub
		return null;
	}

	// MÉTODO PARA DELETAR UMA CONDIÇÃO DE PAGAMENTO
	@Override
	public void deletar(Long idCondicaoPagamento) {
		// TODO Auto-generated method stub
		return null;
	}

}
