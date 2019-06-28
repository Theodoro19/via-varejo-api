package br.com.via.varejo.produto.service;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.via.varejo.condicao.pagamento.service.CondicaoPagamentoService;
import br.com.via.varejo.parcela.model.Parcela;
import br.com.via.varejo.parcela.service.ParcelaService;
import br.com.via.varejo.produto.model.Produto;
import br.com.via.varejo.produto.model.ProdutoRepository;

/**
 * @author rapha
 * @version 1.1
 */
@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ParcelaService parcelaService;

	@Autowired
	private CondicaoPagamentoService condicaoPagamentoService;

	// MÉTODO PARA BUSCAR TODAS OS PRODUTOS
	@Override
	public List<Produto> obterTodos() {

		List<Produto> listaProduto = (List<Produto>) produtoRepository.findAll();

		listaProduto.forEach(produto -> {

			produto.setCondicaoPagamento(condicaoPagamentoService.obterTodos(produto.getId()));
			produto.setListaParcelas((List<Parcela>) parcelaService.obterTodos(produto.getId()));
		});

		return listaProduto;
	}

	// MÉTODO PARA BUSCAR UM PRODUTO COM BASE NO ID

	@Override
	public Produto obterUm(Long idProduto) {

		Optional<Produto> optional = produtoRepository.findById(idProduto);

		if (optional.isPresent()) {

			Produto produto = optional.get();

			produto.setCondicaoPagamento(condicaoPagamentoService.obterTodos(produto.getId()));
			produto.setListaParcelas((List<Parcela>) parcelaService.obterTodos(produto.getId()));

			return produto;
		}

		return null;
	}

	// MÉTODO PARA SALVAR UM PRODUTO
	@Override
	public Produto salvar(Produto produto) {

		if (produto.getId() == null) {

			produto = new Produto();
		}
		produto.setAtivo(TRUE);

		produtoRepository.save(produto);

		if (produto.getCondicaoPagamento() != null) {
			condicaoPagamentoService.salvar(produto.getCondicaoPagamento());
		}

		if (produto.getListaParcelas() != null) {
			produto.getListaParcelas().forEach(parcela -> parcelaService.salvar(parcela));
		}

		return produto;
	}

	// MÉTODO PARA DELETAR UM PRODUTO
	@Override
	public String deletar(Long idProduto) {

		Produto produto = obterUm(idProduto);

		if (produto == null) {

			return "Produto não encontrado!";
		}

		if (produto.getCondicaoPagamento() != null) {
			condicaoPagamentoService.deletar(produto.getCondicaoPagamento().getId());
		}

		if (produto.getListaParcelas() != null) {
			parcelaService.deletarTodos(produto.getListaParcelas());
		}

		produto.setAtivo(FALSE);

		produtoRepository.save(produto);

		return "Deletado com sucesso!";
	}

}
