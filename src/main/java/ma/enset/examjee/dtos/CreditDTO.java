package ma.enset.examjee.dtos;

import jakarta.persistence.*;
import lombok.Data;
import ma.enset.examjee.entities.Client;
import ma.enset.examjee.entities.Remboursement;
import ma.enset.examjee.enums.StatutCredit;

import java.util.Date;
import java.util.List;


@Data
public class CreditDTO {


    private Long id;


    private Date dateDemande;


    private StatutCredit statut;

    private Date dateAcception;

    private double montant;
    private int dureeRemboursement;
    private double tauxInteret;
    private ClientDTO clientDTO;

}


