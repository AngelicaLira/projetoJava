import java.text.ParseException;

public class Main {

    public static void main(String[] args){

        Customers customer = new Customers();

        try {
            System.out.println(customer.createCustomers().getId());
        } catch (ParseException e) {
            e.printStackTrace();
        }


        System.out.println(customer.getCustomer("CUS-I7T8IVLDPI03"));

    //    Orders orders = new Orders();

      //  Order getOrder = orders.getOrder("ORD-NIRK69KW2H9C");
        //System.out.println(getOrder);

//        Payments payment = new Payments();
//
//        System.out.println(payment.createPayments());


     //   System.out.println(payment.toString());
    }
}

