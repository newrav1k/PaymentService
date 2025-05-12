package ru.newrav1k.mirea.paymentservice.model.enums;

import lombok.Getter;

@Getter
public enum PaymentTransactionalStatus {
    PROCESSED, SUCCESSFUL, FAILED;

    public static PaymentTransactionalStatus fromString(String string) {
        for (PaymentTransactionalStatus status : PaymentTransactionalStatus.values()) {
            if (status.toString().equalsIgnoreCase(string)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid transactional status: " + string);
    }

}