package ma.enset.examjee.service;

import ma.enset.examjee.entities.Client;
import ma.enset.examjee.entities.Credit;
import ma.enset.examjee.entities.Remboursement;
import ma.enset.examjee.repositories.ClientRepository;
import ma.enset.examjee.repositories.CreditRepository;
import ma.enset.examjee.repositories.RemboursementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CreditBancaireImpl implements CreditBancaire {
    private ClientRepository clientRepository;
    private CreditRepository creditRepository;
    private RemboursementRepository remboursementRepository;
    @Override
    public Client saveClient(Client client) {
        return null;
    }

    @Override
    public Client getClientById(Long id) {
        return null;
    }

    @Override
    public List<Client> getAllClients() {
        return List.of();
    }

    @Override
    public Client updateClient(Long id, Client updatedClient) {
        return null;
    }

    @Override
    public void deleteClient(Long id) {

    }

    @Override
    public Credit saveCredit(Credit credit) {
        return null;
    }

    @Override
    public Credit getCreditById(Long id) {
        return null;
    }

    @Override
    public List<Credit> getAllCredits() {
        return List.of();
    }

    @Override
    public List<Credit> getCreditsByClientId(Long clientId) {
        return List.of();
    }

    @Override
    public Credit updateCredit(Long id, Credit updatedCredit) {
        return null;
    }

    @Override
    public void deleteCredit(Long id) {

    }

    @Override
    public Remboursement saveRemboursement(Remboursement remboursement) {
        return null;
    }

    @Override
    public Remboursement getRemboursementById(Long id) {
        return null;
    }

    @Override
    public List<Remboursement> getAllRemboursements() {
        return List.of();
    }

    @Override
    public List<Remboursement> getRemboursementsByCreditId(Long creditId) {
        return List.of();
    }

    @Override
    public Remboursement updateRemboursement(Long id, Remboursement updatedRemboursement) {
        return null;
    }

    @Override
    public void deleteRemboursement(Long id) {

    }
}
