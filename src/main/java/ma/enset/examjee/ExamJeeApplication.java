package ma.enset.examjee;

import ma.enset.examjee.entities.Client;
import ma.enset.examjee.entities.CreditImmobilier;
import ma.enset.examjee.entities.CreditPersonnel;
import ma.enset.examjee.entities.Remboursement;
import ma.enset.examjee.enums.StatutCredit;
import ma.enset.examjee.enums.TypeBien;
import ma.enset.examjee.enums.TypeRemboursement;
import ma.enset.examjee.repositories.ClientRepository;
import ma.enset.examjee.repositories.CreditRepository;
import ma.enset.examjee.repositories.RemboursementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ExamJeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamJeeApplication.class, args);
    }
    @Bean
    CommandLineRunner initData(ClientRepository clientRepo, CreditRepository creditRepo, RemboursementRepository rembRepo) {
        return args -> {

            Client client = new Client();
            client.setNom("Monaim");
            client.setEmail("monaim.1@gmail.com");
            clientRepo.save(client);
            Client client1 = new Client();
            client1.setNom("Ahmed");
            client1.setEmail("ahmed.1@gmail.com");
            clientRepo.save(client1);


            CreditPersonnel creditPerso = new CreditPersonnel();
            creditPerso.setClient(client);
            creditPerso.setDateDemande(new Date());
            creditPerso.setDateAcception(new Date());
            creditPerso.setStatut(StatutCredit.EnCours);
            creditPerso.setMontant(10000);
            creditPerso.setDureeRemboursement(24);
            creditPerso.setTauxInteret(3.5);
            creditPerso.setMotif("Achat voiture");
            creditRepo.save(creditPerso);


            Remboursement remb1 = new Remboursement();
            remb1.setCredit(creditPerso);
            remb1.setDate(new Date());
            remb1.setMontant(450);
            remb1.setType(TypeRemboursement.Mensualite);
            rembRepo.save(remb1);


            CreditImmobilier creditImmo = new CreditImmobilier();
            creditImmo.setClient(client);
            creditImmo.setDateDemande(new Date());
            creditImmo.setDateAcception(new Date());
            creditImmo.setStatut(StatutCredit.Accepte);
            creditImmo.setMontant(150000);
            creditImmo.setDureeRemboursement(180);
            creditImmo.setTauxInteret(2.1);
            creditImmo.setTypeBien(TypeBien.Appartement);
            creditRepo.save(creditImmo);


            Remboursement remb2 = new Remboursement();
            remb2.setCredit(creditImmo);
            remb2.setDate(new Date());
            remb2.setMontant(10000);
            remb2.setType(TypeRemboursement.RemboursementAnticipe);
            rembRepo.save(remb2);

            System.out.println("Données initialisées dans la base.");
        };
    }

}
