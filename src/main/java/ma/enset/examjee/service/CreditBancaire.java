package ma.enset.examjee.service;

import ma.enset.examjee.dtos.*;
import ma.enset.examjee.entities.Client;
import ma.enset.examjee.entities.Credit;
import ma.enset.examjee.entities.Remboursement;
import ma.enset.examjee.exceptions.ClientNotFoundException;
import ma.enset.examjee.exceptions.CreditNotFoundException;
import ma.enset.examjee.exceptions.RemboursementNotFoundException;

import java.util.List;

public interface CreditBancaire {

    ClientDTO saveClient(ClientDTO clientDTO);
    ClientDTO getClientById(Long id) throws ClientNotFoundException;
    List<ClientDTO> getAllClients();
    ClientDTO updateClient(Long id, ClientDTO updatedClientDTO) throws ClientNotFoundException;

    ClientDTO updateClient(ClientDTO updatedClientDTO);

    void deleteClient(Long id) throws ClientNotFoundException;


    CreditDTO saveCredit(CreditDTO creditDTO) throws ClientNotFoundException;
    CreditDTO getCreditById(Long id) throws CreditNotFoundException;
    List<CreditDTO> getAllCredits();
    List<CreditDTO> getCreditsByClientId(Long clientId) throws ClientNotFoundException;
    CreditDTO updateCredit(Long id, CreditDTO updatedCreditDTO) throws CreditNotFoundException;
    void deleteCredit(Long id) throws CreditNotFoundException;


    CreditPersonnelDTO saveCreditPersonnel(CreditPersonnelDTO creditDTO) throws ClientNotFoundException;


    CreditImmobilierDTO saveCreditImmobilier(CreditImmobilierDTO creditDTO) throws ClientNotFoundException;


    CreditProfessionnelDTO saveCreditProfessionnel(CreditProfessionnelDTO creditDTO) throws ClientNotFoundException;


    RemboursementDTO saveRemboursement(RemboursementDTO remboursementDTO);
    RemboursementDTO getRemboursementById(Long id) throws RemboursementNotFoundException;
    List<RemboursementDTO> getAllRemboursements();
    List<RemboursementDTO> getRemboursementsByCreditId(Long creditId);

    RemboursementDTO updateRemboursement(RemboursementDTO updatedRemboursementDTO);

    void deleteRemboursement(Long id);


}
