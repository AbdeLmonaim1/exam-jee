package ma.enset.examjee.entities;

import lombok.Data;

@Data
public class CreditProfessionnel extends Credit{
    private String motif;
    private String raisonSociale;
}
