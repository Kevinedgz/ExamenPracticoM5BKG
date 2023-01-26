package com.edu.exam.ExamenPracticoM5BKG.service;

import com.edu.exam.ExamenPracticoM5BKG.model.Producto;
import com.edu.exam.ExamenPracticoM5BKG.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service

public class ProductoServiceImpl extends GenericServiceImpl<Producto, Integer> implements ProductoService{

    @Autowired
    ProductoRepository pro;

    @Override
    public CrudRepository<Producto, Integer> getDao() {
        return pro;
    }

}
