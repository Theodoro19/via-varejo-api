package br.com.via.varejo.produto.model;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Long>, JpaSpecificationExecutor<Produto> {

}
