package com.shoppingapp.payment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_generator")
    private Long id;

    String type;

    // credit
    String cardNumber;
    String expireDate;
    String cvc;
    String creditHolder;

    // paypal
    String email;

    // bank
    String bankName;
    String accountNo;
    String bankHolder;

    Double total;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Payment{" +
                "id=" + id +
                ", type='" + type + '\'');
        switch (type) {
            case "CREDIT":
                sb.append(", cardNumber='" + cardNumber + '\'' +
                        ", expireDate='" + expireDate + '\'' +
                        ", cvc='" + cvc + '\'' +
                        ", creditHolder='" + creditHolder + '\'');
                break;
            case "PAYPAL":
                sb.append(", email='" + email + '\'');
                break;
            default:
                sb.append(", bankName='" + bankName + '\'' +
                        ", accountNo='" + accountNo + '\'' +
                        ", bankHolder='" + bankHolder + '\'');
                break;
        }
        sb.append(", total=" + total +
                '}');
        return sb.toString();
    }

}
