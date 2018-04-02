import java.text.ParseException;

public class Main {

        public static void main(String[] args) throws ParseException {


                //Cria Customer
                Customers customer = new Customers();
                System.out.println(customer.createCustomers().getOwnId());
                System.out.println(customer.getCustomer());

                //Solicita autorização
                Auth auth = new Auth();
                System.out.println(auth.createAuth());

                //Retorna Token
                Tokens tokens = new Tokens();
                System.out.println(tokens.createTokens());
                //* verificar onde colocar o try catch*//*

                //Cria Multiorder
                Multiorders multiorders = new Multiorders();
                System.out.println(multiorders.createMultiorder().getId());


                //Pagamento Cartão
                Multipaycc multipayment = new Multipaycc();
                System.out.println(multipayment.createMultipayment());

                //Pagamento Boleto
                Multipayments multipaymentbol = new Multipayments();
                System.out.println(multipaymentbol.createMultipayment());

                //Libera Escrow
                Escrows escrow = new Escrows();
                System.out.println(escrow);
        }
}