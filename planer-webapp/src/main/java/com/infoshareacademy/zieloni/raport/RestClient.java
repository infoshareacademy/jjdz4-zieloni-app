package com.infoshareacademy.zieloni.raport;

import com.infoshareacademy.zieloni.raport.dto.User;
import com.infoshareacademy.zieloni.raport.exception.CountryNotFoundException;

import javax.ws.rs.core.Response;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response.Status;
public class RestClient {

    //private final static String API_URL = "https://restcountries.eu/rest/v2/";

    private final static String API_URL = "http://localhost:8081/planer-inwigilator/";

    private Response getResponse(String sb) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(sb);
        final Response response = webTarget.request().get();
        return response;
    }

    private List<User> checkStatusIsOK(Response response) {
        if (response.getStatus() == Status.OK.getStatusCode()) {
            List<User> restCountryResponse = response.readEntity(new GenericType<List<User>>() {});
            response.close();
            return restCountryResponse;
        } else {
            response.close();
            throw new CountryNotFoundException("Not found country for given parameter.");
        }
    }


    public  List<User> getUserList(){

        final Response response = getResponse(API_URL + "users/");
        List<User> restResponse = checkStatusIsOK(response);
        return restResponse;
    }
}
