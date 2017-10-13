
create table semi_member(
	m_id varchar2(100) primary key,
	m_name varchar2(100) not null,
	m_password varchar2(100) not null,
	m_nick varchar2(100) not null,
	m_address varchar2(200) not null,
	m_birthday varchar2(100) not null,
	m_tel varchar2(100) not null,
	m_grade number not null,
	m_favoritegenre varchar2(100) not null
)
drop table semi_member;
select * from semi_member;

-----------------------------------
create table semi_movie(
	mv_no number primary key,
	mv_name varchar2(100) not null,
	mv_opendate varchar2(100) not null,
	mv_info clob not null,
	mv_director varchar2(100) not null,
	mv_genre varchar2(100) not null,
	mv_grade number not null,
	mv_content clob not null,
	mv_hits number not null,
	mv_runningtime number not null,
	mv_openflag number not null
)

drop table semi_movie;
select * from semi_movie;

create sequence semi_movie_seq;
drop sequence semi_movie_seq;

insert into semi_movie(mv_no,mv_name,mv_opendate, mv_info, mv_director, mv_genre, 
mv_grade, mv_content, mv_hits, mv_runningtime, mv_openflag) 
values(semi_movie_seq.nextval, '킹스맨2','2017.10.03',' 출연:이병헌 ..',
'감독: 황동혁','드라마',0,'1636년 인조 14년 병자호란 \n 청의 대군이....',0,139,1 );
--------------------------------------
create table semi_review(
	mv_no number not null,
	constraint fk_semi_review foreign key(mv_no) references semi_movie(mv_no),
	rv_content clob not null,
	m_id varchar2(100) not null,
	constraint fk_semi_member foreign key(m_id) references semi_member(m_id),
	rv_timeposted date not null,
	rv_hits number default 0 not null,
	rv_title varchar2(200) not null
)
drop table semi_review;
select * from semi_review;
--------------------------------------
create table semi_notice(
	nt_no number primary key,
	nt_title varchar2(200) not null,
	nt_content clob not null,
	nt_timeposted date not null,
	nt_hits number default 0
)
drop table semi_notice;
select * from semi_notice;

create sequence semi_notice_seq;
drop sequence semi_notice_seq;


-------------------------------------------
--검색 쿼리
select mv_no,mv_name,mv_opendate, mv_info, mv_director, mv_genre, 
mv_grade, mv_content, mv_hits, mv_runningtime, mv_openflag 
from semi_movie 
where mv_name like '%맨%';

-- 메인 리스트 쿼리
SELECT mv_no, mv_name, mv_opendate 
FROM SEMI_MOVIE 

-- 영화 상세정보 쿼리
SELECT mv_no,mv_name,mv_opendate, mv_info, mv_director, mv_genre, 
mv_grade, mv_content, mv_hits, mv_runningtime, mv_openflag 
FROM SEMI_MOVIE 
WHERE mv_no = 2 








