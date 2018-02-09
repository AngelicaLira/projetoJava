import java.text.ParseException;

public class Main {

    public static void main(String[] args, Payments.OrderID payments) throws ParseException {

        Customers customer = new Customers();

       System.out.println(customer.createCustomers().getOwnId());


       //* verificar onde colocar o try catch*//*

      System.out.println(customer.getCustomer());


        Payments payment = new Payments();

        System.out.println(payments.createPayments());
        System.out.println(payments.getPayments());

        Payments2 cc = new Payments2();

        System.out.println(payments.createPayments());


    }
}

