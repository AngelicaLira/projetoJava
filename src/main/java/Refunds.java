import br.com.moip.API;
import br.com.moip.exception.UnexpectedException;
import br.com.moip.exception.ValidationException;
import br.com.moip.request.RefundRequest;
import br.com.moip.request.RefundingInstrumentRequest;
import br.com.moip.resource.Refund;

import java.text.ParseException;
import java.util.Scanner;

public class Refunds {


    private Authorization config;

    private Authorization myAuth = new Authorization();

    private API api = myAuth.startConfig();

    private Scanner input = new Scanner(System.in);

    public Refund createRefunds() throws ParseException {

        Refund refund = new Refund();

        /**
         * Input payment
         */
        System.out.println("\nQual pagamento deseja reembolsar? ");
        String Refunds = input.next();

        try {
            refund = api.refund().order(
                    new RefundRequest(Refunds)
                            .refundingInstrument(new RefundingInstrumentRequest().creditCard())
            );
        } catch (UnexpectedException e) {
            //StatusCode >= 500
        } catch (ValidationException e) {
            //StatusCode entre 400 e 499 (exceto 401)


        }
        return refund;
    }
}
