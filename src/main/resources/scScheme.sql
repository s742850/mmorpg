#MYSQL

# 成績表
create table sc
(
    sno   varchar(10) comment '學生編號',
    cno   varchar(10) comment '課程編號',
    score float(4, 2) comment '分數',
    constraint pk_sc primary key (sno, cno)
);

insert into sc
values ('s001', 'c001', 78.9);
insert into sc
values ('s002', 'c001', 80.9);
insert into sc
values ('s003', 'c001', 81.9);
insert into sc
values ('s004', 'c001', 50.9);
insert into sc
values ('s005', 'c001', 59.9);
insert into sc
values ('s001', 'c002', 82.9);
insert into sc
values ('s002', 'c002', 72.9);
insert into sc
values ('s003', 'c002', 82.9);
insert into sc
values ('s001', 'c003', 59);
insert into sc
values ('s006', 'c003', 99.8);
insert into sc
values ('s002', 'c004', 52.9);
insert into sc
values ('s003', 'c004', 20.9);
insert into sc
values ('s004', 'c004', 59.8);
insert into sc
values ('s005', 'c004', 50.8);
insert into sc
values ('s002', 'c005', 92.9);
insert into sc
values ('s001', 'c007', 78.9);
insert into sc
values ('s001', 'c010', 78.9);

#題目:所有課程排名成績(不考慮並列) 學號,課程號,排名,成績 照課程,排名排序


# 下面這兩個SQL執行結果不一樣
SELECT sc.sno,
       sc.cno,
       CASE
           WHEN @pre_parent_code = sc.cno THEN @curRank := @curRank + 1
           WHEN @pre_parent_code := sc.cno THEN @curRank := 1
           ELSE @curRank := 1
           END AS rank,sc.score
FROM (select @curRank := 0, @pre_parent_code := '') r, sc
ORDER BY sc.cno, sc.score
DESC;


SELECT sc.sno,
       sc.cno,
       CASE
           WHEN @pre_parent_code = sc.cno THEN @curRank := @curRank + 1
           WHEN @pre_parent_code := sc.cno THEN @curRank := 1
           ELSE @curRank := 1
           END AS rank,sc.score
FROM (select @curRank := 0, @pre_parent_code := '') r, sc
where cno='c001';