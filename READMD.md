개발 프레임웍
Spring Framework

문제해결 방법
고객 거래내역 데이터, 고객 데이터, 지점 데이터를 테이블에 Insert
H2 DB를 이용하여 Native Query/SQL을 이용 조건에 맞는 데이터 Select
각 문제별 출력값에 맞는 DTO 도메인 생성
컨트롤러에서는 입력값에 따라 분기하여 DB와 매핑되는 DAO 호출
DAO에서는 쿼리에서 출력된 값을 도메인에 매핑하고 ArrayList 리턴
컨트롤러에서는 ArrayList를 JSON과 매핑하여 결과값 리턴

빌드 및 실행 방법
Maven과 Spring boot를 이용하여 자동 빌드 및 실행
단위 테스트(Unit Test) 코드를 개발하여 출력값 검증
POSTMAN 유틸을 활용하여 실제 기능 검증
