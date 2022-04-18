package com.bolsadeideas.springboot.backend.apirest.models.DAO;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//public interface IClienteDAO  extends CrudRepository<Cliente, Long> {
public interface IClienteDAO  extends JpaRepository<Cliente, Long> {

    @Query("from Region")
    public List<Region> findAllRegiones();
}
