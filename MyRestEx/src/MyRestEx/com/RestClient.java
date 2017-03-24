package MyRestEx.com;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class RestClient {

 /**
  * @param args
  */
 public static void main(String[] args) {
  RestClient client = new RestClient();
  client.sayHello();
  client.getMessage("Welcome");
  client.getXMLEmployees();
  client.getXMLEmployee(11111);
  client.getJSONEmployees();
  client.getJSONEmployee(11111);
 }
 
 private void sayHello() {
  try {
            Client client = Client.create();
            WebResource webResource = client.resource("http://localhost:8090/newWebApp/doj/webservice/hello");
            ClientResponse response = webResource.accept("text/plain").get(ClientResponse.class);
            System.out.println(response.getStatus());
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
 
            String output = response.getEntity(String.class);
            System.out.println("===plain text===");
            System.out.println(output);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
 private void getMessage(String msg) {
  try {
            Client client = Client.create();
            WebResource webResource = client.resource("http://localhost:8090/newWebApp/doj/webservice/message/"+msg);
            ClientResponse response = webResource.accept("text/plain").get(ClientResponse.class);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
 
            String output = response.getEntity(String.class);
            System.out.println("===message===");
            System.out.println(output);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
 private void getXMLEmployees() {
  try {
            Client client = Client.create();
            WebResource webResource = client.resource("http://localhost:8090/newWebApp/doj/webservice/employees");
            ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
 
            String output = response.getEntity(String.class);
            System.out.println("===xml format===");
            System.out.println(output);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 private void getXMLEmployee(int empid) {
  try {
            Client client = Client.create();
            WebResource webResource = client.resource("http://localhost:8090/newWebApp/doj/webservice/employee/"+empid);
            ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
 
            String output = response.getEntity(String.class);
            System.out.println("===xml format based on employee id===");
            System.out.println(output);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 private void getJSONEmployees() {
  try {
            Client client = Client.create();
            WebResource webResource = client.resource("http://localhost:8090/newWebApp/doj/webservice/json/employees/");
            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
 
            String output = response.getEntity(String.class);
            System.out.println("===json format===");
            System.out.println(output);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 private void getJSONEmployee(int empid) {
  try {
            Client client = Client.create();
            WebResource webResource = client.resource("http://localhost:8090/newWebApp/doj/webservice/json/employee/"+empid);
            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
 
            String output = response.getEntity(String.class);
            System.out.println("===json format based on employee id");
            System.out.println(output);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}