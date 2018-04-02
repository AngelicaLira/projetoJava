import br.com.moip.API;
import br.com.moip.exception.UnexpectedException;
import br.com.moip.exception.ValidationException;
import br.com.moip.resource.Escrow;

import java.util.Scanner;


public class Escrows {
    private Authorization config;

    private Authorization myAuth = new Authorization();

    private API api = myAuth.startConfig();

    private Scanner input = new Scanner(System.in);

    public String releaseEscrow(String escrowId)  {

        try {
            Escrow escrow = api.escrow().release(escrowId);
            System.out.println(escrow);

        } catch (UnexpectedException e) {
            //StatusCode >= 500
        } catch (ValidationException e) {
            //StatusCode entre 400 e 499 (exceto 401)
        }
    return escrowId;
    }
}