package se.salt.jfs.saltstars;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.util.Properties;

public class Application {

    public static void main(String... args) {
        try {
          Properties props = loadProperties();
          int serverPort = Integer.parseInt(props.get("server.port").toString());
          HttpServer server = HttpServer.create(new InetSocketAddress("0.0.0.0", serverPort), 0);
          server.createContext("/", new GreetingHandler());
          server.start();
          System.out.println("Salt Stars API is listening on port : " + serverPort);
        } catch (IOException e) {
          e.printStackTrace();
          System.out.println("Something went wrong! Shutting down the Kanye API...");
        }
      }
    
      static Properties loadProperties() {
    
        InputStream propertiesResource = Application.class.getClassLoader().getResourceAsStream("application.properties");
        Properties props = new Properties();
        try {
          props.load(propertiesResource);
        } catch (IOException e) {
          e.printStackTrace();
    
        }
        return props;
      }

}