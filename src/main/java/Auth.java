import br.com.moip.API;
import br.com.moip.exception.UnexpectedException;
import br.com.moip.exception.ValidationException;
import br.com.moip.resource.ScopePermission;
import br.com.moip.resource.ScopePermissionList;

import java.text.ParseException;
import java.util.Scanner;

public class Auth {

    private Authorization config;

    private Authorization myAuth = new Authorization();

    private API api = myAuth.startConfig();

    private Scanner input = new Scanner(System.in);

    public Auth createAuth() throws ParseException {

        Auth auth = new Auth();

        try

        {
            String authURL = api.connect().getAuthorizeUrl("APP-M9R028T2FKM2",
                    "http://www.moip.com.br/blablabla",
                    new ScopePermissionList(ScopePermission.DEFINE_PREFERENCES
                            , ScopePermission.MANAGE_ACCOUNT_INFO
                            , ScopePermission.RECEIVE_FUNDS
                            , ScopePermission.REFUND
                            , ScopePermission.RETRIEVE_FINANCIAL_INFO
                            , ScopePermission.TRANSFER_FUNDS
                    )
            );
            System.out.println(authURL);

        } catch (UnexpectedException e)

        {//StatusCode >= 500
        } catch (ValidationException e)

        { //StatusCode entre 400 e 499 (exceto 401)
        }
        return auth;
    }
}
