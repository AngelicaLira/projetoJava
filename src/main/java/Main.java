import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {

        Customers customer = new Customers();

       System.out.println(customer.createCustomers().getOwnId());


            /* verificar onde colocar o try catch*/

            System.out.println(customer.getCustomer());
        }
    }
