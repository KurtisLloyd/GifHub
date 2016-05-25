package Main;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;

/**
 * Created by Kurtis Lloyd on 5/16/2016.
 */
public class LoginSocketHandler {
    private String username;
    private String password;

    @OnWebSocketConnect
    public void onConnect(Session user) throws Exception{
        String username = this.username;

    }
}
