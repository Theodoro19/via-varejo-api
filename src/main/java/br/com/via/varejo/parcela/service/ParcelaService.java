package br.com.via.varejo.parcela.service;

import org.springframework.stereotype.Service;

import br.com.via.varejo.parcela.model.Parcela;

/**
 * @author rapha
 * @version 1.1
 */
@Service
public interface ParcelaService {

	Iterable<Parcela> obterTodos(Long idProduto);

	Parcela salvar(Parcela parcela);

	String deletar(Long idParcela);
}
