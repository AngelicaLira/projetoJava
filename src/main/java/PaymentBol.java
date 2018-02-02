import br.com.moip.API;
import br.com.moip.exception.UnexpectedException;
import br.com.moip.exception.ValidationException;
import br.com.moip.request.*;
import br.com.moip.resource.Order;
import br.com.moip.resource.Payment;


import java.util.Calendar;
import java.util.GregorianCalendar;

public class PaymentBol {

    private Authorization config;

    private Authorization myAuth = new Authorization();

    private API api = myAuth.startConfig();

    private Order id = new Order();

    public Payment createPaymentBol() {

        Payment paymentBol = new Payment();

        Order order;

        try {

            paymentBol = api.payment().create(new PaymentRequest()
                    .orderId(String.valueOf(getClass()))
                    .installmentCount(1)
                    .fundingInstrument(new FundingInstrumentRequest()
                            .boleto(new BoletoRequest()
                                    .expirationDate(new ApiDateRequest().date(new GregorianCalendar(2020, Calendar.NOVEMBER, 10).getTime()))
                                    .logoUri("http://logo.com")
                                    .instructionLines(new InstructionLinesRequest()
                                            .first("Primeira linha")
                                            .second("Segunda linha")
                                            .third("Terceira linha")
                                    )
                            )

                    )
            );


            System.out.println(paymentBol.toString());


        } catch (UnexpectedException e) {
            //StatusCode >= 500
        } catch (ValidationException e) {
            //StatusCode entre 400 e 499 (exceto 401)
        }
        return paymentBol;


    }

}

