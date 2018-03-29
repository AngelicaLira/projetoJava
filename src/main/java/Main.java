import java.text.ParseException;
import br.com.moip.request.MultiorderRequest;
import br.com.moip.resource.Escrow;

public class Main {

    public static void main(String[] args) throws ParseException {

    //    Customers customer = new Customers();

//       System.out.println(customer.createCustomers().getOwnId());


       //* verificar onde colocar o try catch*//*

      Multiorders multiorder = new Multiorders();

      System.out.println(multiorder.createMultiorder().getId());
       //System.out.println(multiorder.getMultiorder());


      Multipaycc multipayment = new Multipaycc();

      System.out.println(multipayment.createMultipayment());
      System.out.println(multipayment.createMultipayment().getPayments().get(0).getEscrows().get(0).getDescription().toString());
       //System.out.println(multipayment.getMultipayment());

        Escrows escrow = new Escrows();
        System.out.println(escrow);



    }

    private static boolean escrow() {
        return true;
    }
}

