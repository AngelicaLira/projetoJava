import br.com.moip.API;
import br.com.moip.exception.UnexpectedException;
import br.com.moip.exception.ValidationException;
import br.com.moip.request.*;
import br.com.moip.resource.Refund;

import java.text.ParseException;
import java.util.Scanner;

public class RefundBoleto {

    private Authorization config;

    private Authorization myAuth = new Authorization();

    private API api = myAuth.startConfig();

    private Scanner input = new Scanner(System.in);

    public Refund createRefundBoleto() throws ParseException {

        Refund refund = new Refund();

        /**
         * Input Reembolso
         */
        System.out.println("\nQual pagamento deseja reembolsar? ");
        String Refunds = input.next();

        /**
         * Input Bank
         */
        System.out.println("\nQual numero do banco que deseja receber? ");
        String Bank = input.next();

        /**
         * Input Conta
         */
        System.out.println("\nNúmero da Conta:");
        String account = input.next();
        /**
         * Input Dig
         */
        System.out.println("\nDígito:");
        String Dig = input.next();

        /**
         * Input Agencia
         */
        System.out.println("\nAgência:");
        String agency = input.next();
        /**
         * Input Dig
         */
        System.out.println("\nDígito:");
        String Agdig = input.next();

        /**
         * Input Fullname
         */
        System.out.println("\nNome do portador ");
        String Name = input.next();

        /**
        * Input Fullname
         */
        System.out.println("\nSobrenome do portador ");
        String LastName = input.next();

        /**
         * Input tax document
         */
        System.out.println("\nInsira o nº do seu CPF: ");
        String taxDocumentNumber = input.next();

        /**
         * Input Amount
         */
        System.out.println("\nValor de reembolso: ");
        String Amt = input.next();

        try {
        refund = api.refund().order(
                new RefundRequest(Refunds)
                        .refundingInstrument(new RefundingInstrumentRequest()
                                .bankAccount(
                                        new BankAccountRequest()
                                                .checking()
                                                .bankNumber(Bank)
                                                .accountNumber(account)
                                                .accountCheckNumber(Dig)
                                                .agencyNumber(agency)
                                                .agencyCheckNumber(Agdig)
                                                .holder(new HolderRequest()
                                                        .fullname(Name)
                                                        .fullname(LastName)
                                                        .taxDocument(TaxDocumentRequest.cpf(taxDocumentNumber))
                                                )
                                )
                        )
                        .amount(Integer.valueOf(Amt))
        );

        } catch (UnexpectedException e) {
            //StatusCode >= 500
        } catch (ValidationException e) {
            //StatusCode entre 400 e 499 (exceto 401)
        }
        return refund;
    }
}
