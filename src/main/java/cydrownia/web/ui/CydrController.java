package cydrownia.web.ui;

import cydrownia.model.Cydr;
import cydrownia.model.Producent;
import cydrownia.service.CydrService;
import cydrownia.service.ProducentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
public class CydrController {

    private final CydrService cydrService;
    private final ProducentService producentService; // Dodany serwis producenta

    @GetMapping("/ciders")
    public String getCydry(@RequestParam(required = false) Integer producerId, Model model) {
        List<Cydr> cydry;
        String widokTytul;

        if (producerId != null) {
            log.info("Pobieranie cydrów dla producenta ID: {}", producerId);

            Producent p = producentService.getProducentById(producerId);
            cydry = p.getOferta();
            widokTytul = "Cydry producenta: " + p.getNazwa();
        } else {
            log.info("Pobieranie wszystkich cydrów");
            cydry = cydrService.getAllCydrs();
            widokTytul = "Wszystkie dostępne cydry";
        }

        model.addAttribute("cydry", cydry);
        model.addAttribute("title", widokTytul);

        return "cidersView";
    }
}