package br.com.via.varejo.produto.service;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.via.varejo.produto.model.Produto;
import br.com.via.varejo.produto.model.ProdutoRepository;

/**
 * @author rapha
 * @version 1.0
 */
@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	// MÉTODO PARA BUSCAR TODAS OS PRODUTOS
	@Override
	public Iterable<Produto> obterTodos() {
		
		return produtoRepository.findAll();
	}

	// MÉTODO PARA BUSCAR UM PRODUTO COM BASE NO ID

	@Override
	public Produto obterUm(Long idProduto) {

		Optional<Produto> optional = produtoRepository.findById(idProduto);

		if (optional.isPresent()) {

			return optional.get();
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

		return produto;
	}

	// MÉTODO PARA DELETAR UM PRODUTO
	@Override
	public String deletar(Long idProduto) {

		Produto produto = obterUm(idProduto);

		if (produto == null) {

			return "Produto não encontrado!";
		}
		produto.setAtivo(FALSE);

		produtoRepository.save(produto);

		return "Deletado com sucesso!";
	}

}
