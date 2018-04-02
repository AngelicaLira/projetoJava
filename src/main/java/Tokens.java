import br.com.moip.API;
import br.com.moip.exception.UnexpectedException;
import br.com.moip.exception.ValidationException;
import br.com.moip.request.ConnectRequest;
import br.com.moip.request.GrantType;
import br.com.moip.resource.Connect;
import br.com.moip.resource.Customer;

import java.text.ParseException;
import java.util.Scanner;

public class Tokens {
    private Authorization config;

    private Authorization myAuth = new Authorization();

    private API api = myAuth.startConfig();

    private Scanner input = new Scanner(System.in);

    public Tokens createTokens() throws ParseException {

        Tokens tokens = new Tokens();
/**
 * Input code
 */
        System.out.println("\nCole o code: ");
        String Code = input.next();

        try {

            Connect connect = api.connect().authorize(new ConnectRequest()
                    .clientId("APP-M9R028T2FKM2")
                    .clientSecret("88d970e11111485994ae95912ae4dc0a")
                    .code(Code)
                    .redirectUri("http://www.moip.com.br/blablabla")
                    .grantType(GrantType.AUTHORIZATION_CODE)
            );
            System.out.println(connect);


        } catch (UnexpectedException e)

        {//StatusCode >= 500
        } catch (ValidationException e)

        { //StatusCode entre 400 e 499 (exceto 401)
        }
        return tokens;
        }
    }

