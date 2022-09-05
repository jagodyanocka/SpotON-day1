package se.salt.jfs.saltstars;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;

public class GreetingHandler implements HttpHandler {
  @Override
  public void handle(HttpExchange exchange) throws IOException {
      System.out.println(exchange.getRequestMethod() + " " + exchange.getRequestURI());
      OutputStream stream = exchange.getResponseBody();
      exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
      exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "*");
      Headers responseHeaders = exchange.getResponseHeaders();
      responseHeaders.add("content-type", "application/json");
      String name = getQueryParameter("name", exchange.getRequestURI().getQuery());
      String data = """
          {
              "name": "%s"
          }
          """.formatted(name);
    
      exchange.sendResponseHeaders(200, data.length());
      stream.write(data.getBytes());
      stream.flush();
      stream.close();
      exchange.close();
  }


  String getQueryParameter(String parameterName, String queryString) {
    return "This should work, Yippee-ki-yay!!";
  } 
}
