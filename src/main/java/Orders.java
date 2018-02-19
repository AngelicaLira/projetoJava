import br.com.moip.API;
import br.com.moip.exception.UnexpectedException;
import br.com.moip.exception.ValidationException;
import br.com.moip.request.OrderRequest;
import br.com.moip.request.CustomerRequest;
import br.com.moip.request.ApiDateRequest;
import br.com.moip.request.TaxDocumentRequest;
import br.com.moip.request.PhoneRequest;
import br.com.moip.request.ShippingAddressRequest;
import br.com.moip.resource.Order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Orders {

    private Authorization config;

    private Authorization myAuth = new Authorization();

    private API api = myAuth.startConfig();

    private Scanner input = new Scanner(System.in);

    public Order createOrder() throws ParseException {

        Order order = new Order();

        /**
         * Input Product Name
         */
        System.out.println("Digite o nome do produto");
        String addItemName = input.next();

        /**
         * Input Quantity
         */
        System.out.println("Quantidade: ");
        Integer addItemquantity = Integer.valueOf(input.next());

        /**
         * Input Details
         */
        System.out.println("Detalhe... ");
        String addItemdetail = input.next();

        /**
         * Input Price
         */
        System.out.println("Preço: ");
        Integer addItemdetailprice = Integer.valueOf(input.next());

        /**
         * Input ID Moip
         */
        System.out.println("ID Moip: ");
        String customer = input.next();

        /**
         * Input fullname
         */
        System.out.println("Nome: ");
        String fullname = input.next();

        /**
         * Input e-mail
         */
        System.out.println("Email: ");
        String email = input.next();

        /**
         * Input birthdate
         */
        System.out.println("\nInsira sua data de nascimento: ");
        String birthday = input.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        Date date = null;
        Date date1 = dateFormat.parse(birthday);

        /**
         * Input tax document
         */
        System.out.println("CPF: ");
        String taxDocumentNumber = input.next();

        /**
         * Input local phone
         */
        System.out.println("Telefone ");

        /**
         * Input ddd phone
         */
        System.out.println("DDD: ");
        String phoneNumberAreaCode = input.next();

        /**
         * Input  phone
         */
        System.out.println("Telefone: ");
        String phoneNumber = input.next();

        /**
         * Input address
         */
        System.out.println("Endereço ");

        /**
         * Input Address Street
         */
        System.out.println("Endereço: ");
        String shippingAddressStreet = input.next();

        /**
         * Input Address Number
         */
        System.out.println("N: ");
        String shippingAddressStreetNumber = input.next();

        /**
         * Input Address Complement
         */
        System.out.println("Complemento: ");
        String shippingAddressComplement = input.next();

        /**
         * Input Address City
         */
        System.out.println("Cidade: ");
        String shippingAddressCity = input.next();

        /**
         * Input Address State
         */
        System.out.println("Estado: ");
        String shippingAddressState = input.next();

        /**
         * Input Address District
         */
        System.out.println("Bairro: ");
        String shippingAddressDistrict = input.next();

        /**
         * Input Address Country
         */
        System.out.println("Pais: ");
        String shippingAddressCountry = input.next();

        /**
         * Input Address zipCode
         */
        System.out.println("CEP: ");
        String shippingAddressZipCode = input.next();

        try {

            order = api.order().create(new OrderRequest()
                    .ownId("ORD-" + System.currentTimeMillis())
                    .addItem(addItemName, addItemquantity,addItemdetail, addItemdetailprice)
                    .customer(new CustomerRequest()
                            .ownId("CUS-" + System.currentTimeMillis())
                            .fullname(fullname)
                            .email(email)
                            .birthdate(new ApiDateRequest().date(new Birthdate()))
                            .taxDocument(TaxDocumentRequest.cpf(taxDocumentNumber))
                                    .phone(new PhoneRequest().setAreaCode(phoneNumberAreaCode).setNumber(phoneNumber))
                                    .shippingAddressRequest(new ShippingAddressRequest().street(shippingAddressStreet)
                                            .streetNumber(shippingAddressStreetNumber)
                                            .complement(shippingAddressComplement)
                                            .city(shippingAddressCity)
                                            .state(shippingAddressState)
                                            .district(shippingAddressDistrict)
                                            .country(shippingAddressCountry)
                                            .zipCode(shippingAddressZipCode)
                                    )
                    )

            );

        } catch(UnexpectedException e) {
            //StatusCode >= 500
        } catch(ValidationException e) {
            //StatusCode entre 400 e 499 (exceto 401)
        }
        return order;
    }
    public Order getOrder() {

        System.out.println("\n Digite o ID Moip do Order:");
        String id = input.next();
        Order getOrder = api.order().get(id);


        return getOrder;

}
private class Birthdate extends Date {

    }
}
