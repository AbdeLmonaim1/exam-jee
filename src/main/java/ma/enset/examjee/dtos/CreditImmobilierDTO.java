package ma.enset.examjee.dtos;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import ma.enset.examjee.entities.Credit;
import ma.enset.examjee.enums.TypeBien;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class CreditImmobilierDTO extends CreditDTO {
    private TypeBien typeBien;
}
