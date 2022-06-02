package dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import map.BaseMapper;
import map.GenericMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase Abstracta generica
 * 
 * @author jslopez
 *
 * @param <D> the DTO
 * @param <E> the DOCUMENT
 * @param <R> the REPOSITORY
 * @param <M> the MAPPER
 */
@Slf4j
@Data
public class GenericDaoImpl<D, E, R extends MongoRepository<E, String>, M extends BaseMapper<D, E>> {

	/** the repository */
	@Autowired
	protected R repository;

	/** the mapper */
	@Autowired
	protected M mapper;
	
	/** Messagges Error */
	public static final String ERROR = "Error al guardar elemento: ";
	public static final String ERROR_DELETE = "Error al eliminar elemento: ";

	/**
	 * Obtenemos todos los elementos del repositorio asociado
	 * 
	 * @return List DTO
	 */
	public List<D> findAll() {
		log.info("Inicio AbstractDaoImpl.findAll");
		final List<D> list = mapper.toDto(repository.findAll());
		log.info("Fin AbstractDaoImpl.findAll");
		if (CollectionUtils.isEmpty(list)) {
			return new ArrayList<>();
		} else {
			return list;
		}
	}

	/**
	 * Obtenemos todos los elementos del repositorio asociado
	 * 
	 * @param sort ordenacion
	 * @return List DTO
	 */
	public List<D> findAll(Sort sort) {
		log.info("Inicio AbstractDaoImpl.findAll ordenado: {}", sort);
		final List<D> list = mapper.toDto(repository.findAll(sort));
		log.info("Fin AbstractDaoImpl.findAll");
		if (CollectionUtils.isEmpty(list)) {
			return new ArrayList<>();
		} else {
			return list;
		}

	}

	/**
	 * Obtenemos dato por id
	 * 
	 * @param id the id
	 * @return DTO dto
	 */
	public D findById(String id) {
		log.info("Inicio AbstractDaoImpl.findById param: {}", id);
		Optional<E> optDocument = repository.findById(id);
		D dto = null;
		if (optDocument.isPresent()) {
			dto = mapper.toDto(optDocument.get());
		}
		log.info("Fin AbstractDaoImpl.findById");
		return dto;
	}

	/**
	 * Obtenemos datos por lista ids
	 * 
	 * @param ids the list id
	 * @return List DTO dtos
	 */
	public List<D> findById(List<String> ids) {
		log.info("Inicio AbstractDaoImpl.findById param: {} ids", ids.size());
		Iterable<E> documents = repository.findAllById(ids);
		List<D> dtos = new ArrayList<>();
		documents.forEach(document -> dtos.add(mapper.toDto(document)));
		log.info("Fin AbstractDaoImpl.findById");
		return (CollectionUtils.isEmpty(dtos)) ? new ArrayList<>() : dtos;
	}

	/**
	 * Guardamos el DTO psasado por parametros
	 * 
	 * @param dto the DTO
	 * @return same DTO
	 */
	@Transactional
	public D save(D dto) {
		log.info("Inicio AbstractDaoImpl.save: {}", dto);
		final E document = mapper.toDocument(dto);
		try {
			if (ObjectUtils.allNotNull(document)) {
				repository.save(document);
			}
		} catch (DataAccessException  e) {
			log.error(ERROR+"{}", e.getMessage());
			throw e;
		}
		log.info("Fin AbstractDaoImpl.save");
		return dto;
	}

	/**
	 * Guardamos el DTO psasado por parametros
	 * 
	 * @param dtos the DTO
	 * @return same DTO
	 */
	@Transactional
	public List<D> save(List<D> dtos) {
		log.info("Inicio AbstractDaoImpl.save List<DTO>");
		final List<E> documents = dtos.stream().map(mapper::toDocument).distinct().collect(Collectors.toList());
		try {
			if (!CollectionUtils.isEmpty(documents)) {
				repository.saveAll(documents);
			}
		} catch (DataAccessException e) {
			log.error(ERROR+"{}", e.getMessage());
			throw e;
		}
		log.info("Fin AbstractDaoImpl.save List<DTO>");
		return dtos;
	}

	/**
	 * Eliminamos el DTO psasado por parametros
	 * 
	 * @param dto the DTO
	 * @return same DTO
	 */
	@Transactional
	public D delete(D dto) {
		log.info("Inicio AbstractDaoImpl.delete: {}", dto);
		final E document = mapper.toDocument(dto);
		try {
			if (ObjectUtils.allNotNull(document)) {
				repository.delete(document);
			}
		} catch (DataAccessException e) {
			log.error(ERROR_DELETE+"{}", e.getMessage());
			throw e;
		}
		log.info("Fin AbstractDaoImpl.delete");
		return dto;
	}

	/**
	 * Eliminamos el DTO psasado por parametros
	 * 
	 * @param dtos the DTO
	 * @return same List DTO
	 */
	@Transactional
	public List<D> delete(List<D> dtos) {
		log.info("Inicio AbstractDaoImpl.delete List<DTO>");
		final List<E> documents = dtos.stream().map(mapper::toDocument).distinct().collect(Collectors.toList());
		try {
			if (ObjectUtils.allNotNull(documents)) {
				repository.deleteAll(documents);
			}
		} catch (DataAccessException e) {
			log.error(ERROR_DELETE+"{}", e.getMessage());
			throw e;
		}
		log.info("Fin AbstractDaoImpl.delete List<DTO>");
		return dtos;
	}

	/**
	 * Eliminamos elemento by id
	 * 
	 * @param id the id
	 * @return same id
	 */
	@Transactional
	public String delete(String id) {
		log.info("Inicio AbstractDaoImpl.delete, param: {}", id);
		try {
			if (ObjectUtils.allNotNull(id)) {
				repository.deleteById(id);
			}
		} catch (DataAccessException e) {
			log.error(ERROR_DELETE+"{}", e.getMessage());
			throw e;
		}
		log.info("Fin AbstractDaoImpl.delete");
		return id;
	}

}
