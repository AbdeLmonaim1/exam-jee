package ma.enset.examjee.mapper;

import ma.enset.examjee.dtos.*;
import ma.enset.examjee.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CreditBancaireMapper {

    public ClientDTO fromClient(Client client) {
        if(client == null) {
            return null;
        }
        ClientDTO clientDto = new ClientDTO();
        BeanUtils.copyProperties(client, clientDto);
        return clientDto;
    }

    public Client fromClientDTO(ClientDTO clientDto) {
        if(clientDto == null) {
            return null;
        }
        Client client = new Client();
        BeanUtils.copyProperties(clientDto, client);
        return client;
    }
    public CreditDTO fromCredit(Credit credit) {
        if (credit == null) return null;
        CreditDTO dto = new CreditDTO();
        BeanUtils.copyProperties(credit, dto);
        dto.setClientDTO(fromClient(credit.getClient()));
        return dto;
    }

    public Credit fromCreditDTO(CreditDTO dto) {
        if (dto == null) return null;
        Credit credit = new Credit();
        BeanUtils.copyProperties(dto, credit);
        credit.setClient(fromClientDTO(dto.getClientDTO()));
        return credit;
    }
    public CreditPersonnelDTO fromCreditPersonnel(CreditPersonnel credit) {
        if (credit == null) return null;
        CreditPersonnelDTO dto = new CreditPersonnelDTO();
        BeanUtils.copyProperties(credit, dto);
        dto.setClientDTO(fromClient(credit.getClient()));

        return dto;
    }

    public CreditPersonnel fromCreditPersonnelDTO(CreditPersonnelDTO dto) {
        if (dto == null) return null;
        CreditPersonnel credit = new CreditPersonnel();
        BeanUtils.copyProperties(dto, credit);
        credit.setClient(fromClientDTO(dto.getClientDTO()));
        return credit;
    }
    public CreditImmobilierDTO fromCreditImmobilier(CreditImmobilier credit) {
        if (credit == null) return null;
        CreditImmobilierDTO dto = new CreditImmobilierDTO();
        BeanUtils.copyProperties(credit, dto);
        dto.setClientDTO(fromClient(credit.getClient()));
        return dto;
    }

    public CreditImmobilier fromCreditImmobilierDTO(CreditImmobilierDTO dto) {
        if (dto == null) return null;
        CreditImmobilier credit = new CreditImmobilier();
        BeanUtils.copyProperties(dto, credit);
        credit.setClient(fromClientDTO(dto.getClientDTO()));
        return credit;
    }
    public CreditProfessionnelDTO fromCreditProfessionnel(CreditProfessionnel credit) {
        if (credit == null) return null;
        CreditProfessionnelDTO dto = new CreditProfessionnelDTO();
        BeanUtils.copyProperties(credit, dto);
        dto.setClientDTO(fromClient(credit.getClient()));

        return dto;
    }

    public CreditProfessionnel fromCreditProfessionnelDTO(CreditProfessionnelDTO dto) {
        if (dto == null) return null;
        CreditProfessionnel credit = new CreditProfessionnel();
        BeanUtils.copyProperties(dto, credit);
        credit.setClient(fromClientDTO(dto.getClientDTO()));
        return credit;
    }
    public RemboursementDTO fromRemboursement(Remboursement remboursement) {
        if (remboursement == null) return null;
        RemboursementDTO dto = new RemboursementDTO();
        BeanUtils.copyProperties(remboursement, dto);
        dto.setCreditDTO(fromCredit(remboursement.getCredit()));
        return dto;
    }

    public Remboursement fromRemboursementDTO(RemboursementDTO dto) {
        if (dto == null) return null;
        Remboursement remboursement = new Remboursement();
        BeanUtils.copyProperties(dto, remboursement);
        remboursement.setCredit(fromCreditDTO(dto.getCreditDTO()));
        return remboursement;
    }
}
