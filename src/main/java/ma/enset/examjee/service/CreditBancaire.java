package ma.enset.examjee.service;

import ma.enset.examjee.entities.Client;
import ma.enset.examjee.entities.Credit;
import ma.enset.examjee.entities.Remboursement;

import java.util.List;

public interface CreditBancaire {
    Client saveClient(Client client);
    Client getClientById(Long id);
    List<Client> getAllClients();
    Client updateClient(Long id, Client updatedClient);
    void deleteClient(Long id);

    Credit saveCredit(Credit credit);
    Credit getCreditById(Long id);
    List<Credit> getAllCredits();
    List<Credit> getCreditsByClientId(Long clientId);
    Credit updateCredit(Long id, Credit updatedCredit);
    void deleteCredit(Long id);


    Remboursement saveRemboursement(Remboursement remboursement);
    Remboursement getRemboursementById(Long id);
    List<Remboursement> getAllRemboursements();
    List<Remboursement> getRemboursementsByCreditId(Long creditId);
    Remboursement updateRemboursement(Long id, Remboursement updatedRemboursement);
    void deleteRemboursement(Long id);
}
