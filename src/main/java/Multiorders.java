import br.com.moip.API;
import br.com.moip.exception.UnexpectedException;
import br.com.moip.exception.ValidationException;
import br.com.moip.request.MultiorderRequest;
import br.com.moip.request.OrderRequest;
import br.com.moip.resource.Multiorder;
import br.com.moip.request.AmountRequest;
import br.com.moip.request.OrderAmountRequest;
import br.com.moip.request.SubtotalsRequest;
import br.com.moip.request.CustomerRequest;
import br.com.moip.request.ApiDateRequest;
import br.com.moip.request.TaxDocumentRequest;
import br.com.moip.request.PhoneRequest;
import br.com.moip.request.ShippingAddressRequest;
import br.com.moip.request.ReceiverRequest;



import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class Multiorders {

    private Authorization config;

    private Authorization myAuth = new Authorization();

    private API api = myAuth.startConfig();

    private Scanner input = new Scanner(System.in);

    private Customers customers = new Customers();

    public Multiorder createMultiorder() throws ParseException {

        Multiorder multiorder = new Multiorder();


        /*
         * Input  Own_ID
         */
        System.out.println("\nID do pedido:" +(1));
        String IDPed = String.valueOf(1);

        /*
         * Selection product
         */
        System.out.println("\nEscolha o produto:");
        String Choose = input.next();

        /*
         * Selection Quantidade
         */
        System.out.println("\nQuantidade:");
        Integer Qnt = input.nextInt();

        /*
         * CUS_ID_intern
         */
        System.out.println("\nDigite seu código de cliente:");
        String IDCus = input.next();

        /*
         * Name
         */
        System.out.println("\nNome:");
        String CusName = input.next();

        /*
         * Email
         */
        System.out.println("\nEmail:");
        String email = input.next();
        /*
         * cpf
         */
        System.out.println("\nCPF:");
        String Cpf = input.next();

        /*
         *Input ddd phone
         */
        System.out.println("DDD: ");
        String DDD = input.next();

        /*
         * Input  phone
         */
        System.out.println("Telefone: ");
        String Number = input.next();

        /*
         * Input  Street
         */
        System.out.println("Rua: ");
        String Rua = input.next();

        /*
         * Input  Number
         */
        System.out.println("N: ");
        String Num = input.next();

        /*
         * Input  CEP
         */
        System.out.println("CEP: ");
        String CEP = input.next();

        /*
         * Input CITY
         */
        System.out.println("Cidade: ");
        String City = input.next();

        /*
         * Input State
         */
        System.out.println("Estado (2 digitos): ");
        String State = input.next();

        /*
         * Input Bairro
         */
        System.out.println("Bairro: ");
        String Bairro = input.next();


        try {
            multiorder = api.multiorder().create(new MultiorderRequest()
                    .ownId("abx123")
                    .addOrder(new OrderRequest()
                            .ownId(String.valueOf(IDPed))
                            .amount(new OrderAmountRequest()
                                    .subtotals(new SubtotalsRequest().shipping(2000))
                                    .currency("BRL")
                            )
                            .addItem(Choose, Qnt, "Teste", 2000)
                            .customer(new CustomerRequest()
                                    .ownId(IDCus)
                                    .fullname(CusName)
                                    .email(email)
                                    .birthdate(new ApiDateRequest().date(new GregorianCalendar(1988, Calendar.DECEMBER, 30).getTime()))
                                    .taxDocument(TaxDocumentRequest.cpf(Cpf))
                                    .phone(new PhoneRequest()
                                            .countryCode("55")
                                            .setAreaCode(DDD)
                                            .setNumber(Number))
                                    .shippingAddressRequest(new ShippingAddressRequest()
                                            .street(Rua)
                                            .streetNumber(Num)
                                            .zipCode(CEP)
                                            .city(City)
                                            .state(State)
                                            .complement("null")
                                            .district(Bairro))
                            )
                            .addReceiver(new ReceiverRequest()
                                    .secondary("MPA-818172182C15", new AmountRequest().percentual(10), false))
                            .addReceiver(new ReceiverRequest()
                                    .primary("MPA-101C9F83FF3A", new AmountRequest(), true))
                    )
                    .addOrder(new OrderRequest()
                            .ownId("pedido_2_id")
                            .amount(new OrderAmountRequest()
                                    .subtotals(new SubtotalsRequest().shipping(3000))
                                    .currency("BRL")
                            )
                            .addItem(Choose, Qnt, "Teste", 2000)
                            .customer(new CustomerRequest()
                                    .ownId(String.valueOf(IDCus))
                                    .fullname(CusName)
                                    .email(email)
                                    .birthdate(new ApiDateRequest().date(new GregorianCalendar(1988, Calendar.DECEMBER, 30).getTime()))
                                    .taxDocument(TaxDocumentRequest.cpf(Cpf))
                                    .phone(new PhoneRequest()
                                            .countryCode("55")
                                            .setAreaCode(DDD)
                                            .setNumber(Number))
                                    .shippingAddressRequest(new ShippingAddressRequest()
                                            .street(Rua)
                                            .streetNumber(Num)
                                            .zipCode(CEP)
                                            .city(City)
                                            .state(State)
                                            .complement("null")
                                            .district(Bairro))
                            )
                            .addReceiver(new ReceiverRequest()
                                    .primary("MPA-101C9F83FF3A", new AmountRequest(), true)
                            )
                    )
            );




        } catch (UnexpectedException e) {
            //StatusCode >= 500
        } catch (ValidationException e) {
            //StatusCode entre 400 e 499 (exceto 401)
        }

        return multiorder;
    }

        public String getMultiorder () {


            System.out.println("\nID Moip:");
            String id = input.next();
            String getMutiorder = String.valueOf(api.multiorder().get(id));


            return id;
        }

/*

        private int IDs () {
            int nextId = 0 + 1;
            int getNextId;


            int id = getNextId();
            return nextId;
        }

        private int getNextId () {
            return 1;
        }
*/

    }
