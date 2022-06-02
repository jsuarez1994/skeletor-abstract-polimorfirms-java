package mapper;

import org.mapstruct.Mapper;

import documents.ExampleDocument;
import dto.ExampleDTO;

/**
 * Mapper for the entity {@link ExampleDocument} and its DTO {@link ExampleDTO}.
 * 
 * @author jslopez
 */
@Mapper(componentModel = "spring", uses = {})
public interface ExampleMapper extends BaseMapper<ExampleDTO, ExampleDocument> {

}
