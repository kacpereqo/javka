package cydrownia.webrest;

import cydrownia.model.Cydr;
import cydrownia.service.CydrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class CydrController {

    @Autowired
    private CydrService cydrService;

    @GetMapping
    public List<Cydr> getAllCydrs() {
        return cydrService.getAllCydrs();
    }
}

