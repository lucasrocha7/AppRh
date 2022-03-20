package com.AppRH.AppRH.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.AppRH.AppRH.models.Recado;


public interface RecadoRepository extends CrudRepository<Recado, String> {
	Recado findByCodigo(long codigo);
	List<Recado> findByNome(String Recado);
}
