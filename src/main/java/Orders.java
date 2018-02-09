import br.com.moip.API;
import br.com.moip.exception.UnexpectedException;
import br.com.moip.exception.ValidationException;
import br.com.moip.request.*;
import br.com.moip.resource.Order;

import java.util.Date;

public class Orders {

    private Authorization config;

    private Authorization myAuth = new Authorization();

    private API api = myAuth.startConfig();

    public Order createOrder() {

        Order order = new Order();

        try {

            order = api.order().create(new OrderRequest()
                    .ownId("order_own_id")
                    .addItem("Nome do produto", 10, "Mais info...", 100)
                    .customer(new CustomerRequest()
                            .ownId("customer_own_id")
                            .fullname("Jose da Silva")
                            .email("josedasilva@email.com")
                            .birthdate(new ApiDateRequest().date(new Date()))
                            .taxDocument(TaxDocumentRequest.cpf("22222222222"))
                            .phone(new PhoneRequest().setAreaCode("11").setNumber("55443322"))
                            .shippingAddressRequest(new ShippingAddressRequest().street("Avenida Faria Lima")
                                    .streetNumber("3064")
                                    .complement("12 andar")
                                    .city("São Paulo")
                                    .state("SP")
                                    .district("Itaim")
                                    .country("BRA")
                                    .zipCode("01452-000")
                            )
                    )
            );
            System.out.println(order.toString());

        } catch(UnexpectedException e) {
            //StatusCode >= 500
        } catch(ValidationException e) {
            //StatusCode entre 400 e 499 (exceto 401)
        }
        return order;
    }
    public Order getOrder(String id) {

        Order order = new Order();

        try{
            order = api.order().get(id);

        } catch(UnexpectedException e) {
            //StatusCode >= 500
        } catch(ValidationException e) {
            //StatusCode entre 400 e 499 (exceto 401)
        }
        return order;
    }
}