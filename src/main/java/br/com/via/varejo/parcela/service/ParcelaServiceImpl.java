package br.com.via.varejo.parcela.service;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import java.util.List;

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

		return produtoService.obterUm(idProduto).getListaParcelas();
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

	// MÉTODO PARA DELETAR TODAS AS PARCELAS
	@Override
	public void deletarTodos(List<Parcela> listaParcela) {

		listaParcela.forEach(parcela -> deletar(parcela));

	}

	protected void deletar(Parcela parcela) {

		parcela.setAtivo(FALSE);

		parcelaRepository.save(parcela);
	}

}
