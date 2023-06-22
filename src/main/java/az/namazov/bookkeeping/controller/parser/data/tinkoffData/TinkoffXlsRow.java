package az.namazov.bookkeeping.controller.parser.data.tinkoffData;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class TinkoffXlsRow {

    private Date operationDate;
    private Date paymentDate;
    private int cardNumber;
    private String status;
    private double operationSum;
    private String operationCurrency;
    private double paymentSum;
    private String paymentCurrency;
    private double cashBack;
    private String category;
    private int mcc;
    private String description;
    private double bonusWithCashback;
    private double roundingOnInvestmentAccount;
    private double operationSumWithRounding;

    @Override
    public String toString() {
        return "TinkoffXlsRow{" + "operationDate=" + operationDate + ", paymentDate=" + paymentDate + ", cardNumber=" +
                cardNumber + ", status='" + status + '\'' + ", operationSum=" + operationSum + ", operationCurrency='" +
                operationCurrency + '\'' + ", paymentSum=" + paymentSum + ", paymentCurrency='" + paymentCurrency +
                '\'' + ", cashBack=" + cashBack + ", category='" + category + '\'' + ", mcc=" + mcc +
                ", description='" + description + '\'' + ", bonusWithCashback=" + bonusWithCashback +
                ", roundingOnInvestmentAccount=" + roundingOnInvestmentAccount + ", operationSumWithRounding=" +
                operationSumWithRounding + '}';
    }
}
