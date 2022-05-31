package es.santander.ucrapl.mcs.dao;

import java.util.List;

import org.springframework.data.domain.Sort;

/**
 * Clase Abstracta generica
 * 
 * @author jslopez
 *
 * @param <D>        the DTO
 */
public interface GenericDao<D> {

	/**
	 * Obtenemos todos los elementos del repositorio asociado
	 * 
	 * @return List DTO
	 */
	List<D> findAll();

	/**
	 * Obtenemos todos los elementos del repositorio asociado
	 * 
	 * @param sort ordenacion
	 * @return List DTO
	 */
	List<D> findAll(Sort sort);

	/**
	 * Obtenemos dato por id
	 * 
	 * @param id the id
	 * @return DTO dto
	 */
	D findById(String id);
	
	/**
	 * Obtenemos dato por id
	 * 
	 * @param id the id
	 * @return DTO dto
	 */
	List<D> findById(List<String> id);

	/**
	 * Guardamos el DTO psasado por parametros
	 * 
	 * @param dto the DTO
	 * @return same DTO
	 */
	D save(D dto);

	/**
	 * Guardamos el DTO psasado por parametros
	 * 
	 * @param dtos the DTO
	 * @return same DTO
	 */
	List<D> save(List<D> dtos);

	/**
	 * Eliminamos el DTO psasado por parametros
	 * 
	 * @param dto the DTO
	 * @return same DTO
	 */
	D delete(D dto);

	/**
	 * Eliminamos el DTO psasado por parametros
	 * 
	 * @param dtos the DTO
	 * @return same List DTO
	 */
	List<D> delete(List<D> dtos);

	/**
	 * Eliminamos elemento by id
	 * 
	 * @param id the id
	 * @return same id
	 */
	String delete(String id);

}
