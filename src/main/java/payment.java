import br.com.moip.API;
import br.com.moip.api.EscrowAPI;
import br.com.moip.exception.UnexpectedException;
import br.com.moip.exception.ValidationException;
import br.com.moip.request.*;
import br.com.moip.resource.Multipayment;

import java.util.Scanner;


public class payment {
    private Authorization config;

    private Authorization myAuth = new Authorization();

    private API api = myAuth.startConfig();

    private Scanner input = new Scanner(System.in);

    private Multiorders multiorder = new Multiorders();


}


