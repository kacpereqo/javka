package cydrownia.config;

import cydrownia.service.CydrService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CydrInfoContributor implements InfoContributor {

    private final CydrService cydrService;

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("cydry", cydrService.getAllCydrs().size());
    }
}
