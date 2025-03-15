-- 코드를 입력하세요
select APNT_NO,	PT_NAME,	p.PT_NO,	MCDP_CD,	DR_NAME,	APNT_YMD
from PATIENT p
join(
SELECT a.pt_no ,a.APNT_NO ,a.MCDP_CD, d.dr_name, apnt_ymd from DOCTOR d join APPOINTMENT a on d.DR_ID = a.MDDR_ID
where a.APNT_CNCL_YN = 'N'
and year(APNT_YMD)=2022 and month(APNT_YMD) = 4 and day(APNT_YMD) = 13 and a.MCDP_CD = 'CS')
 t on p.pt_no = t.pt_no
 order by APNT_YMD