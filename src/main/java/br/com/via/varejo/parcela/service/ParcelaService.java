package br.com.via.varejo.parcela.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.via.varejo.parcela.model.Parcela;

/**
 * @author rapha
 * @version 1.1
 */
@Service
public interface ParcelaService {

	Iterable<Parcela> obterTodos(Long idProduto);

	Parcela salvar(Parcela parcela, Integer quantidadeParcelas);

	void deletarTodos(List<Parcela> listaParcela);
}
