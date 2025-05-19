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
@DiscriminatorValue("CPer")
public class CreditPersonnel extends Credit {
    private String motif;
}
