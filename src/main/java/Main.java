import java.text.ParseException;
import br.com.moip.request.MultiorderRequest;
import br.com.moip.resource.Escrow;

public class Main {

    public static void main(String[] args) throws ParseException {

        //    Customers customer = new Customers();

//       System.out.println(customer.createCustomers().getOwnId());
        /**
         * reembolso cartão
         */
       Refunds refund = new Refunds();
        System.out.println(refund.createRefunds());
        /**
         * reembolso boleto
         */

        RefundBoleto refund = new RefundBoleto();
        System.out.println(refund.createRefundBoleto());

        Escrows escrow = new Escrows();
        System.out.println(escrow.toString());

        //* verificar onde colocar o try catch*//*
/*
      Multiorders multiorder = new Multiorders();

      System.out.println(multiorder.createMultiorder().getId());
       //System.out.println(multiorder.getMultiorder());


      Multipayments multipayments = new Multipayments();

      System.out.println(multipayments.createMultipayment());

       //System.out.println(multipayment.getMultipayment());





    }

    private static boolean escrow() {
        return true;
    }*/
    }
}

