package com.cda.intro2.client;

import com.cda.intro2.helpers.JsonHelper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiClientImpl implements ApiClient{
    private String jwt = "";
    @Override
    public <T> T get(String endpoint, TypeReference<T> typeReference) throws IOException {
        URL url = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + jwt);
        String responseAsString = getResponseBodyAsString(connection);
        connection.disconnect();
        return JsonHelper.jsonToObject(responseAsString, typeReference);
    }

    @Override
    public <T, Q> T post(String endpoint, Q body, TypeReference<T> typeReference) throws IOException {
        URL url = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + jwt);
        setRequestBodyFromString(connection, JsonHelper.objectToJson(body));
        String responseAsString = getResponseBodyAsString(connection);
        connection.disconnect();
        return JsonHelper.jsonToObject(responseAsString, typeReference);
    }

    @Override
    public <T, Q> T put(String endpoint, Q body, TypeReference<T> typeReference) throws IOException {
        return null;
    }

    @Override
    public void delete(String endpoint) throws IOException {
        URL url = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + jwt);
        connection.disconnect();
    }

    @Override
    public <T> T login(String username, String password, TypeReference<T> typeReference) throws IOException {
        return null;
    }

    @Override
    public void setJwt(String jwt) {

    }

    @Override
    public void logout() {

    }
    private static String getResponseBodyAsString(HttpURLConnection connection) throws
            IOException {
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        return response.toString();
    }
    private static void setRequestBodyFromString(HttpURLConnection connection, String
            body) throws IOException {
        connection.setDoOutput(true);
        DataOutputStream outputStream = new
                DataOutputStream(connection.getOutputStream());
        outputStream.writeBytes(body);
        outputStream.flush();
        outputStream.close();
    }
}
