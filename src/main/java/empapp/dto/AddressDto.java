package empapp.dto;

import lombok.Data;
import org.hibernate.envers.Audited;

@Data
@Audited
public class AddressDto {

    private Long id;

    private String city;
}
