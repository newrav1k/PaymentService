package ru.newrav1k.mirea.paymentservice.model.enums.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import ru.newrav1k.mirea.paymentservice.model.enums.PaymentTransactionalStatus;

@Converter(autoApply = true)
public class PaymentTransactionalStatusConverter implements AttributeConverter<PaymentTransactionalStatus, String> {

    @Override
    public String convertToDatabaseColumn(PaymentTransactionalStatus attribute) {
        return attribute == null ? null : attribute.name();
    }

    @Override
    public PaymentTransactionalStatus convertToEntityAttribute(String dbData) {
        return dbData == null ? null : PaymentTransactionalStatus.valueOf(dbData);
    }

}