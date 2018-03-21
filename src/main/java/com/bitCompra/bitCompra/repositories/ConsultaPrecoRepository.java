package com.bitCompra.bitCompra.repositories;

import com.bitCompra.bitCompra.entities.ConsultaPreco;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ConsultaPrecoRepository extends CrudRepository<ConsultaPreco, Long> {

}