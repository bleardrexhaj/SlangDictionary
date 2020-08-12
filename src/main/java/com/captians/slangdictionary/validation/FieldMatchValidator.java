package com.captians.slangdictionary.validation;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
    private String firstFieldName;
    private String secondFieldName;
    private String message;

    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        boolean valid = true;
        try
        {
            final Object firstObj = PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(firstFieldName);
            final Object secondObj = PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(secondFieldName);
            valid =  firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        }
        catch (final Exception ignore)
        {
            // ignore
        }

        if (!valid){
            context.unwrap(HibernateConstraintValidatorContext.class)
                    .addMessageParameter("0", firstFieldName.substring(0, 1).toUpperCase() + firstFieldName.substring(1))
                    .addMessageParameter("1", secondFieldName.substring(0, 1).toUpperCase() + secondFieldName.substring(1));
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(firstFieldName)
                    .addConstraintViolation().disableDefaultConstraintViolation();
        }
        return valid;
    }
}
