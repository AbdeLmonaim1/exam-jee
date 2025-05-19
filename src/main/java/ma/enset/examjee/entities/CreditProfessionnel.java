package ma.enset.examjee.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@DiscriminatorValue("CPro")
public class CreditProfessionnel extends Credit{
    private String motif;
    private String raisonSociale;
}
