import br.com.moip.API;
import br.com.moip.exception.UnexpectedException;
import br.com.moip.exception.ValidationException;
import br.com.moip.request.PaymentRequest;
import br.com.moip.request.ApiDateRequest;
import br.com.moip.request.InstructionLinesRequest;
import br.com.moip.request.BoletoRequest;
import br.com.moip.request.FundingInstrumentRequest;
import br.com.moip.resource.Order;
import br.com.moip.resource.Payment;
import br.com.moip.resource.links.PaymentLinks;


import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Payments {


    private Authorization config;

    private Authorization myAuth = new Authorization();

    private API api = myAuth.startConfig();

    private Scanner input = new Scanner(System.in);



    public Payment createPayment() throws ParseException {

        Payment payment = new Payment();

               
      try {
          Orders order = new Orders();
          payment = api.payment().create(new PaymentRequest()
                        .orderId(order.getOrder().getId())
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

            } catch(
            UnexpectedException e)
            {
                //StatusCode >= 500
            } catch(
            ValidationException e)
            {
                //StatusCode entre 400 e 499 (exceto 401)
            }
            return payment;

        }

            public Payment getPayment() {
                

                System.out.println("\n Digite o ID Moip do Order:");
                String id = input.next();
                Payment getPayment = api.payment().get(id);
                
                return getPayment();
            }

        }








    


