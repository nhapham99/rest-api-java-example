package com.lnb.repositories;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lnb.constants.Constants;
import com.lnb.helpers.ApiHelper;
import com.lnb.models.Weather;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class WeatherRepository {
    ApiHelper apiHelper;

    public WeatherRepository() {
        apiHelper = new ApiHelper();
    }

    public Weather getWeather(String location) {
        Map<String, Object> params = new HashMap<>();
        params.put("key", Constants.API_KEY);
        params.put("q", location);

        try {
            HttpResponse<String> response = apiHelper.get(Constants.DOMAIN + Constants.API_CURRENT_WEATHER, null, params);
            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                Map<String, Object> data = gson.fromJson(response.body(), new TypeToken<Map<String, Object>>() {}.getType());
                return new Weather(data);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
