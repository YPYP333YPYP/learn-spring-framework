# GreenProduct

< 재고 관리 프로그램 >
언어 : Java(JDK 18)<br/>
서버 : Apache Tomcat 8.0<br/>
프레임 워크 : Spring boot<br/>
DB : MariaDB 10.6<br/>
IDE IntelliJ IDEA 2022, HeidiSQL<br/>
API : REST api<br/>

# 설명
spring boot의 JpaRepository를 이용한 entity CRUD API <br/>
Client - Controller - Service - DAO(Repository) - DB 순의 계층 프로그래밍 진행

# <API 명세서>
|Method|URI|Description|
|------|---|---|
|GET|/product|물품 검색|
|POST|/product|물품 추가|
|PUT|/product|물품 이름 변경|
|DELETE|/product|물품 삭제|
|GET|/product/get|물품 검색 - 가격|
|GET|/product/get+|물품 검색 - 이름 - 페이징|
|GET|/category|분류 검색|
|POST|/category|분류 추가|
|DELETE|/category|분류 삭제|
|GET|/product_detail|물품 정보 검색|
|POST|/product_detail|물품 정보 추가|
|DELETE|/product_detail|물품 정보 삭제|
|GET|/provider|공급업체 검색|
|POST|/provider|공급업체 추가|
|DELETE|/provider|공급업체 삭제|







# <DB 정보>
상품 - proudct
1. 상품번호 pk
2. 상품 이름
3. 상품 가격
4. 상품 재고
5. 상품 생성 일자
6. 상품 정보 변경 일자
7. 공급 업체 번호 fk
8. 분류 번호 fk

상품 정보 - product_detail
1. 상품 정보 번호 pk
2. 상품 설명
3. 상품 번호 fk
4. 상품 정보 생성 일자
5. 상품 정보 변경 일자

공급 업체 - provider
1. 공급 업체 번호 pk fk
2. 업체 이름
3. 업체 생성 일자
4. 업체 정보 변경 일자 

상품 분류 - category
1. 상품 분류 번호 pk
2. 상품 분류 코드 fk
3. 상품 분류 이름
