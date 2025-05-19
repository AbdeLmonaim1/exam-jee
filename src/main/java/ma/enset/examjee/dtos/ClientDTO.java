package ma.enset.examjee.dtos;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.examjee.entities.Credit;

import java.util.List;


@Data
public class ClientDTO {

    private Long id;

    private String nom;
    private String email;
}


