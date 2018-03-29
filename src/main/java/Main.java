import java.text.ParseException;

import br.com.moip.API;
import br.com.moip.request.*;
import br.com.moip.resource.Escrow;
import br.com.moip.resource.Multipayment;
import br.com.moip.resource.Payment;

public class Main {

    public static void main(String[] args) throws ParseException {


        //    Customers customer = new Customers();

//       System.out.println(customer.createCustomers().getOwnId());


        //* verificar onde colocar o try catch*//*
/*

        Multiorders multiorder = new Multiorders();

        System.out.println(multiorder.createMultiorder().getId());
        System.out.println(multiorder.getMultiorder());
*/


        Multipaycc multipayment = new Multipaycc();
        System.out.println(multipayment.createMultipayment());


        //System.out.println(multipayment.getMultipayment());


      Escrows escrow = new Escrows();
   System.out.println(escrow.getEscrow());


    }

}

/*
    private static boolean escrow() {
        return true;
    }
}*/

