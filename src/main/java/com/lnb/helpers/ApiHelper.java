package com.lnb.helpers;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class ApiHelper {
    private final HttpClient client;

    public ApiHelper() {
        client = HttpClient.newHttpClient();
    }

    /**
     * @param authorization if api request authorization
     */
    public HttpResponse<String> get(String url, String authorization, Map<String, Object> params) throws Exception {
        /*
         * convert params to string like param1=value1&&param2=value2...
         * then add to url
         * example: https://example.com/get?param1=value1&&param2=value2
         */
        System.out.println("GET: " + url + "?" + convertParamsToString(params));
        if (authorization == null) {
            authorization = "";
        }
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url + "?" + convertParamsToString(params)))
                .header("Authorization", authorization)
                .GET()
                .build();


        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    /**
     * @param authorization if api request authorization
     */
    public HttpResponse<String> post(String url, String authorization, Map<String, Object> params, String body) throws Exception {
        /*
         * convert params to string like param1=value1&&param2=value2...
         * then add to url
         * example: https://example.com/get?param1=value1&&param2=value2
         */
        System.out.println("POST: " + url + "?" + convertParamsToString(params));
        if (authorization == null) {
            authorization = "";
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url + convertParamsToString(params)))
                .header("Authorization", authorization)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }


    /**
     * @param authorization if api request authorization
     */
    public HttpResponse<String> put(String url, String authorization, Map<String, Object> params, String body) throws Exception {
        /*
         * convert params to string like param1=value1&&param2=value2...
         * then add to url
         * example: https://example.com/get?param1=value1&&param2=value2
         */
        System.out.println("PUT: " + url + "?" + convertParamsToString(params));
        if (authorization == null) {
            authorization = "";
        }
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url + convertParamsToString(params)))
                .header("Authorization", authorization)
                .PUT(HttpRequest.BodyPublishers.ofString(body))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    /**
     * @param authorization if api request authorization
     */
    public HttpResponse<String> delete(String url, String authorization, Map<String, Object> params) throws Exception {
        /*
         * convert params to string like param1=value1&&param2=value2...
         * then add to url
         * example: https://example.com/get?param1=value1&&param2=value2
         */
        System.out.println("DELETE: " + url + "?" + convertParamsToString(params));
        if (authorization == null) {
            authorization = "";
        }
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url + convertParamsToString(params)))
                .header("Authorization", authorization)
                .DELETE()
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }


    /**
     * @return string of s
     */
    private String urlEncodeUTF8(String s) {
        return URLEncoder.encode(s, StandardCharsets.UTF_8);
    }


    private String convertParamsToString(Map<String, Object> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<?, ?> entry : params.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }

            sb.append(String.format("%s=%s",
                    urlEncodeUTF8(entry.getKey().toString()),
                    urlEncodeUTF8(entry.getValue().toString())
            ));
        }
        return sb.toString();
    }


}
