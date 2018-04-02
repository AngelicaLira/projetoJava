import br.com.moip.resource.Escrow;
import br.com.moip.resource.Multiorder;
import br.com.moip.resource.Multipayment;
import br.com.moip.resource.Payment;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Scanner input = new Scanner(System.in);

        //Cria Customer
    /*    Customers customer = new Customers();
        System.out.println(customer.createCustomers().getOwnId());
        //System.out.println(customer.getCustomer());
*/
        //Cria Multiorder
        Multiorder multiorders = new Multiorders().createMultiorder();
        System.out.println(multiorders.getId());


        // Pagamentos
        String escrowId;
        System.out.println("Escolha o método de pagamento (1- pagamento com cartao/ 2- pagamento com boleto):");
        int paymentMethod = input.nextInt();
        if (paymentMethod == 1) {

            //Pagamento Cartão
            Multipayment multipayment = new Multipaycc().createMultipayment(multiorders.getId());
            System.out.println(multipayment);
            escrowId = multipayment.getPayments().get(0).getEscrowId();

        } else {

            if (paymentMethod == 2) {

                //Pagamento Boleto
                Multipayment multipaymentbol = new Multipayments().createMultipayment(multiorders.getId());
                System.out.println(multipaymentbol);
                escrowId = multipaymentbol.getPayments().get(0).getEscrowId();
            }
            else {
                System.out.println("Método de pagamento inválido!");
                escrowId = "ERROR";
                System.exit(1);
            }
        }

        //Libera Escrow
        String escrow = new Escrows().releaseEscrow(escrowId);
        System.out.println(escrow);

        /*
         * reembolso cartão
         */
        String refundId;
        System.out.println("Selecione o metodo de pagamento (1- pagamento com cartao/ 2- pagamento com boleto):");
        int refundMethod = input.nextInt();
        if (refundMethod == 1)

        {
            String refund = new Refunds().createRefunds().getId();
            System.out.println(refund);

    } else

    {


        if (refundMethod == 2) {
            /*
             * reembolso boleto
             */

            String refunds = new RefundBoleto().createRefundBoleto().getId();
            System.out.println(refunds);

        } else {
                System.out.println("Método de pagamento inválido!");
                refundId = "ERROR";
                System.exit(1);
            }
        }

        //Cria Conta Moip
        Accounts accounts = new Accounts();
        System.out.println(accounts.createAccount());

        //Solicita autorização
        Auth auth = new Auth();
        System.out.println(auth.createAuth());

        //Retorna Token
        Tokens tokens = new Tokens();
        System.out.println(tokens.createTokens());
        //* verificar onde colocar o try catch*//*
    }
    }


