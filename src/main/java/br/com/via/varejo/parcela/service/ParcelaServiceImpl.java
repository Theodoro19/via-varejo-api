package br.com.via.varejo.parcela.service;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.via.varejo.parcela.model.Parcela;
import br.com.via.varejo.parcela.model.ParcelaRepository;
import br.com.via.varejo.produto.service.ProdutoService;

/**
 * @author rapha
 * @version 1.1
 */
@Service
public class ParcelaServiceImpl implements ParcelaService {

	@Autowired
	private ParcelaRepository parcelaRepository;

	@Autowired
	private ProdutoService produtoService;

	// MÉTODO PARA BUSCAR TODAS AS PARCELAS COM BASE NO ID DO PRODUTO
	@Override
	public Iterable<Parcela> obterTodos(Long idProduto) {

		return parcelaRepository.findByProduto(produtoService.obterUm(idProduto));
	}

	// MÉTODO PARA SALVAR UMA PARCELA
	@Override
	public Parcela salvar(Parcela parcela) {

		if (parcela.getId() == null) {

			parcela = new Parcela();
		}

		parcela.setAtivo(TRUE);

		parcelaRepository.save(parcela);

		return parcela;
	}

	// MÉTODO PARA DELETAR UMA PARCELA
	@Override
	public String deletar(Long idParcela) {

		Optional<Parcela> optional = parcelaRepository.findById(idParcela);

		if (optional.isPresent()) {

			deletar(optional.get());

			return "Deletado com sucesso!";
		} else {

			return "Não foram encontras parcelas para esse produto.";
		}
	}

	// MÉTODO PARA DELETAR TODAS AS PARCELAS
	@Override
	public String deletarTodos(Long idProduto) {

		obterTodos(idProduto).forEach(parcela -> deletar(parcela));

		return "Todas as parcelas deste produto foram deletadas.";
	}

	protected void deletar(Parcela parcela) {

		parcela.setAtivo(FALSE);

		parcelaRepository.save(parcela);
	}

}
