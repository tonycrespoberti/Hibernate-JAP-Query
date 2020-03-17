package com.myapp.bricolaje.model.persistency;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myapp.bricolaje.model.repo.Direccion;

@Repository
public interface IDireccionDao extends JpaRepository<Direccion, Integer> {
	
}
