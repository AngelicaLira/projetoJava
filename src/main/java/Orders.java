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

        // Writter product
        System.out.println("Digite o nome do produto");
        String addItemName = input.next();

        // Quantit
        System.out.println("Quantidade: ");
        Integer addItemquantity = Integer.valueOf(input.next());

        // Details
        System.out.println("Detalhe... ");
        String addItemdetail = input.next();

        // Price
        System.out.println("Preço: ");
        Integer addItemdetailprice = Integer.valueOf(input.next());

        // Customer ID
        System.out.println("ID Moip: ");
        String customer = input.next();

        // Customer Name
        System.out.println("Nome: ");
        String fullname = input.next();

        // Customer Email
        System.out.println("Email: ");
        String email = input.next();

        // Customer birthday
        System.out.println("\nInsira sua data de nascimento: ");
        String birthday = input.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        Date date = null;
        Date date1 = dateFormat.parse(birthday);

        // Customer CPF
        System.out.println("CPF: ");
        String taxDocumentNumber = input.next();

        // Customer Phone
        System.out.println("Telefone ");

        // Customer AreaPhone
        System.out.println("DDD: ");
        String phoneNumberAreaCode = input.next();

        // Customer NPhone
        System.out.println("Telefone: ");
        String phoneNumber = input.next();

        // Customer Address
        System.out.println("Endereço ");

        // Customer Shipping Address
        System.out.println("Endereço: ");
        String shippingAddressStreet = input.next();

        // Customer Shipping Address Number
        System.out.println("N: ");
        String shippingAddressStreetNumber = input.next();

        // Customer Shipping Address complement
        System.out.println("Complemento: ");
        String shippingAddressComplement = input.next();

        // Customer Shipping Address City
        System.out.println("Cidade: ");
        String shippingAddressCity = input.next();

        // Customer Shipping Address State
        System.out.println("Estado: ");
        String shippingAddressState = input.next();

        // Customer Shipping Address Disctrict
        System.out.println("Bairro: ");
        String shippingAddressDistrict = input.next();

        // Customer Shipping Address Country
        System.out.println("Pais: ");
        String shippingAddressCountry = input.next();

        // Customer Shipping Address Zip
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

        System.out.println("\n Digite o Código Moip do pedido:");
        String id = input.next();
        Order getOrder = api.order().get(id);


        return getOrder;

}
private class Birthdate extends Date {

    }
}
