#排名練習
CREATE TABLE t (
    val INT
);

INSERT INTO t(val)
VALUES(1),(2),(2),(3),(4),(4),(5);

SELECT * FROM t;

SELECT
    val,
    RANK() OVER (
        ORDER BY val
        ) my_rank
FROM
    t;