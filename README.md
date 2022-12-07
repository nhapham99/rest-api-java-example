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

## Architecture
![Untitled drawio](https://user-images.githubusercontent.com/38499139/206187786-02b358d0-509d-478f-bfa1-7d445a2091d6.png)
- `Location` và `Weather` là những Model dựa vào cấu trúc json trả về từ API
- `Repository` là nơi trung gian chuyển từ json data sang các object sử dụng trong hệ thg
- `APIHelper` class để gửi các Request API lên Server trả về Response từ Server




