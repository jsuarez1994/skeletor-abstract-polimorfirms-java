package es.santander.ucrapl.mcs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import es.santander.ucrapl.mcs.dao.impl.BaseDaoImpl;
import es.santander.ucrapl.mcs.documents.BaseDocument;
import es.santander.ucrapl.mcs.dto.BaseDTO;
import es.santander.ucrapl.mcs.map.BaseMapper;
import es.santander.ucrapl.mcs.repository.BaseRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase abstracta con metodos genericos
 * 
 * @author jslopez
 *
 * @param <D> dto
 * @param <E> document
 * @param <R> repository
 * @param <M> mapper
 */
@Slf4j
@Data
public class GenericServiceImpl<D extends BaseDTO, E extends BaseDocument, R extends BaseRepository<E>, M extends BaseMapper<D, E>> {

	/** the abstractDao */
	@Autowired
	protected BaseDaoImpl<D, E, R, M> dao;

	/**
	 * Obtenemos todos los elementos del repositorio asociado
	 * 
	 * @param sort Ordenacion
	 * @return List DTO
	 */
	public List<D> findAll(Sort sort) {
		log.info("Inicio AbstractServiceImpl.findAll");
		final List<D> list = (ObjectUtils.allNotNull(sort)) ? dao.findAll(sort) : dao.findAll();
		log.info("Fin findAll AbstractServiceImpl");
		return CollectionUtils.isEmpty(list) ? new ArrayList<>() : list;
	}

	/**
	 * Obtenemos todos los elementos del repositorio asociado
	 * 
	 * @return List DTO
	 */
	public List<D> findAll() {
		log.info("Inicio AbstractServiceImpl.findAll");
		final List<D> list = dao.findAll();
		log.info("Fin findAll AbstractServiceImpl");
		return CollectionUtils.isEmpty(list) ? new ArrayList<>() : list;
	}

	/**
	 * Obtenemos dato por id
	 * 
	 * @param id the id
	 * @return DTO dto
	 */
	public D findById(String id) {
		log.info("Inicio AbstractServiceImpl.findById, param: {}", id);
		final D dto = dao.findById(id);
		log.info("Fin AbstractServiceImpl.findById");
		return dto;
	}

	/**
	 * Obtenemos dato por lista id
	 * 
	 * @param ids the id
	 * @return List DTO dtos
	 */
	public List<D> findById(List<String> ids) {
		log.info("Inicio AbstractServiceImpl.findById, param: {} ids", ids.size());
		final List<D> dtos = dao.findById(ids);
		log.info("Fin AbstractServiceImpl.findById");
		return dtos;
	}

	/**
	 * Guardamos el DTO psasado por parametros
	 * 
	 * @param dto the DTO
	 * @return same DTO
	 */
	public D save(D dto) {
		log.info("Inicio AbstractServiceImpl.save: {}", dto);
		dao.save(dto);
		log.info("Fin AbstractServiceImpl.save");
		return dto;
	}

	/**
	 * Guardamos el DTO psasado por parametros
	 * 
	 * @param dtos the DTO
	 * @return same DTO
	 */
	public List<D> save(List<D> dtos) {
		log.info("Inicio AbstractServiceImpl.save List<DTO>");
		dao.save(dtos);
		log.info("Fin AbstractServiceImpl.save List<DTO>");
		return dtos;
	}

	/**
	 * Eliminamos el DTO psasado por parametros
	 * 
	 * @param dto the DTO
	 * @return same DTO
	 */
	public D delete(D dto) {
		log.info("Inicio AbstractServiceImpl.delete: {}", dto);
		dao.delete(dto);
		log.info("Fin AbstractServiceImpl.delete");
		return dto;
	}

	/**
	 * Eliminamos el DTO psasado por parametros
	 * 
	 * @param dtos the DTO
	 * @return same List DTO
	 */
	public List<D> delete(List<D> dtos) {
		log.info("Inicio AbstractServiceImpl.delete List<DTO>");
		dao.delete(dtos);
		log.info("Fin AbstractServiceImpl.delete List<DTO>");
		return dtos;
	}

	/**
	 * Eliminamos elemento by id
	 * 
	 * @param id the id
	 * @return same id
	 */
	public String delete(String id) {
		log.info("Inicio AbstractServiceImpl.delete, param: {}", id);
		dao.delete(id);
		log.info("Fin AbstractServiceImpl.delete");
		return id;
	}

}
