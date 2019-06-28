package br.com.via.varejo.produto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.via.varejo.produto.model.Produto;

/**
 * @author rapha
 * @version 1.1
 */
@Service
public interface ProdutoService {

	List<Produto> obterTodos();

	Produto obterUm(Long idProduto);

	Produto salvar(Produto produto);

	String deletar(Long idProduto);
}
