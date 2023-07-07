package com.cda.intro2.client;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;

public interface ApiClient {
    <T> T get(String endpoint, TypeReference<T> typeReference) throws IOException;
    <T, Q> T post(String endpoint, Q body, TypeReference<T> typeReference) throws IOException;
    <T, Q> T put(String endpoint, Q body, TypeReference<T> typeReference) throws IOException;
    void delete(String endpoint) throws IOException;
    <T> T login(String username, String password, TypeReference<T> typeReference) throws IOException;
    void setJwt(String jwt);
    void logout();

}
