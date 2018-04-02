import br.com.moip.API;
import br.com.moip.exception.UnexpectedException;
import br.com.moip.exception.ValidationException;
import br.com.moip.request.CustomerRequest;
import br.com.moip.request.ApiDateRequest;
import br.com.moip.request.TaxDocumentRequest;
import br.com.moip.request.PhoneRequest;
import br.com.moip.request.ShippingAddressRequest;
import br.com.moip.resource.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Customers {

    private Authorization config;

    private Authorization myAuth = new Authorization();

    private API api = myAuth.startConfig();

    private Scanner input = new Scanner(System.in);

    public Customer createCustomers() throws ParseException {

        Customer customer = new Customer();

        /*
         * Input fullname
         */
        System.out.println("\nPrimeiro Nome: ");
        String fullname = input.next();
        /*
         * Input e-mail
         */
        System.out.println("\nE-mail: ");
        String email = input.next();
        /*
         * Input birthdate
         */
        System.out.println("\nData de nascimento: ");
        String birthday = input.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        Date date = null;
        Date date1 = dateFormat.parse(birthday);
        /*
         * Input tax document
         */
        System.out.println("\nCPF: ");
        String taxDocumentNumber = input.next();
        /*
         * Input local phone
         */
        System.out.println("\nTelefone ");
        /*
         * Input ddd phone
         */
        System.out.println("\nDDD: ");
        String phoneNumberAreaCode = input.next();
        /*
         * Input  phone
         */
        System.out.println("\nTelefone: ");
        String phoneNumber= input.next();
        /*
         * Input  Address
         */
        System.out.println("\nEndereço ");
        /*
         * Input  Address Street
         */
        System.out.println("\nRua: ");
        String shippingAddressStreet = input.next();
        /*
         * Input  Address Number
         */
        System.out.println("\nNúmero: ");
        String shippingAddressStreetNumber = input.next();
        /*
         * Input  Address City
         */
        System.out.println("\nCidade: ");
        String shippingAddressCity = input.next();
        /*
         * Input  Address State
         */
        System.out.println("\nEstado (2 digitos): ");
        String shippingAddressState = input.next();
        /*
         * Input  Address District
         */
        System.out.println("\nBairro: ");
        String shippingAddressDistrict = input.next();
        /*
         * Input  Address zipCode
         */
        System.out.println("\nCEP: ");
        String shippingAddressZipCode = input.next();

        try {

            customer = api.customer().create(new CustomerRequest()
                    .ownId("CUS-" + System.currentTimeMillis())
                    .fullname(fullname)
                    .email(email)
                    .birthdate(new ApiDateRequest().date(new Birthdate()))
                    .taxDocument(TaxDocumentRequest.cpf(taxDocumentNumber))
                    .phone(new PhoneRequest().setAreaCode(phoneNumberAreaCode).setNumber(phoneNumber))
                    .shippingAddressRequest(new ShippingAddressRequest().street(shippingAddressStreet)
                            .streetNumber(shippingAddressStreetNumber)
                            .complement("Casa")
                            .city(shippingAddressCity)
                            .state(shippingAddressState)
                            .district(shippingAddressDistrict)
                            .country("BRA")
                            .zipCode(shippingAddressZipCode)
                    )
            );



        } catch (UnexpectedException e) {
            //StatusCode >= 500
        } catch (ValidationException e) {
            //StatusCode entre 400 e 499 (exceto 401)
        }

        return customer;
    }


    public String getCustomer() {



        System.out.println("\nDigite o ID Moip do Customer:");
        String id = input.next();
        String getCustomer = String.valueOf(api.customer().get(id));

        return id;
    }

    private class Birthdate extends Date {
    }
}



