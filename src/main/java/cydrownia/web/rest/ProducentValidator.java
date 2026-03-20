package cydrownia.web.rest;

import cydrownia.model.Producent;
import cydrownia.service.ProducentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class ProducentValidator implements Validator {

    private final ProducentService producentService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Producent.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Producent producent = (Producent) target;

        if (producentService.getProducentById(producent.getId()) != null) {
            errors.rejectValue("id", "producent.duplicated",
                    "Producent o tym ID już istnieje");
        }

    }
}