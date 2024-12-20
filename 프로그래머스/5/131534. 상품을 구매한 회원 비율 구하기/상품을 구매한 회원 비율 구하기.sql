-- 코드를 입력하세요 2021년에 가입한 전체 회원들 중 상품을 구매한 회원수와 상품을 구매한 회원의 비율(=2021년에 가입한 회원 중 상품을 구매한 회원수 / 2021년에 가입한 전체 회원 수)을 년, 월 별로 출력하는 SQL문을 작성
-- 상품을 구매한 회원의 비율은 소수점 두번째자리에서 반올림하고, 전체 결과는 년을 기준으로 오름차순 정렬해주시고 년이 같다면 월을 기준으로 오름차순 정렬

select YEAR(SALES_DATE) as YEAR, MONTH(SALES_DATE) as MONTH, count(distinct U.USER_ID) as PURCHASED_USERS, ROUND(count(distinct U.USER_ID) / (select COUNT(*) from USER_INFO where YEAR(JOINED) = '2021'), 1) as PUCHASED_RATIO from USER_INFO U
    inner join ONLINE_SALE O on U.USER_ID = O.USER_ID
    where YEAR(JOINED) = 2021
    group by YEAR(SALES_DATE), MONTH(SALES_DATE)
    order by YEAR ASC, MONTH ASC;
    
