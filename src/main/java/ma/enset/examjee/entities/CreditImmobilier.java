package ma.enset.examjee.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import ma.enset.examjee.enums.TypeBien;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@DiscriminatorValue("CI")
public class CreditImmobilier extends Credit {
    @Enumerated(EnumType.STRING)
    private TypeBien typeBien;
}
