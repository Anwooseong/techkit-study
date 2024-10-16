-- 코드를 입력하세요
SELECT count(*) as USERS
FROM USER_INFO
where year(JOINED) = '2021' AND AGE >= 20 AND AGE <= 29;