import br.com.moip.API;
import br.com.moip.exception.UnexpectedException;
import br.com.moip.exception.ValidationException;
import br.com.moip.request.*;
import br.com.moip.resource.Customer;

import java.util.Date;

public class Customers {

    private Authorization config;

    private Authorization myAuth = new Authorization();

    private API api = myAuth.startConfig();

    public Customers() {


        try {

            Customer customer = api.customer().create(new CustomerRequest()
                    .ownId("CUS-" + System.currentTimeMillis())
                    .fullname("Jose da Silva")
                    .email("josedasilva@email.com")
                    .birthdate(new ApiDateRequest().date(new Date("12/11/90")))
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
            );
            System.out.println(customer.toString());


        } catch (UnexpectedException e) {
            //StatusCode >= 500
        } catch (ValidationException e) {
            //StatusCode entre 400 e 499 (exceto 401)
        }

        }

    public Customers getCustomer() {
        return null;
    }
}





        
