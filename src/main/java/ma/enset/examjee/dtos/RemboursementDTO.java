package ma.enset.examjee.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.enset.examjee.entities.Credit;
import ma.enset.examjee.enums.TypeRemboursement;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class RemboursementDTO {

    private Long id;

    private Date date;

    private double montant;


    private TypeRemboursement type;
    private CreditDTO creditDTO;
}
