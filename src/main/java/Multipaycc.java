import br.com.moip.API;
import br.com.moip.exception.UnexpectedException;
import br.com.moip.exception.ValidationException;
import br.com.moip.request.*;
import br.com.moip.resource.Multipayment;
import sun.util.calendar.LocalGregorianCalendar;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Multipaycc {

    private Authorization config;

    private Authorization myAuth = new Authorization();

    private API api = myAuth.startConfig();

    private Scanner input = new Scanner(System.in);

    private Multiorders multiorder = new Multiorders();


    public Multipayment createMultipayment() throws ParseException {

        Multipayment multipayment = new Multipayment();


        // * Number Card

        System.out.println("\nNumero do cartão:");
        String numbc = input.next();


        // * CVV

        System.out.println("\nCVC:");
        Integer cvv = Integer.valueOf(input.next());


        // * Expiration Month

        System.out.println("\nMês expiração:");
        String mes = input.next();


        //* Expiration Year

        System.out.println("\nAno expiração:");
        String year = input.next();


        //* Name

        System.out.println("\nNome:");
        String HolderName = input.next();

        // * cpf

        System.out.println("\nCPF:");
        String Cpf = input.next();


        //* Input birthdate

    System.out.println("\nData de nascimento: ");
        String birthday = input.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMDD");
        LocalGregorianCalendar.Date date = null;
        Date date1 = dateFormat.parse(birthday);


        //*Input ddd phone

        System.out.println("DDD: ");
        String DDD = input.next();

        //**
        // * Input  phone
        //
        System.out.println("Telefone: ");
        String Number = input.next();

        try {

            multipayment = api.multipayment().create(new PaymentRequest()
                    .orderId(multiorder.getMultiorder())
                    .installmentCount(1)
                    .escrow(new PaymentRequest.EscrowRequest("Custódia de pagamento"))
                    .fundingInstrument(
                            new FundingInstrumentRequest()
                                    .creditCard(
                                            new CreditCardRequest()
                                                    .number(numbc)
                                                    .cvc(cvv)
                                                    .expirationMonth(mes)
                                                    .expirationYear(year)
                                                    .holder(
                                                            new HolderRequest()
                                                                    .fullname(HolderName)
                                                                    .birthdate(birthday)
                                                                    .phone(
                                                                            new PhoneRequest()
                                                                                    .setAreaCode(DDD)
                                                                                    .setNumber(Number)
                                                                    )
                                                                    .taxDocument(TaxDocumentRequest.cpf(Cpf))
                                                    )
                                    )
                    )
            );


        } catch (UnexpectedException e) {
            //StatusCode >= 500
        } catch (
                ValidationException e) {
            //StatusCode entre 400 e 499 (exceto 401)
        }

        return multipayment;
    }

}
    /*public void getMultipayment() {


        System.out.println("\n Digite o ID Moip do Order:");
        String id = input.next();
        Multipayment getMultipayment = api.multipayment().get(id);

        return;
    }
    }*/
