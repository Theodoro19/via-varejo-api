package br.com.via.varejo.produto.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.via.varejo.parcela.model.Parcela;
import br.com.via.varejo.produto.model.Produto;
import br.com.via.varejo.produto.service.ProdutoService;

/**
 * @author rapha
 * @version 1.0
 */

@RestController
@RequestMapping(value = "produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> getAll() {

		return new ResponseEntity<List<Produto>>(produtoService.obterTodos(), OK);
	}

	@RequestMapping(value = "/{idProduto}", method = RequestMethod.GET)
	public ResponseEntity<Produto> getOne(@PathVariable("idProduto") Long idProduto) {

		if (idProduto == null) {
			return new ResponseEntity<Produto>(NO_CONTENT);
		}

		return new ResponseEntity<Produto>(produtoService.obterUm(idProduto), OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<List<Parcela>> save(@RequestBody Produto produto) {

		return new ResponseEntity<List<Parcela>>(produtoService.salvar(produto).getListaParcelas(), CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<List<Parcela>> update(@RequestBody Produto produto) {

		return new ResponseEntity<List<Parcela>>(produtoService.salvar(produto).getListaParcelas(), OK);
	}

	@RequestMapping(value = "/{idProduto}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("idProduto") Long idProduto) {

		return new ResponseEntity<String>(produtoService.deletar(idProduto), OK);
	}
}
