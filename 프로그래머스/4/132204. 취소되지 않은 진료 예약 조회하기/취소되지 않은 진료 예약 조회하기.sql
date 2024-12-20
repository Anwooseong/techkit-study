-- PATIENT  환자번호(PT_NO) / 환자이름(PT_NAME) / 성별코드(GEND_CD) / 나이(AGE) / 전화번호(TLNO, null)
-- DOCTOR  의사이름(DR_NAME) / 의사ID(DR_ID) / 면허번호(LCNS_NO) / 진료과코드(HIRE_YMD, null) / 전화번호(TLNO, null)
-- APPOINTMENT 진료예약일시(APNT_YMD) / 진료예약번호(APNT_NO) / 환자번호(PT_NO) / 진료과코드(MCDP_CD) / 의사ID(MDDR_ID) / 예약취소여부(APNT_CNCL_YN, null) / 예약취소날짜(APNT_CNCL_YMD, null)

select APNT_NO, PT_NAME, A.PT_NO as PT_NO, A.MCDP_CD as MCDP_CD, DR_NAME, APNT_YMD from APPOINTMENT A
    inner join PATIENT P on A.PT_NO = P.PT_NO
    inner join DOCTOR D on D.DR_ID = A.MDDR_ID
    where APNT_CNCL_YN = 'N' AND APNT_YMD LIKE ('2022-04-13%')
    order by APNT_YMD asc;