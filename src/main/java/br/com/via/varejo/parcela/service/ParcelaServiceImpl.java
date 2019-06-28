package br.com.via.varejo.parcela.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.via.varejo.parcela.model.Parcela;
import br.com.via.varejo.parcela.model.ParcelaRepository;

/**
 * @author rapha
 * @version 1.1
 */
@Service
public class ParcelaServiceImpl implements ParcelaService {
	
	@Autowired
	private ParcelaRepository parcelaRepository;

	// MÉTODO PARA BUSCAR TODAS AS PARCELAS COM BASE NO ID DO PRODUTO
	@Override
	public Iterable<Parcela> obterTodos(Long idProduto) {
		// TODO Auto-generated method stub
		return null;
	}

	// MÉTODO PARA SALVAR UMA PARCELA
	@Override
	public Parcela salvar(Parcela parcela) {
		// TODO Auto-generated method stub
		return null;
	}

	// MÉTODO PARA DELETAR UMA PARCELA
	@Override
	public String deletar(Long idParcela) {
		
		Optional<Parcela> optional = parcelaRepository.findById(idParcela);
		
		if(optional.isPresent()) {
			
			return null;
		}else {
			
			return "Não foram encontras parcelas para esse produto";
		}
	}

}
