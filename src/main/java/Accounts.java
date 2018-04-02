import br.com.moip.API;
import br.com.moip.exception.UnexpectedException;
import br.com.moip.exception.ValidationException;
import br.com.moip.request.TaxDocumentRequest;
import br.com.moip.request.AccountRequest;
import br.com.moip.request.PersonRequest;
import br.com.moip.request.ShippingAddressRequest;
import br.com.moip.request.ApiDateRequest;
import br.com.moip.request.IdentityDocumentRequest;
import br.com.moip.request.PhoneRequest;
import br.com.moip.request.CompanyRequest;
import br.com.moip.resource.Account;
import java.util.GregorianCalendar;

import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;



public class Accounts {


    private Authorization config;

    private Authorization myAuth = new Authorization();

    private API api = myAuth.startConfig();

    private Scanner input = new Scanner(System.in);

    public boolean createAccount( ) throws ParseException {

        Account account = new Account();
       /*
         * Input email
         */
        System.out.println("Digite o seu email: ");
        String email = input.next();

        /*
         * Input BusinessSegment
         */
        System.out.println("Qual seguimento: ");
        String idBusiness = input.next();

        /*
         * Input Site
         */
        System.out.println("Site: ");
        String site = input.next();

        /*
         * Input Name
         */
        System.out.println("Nome: ");
        String name = input.next();

        /*
         * Input Last Name
         */
        System.out.println("Sobrenome: ");
        String lastName = input.next();

        /*
         * Input birthdate
         */
        System.out.println("\nInsira sua data de nascimento: ");
        String bday = input.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        Date date1 = dateFormat.parse(bday);

    /*    *//*
         * Input Nationality
         *//*
        System.out.println("Nacionalidade: ");
        String nationality = input.next();
*/
        /*
         * Input birthPlace
         */
        System.out.println("Naturalidade: ");
        String natural = input.next();

        /*
         * Input tax document
         */
        System.out.println("CPF: ");
        String taxDocumentNumber = input.next();

        /*
         * Input address
         */
        System.out.println("Endereço ");

        /*
         * Input Address Street
         */
        System.out.println("Rua: ");
        String shippingAddressStreet = input.next();

        /*
         * Input Address Number
         */
        System.out.println("N: ");
        String shippingAddressStreetNumber = input.next();

        /*
         * Input Address Complement
         */
        System.out.println("Complemento: ");
        String shippingAddressComplement = input.next();

        /*
         * Input Address City
         */
        System.out.println("Cidade: ");
        String shippingAddressCity = input.next();

      /*  *//*
         * Input Address State(duas letras)
         *//*
        System.out.println("Estado com duas letras: ");
        String shippingAddressState = input.next();*/

        /*
         * Input Address District
         */
        System.out.println("Bairro: ");
        String shippingAddressDistrict = input.next();

   /*     *//*
         * Input Address Country (3 letras)
         *//*
        System.out.println("Pais com 3 letras: ");
        String shippingAddressCountry = input.next();
*/
        /*
         * Input Address zipCode
         */
        System.out.println("CEP: ");
        String shippingAddressZipCode = input.next();

        /*
         * Input local phone
         */
        System.out.println("Telefone ");

      /*  *//*
         * Input ddd phone
         *//*
        System.out.println("DDI: ");
        String phoneNumberCountryCode = input.next();*/
        /*
         * Input ddd phone
         */
        System.out.println("DDD: ");
        String phoneNumberAreaCode = input.next();

        /*
         * Input  phone
         */
        System.out.println("Telefone: ");
        String phoneNumber = input.next();

        /*
         * Input  Identity
         */
        System.out.println("Documento de identidade ");

        /*
         * Input  Identity Number
         */
        System.out.println("RG: ");
        String identityNumber = input.next();

        /*
         * Input  Identity Issue
         */
        System.out.println("Orgão Emissor: ");
        String identityIssue = input.next();

        /*
         * Input  Date Issue
         */

        System.out.println("\nData de emissão do RG: ");
        String day = input.next();
        SimpleDateFormat days = new SimpleDateFormat("yyyyMMdd");
        Date day2 = days.parse(day);


/*
        System.out.println("\nInsira sua data de emissão: ");
        String dateIssue = input.next();
        SimpleDateFormat dates = new SimpleDateFormat();
        Date date2 = dates.parse(null);
*/

        /*
         * Input  Company
         */
        System.out.println("Dados da empresa");

        /*
         * Input  Name Company
         */
        System.out.println("Nome da empresa: ");
        String nameCompany = input.next();

        /*
         * Input  Business Name
         */
        System.out.println("Negócio: ");
        String businessName = input.next();

        /*
         * Input addressCompany
         */
        System.out.println("Endereço da empresa ");

        /*
         * Input Address Street Company
         */
        System.out.println("Rua: ");
        String companyAddressStreet = input.next();

        /*
         * Input Address Number Company
         */
        System.out.println("N: ");
        String companyAddressStreetNumber = input.next();

        /*
         * Input Address Complement Company
         */
        System.out.println("Complemento: ");
        String companyAddressComplement = input.next();

        /*
         * Input Address City Company
         */
        System.out.println("Cidade: ");
        String companyAddressCity = input.next();

        /*
         * Input Address State Company
         */
       /* System.out.println("Estado com duas letras: ");
        String companyAddressState = input.next();*///


      /*  *//*
         * Input Address Country Company
         *//*
        System.out.println("Pais com tres letras: ");
        String companyAddressCountry = input.next();*/

        /*
         * Input Address zipCode company
         */
        System.out.println("CEP: ");
        String companyAddressZipCode = input.next();

        /*
         * Input CNAE company
         */
        System.out.println("Copie este CNAE 82.91-1/00" );
        String companyCNAE = input.next();

        /*
         * Input CNAE Description company
         */
        System.out.println("Descrição CNAE ");
        String companyCNAEDescription = input.next();


        /*
         * Input  Identity Company
         */
        System.out.println("Documento da empresa ");

        /*
         * Input  Identity Number Company
         */
        System.out.println("CNPJ(com pontuação): ");
        String companyIdentityNumber = input.next();

        /*
         * Input  Date Issue company
         */


        System.out.println("\nInsira sua data de abertura da empresa: ");
        String dateI = input.next();
        SimpleDateFormat dated3 = new SimpleDateFormat("ddMMyyyy");
        Date dateIn = dated3.parse(dateI);


        /*
         * Input local phone Company
         */
        System.out.println("Telefone Corporativo");

      /*  *//*
         * Input ddd phone company
         *//*
        System.out.println("DDI: ");
        String companyPhoneNumberCountryCode = input.next();*/
        /*
         * Input ddd phone company
         */
        System.out.println("DDD: ");
        String companyphoneNumberAreaCode = input.next();

        /*
         * Input  phone company
         */
        System.out.println("Telefone: ");
        String companyphoneNumber = input.next();


        try {

            account = api.account().create(new AccountRequest()
                    .email(email)
                    .type(AccountRequest.Type.MERCHANT)
                    .transparentAccount(false)
                    .businessSegment(new AccountRequest.BusinessSegmentRequest(idBusiness))
                    .site(site)
                    .person(new PersonRequest()
                            .name(name)
                            .lastName(lastName)
                            .birthDate(new ApiDateRequest().date(new GregorianCalendar(1990, Calendar.JANUARY, 1).getTime()))
                            .nationality("BRA")
                            .birthPlace(natural)
                            .taxDocument(TaxDocumentRequest.cpf(taxDocumentNumber))
                            .address(new ShippingAddressRequest()
                                    .street(shippingAddressStreet)
                                    .streetNumber(shippingAddressStreetNumber)
                                    .district(shippingAddressDistrict)
                                    .city(shippingAddressCity)
                                    .state("SP")
                                    .country("BRA")
                                    .zipCode(shippingAddressZipCode)
                            )
                            .phone(new PhoneRequest()
                                    .countryCode("55")
                                    .setAreaCode(phoneNumberAreaCode)
                                    .setNumber(phoneNumber)
                            )
                            .identityDocument(new IdentityDocumentRequest()
                                    .number(identityNumber)
                                    .issuer(identityIssue)
                                    .issueDate(new ApiDateRequest().date(new GregorianCalendar(1990, Calendar.JANUARY, 1).getTime()))
                                    .type(IdentityDocumentRequest.Type.RG)
                            )
                    )
                    .company(new CompanyRequest()
                            .name(nameCompany)
                            .businessName(businessName)
                            .address(new ShippingAddressRequest()
                                    .street(companyAddressStreet)
                                    .streetNumber(companyAddressStreetNumber)
                                    .district(companyAddressComplement)
                                    .city(companyAddressCity)
                                    .state("SP")
                                    .country("BRA")
                                    .zipCode(companyAddressZipCode)
                            )
                            .mainActivity(new CompanyRequest.MainActivityRequest()
                                    .cnae(companyCNAE)
                                    .description(companyCNAEDescription)
                            )
                            .taxDocument(TaxDocumentRequest.cnpj(companyIdentityNumber))
                            .openingDate(new ApiDateRequest().date(new GregorianCalendar(2000, Calendar.JANUARY, 1).getTime()))
                            .phone(new PhoneRequest()
                                    .countryCode("55")
                                    .setAreaCode(companyphoneNumberAreaCode)
                                    .setNumber(companyphoneNumber)
                            )
                    )

            );

            return true;

        } catch (UnexpectedException e) {
            //StatusCode >= 500
        } catch (ValidationException e) {
            //StatusCode entre 400 e 499 (exceto 401)
        }
        return false;
    }

    private class dateIssueCompany extends Date {
    }


    private class Birthdate extends Date {

    }

    private class DateIssue extends Date {

    }

    private class DateCompany extends Date {

    }
}
