import java.text.ParseException;
import br.com.moip.resource.Multiorder;

public class Main {

    public static void main(String[] args) throws ParseException {

        Customers customer = new Customers();

        System.out.println(customer.createCustomers().getId());

        // verificar onde colocar o try catch

        System.out.println(customer.getCustomer());

       //* verificar onde colocar o try catch*//*

        Multiorders multiorders = new Multiorders();

        System.out.println(multiorders.createMultiorder());

        System.out.println(multiorders.getMultiorder());
        //OK

    }
}



