package ru.newrav1k.mirea.paymentservice.model.enums;

import lombok.Getter;

@Getter
public enum RefundStatus {
    COMPLETED, FAILED;

    public static RefundStatus fromString(String string) {
        for (RefundStatus status : RefundStatus.values()) {
            if (status.toString().equalsIgnoreCase(string)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid refund status: " + string);
    }

}