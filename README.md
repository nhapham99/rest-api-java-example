# Weather API Java
yêu bé ❤️

## Used Libraries
1. gson
```
gson là thư viện dùng để chuyển từ json sang object trong java
```
https://mvnrepository.com/artifact/com.google.code.gson/gson

Cách thêm thư viện trong Maven: https://www.jetbrains.com/help/idea/work-with-maven-dependencies.html

## Setup Project
1. Tạo Java Project sử dụng Maven để có thể sử dụng thư viện bên ngoài
2. Thêm Thư viện `gson` vào file pom.xml

## Project Structure
```
├── pom.xml
├── src
├── main
│ │ ├── java
│ │ │ └── com
│ │ │     └── lnb
│ │ │         ├── RestApiExample.java       --> main file
│ │ │         ├── constants
│ │ │         │ └── Constants.java          --> file chứa url, api_key,...
│ │ │         ├── helpers
│ │ │         │ └── ApiHelper.java          --> nơi để gọi api
│ │ │         ├── models
│ │ │         │ ├── Location.java
│ │ │         │ └── Weather.java
│ │ │         └── repositories
│ │ │             └── WeatherRepository.java    --> xử lý data từ api trả về model Weather
```

## API
https://www.weatherapi.com/api-explorer.aspx

## Json Example
```
{
    "location": {
        "name": "London",
        "region": "City of London, Greater London",
        "country": "United Kingdom",
        "lat": 51.52,
        "lon": -0.11,
        "tz_id": "Europe/London",
        "localtime_epoch": 1670419016,
        "localtime": "2022-12-07 13:16"
    },
    "current": {
        "last_updated_epoch": 1670418900,
        "last_updated": "2022-12-07 13:15",
        "temp_c": 5.0,
        "temp_f": 41.0,
        "is_day": 1,
        "condition": {
            "text": "Partly cloudy",
            "icon": "//cdn.weatherapi.com/weather/64x64/day/116.png",
            "code": 1003
        },
        "wind_mph": 5.6,
        "wind_kph": 9.0,
        "wind_degree": 280,
        "wind_dir": "W",
        "pressure_mb": 1021.0,
        "pressure_in": 30.15,
        "precip_mm": 0.0,
        "precip_in": 0.0,
        "humidity": 75,
        "cloud": 25,
        "feelslike_c": 2.4,
        "feelslike_f": 36.2,
        "vis_km": 10.0,
        "vis_miles": 6.0,
        "uv": 2.0,
        "gust_mph": 8.7,
        "gust_kph": 14.0
    }
}
```

## Architecture
![Untitled drawio](https://user-images.githubusercontent.com/38499139/206187786-02b358d0-509d-478f-bfa1-7d445a2091d6.png)
- `Location` và `Weather` là những Model dựa vào cấu trúc json trả về từ API
- `Repository` là nơi trung gian chuyển từ json data sang các object sử dụng trong hệ thg
- `APIHelper` class để gửi các Request API lên Server trả về Response từ Server




