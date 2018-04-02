import java.text.ParseException;
import br.com.moip.request.MultiorderRequest;
import br.com.moip.resource.Escrow;

public class Main {

    public static void main(String[] args) throws ParseException {


        /**
         * reembolso cartão
         */
        Refunds refund = new Refunds();
        System.out.println(refund.createRefunds());
        /**
         * reembolso boleto
         */

        RefundBoleto refunds = new RefundBoleto();
        System.out.println(refunds.createRefundBoleto());
    }
}


