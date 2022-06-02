package service;

import java.util.List;

import org.springframework.data.domain.Sort;

interface GenericService<D> {

	/**
	 * Obtenemos todos los elementos del repositorio asociado
	 * 
	 * @param sort Ordenacion
	 * @return List DTO
	 */
	List<D> findAll(Sort sort);

	/**
	 * Obtenemos todos los elementos del repositorio asociado
	 * 
	 * @return List DTO
	 */
	List<D> findAll();

	/**
	 * Obtenemos dato por id
	 * 
	 * @param id the id
	 * @return DTO dto
	 */
	D findById(String id);
	
	/**
	 * Obtenemos dato por lista ids
	 * 
	 * @param ids the id
	 * @return List DTO dtos
	 */
	List<D> findById(List<String> ids);

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
