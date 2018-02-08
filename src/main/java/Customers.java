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


        /**
         * Input fullname
         */
        System.out.println("\nInsira o seu nome completo: ");
        String fullname = input.next();

        /**
         * Input e-mail
         */
        System.out.println("\nInsira o seu e-mail: ");
        String email = input.next();

        /**
         * Input birthdate
         */
        System.out.println("\nInsira sua data de nascimento: ");
        String birthday = input.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        Date date = null;

         try  {
         Date date1 = dateFormat.parse(birthday);
         }
         catch (ParseException e){
            e.printStackTrace();
         }

        /**
         * Input tax document
         */
        System.out.println("\nInsira o nº do seu CPF: ");
        String taxDocumentNumber = input.next();

        /**
         * Input local phone
         */
        System.out.println("\nTelefone ");

        /**
         * Input ddd phone
         */
        System.out.println("\nInsira o nº do seu DDD: ");
        String phoneNumber = input.next();

        /**
         * Input  phone
         */
        System.out.println("\nInsira o nº do seu Telefone: ");
        String phoneNumberAreaCode = input.next();

        /**
         * Input  Address
         */
        System.out.println("\nEndereço ");

        /**
         * Input  Address Street
         */
        System.out.println("\nEndereço: ");
        String shippingAddressStreet = input.next();
        /**
         * Input  Address Number
         */
        System.out.println("\nNúmero: ");
        String shippingAddressStreetNumber = input.next();
        /**
         * Input  Address Complement
         */
        System.out.println("\nComplemento: ");
        String shippingAddressComplement = input.next();
        /**
         * Input  Address City
         */
        System.out.println("\nCidade: ");
        String shippingAddressCity = input.next();
        /**
         * Input  Address State
         */
        System.out.println("\nEstado: ");
        String shippingAddressState = input.next();
        /**
         * Input  Address District
         */
        System.out.println("\nBairro: ");
        String shippingAddressDistrict = input.next();

        /**
         * Input  Address Country
         */
        System.out.println("\nPais: ");
        String shippingAddressCountry = input.next();

        /**
         * Input  Address zipCode
         */
        System.out.println("\nCEP: ");
        String shippingAddressZipCode = input.next();

        try {

            customer = api.customer().create(new CustomerRequest()
                    .ownId("CUS-" + System.currentTimeMillis())
                    .fullname(fullname)
                    .email(email)
                    .birthdate(new ApiDateRequest().date(new Date(birthday)))
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
            );



        } catch (UnexpectedException e) {
            //StatusCode >= 500
        } catch (ValidationException e) {
            //StatusCode entre 400 e 499 (exceto 401)
        }

        return customer;
    }

    public Customer getCustomer(String id) {

        Customer getCustomer = api.customer().get(id);

        return getCustomer;
    }
}










        
