package cydrownia.rest;

import cydrownia.model.Cydr;
import cydrownia.service.CydrService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CydrValidator implements Validator {

    private final CydrService cydrService;

    public CydrValidator(CydrService cydrService) {
        this.cydrService = cydrService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Cydr.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Cydr validatedCydr = (Cydr) target;

        boolean is_duplicated = cydrService.getAllCydrs().stream()
                .anyMatch(c -> c.getNazwa().equalsIgnoreCase(validatedCydr.getNazwa()));

        if (is_duplicated) {
            errors.rejectValue("nazwa", "cydr.duplicated", "Cydr o tej nazwie już istnieje");
        }
    }
}
