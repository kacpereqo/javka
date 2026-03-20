package cydrownia.web.ui;

import cydrownia.model.Producent;
import cydrownia.service.ProducentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
public class ProducentController {

    private final ProducentService producentService;

    @GetMapping("/producers")
    public String getProducenci(Model model) {
        log.info("Pobieranie listy producentów");

        List<Producent> producenci = producentService.getAllProducents();

        log.info("Znaleziono {} producentów", producenci.size());

        model.addAttribute("producenci", producenci);
        model.addAttribute("title", "Nasi Producenci");

        return "producersView";
    }
}