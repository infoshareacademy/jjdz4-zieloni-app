package com.infoshareacademy.zieloni.admin.raport;

import com.infoshareacademy.zieloni.admin.raport.dto.UserActivity;
import com.infoshareacademy.zieloni.admin.raport.exception.InwigilatorNotFoundException;
import com.infoshareacademy.zieloni.registration.model.User;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;

public class RestClient {

    private static String url = "http://localhost:8081/planer-inwigilator/";
    private final Logger logger = LoggerFactory.getLogger(RestClient.class.getName());

    private Response getResponse(String sb) {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(sb);
            return webTarget.request().get();
        } catch (RuntimeException e) {
            logger.warn("brak połaczenia z rest api");
            return null;
        }
    }

    private List<UserActivity> checkStatusIsOK(Response response) {
        if (response != null && response.getStatus() == Status.OK.getStatusCode()) {
            List<UserActivity> restInwigilatorResponse = response.readEntity(new GenericType<List<UserActivity>>() {
            });
            response.close();
            return restInwigilatorResponse;
        } else {
            if (response != null) {
                response.close();
            }
            logger.warn("Nie znaleziona listy użykowników dla tego kryterium");
            return null;
        }
    }

    private List<String> checkStatusListResponse(Response response) {
        if (response != null && response.getStatus() == Status.OK.getStatusCode()) {
            List<String> restInwigilatorResponse = response.readEntity(new GenericType<List<String>>() {
            });
            response.close();
            return restInwigilatorResponse;
        } else {
            if (response != null) {
                response.close();
            }
            logger.warn("Nie znaleziona listy użykowników dla tego kryterium");
            return null;
        }
    }

    public List<UserActivity> getUserList() {
        final Response response = getResponse(url + "users/");
        return checkStatusIsOK(response);
    }


    public List<String> getDataOfUserAge(String path) {
        final Response response = getResponse(url + "users/" + path);
        return checkStatusListResponse(response);
    }

    public void infoAboutUserActivity(User user, String activity) {

        String address = url + "user";

        JSONObject obj = new JSONObject();
        obj.put("name", user.getName());
        obj.put("surname", user.getSurname());
        obj.put("login", user.getLogin());
        obj.put("activity", activity);
        obj.put("age", user.getAge());
        obj.put("gender", user.getGender());

        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(address);
            webTarget.request().post(Entity.entity(obj, MediaType.APPLICATION_JSON_TYPE));
        } catch (RuntimeException e) {
            logger.warn("brak połaczenia z rest api");
        }
    }
}
