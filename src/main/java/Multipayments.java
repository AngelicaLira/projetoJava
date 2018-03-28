import br.com.moip.API;
import br.com.moip.exception.UnexpectedException;
import br.com.moip.exception.ValidationException;
import br.com.moip.request.PaymentRequest;
import br.com.moip.request.ApiDateRequest;
import br.com.moip.request.InstructionLinesRequest;
import br.com.moip.request.BoletoRequest;
import br.com.moip.request.FundingInstrumentRequest;
import br.com.moip.resource.Multiorder;
import br.com.moip.resource.Multipayment;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;




public class Multipayments {
    private Authorization config;

    private Authorization myAuth = new Authorization();

    private API api = myAuth.startConfig();

    private Scanner input = new Scanner(System.in);

    private Multiorders multiorder = new Multiorders();


    public Multipayment createMultipayment() throws ParseException {

        Multipayment multipayment = new Multipayment();



        try {
                    multipayment = api.multipayment().create(new PaymentRequest()
                    .orderId(multiorder.createMultiorder().getOwnId())
                    .installmentCount(1)
                    .escrow(new PaymentRequest.EscrowRequest("Custódia de pagamento"))
                    .fundingInstrument(new FundingInstrumentRequest()
                            .boleto(new BoletoRequest()
                                    .expirationDate(new ApiDateRequest().date(new GregorianCalendar(2020, Calendar.NOVEMBER, 10).getTime()))
                                    .logoUri("http://logo.com")
                                    .instructionLines(new InstructionLinesRequest()
                                            .first("Pagamento até 3 dias")
                                            .second("Sr Bancário não receber após o vencimento")
                                            .third("Terceira linha")
                                    )
                            )
                    )
            );

        } catch (UnexpectedException e) {
            //StatusCode >= 500
        } catch (
                ValidationException e) {
            //StatusCode entre 400 e 499 (exceto 401)
        }
        return multipayment;


    }



    public Multipayment getMultipayment() {


        System.out.println("\n Digite o ID Moip do Order:");
        String id = input.next();
        Multipayment getMultipayment = api.multipayment().get(id);

        return getMultipayment();
        }

        }