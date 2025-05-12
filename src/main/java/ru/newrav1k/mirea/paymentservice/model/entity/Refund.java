package ru.newrav1k.mirea.paymentservice.model.entity;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.newrav1k.mirea.paymentservice.model.enums.RefundStatus;
import ru.newrav1k.mirea.paymentservice.model.enums.converter.RefundStatusConverter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Refund extends BaseEntity {

    private BigDecimal refundedAmount;

    private String reason;

    @Convert(converter = RefundStatusConverter.class)
    private RefundStatus status;

    @ManyToOne
    @JoinColumn(name = "paymentTransactionalId", referencedColumnName = "id")
    private PaymentTransactional paymentTransaction;

}