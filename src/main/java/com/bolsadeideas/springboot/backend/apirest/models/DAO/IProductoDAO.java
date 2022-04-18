package com.bolsadeideas.springboot.backend.apirest.models.DAO;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductoDAO extends CrudRepository<Producto, Long> {

    @Query("select p from Producto p where p.nombre like %?1%")
    public List<Producto> findByNombre(String term);

    /* para buscar el parámetro 'term' que contenga en cualquier parte del campo
    se usa Containing o con StartingWith para buscar en el campo que inicie con el parámetro
    IgnoreCase se usa para ignorar mayúsculas o minúsculas */
    public List<Producto> findByNombreContainingIgnoreCase(String term);

    public List<Producto> findByNombreStartingWithIgnoreCase(String term);
}
