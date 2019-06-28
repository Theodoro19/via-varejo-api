package br.com.via.varejo.condicao.pagamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.via.varejo.condicao.pagamento.model.CondicaoPagamento;
import br.com.via.varejo.condicao.pagamento.model.CondicaoPagamentoRepository;

/**
 * @author rapha
 * @version 1.1
 */
@Service
public class CondicaoPagamentoServiceImpl implements CondicaoPagamentoService {

	@Autowired
	private CondicaoPagamentoRepository condicaoPagamentoRepository;

	// MÉTODO PARA BUSCAR TODAS AS CONDIÇÕES DE PAGAMENTOS COM BASE NO ID DO PRODUTO
	@Override
	public List<CondicaoPagamento> obterTodos(Long idProduto) {
		
		return null;
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
	public String deletar(Long idCondicaoPagamento) {

		Optional<CondicaoPagamento> optional = condicaoPagamentoRepository.findById(idCondicaoPagamento);

		if (optional.isPresent()) {

			CondicaoPagamento condicaoPagamento = optional.get();

			condicaoPagamento.setAtivo(Boolean.FALSE);

			condicaoPagamentoRepository.save(condicaoPagamento);

			return "Deletado com sucesso!";
		} else {

			return "Não encontrada uma condição de pagamento";
		}
	}

}
