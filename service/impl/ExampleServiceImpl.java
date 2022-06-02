package service.impl;

import org.springframework.stereotype.Service;

import documents.ExampleDocument;
import dto.ExampleDTO;
import map.ExampleMapper;
import repository.ExampleRepository;
import service.ExampleService;

/**
 * ExampleServiceImpl
 * 
 * Service de ExampleServiceImpl
 * 
 * @author jslopez
 */

@Service("exampleService")
public class ExampleServiceImpl extends BaseServiceImpl<ExampleDTO, ExampleDocument, ExampleRepository, ExampleMapper>
		implements ExampleService {
}
