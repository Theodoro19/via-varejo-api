package br.com.via.varejo.produto.service;

import org.springframework.stereotype.Service;

import br.com.via.varejo.produto.model.Produto;

/**
 * @author rapha
 * @version 1.1
 */
@Service
public interface ProdutoService {

	Iterable<Produto> obterTodos();

	Produto obterUm(Long idProduto);

	Produto salvar(Produto produto);

	String deletar(Long idProduto);
}
