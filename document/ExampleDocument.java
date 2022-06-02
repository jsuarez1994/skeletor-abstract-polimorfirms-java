package documents;

import java.util.Date;

import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ExampleDocument
 * 
 * TABLA: table_example
 * 
 * @author jslopez
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter 
@Setter
@Document(collection = "table_example")
public class ExampleDocument extends BaseDocument {

	/** the countContable */
	@Field("count_contable")
	@Size(min = 7, max = 7)
	private String countContable;
	
	/** the sign */
	@Size(min = 1, max = 1)
	private String sign;
	
	/** the typeBalance */
	@Field("type_balance")
	@Size(min = 2, max = 2)
	private String typeBalance;

	/** the balanceDate */
	@Field("balance_date")
	private Date balanceDate;
	
}
