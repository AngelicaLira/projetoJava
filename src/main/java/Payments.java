import br.com.moip.API;
import br.com.moip.exception.UnexpectedException;
import br.com.moip.exception.ValidationException;
import br.com.moip.request.*;
import br.com.moip.resource.Order;
import br.com.moip.resource.Payment;

public class Payments {

    private Authorization config;

    private Authorization myAuth = new Authorization();

    private API api = myAuth.startConfig();

    private Order id = new Order();

    public Payment createPayment() {

        Payment payment = new Payment();

        Order order;
        try {
            payment = api.payment().create(new PaymentRequest()
                    .orderId(String.valueOf(getClass()))
                    .installmentCount(1)
                    .fundingInstrument(new FundingInstrumentRequest()
                            .creditCard(new CreditCardRequest()
                                    .hash("")
                                    .holder(new HolderRequest()
                                            .fullname("Roberto Oliveira")
                                            .birthdate("1988-12-30")
                                            .taxDocument(TaxDocumentRequest.cpf("78994193600"))
                                            .phone(new PhoneRequest()
                                                    .countryCode("55")
                                                    .setAreaCode("11")
                                                    .setNumber("22849560")
                                            )
                                    )
                                    .store(true)
                            )
                    )
            );



            System.out.println(payment.toString());


        } catch (UnexpectedException e) {
            //StatusCode >= 500
        } catch (ValidationException e) {
            //StatusCode entre 400 e 499 (exceto 401)
        }

        return payment;
    }
}







