package com.myapp.bricolaje.model.persistency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.bricolaje.model.repo.TipoProducto;

@Repository
public interface ITipoProductoDao extends JpaRepository<TipoProducto, Integer>{

}