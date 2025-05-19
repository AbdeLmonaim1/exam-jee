package ma.enset.examjee.service;

import lombok.AllArgsConstructor;
import ma.enset.examjee.dtos.*;
import ma.enset.examjee.entities.*;
import ma.enset.examjee.enums.StatutCredit;
import ma.enset.examjee.exceptions.ClientNotFoundException;
import ma.enset.examjee.exceptions.CreditNotFoundException;
import ma.enset.examjee.exceptions.RemboursementNotFoundException;
import ma.enset.examjee.mapper.CreditBancaireMapper;
import ma.enset.examjee.repositories.ClientRepository;
import ma.enset.examjee.repositories.CreditRepository;
import ma.enset.examjee.repositories.RemboursementRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CreditBancaireImpl implements CreditBancaire {
    private CreditRepository creditRepository;
    private ClientRepository clientRepository;
    private RemboursementRepository remboursementRepository;
    private CreditBancaireMapper mapper;
    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client savedClient = clientRepository.save(mapper.fromClientDTO(clientDTO));
        return mapper.fromClient(savedClient);
    }

    @Override
    public ClientDTO getClientById(Long id) throws ClientNotFoundException {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client not found"));
        return mapper.fromClient(client);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(client -> mapper.fromClient(client))
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO updateClient(Long id, ClientDTO updatedClientDTO) throws ClientNotFoundException {
        return null;
    }

    @Override
    public ClientDTO updateClient(ClientDTO updatedClientDTO) {
        Client updatedClient = clientRepository.save(mapper.fromClientDTO(updatedClientDTO));
        return mapper.fromClient(updatedClient);
    }

    @Override
    public void deleteClient(Long id) throws ClientNotFoundException {
        ClientDTO client = this.getClientById(id);
        clientRepository.deleteById(id);
    }

    @Override
    public CreditDTO saveCredit(CreditDTO creditDTO) throws ClientNotFoundException {
        Client client = clientRepository.findById(creditDTO.getClientDTO().getId())
                .orElseThrow(() -> new ClientNotFoundException("Client non trouvé"));

        Credit credit = mapper.fromCreditDTO(creditDTO);
        credit.setClient(client);
        credit.setStatut(StatutCredit.EnCours);
       credit.setDateDemande(new Date());
        credit.setDateAcception(null);
        Credit savedCredit = creditRepository.save(credit);
        return mapper.fromCredit(savedCredit);
    }

    @Override
    public CreditDTO getCreditById(Long id) throws CreditNotFoundException {
        Credit credit = creditRepository.findById(id)
                .orElseThrow(() -> new CreditNotFoundException("Crédit non trouvé"));
        return mapper.fromCredit(credit);
    }

    @Override
    public List<CreditDTO> getAllCredits() {
        List<Credit> credits = creditRepository.findAll();
        return credits.stream()
                .map(credit -> mapper.fromCredit(credit))
                .toList();
    }

    @Override
    public List<CreditDTO> getCreditsByClientId(Long clientId) throws ClientNotFoundException {
        clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException("Client non trouvé"));

        List<Credit> credits = creditRepository.findByClientId(clientId);
        return credits.stream()
                .map(credit -> mapper.fromCredit(credit))
                .toList();
    }

    @Override
    public CreditDTO updateCredit(Long id, CreditDTO updatedCreditDTO) throws CreditNotFoundException {
        Credit existingCredit = creditRepository.findById(id)
                .orElseThrow(() -> new CreditNotFoundException("Crédit non trouvé"));


        Credit credit = mapper.fromCreditDTO(updatedCreditDTO);
        credit.setId(id);
        credit.setClient(existingCredit.getClient());
        credit.setDateAcception(existingCredit.getDateAcception());

        Credit updatedCredit = creditRepository.save(credit);
        return mapper.fromCredit(updatedCredit);
    }

    @Override
    public void deleteCredit(Long id) throws CreditNotFoundException {
        CreditDTO credit = this.getCreditById(id);
        creditRepository.deleteById(id);
    }

    @Override
    public CreditPersonnelDTO saveCreditPersonnel(CreditPersonnelDTO creditDTO) throws ClientNotFoundException {
        Client client = clientRepository.findById(creditDTO.getClientDTO().getId())
                .orElseThrow(() -> new ClientNotFoundException("Client non trouvé"));

        CreditPersonnel credit = mapper.fromCreditPersonnelDTO(creditDTO);
        credit.setClient(client);
        CreditPersonnel savedCredit = creditRepository.save(credit);
        return mapper.fromCreditPersonnel(savedCredit);
    }



    @Override
    public CreditImmobilierDTO saveCreditImmobilier(CreditImmobilierDTO creditDTO) throws ClientNotFoundException {
        Client client = clientRepository.findById(creditDTO.getClientDTO().getId())
                .orElseThrow(() -> new ClientNotFoundException("Client non trouvé"));

        CreditImmobilier credit = mapper.fromCreditImmobilierDTO(creditDTO);
        credit.setClient(client);
        CreditImmobilier savedCredit = creditRepository.save(credit);
        return mapper.fromCreditImmobilier(savedCredit);
    }


    @Override
    public CreditProfessionnelDTO saveCreditProfessionnel(CreditProfessionnelDTO creditDTO) throws ClientNotFoundException {
        Client client = clientRepository.findById(creditDTO.getClientDTO().getId())
                .orElseThrow(() -> new ClientNotFoundException("Client non trouvé"));

        CreditProfessionnel credit = mapper.fromCreditProfessionnelDTO(creditDTO);
        credit.setClient(client);
        CreditProfessionnel savedCredit = creditRepository.save(credit);
        return mapper.fromCreditProfessionnel(savedCredit);
    }





    @Override
    public RemboursementDTO saveRemboursement(RemboursementDTO remboursementDTO) {
        Remboursement remboursement = mapper.fromRemboursementDTO(remboursementDTO);
        Remboursement savedRemboursement = remboursementRepository.save(remboursement);
        return mapper.fromRemboursement(savedRemboursement);
    }

    @Override
    public RemboursementDTO getRemboursementById(Long id) throws RemboursementNotFoundException {
        Remboursement remboursement = remboursementRepository.findById(id)
                .orElseThrow(() -> new RemboursementNotFoundException("Remboursement not found"));
        return mapper.fromRemboursement(remboursement);
    }

    @Override
    public List<RemboursementDTO> getAllRemboursements() {
        List<Remboursement> remboursements = remboursementRepository.findAll();
        return remboursements.stream()
                .map(mapper::fromRemboursement)
                .collect(Collectors.toList());
    }

    @Override
    public List<RemboursementDTO> getRemboursementsByCreditId(Long creditId) {
        List<Remboursement> remboursements = remboursementRepository.findByCreditId(creditId);
        return remboursements.stream()
                .map(mapper::fromRemboursement)
                .collect(Collectors.toList());
    }



    @Override
    public RemboursementDTO updateRemboursement(RemboursementDTO updatedRemboursementDTO) {
        Remboursement updatedRemboursement = remboursementRepository.save(mapper.fromRemboursementDTO(updatedRemboursementDTO));
        return mapper.fromRemboursement(updatedRemboursement);
    }

    @Override
    public void deleteRemboursement(Long id) {
        Remboursement remboursement = remboursementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Remboursement not found"));
        remboursementRepository.delete(remboursement);
    }
}
