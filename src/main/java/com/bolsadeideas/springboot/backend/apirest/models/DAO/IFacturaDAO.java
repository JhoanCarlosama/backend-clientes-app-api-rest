package com.bolsadeideas.springboot.backend.apirest.models.DAO;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Factura;
import org.springframework.data.repository.CrudRepository;

public interface IFacturaDAO extends CrudRepository<Factura, Long> {

}
