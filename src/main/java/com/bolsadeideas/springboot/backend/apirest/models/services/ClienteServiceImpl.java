package com.bolsadeideas.springboot.backend.apirest.models.services;

import com.bolsadeideas.springboot.backend.apirest.models.DAO.IClienteDAO;
import com.bolsadeideas.springboot.backend.apirest.models.DAO.IFacturaDAO;
import com.bolsadeideas.springboot.backend.apirest.models.DAO.IProductoDAO;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Factura;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Producto;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private IClienteDAO clienteDAO;

    @Autowired
    private IFacturaDAO facturaDAO;

    @Autowired
    private IProductoDAO productoDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pageable) {
        return clienteDAO.findAll(pageable);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteDAO.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteDAO.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return clienteDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Region> findAllRegiones() {
        return clienteDAO.findAllRegiones();
    }

    @Override
    @Transactional
    public Factura findFacturaById(Long id) {
        return facturaDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Factura saveFactura(Factura factura) {
        return facturaDAO.save(factura);
    }

    @Override
    @Transactional
    public void deleteFacturaById(Long id) {
        facturaDAO.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findProductoByNombre(String term) {
        return productoDAO.findByNombre(term);
    }
}
