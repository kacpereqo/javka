package cydrownia.service;

import cydrownia.repository.mem.MemCydrRepository;
import cydrownia.repository.mem.MemProducentRepository;
import cydrownia.service.impl.CydrServiceBean;
import cydrownia.service.impl.ProducentServiceBean;

public class CydrowniaServiceMain {

    public static void main(String[] args) {
        System.out.println("Let's find cydrs and producents!");

        var cydrRepo = new MemCydrRepository();
        var producentRepo = new MemProducentRepository();

        var cydrService = new CydrServiceBean(cydrRepo);
        var producentService = new ProducentServiceBean(producentRepo);

        System.out.println("\n--- Lista Cydrów ---");
        System.out.println(cydrService.getAllCydrs());

        System.out.println("\n--- Lista Producentów ---");
        System.out.println(producentService.getAllProducents());
    }
}