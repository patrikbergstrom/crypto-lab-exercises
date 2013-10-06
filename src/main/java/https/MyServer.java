package https;

import org.apache.commons.io.IOUtils;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.bio.SocketConnector;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.handler.HandlerList;
import org.mortbay.jetty.security.SslSocketConnector;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/*
Övning1:

Förberedelse: Lägg in crypto.example.com att peka på 127.0.0.1 i din host-fil

Med hjälp av src/main/doc/keytoolHelp, skapa en fil serverkeystore.jks, kör sedan main-metoden och slutligen gå till
https://crypto.example.com:6443. Väl där ska du med hjälp av webbläsaren kunna lägga till root-certifikatet till ditt OS
så att du nästa gång får ett trevligt "lås" i din webbläsare utan några varningar.
 */
public class MyServer {

    private Server server = new Server();

    public static void main(String[] args) throws Exception {
        MyServer myServer = new MyServer();
        myServer.setUp();
    }


	public void setUp() throws Exception {

        configureSslSocketConnector();

        HandlerList handlerList = new HandlerList();
        handlerList.addHandler(new AbstractHandler() {
            @Override
            public void handle(String s, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, int i) throws IOException, ServletException {

                System.out.println("uri: " + httpServletRequest.getRequestURI());
                System.out.println("queryString: " + httpServletRequest.getQueryString());
                System.out.println("method: " + httpServletRequest.getMethod());

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                IOUtils.copy(httpServletRequest.getInputStream(), baos);

                System.out.println("body: " + baos.toString());

                PrintWriter writer = httpServletResponse.getWriter();
                writer.append("testsvar");
                Random r = new Random();
                for (int j = 0; j < 10; j++) {
                    int value = r.nextInt(Integer.MAX_VALUE);
                    writer.append(value + "");
                }
                System.out.println();
                writer.close();
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            }
        });

        server.addHandler(handlerList);

        server.start();
    }
	
	private void configureSslSocketConnector() {
        SslSocketConnector sslSocketConnector = new SslSocketConnector();
        sslSocketConnector.setPort(6443);
        sslSocketConnector.setNeedClientAuth(false);

        String serverKeystore = this.getClass().getClassLoader().getResource("serverkeystore/serverkeystore.jks").getPath();
        sslSocketConnector.setKeystore(serverKeystore);
        sslSocketConnector.setKeyPassword("changeit");

        server.addConnector(sslSocketConnector);
    }
}
