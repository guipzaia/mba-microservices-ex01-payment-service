package br.com.fiap.paymentservice.dto;

import br.com.fiap.paymentservice.enums.Brand;
import br.com.fiap.paymentservice.enums.TransactionType;
import lombok.*;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private String uuid;
    @NotNull(message = "Campo 'brand' obrigatório")
    private Brand brand;
    @NotNull(message = "Campo 'transactionType' obrigatório")
    private TransactionType transactionType;
    @NotNull(message = "Campo 'cardNumber' obrigatório")
    private String cardNumber;
    @NotNull(message = "Campo 'expDate' obrigatório")
    private String expDate;
    @NotNull(message = "Campo 'cvv' obrigatório")
    @Size(min = 3, max = 3)
    private String cvv;
    @NotNull(message = "Campo 'price' obrigatório")
    @Digits(integer=5, fraction=2)
    private BigDecimal price;
}
