import br.com.moip.API;
import br.com.moip.exception.UnexpectedException;
import br.com.moip.exception.ValidationException;
import br.com.moip.request.PaymentRequest;
import br.com.moip.request.PhoneRequest;
import br.com.moip.request.HolderRequest;
import br.com.moip.request.TaxDocumentRequest;
import br.com.moip.request.FundingInstrumentRequest;
import br.com.moip.request.CreditCardRequest;
import br.com.moip.resource.Order;
import br.com.moip.resource.Payment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Payments2 {

    private Authorization config;

    private Authorization myAuth = new Authorization();

    private API api = myAuth.startConfig();

    private Scanner input = new Scanner(System.in);

    public class OrderID extends Orders {
        private Order orderId;
        Order order = orderId;


        public Payment createPayments() throws ParseException {

            Payment cc = new Payment();

            /**
             * Input hash
             */
            String hash = input.next("KMbEhVGkKmgujQ3+89gMtycqDUt7ApKnJE7GmIC+3zwbNaVUugGGEzDR+1NsLWlYilk/bJHIAi2nWECWRukgGgOHmh1BjbNbvcUfrLbpndQYgw/1ER1WyRYWg4ssFXanQw6cmpfXS53gOzVkeYBq3Mh9fUNapa4UGDf7axtfAa/eMenKU4a2p7Epbcau3RmylMySi77H/hFNGSE/+IRzXVMhtFxpQM6A4UtsxIWZVLSg+VohByWfEQfJvGjw8MsowX06Li7CCginIJ03xmW8lt4aCmBCJnRsaWmompoWeqkyIaoxQDzRsIhI/UG5PzMX1yF1noEu6zi4J2EnK0MNKw==");
            /**
             * Input NameHolder
             */
            System.out.println("\nTitular do cartão: ");
            String fullname = input.next();

            /**
             * Input birthdate
             */
            System.out.println("\nData de nascimento: ");
            String birthday = input.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
            Date date = null;
            Date date1 = dateFormat.parse(birthday);

            /**
             * Input local phone
             */
            System.out.println("\nTelefone ");

            /**
             * Input ddd phone
             */
            System.out.println("\nDDD: ");
            String phoneNumberAreaCode = input.next();

            /**
             * Input  phone
             */
            System.out.println("\nTelefone: ");
            String phoneNumber = input.next();

            /**
             * Input tax document
             */
            System.out.println("\nCPF: ");
            String taxDocumentNumber = input.next();



            try {
                cc = api.payment().create(new PaymentRequest()
                        .orderId(String.valueOf(orderId))
                        .installmentCount(1)
                        .fundingInstrument(new FundingInstrumentRequest()
                                .creditCard(new CreditCardRequest()
                                        .hash(hash)
                                        .holder(new HolderRequest()
                                                .fullname(fullname)
                                                .birthdate(birthday)
                                                .phone(new PhoneRequest().setAreaCode(phoneNumberAreaCode).setNumber(phoneNumber))
                                                .taxDocument(TaxDocumentRequest.cpf(taxDocumentNumber))
                                        )
                                )
                        )
                );


            } catch (UnexpectedException e) {
                //StatusCode >= 500
            } catch (ValidationException e) {
                //StatusCode entre 400 e 499 (exceto 401)
            }
            return cc;
        }
    }
}
