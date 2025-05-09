SELECT DISTINCT D.ID AS ID, D.EMAIL AS EMAIL, D.FIRST_NAME AS FIRST_NAME, D.LAST_NAME AS LAST_NAME
FROM SKILLCODES AS S
INNER JOIN DEVELOPERS AS D ON S.CODE & D.SKILL_CODE
WHERE S.CATEGORY LIKE 'Front %'
ORDER BY D.ID ASC;