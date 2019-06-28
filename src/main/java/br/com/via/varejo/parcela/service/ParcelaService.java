package br.com.via.varejo.parcela.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.via.varejo.parcela.model.Parcela;

/**
 * @author rapha
 * @version 1.0
 */
@Service
public interface ParcelaService {

	List<Parcela> obterTodos(Long idProduto);

	Parcela salvar(Parcela parcela);

	Parcela atualizar(Parcela parcela);

	void deletar(Long idParcela);
}
