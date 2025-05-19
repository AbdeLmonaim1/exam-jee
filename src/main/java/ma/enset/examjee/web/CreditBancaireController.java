package ma.enset.examjee.web;

import lombok.AllArgsConstructor;
import ma.enset.examjee.dtos.ClientDTO;
import ma.enset.examjee.exceptions.ClientNotFoundException;
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

}
