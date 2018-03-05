package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.dto.User;
import com.infoshareacademy.zieloni.exception.CountryNotFoundException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
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
            List<User> restCountryResponse = response.readEntity(new GenericType<List<User>>() {
            });
            response.close();
            return restCountryResponse;
        } else {
            response.close();
            throw new CountryNotFoundException("Not found country for given parameter.");
        }
    }


    public void test(){




        final Response response = getResponse(API_URL + "users/");
        List<User> restResponse = checkStatusIsOK(response);

      //  return restCountryResponse.get(0).getBorders();
        System.out.println("TEST"+restResponse);

    }




    /*public List<RestCountryResponse> findByCurrency(String currency) {
        final Response response = getResponse(API_URL + "currency/" + currency);
        List<RestCountryResponse> restCountryResponse = checkStatusIsOK(response);

        return restCountryResponse;
    }*/
}
