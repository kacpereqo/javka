package cydrownia.web.rest;

import cydrownia.web.rest.dto.CydrDTO;
import cydrownia.service.CydrService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class CydrValidator implements Validator {

    private final CydrService cydrService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(CydrDTO.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CydrDTO validatedCydr = (CydrDTO) target;

        boolean is_duplicated = cydrService.getAllCydrs().stream()
                .anyMatch(c -> c.getNazwa().equalsIgnoreCase(validatedCydr.getNazwa()));

        if (is_duplicated) {
            errors.rejectValue("nazwa", "cydr.duplicated", "Cydr o tej nazwie już istnieje");
        }
    }
}
