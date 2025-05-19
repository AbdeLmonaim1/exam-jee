package ma.enset.examjee.dtos;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import ma.enset.examjee.entities.Credit;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class CreditPersonnelDTO extends CreditDTO {
    private String motif;
}
