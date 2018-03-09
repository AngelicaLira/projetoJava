import java.text.ParseException;
import br.com.moip.request.PaymentRequest;

public class Main {

    public static void main(String[] args) throws ParseException {

        Customers customer = new Customers();

       System.out.println(customer.createCustomers().getId());

       //* verificar onde colocar o try catch*//*

        Orders order = new Orders();

        System.out.println(order.createOrder().getId());

        System.out.println(order.getOrder());


        Payments payment = new Payments();

        System.out.println(payment.createPayment().getId());

        //System.out.println(payment.getPayment());
    }
}

