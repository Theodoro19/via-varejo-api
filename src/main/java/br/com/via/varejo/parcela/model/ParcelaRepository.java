package br.com.via.varejo.parcela.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import br.com.via.varejo.produto.model.Produto;

public interface ParcelaRepository extends CrudRepository<Parcela, Long>, JpaSpecificationExecutor<Parcela> {

	List<Parcela> findByProduto(Produto produto);
}
