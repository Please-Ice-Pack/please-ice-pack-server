# please-ice-pack-server

## 💁‍♀️ 프로젝트 개요

**Please-Ice-Pack**은 **AI**를 활용한 패킹 전후 상품 검수와 최적 포장제 추천 솔루션입니다.
패킹은 센터 상품 출고 전 마지막 작업입니다.
패킹 단계를 강화해 오피킹을 검수하고 포장 효율을 높일 수 있습니다.

## 🌱 서비스 주요기능

- 주문 상품과 실제 상품 매칭
- 상품을 매칭한 결과로 포장제 추천
- 향후 AI 모델 정확도 향상을 위한 오류 데이터 적재

## 📦 페이지

![KakaoTalk_Image_2022-08-24-17-52-57](https://user-images.githubusercontent.com/66551410/186375256-258398a9-2d43-49cc-85f5-de4ce753818a.jpeg)

## 🔨 기술스택

|                        Server                                |
| :----------------------------------------------------------: |
| ![Spring Boot](https://img.shields.io/badge/SpringBoot-white?style=flat-square&logo=spring-boot&color=6DB33F&logoColor=white) ![Spring Security](https://img.shields.io/badge/SpringSecurity-6DB33F?style=flat-square&logo=spring-security&logoColor=white) ![AWS](https://img.shields.io/badge/AWS-232F3E?style=flat&logo=amazon-aws&logoColor=white)  ![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat-square&logo=Docker&logoColor=white) ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=MySQL&logoColor=white)|

## ✨ 사용한 기술

- Spring Security  
  사용자 인증을 위해 사용하였습니다.
- Spring Cloud OpenFeign   
  외부 API 연동을 위해 사용하였습니다.
- Jasypt  
  프로퍼티 암호화를 위해 사용하였습니다.

## 🛠 DEV API Server
https://api.pip-kurly.com/ping

## 💚 API Server Swagger
https://api.pip-kurly.com/swagger-ui/index.html

## 🛠 DEV ML Server
https://ml.pip-kurly.com/

## 💚 ML Server Swagger
https://ml.pip-kurly.com/docs

## 🕍 아키텍쳐

### Server Architecture

![image](https://user-images.githubusercontent.com/66551410/186376975-881fb3bb-906d-45ec-9ebb-3ed02e9dede6.png)

### CICD Architecture

![Untitled (3)](https://user-images.githubusercontent.com/66551410/172353126-2b7f6675-7f92-4ac4-a8cf-673b5eea9601.png)

### ERD

![image](https://user-images.githubusercontent.com/66551410/186373432-8d756fb0-62bd-42cc-8e86-0dc5196aef5d.png)


## ⭐️ Additional Repositories

- [Web](https://github.com/Please-Ice-Pack/please-ice-pack-front)
- [ML](https://github.com/Please-Ice-Pack/please-ice-pack-ml)
