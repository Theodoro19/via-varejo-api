package br.com.via.varejo.condicao.pagamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.via.varejo.condicao.pagamento.model.CondicaoPagamento;
import br.com.via.varejo.condicao.pagamento.model.CondicaoPagamentoRepository;
import br.com.via.varejo.produto.service.ProdutoService;

/**
 * @author rapha
 * @version 1.2
 */
@Service
public class CondicaoPagamentoServiceImpl implements CondicaoPagamentoService {

	@Autowired
	private CondicaoPagamentoRepository condicaoPagamentoRepository;

	@Autowired
	private ProdutoService produtoService;

	// MÉTODO PARA BUSCAR TODAS AS CONDIÇÕES DE PAGAMENTOS COM BASE NO ID DO PRODUTO
	@Override
	public CondicaoPagamento obterTodos(Long idProduto) {

		return produtoService.obterUm(idProduto).getCondicaoPagamento();
	}

	// MÉTODO PARA SALVAR UMA CONDIÇÃO DE PAGAMENTO
	@Override
	public CondicaoPagamento salvar(CondicaoPagamento condicaoPagamento) {

		if (condicaoPagamento.getId() == null) {

			condicaoPagamento = new CondicaoPagamento();
		}
		condicaoPagamento.setAtivo(Boolean.TRUE);

		condicaoPagamentoRepository.save(condicaoPagamento);

		return condicaoPagamento;
	}

	// MÉTODO PARA DELETAR UMA CONDIÇÃO DE PAGAMENTO
	@Override
	public String deletar(Long idProduto) {

		CondicaoPagamento condicaoPagamento = obterTodos(idProduto);

		if (condicaoPagamento != null) {

			condicaoPagamento.setAtivo(Boolean.FALSE);

			condicaoPagamentoRepository.save(condicaoPagamento);

			return "Deletado com sucesso!";
		} else {

			return "Não encontrada uma condição de pagamento";
		}
	}

}
