import br.com.moip.resource.Customer;
import br.com.moip.resource.Order;



public class Main {

    public static void main(String[] args) {

        Customers customer = new Customers();

        Customers myCustomer = customer.getCustomer();


        Orders orders = new Orders();

        Order getOrder = orders.getOrder("ORD-NIRK69KW2H9C");
        System.out.println(getOrder);
    }
}
