package es.santander.ucrapl.mcs.service.impl;

import org.springframework.stereotype.Service;

import es.santander.ucrapl.mcs.documents.ExampleDocument;
import es.santander.ucrapl.mcs.dto.ExampleDTO;
import es.santander.ucrapl.mcs.map.ExampleMapper;
import es.santander.ucrapl.mcs.repository.ExampleRepository;
import es.santander.ucrapl.mcs.service.ExampleService;

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
