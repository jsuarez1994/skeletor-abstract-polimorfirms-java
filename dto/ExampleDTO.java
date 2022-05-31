package es.santander.ucrapl.mcs.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * CUCDocument
 * 
 * TABLA: ucr_cuc
 * 
 * @author jslopez
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter 
@Setter
public class CRIDTO extends BaseDTO {

	/** the countContable */
	private String countContable;

	/** the sign */
	private String sign;

	/** the typeBalance */
	private String typeBalance;

	/** the balanceDate */
	private Date balanceDate;

}
