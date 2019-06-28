package br.com.via.varejo.parcela.model;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface ParcelaRepository extends CrudRepository<Parcela, Long>, JpaSpecificationExecutor<Parcela> {

}
