import br.com.moip.API;
import br.com.moip.Client;
import br.com.moip.authentication.Authentication;
import br.com.moip.authentication.OAuth;

public class Authorization {
    public API startConfig (){
        Authentication auth = new OAuth("8e29bc8f46c342f3952ac4b96e80b76c_v2");
        Client client = new Client (Client.SANDBOX, auth);
        API api = new API (client);

        return api;

    }
}
