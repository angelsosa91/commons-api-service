package py.com.solar.commonsapi.models.validation;

import py.com.solar.commonsapi.models.enums.ShippingDispatchType;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DispatchTypeValidator implements ConstraintValidator<DispatchType, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return ShippingDispatchType.getByName(value) != null;
    }
}
