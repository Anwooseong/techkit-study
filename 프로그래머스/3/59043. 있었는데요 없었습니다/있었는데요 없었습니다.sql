-- 관리자의 실수로 일부 동물의 입양일이 잘못 입력
-- 보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회하는 SQL문 작성(보호 시작일이 빠른 순으로 조회)
SELECT INS.ANIMAL_ID AS ANIMAL_ID, INS.NAME AS NAME FROM ANIMAL_INS AS INS
INNER JOIN ANIMAL_OUTS AS OUTS ON INS.ANIMAL_ID = OUTS.ANIMAL_ID
WHERE INS.DATETIME > OUTS.DATETIME
ORDER BY INS.DATETIME ASC;