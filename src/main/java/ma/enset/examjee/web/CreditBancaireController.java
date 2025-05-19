package ma.enset.examjee.web;

import lombok.AllArgsConstructor;
import ma.enset.examjee.dtos.ClientDTO;
import ma.enset.examjee.dtos.CreditDTO;
import ma.enset.examjee.dtos.RemboursementDTO;
import ma.enset.examjee.exceptions.ClientNotFoundException;
import ma.enset.examjee.exceptions.CreditNotFoundException;
import ma.enset.examjee.exceptions.RemboursementNotFoundException;
import ma.enset.examjee.service.CreditBancaireImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CreditBancaireController {
    private CreditBancaireImpl creditBancaireService;
    @PostMapping("/clients")
    public ClientDTO saveClient(@RequestBody ClientDTO clientDTO) {
        return creditBancaireService.saveClient(clientDTO);
    }
    @GetMapping("/clients/{id}")
    public ClientDTO getClientById(@PathVariable Long id) throws ClientNotFoundException {
        return creditBancaireService.getClientById(id);
    }
    @GetMapping("/clients")
    public List<ClientDTO> getAllClients() {
        return creditBancaireService.getAllClients();
    }
    @PutMapping("/clients/{id}")
    public ClientDTO updateClient(@PathVariable Long id, @RequestBody ClientDTO updatedClientDTO) throws ClientNotFoundException {
        return creditBancaireService.updateClient(id, updatedClientDTO);
    }
    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable Long id) throws ClientNotFoundException {
        creditBancaireService.deleteClient(id);
    }
    @PostMapping
    public CreditDTO saveCredit(@RequestBody CreditDTO creditDTO) throws ClientNotFoundException {
        return creditBancaireService.saveCredit(creditDTO);
    }
    @GetMapping("/credit{id}")
    public CreditDTO getCreditById(@PathVariable Long id) throws CreditNotFoundException {
        return creditBancaireService.getCreditById(id);
    }
    @GetMapping("/credits")
    public List<CreditDTO> getAllCredits() {
        return creditBancaireService.getAllCredits();
    }
    @GetMapping("/credits/client/{clientId}")
    public List<CreditDTO> getCreditsByClientId(@PathVariable Long clientId) throws ClientNotFoundException {
        return creditBancaireService.getCreditsByClientId(clientId);
    }
    @PutMapping("/credit/{id}")
    public CreditDTO updateCredit(@PathVariable Long id, @RequestBody CreditDTO updatedCreditDTO) throws CreditNotFoundException {
        return creditBancaireService.updateCredit(id, updatedCreditDTO);
    }
    @DeleteMapping("credit/{id}")
    public void deleteCredit(@PathVariable Long id) throws CreditNotFoundException {
        creditBancaireService.deleteCredit(id);
    }
    @PostMapping("/remboursements")
    public RemboursementDTO saveRemboursement(@RequestBody RemboursementDTO remboursementDTO) {
        return creditBancaireService.saveRemboursement(remboursementDTO);
    }

    @GetMapping("/remboursements/{id}")
    public RemboursementDTO getRemboursementById(@PathVariable Long id) throws RemboursementNotFoundException {
        return creditBancaireService.getRemboursementById(id);
    }

    @GetMapping("/remboursements")
    public List<RemboursementDTO> getAllRemboursements() {
        return creditBancaireService.getAllRemboursements();
    }

    @GetMapping("/remboursements/credit/{creditId}")
    public List<RemboursementDTO> getRemboursementsByCreditId(@PathVariable Long creditId) {
        return creditBancaireService.getRemboursementsByCreditId(creditId);
    }

    @PutMapping("/remboursements/{id}")
    public RemboursementDTO updateRemboursement(@RequestBody RemboursementDTO updatedRemboursementDTO) {
        return creditBancaireService.updateRemboursement(updatedRemboursementDTO);
    }

    @DeleteMapping("/remboursements/{id}")
    public void deleteRemboursement(@PathVariable Long id) {
        creditBancaireService.deleteRemboursement(id);
    }
}
