package co.simple.http.server.main;

import com.sun.net.httpserver.*;

import java.io.*;
import java.net.*;

public class Server {
    private static final String PATH_POINT = ".";
    private static final String PATH_STATIC_WEB = "static";
    private static final int PORT = 7770;
    private static final String HOSTNAME = "localhost";

    public static void main(String[] args) throws IOException {
        StringBuffer path = new StringBuffer(new File(PATH_POINT).getCanonicalPath());
        path.append(File.separator);
        path.append(PATH_STATIC_WEB);

        HttpServer httpServer = HttpServer.create();
        httpServer.createContext("/", new StaticHandler(path.toString(), false, false));
        httpServer.bind(new InetSocketAddress(HOSTNAME, PORT), 100);
        httpServer.start();
    }
}
