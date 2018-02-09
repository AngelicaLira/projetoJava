import br.com.moip.resource.Order;

public class main {

    public static void main(String[]args) {
        Orders orders = new Orders();

        Order getOrder = orders.getOrder("ORD-NIRK69KW2H9C");
        System.out.println(getOrder);
    }
}
