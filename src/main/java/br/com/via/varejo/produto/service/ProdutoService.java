package br.com.via.varejo.produto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.via.varejo.produto.model.Produto;

/**
 * @author rapha
 * @version 1.0
 */
@Service
public interface ProdutoService {

	List<Produto> obterTodos();
	
	List<Produto> obterUm(Long idProduto);
	
	Produto salvar(Produto produto);

	Produto atualizar(Produto produto);

	Produto deletar(Produto produto);
}
