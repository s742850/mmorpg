# 查詢學生表的 前10條資料
select *
from student s
limit 10;

# 查詢成績表所有成績的最低分,平均分,總分
select MAX(score), AVG(score), SUM(score)
from sc;

# 查詢老師 “諶燕” 所帶的課程設數量
select count(*)
from teacher t
         join course c on t.tno = c.tno
where tname = '諶燕';

SELECT COUNT(*)
FROM course
         LEFT JOIN teacher USING (tno)
WHERE tname = '諶燕';


# 查詢所有老師所帶 的課程 數量
select tname, count(*)
from teacher t
         join course c on t.tno = c.tno
group by tname;

SELECT tname, COUNT(*)
FROM course
         LEFT JOIN teacher USING (tno)
GROUP BY tno;

# 查詢姓”張”的學生名單
select *
from student s
where s.sname like '張%';


# 查詢課程名稱為’Oracle’且分數低於60 的學號和分數
select s.sno, s.score
from course c
         left join sc s on c.cno = s.cno
where c.cname = 'Oracle'
  and score < 60;

SELECT sno, score
FROM sc
         LEFT JOIN course USING (cno)
WHERE cname = 'Oracle'
  AND score < 60;

#  查詢所有學生的選課 課程名稱 (學生有選課就一定有成績)
select s.sname, c.cname
from student s
         right join sc on sc.sno = s.sno
         left join course c on sc.cno = c.cno;

SELECT sname, cname
FROM sc
         LEFT JOIN student USING (sno)
         LEFT JOIN course USING (cno);

# 查詢任何一門課程成績在70 分以上的學生姓名.課程名稱和分數
select s.sname, cname, s2.score
from student s
         right join sc s2 on s.sno = s2.sno
         left join course c on s2.cno = c.cno
where s2.score >= 70;

SELECT sname, cname, score
FROM sc
         LEFT JOIN student USING (sno)
         LEFT JOIN course USING (cno)
WHERE score >= 70;


# 查詢不及格的課程,並按課程號從大到小排列 學號,課程號,課程名,分數
select s.sno, c.cno, cname, score
from student s
         right join sc s2 on s.sno = s2.sno
         left join course c on s2.cno = c.cno
where s2.score < 60
order by c.cno desc;


SELECT sno, cno, cname, score
FROM sc
         LEFT JOIN student USING (sno)
         LEFT JOIN course USING (cno)
WHERE score < 60
ORDER BY cno DESC;


# 查詢沒學過”諶燕”老師講授的任一門課程的學號,學生姓名
select s.sno, sname
from student s
where s.sno not in (select sno
                    from teacher
                             left join course c on teacher.tno = c.tno
                             left join sc s2 on c.cno = s2.cno
                    where tname = '諶燕');

SELECT sno, sname
FROM student
WHERE sno NOT IN (SELECT DISTINCT sno
                  FROM sc
                           LEFT JOIN student USING (sno)
                           LEFT JOIN course USING (cno)
                           LEFT JOIN teacher USING (tno)
                  WHERE tname IN ('諶燕'));


# 查詢兩門以上不及格課程的同學的學號及其平均成績
select s.sno, avg(s2.score)
from student s
         right join sc s2 on s.sno = s2.sno
where s.sno in (select sc.sno
                from sc
                where score < 60
                group by sno
                having count(*) >= 2);

SELECT sno, AVG(score)
FROM sc
WHERE score < 60
GROUP BY sno
HAVING COUNT(score) >= 2;


# 檢索’c004’課程分數小於60, 按分數降序排列的同學學號
select sno, score
from sc
         left join course c on sc.cno = c.cno
where c.cno = 'c004'
  and sc.score < 60
order by score desc;

SELECT sno, score
FROM sc
WHERE score < 60
  AND cno = 'c004'
ORDER BY score DESC;


# 查詢’c001’課程比’c002’課程成績高的所有學生的學號
select distinct sc1.sno
from sc sc1,
     sc sc2
where sc1.score > sc2.score
  and sc1.cno = 'c001'
  and sc2.cno = 'c002'
  and sc1.sno = sc2.sno;

SELECT a.sno
FROM sc a,
     sc b
WHERE a.sno = b.sno
  AND a.cno = 'c001'
  AND b.cno = 'c002'
  AND a.score > b.score;


# 查詢平均成績大於60 分的同學的學號和平均成績
select sno, avg(score)
from sc
group by sno
having avg(score) > 60;


SELECT sno, AVG(score)
FROM sc
GROUP BY sno
HAVING AVG(score) > 60;

# 查詢所有同學的學號.姓名.選課數.總成績
select s.sno, s.sname, COUNT(cno), SUM(score)
from sc
         left join student s on sc.sno = s.sno
group by sno;


SELECT sno, sname, COUNT(cno), SUM(score)
FROM sc
         LEFT JOIN student USING (sno)
GROUP BY sno;


# 查詢姓”劉”的老師的個數
select count(*)
from teacher
where tname like '劉%';

# TODO 沒答案.... 查詢只學”諶燕”老師所教的課的同學的學號:姓名
select sno, sname
from student
where sno in (
    select distinct s.sno
    from course
             join teacher t on course.tno = t.tno
             right join sc s on course.cno = s.cno
    where tname = '諶燕'
);

#### 查詢學過”c001″並且也學過編號”c002″課程的同學的學號.姓名 ####
SELECT sno, sname
FROM student
WHERE sno IN (SELECT a.sno
              FROM sc a,
                   sc b
              WHERE a.sno = b.sno
                AND a.cno = 'c001'
                AND b.cno = 'c002');


# 查詢學過”諶燕”老師所教的所有課的同學的學號:姓名

# 查詢課程編號”c004″的成績比課程編號”c001″和”c002″課程低的所有同學的學號.姓名

# HARD 查詢所有課程成績小於60 分的同學的學號.姓名
SELECT DISTINCT sno
FROM sc x
WHERE 60 > ALL (SELECT score FROM sc y WHERE x.sno = y.sno);

# s001~s005, 只有s004和s005是全部成績小於60分, 所以解答要用ALL
SELECT *
FROM sc x
WHERE x.sno = 's001';

# The ANY and ALL operators are used with a WHERE or HAVING clause.
#
# The ANY operator returns true if any of the subquery values meet the condition.
#
# The ALL operator returns true if all of the subquery values meet the condition.


# 查詢沒有學課的同學的學號.姓名
select sno, sname
from student s
where sno not in (select sno from sc);

SELECT sno, sname
FROM student
WHERE sno NOT IN (SELECT DISTINCT sno FROM sc);

# 查詢與學號為”s001″一起上過課的同學的學號和姓名
select distinct sc.sno, s.sname
from sc
         left join student s on sc.sno = s.sno
where sc.cno in (select cno
                 from sc
                 where sno = 's001')
  AND sc.sno <> 's001';

SELECT DISTINCT sc.sno, student.sname
FROM sc
         RIGHT JOIN student USING (sno)
WHERE cno IN (SELECT DISTINCT cno
              FROM sc
              WHERE sno = 's001')
  AND sc.sno <> 's001';

# s001上過這些課
select cno
from sc
where sno = 's001';

#TODO 好難= = 查詢跟學號為”s005″所修課程完全一樣的同學的學號和姓名
SELECT sno, sname
FROM sc x
         LEFT JOIN student USING (sno)
WHERE cno IN (SELECT cno FROM sc WHERE sno = 's005')
GROUP BY sno
HAVING COUNT(cno) = (SELECT COUNT(*) FROM sc WHERE sno = 's005')
   AND (SELECT COUNT(*) FROM sc WHERE sno = 's005') = ALL (SELECT COUNT(cno) FROM sc y WHERE x.sno = y.sno)
   AND sno <> 's005';

SELECT sno, sname
FROM sc
         LEFT JOIN student USING (sno)
GROUP BY sno
HAVING GROUP_CONCAT(cno ORDER BY cno) = (SELECT GROUP_CONCAT(cno ORDER BY cno) FROM sc WHERE sno = 's005')
   AND sno <> 's005';


# 查詢學號為"s005"所修的課程
select cno
from sc
where sno = 's005';

# 查詢各科成績最高和最低的分 顯示:課程ID,最高分,最低分
select cno, max(score), min(score)
from sc
group by cno;

#HARD 按各科平均成績和及格率的百分數 照平均從低到高顯示
select cno, avg(score)
from sc
group by cno
order by avg(score);

SELECT cno, AVG(score), CONCAT(ROUND(COALESCE(count, 0) / tcount, 2) * 100, '%') AS passing
FROM sc
         LEFT JOIN (SELECT cno, COUNT(*) AS count FROM sc WHERE score > 60 GROUP BY cno) AS pass USING (cno)
         LEFT JOIN (SELECT cno, COUNT(*) AS tcount FROM sc GROUP BY cno) AS total USING (cno)
GROUP BY cno
ORDER BY AVG(score);


# 查詢每個課程的老師及平均分從高到低顯示 老師名稱,課程名稱,平均分數
select tname, c.cname, avg(score)
from teacher t
         right join course c on t.tno = c.tno
         right join sc s on c.cno = s.cno
group by c.cno
order by avg(score) desc;

SELECT tname, cname, AVG(score)
FROM sc
         LEFT JOIN course USING (cno)
         LEFT JOIN teacher USING (tno)
GROUP BY tno, cno
ORDER BY AVG(score) DESC;

#統計列印各科成績, 各分數段人數:課程ID, 課程名稱,verygood[100-86], good[85-71], bad[<60]

#查詢各科成績前三名的記錄:(不考慮成績並列情況)
SELECT *
FROM sc x
WHERE (SELECT COUNT(*) FROM sc y WHERE x.cno = y.cno AND x.score < y.score) < 3
ORDER BY cno, score DESC;

# SELECT COUNT(*), y.*, x.sno, x.score AS xscore FROM sc y,sc x WHERE x.cno = y.cno AND x.score < y.score
# GROUP BY y.sno, y.cno
# ORDER BY cno, score DESC;

#此科c001成績
select *
from sc
where cno = 'c001'
group by score
order by score desc;


# 查詢每門課程被選修的學生數
select cno, count(*) as studetns
from sc
group by cno;

# 查詢出只選修了兩門課程的全部學生的學號和姓名
select s1.sno, s.sname
from sc s1
         left join student s on s1.sno = s.sno
where (select count(*) from sc s2 where s1.sno = s2.sno) = 2
group by s.sno;

SELECT sno, sname
FROM sc
         LEFT JOIN student USING (sno)
GROUP BY sno
HAVING COUNT(*) = 2;

# 查詢男生.女生人數
select ssex, count(ssex)
from student
group by ssex;

# 查詢每個課程的男生女生總數
select sc.cno, ssex, count(*) as count
from sc
         left join student s on sc.sno = s.sno
group by sc.cno, s.ssex;

SELECT cno, cname, COALESCE(boy, 0) AS boy, COALESCE(girl, 0) AS girl
FROM course
         LEFT JOIN (SELECT cno, COUNT(*) AS boy
                    FROM `course`
                             JOIN sc USING (cno)
                             JOIN student USING (sno)
                    GROUP BY cno, ssex
                    HAVING ssex = '男'
                    ORDER BY cno) AS cb USING (cno)
         LEFT JOIN (SELECT cno, COUNT(*) AS girl
                    FROM `course`
                             JOIN sc USING (cno)
                             JOIN student USING (sno)
                    GROUP BY cno, ssex
                    HAVING ssex = '女'
                    ORDER BY cno) AS cg USING (cno);


# 查詢同名同姓學生名單, 並統計同名人數
SELECT sname, COUNT(*)
FROM student
GROUP BY sname
HAVING COUNT(*) > 1;


#NEED 查詢年紀最小跟最大的學生名單(注:Student 表中Sage 列的型別是int)
(select *
 from student
 order by sage desc
 limit 1)
union
(select *
 from student
 order by sage
 limit 1);

SELECT *
FROM student
WHERE sno IN (SELECT sno FROM student x WHERE (SELECT COUNT(*) FROM student y WHERE x.sage > y.sage) < 1)
   OR sno IN (SELECT sno FROM student x WHERE (SELECT COUNT(*) FROM student y WHERE x.sage < y.sage) < 1);


# 查詢每門課程的平均成績,結果按平均成績升序排列,平均成績相同時,按課程號降序排列
select cno, avg(score)
from sc
group by cno
order by avg(score) asc, cno desc;

# 查詢平均成績大於85 的所有學生的學號.姓名和平均成績
select s.sno, sname, avg(score)
from sc
         left join student s on sc.sno = s.sno
group by cno
having avg(score) > 85;

SELECT sno, sname, AVG(score)
FROM sc
         LEFT JOIN student USING (sno)
GROUP BY sno
HAVING AVG(score) > 85;

# 查詢課程編號為c001 且課程成績在80 分以上的學生的學號和姓名
select cno, s.sno, sname, score
from sc
         left join student s on sc.sno = s.sno
where cno = 'c001'
  and score >= 80;


SELECT sno, sname
FROM sc
         LEFT JOIN student USING (sno)
WHERE cno = 'c001'
  AND score >= 80;


# 檢索每課程第二高分的學號 分數(考慮成績並列)
select max(score)
from sc
group by cno;


# 求選了課程的學生人數
SELECT COUNT(*)
FROM (SELECT DISTINCT sno FROM sc) AS scount;

#TODO 查詢選修”諶燕”老師所授課程的學生中,成績最高的學生姓名及其成績
SELECT sname, score
FROM sc
         LEFT JOIN student USING (sno)
         LEFT JOIN course USING (cno)
         LEFT JOIN teacher USING (tno)
WHERE tname = '諶燕'
  AND score = (SELECT MAX(score)
               FROM sc
                        LEFT JOIN student USING (sno)
                        LEFT JOIN course USING (cno)
                        LEFT JOIN teacher USING (tno)
               WHERE tname = '諶燕');


# 查詢不同課程成績 有相同的學生的學號.課程號.學生成績, 也就是查詢同一個學生 在不同課上 取得一樣的成績
select distinct s1.sno, s1.cno, s1.score
from sc s1,
     sc s2
where s1.cno <> s2.cno
  and s1.sno = s2.sno
  and s1.score = s2.score;

# 所有課程排名成績(不考慮並列) 學號,課程號,排名,成績 照課程,排名排序
select *,
       rank() over (
           order by score
           ) ranks
from sc
order by cno, ranks;

#TODO 所有課程排名成績(不考慮並列) 學號,課程號,排名,成績 照課程,排名排序
explain
SELECT role.sc.sno,
       role.sc.cno,
       CASE
           WHEN @pre_parent_code = role.sc.cno THEN @curRank := @curRank + 1
           WHEN @pre_parent_code := role.sc.cno THEN @curRank := 1
           ELSE @curRank := 1
           END AS rank, sc.score
FROM (select @curRank := 0, @pre_parent_code := '') r, sc
ORDER BY role.sc.cno, role.sc.score;


# 所有課程排名成績(考慮並列) 學號,課程號,排名,成績 照課程,排名排序


# 做所有學生, 顯示學生名稱,課程名稱,成績,老師名稱的視圖
select s.sname, c.cname, s2.score, t.tname
from student s
         join sc s2 on s.sno = s2.sno
         join course c on s2.cno = c.cno
         join teacher t on c.tno = t.tno;

CREATE VIEW students AS
select s.sname, c.cname, s2.score, t.tname
from student s
         join sc s2 on s.sno = s2.sno
         join course c on s2.cno = c.cno
         join teacher t on c.tno = t.tno;

# 查詢上過所有老師教的課程的學生 學號,學生名
select  s.sno, s.sname
from student s
         right join sc s2 on s.sno = s2.sno
where s2.cno = ALL (select c.cno
                 from teacher
                          right join course c on teacher.tno = c.tno);

SELECT *
FROM sc
         LEFT JOIN course USING (cno)
         LEFT JOIN student USING (sno)
GROUP BY sno
HAVING GROUP_CONCAT(DISTINCT tno ORDER BY tno) = (SELECT GROUP_CONCAT(tno ORDER BY tno) FROM teacher);

# 所有老師的課程
select c.cno
from teacher
         right join course c on teacher.tno = c.tno;


# 查詢包含數字的課程名
SELECT cname
FROM course
WHERE cname REGEXP '[0-9]';

# 查詢只有英文的課程名
SELECT cname
FROM course
WHERE cname REGEXP '([a-z]|[A-Z])';

# 問題


WHERE cname REGEXP '^([a-z]|[A-Z])+$';



# 查詢所有學生的平均成績 並排名 , 學號,學生名,排名,平均成績(不考慮並列) 對平均成績高到低及學號低到高排序


# 查詢所有學生的平均成績 並排名 , 學號,學生名,排名,平均成績(考慮並列) 對平均成績高到低及學號低到高排序


# 查詢課程有學生的成績是其他人成績兩倍的學號 學生名
SELECT x.sno, student.sname
FROM sc x
         LEFT JOIN student on x.sno = student.sno
WHERE (SELECT count(*) FROM sc y WHERE x.sno <> y.sno AND x.cno = y.cno AND x.score / 2 > y.score);


# 會拿到三筆 (sets of records), 而上面的解答用WHERE代表要把三筆都取出來!!!!!
# where 代表 符合 條件的 都要選出來, 而這裡就是那三筆資料
SELECT COUNT(*)
FROM sc x,
     sc y
WHERE x.sno <> y.sno
  AND x.cno = y.cno
  AND x.score / 2 > y.score;

# Where is Your Data Coming From?
show tables;

# 用join using(column)的好處
# https://stackoverflow.com/questions/11366006/mysql-on-vs-using