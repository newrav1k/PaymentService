package ru.newrav1k.mirea.paymentservice.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.newrav1k.mirea.paymentservice.model.enums.PaymentTransactionalStatus;
import ru.newrav1k.mirea.paymentservice.model.enums.converter.PaymentTransactionalStatusConverter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentTransactional extends BaseEntity {

    private BigDecimal amount;

    private String currency;

    @Convert(converter = PaymentTransactionalStatusConverter.class)
    private PaymentTransactionalStatus paymentTransactionalStatus;

    private String errorMessage;

    @ManyToOne
    @JoinColumn(name = "sourceBankAccountId")
    private BankAccount sourceBankAccount;

    @ManyToOne
    @JoinColumn(name = "sourceBankAccountId")
    private BankAccount destinationBankAccount;

    @OneToMany(mappedBy = "paymentTransaction", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Refund> refunds;

}