Name : Ankit BhagwatiPrasad Dhandharia
CWID : 20033031


#1


with t1(cust, minq, maxq, avgq) as (select cust, min(quant), max(quant), avg(quant) from sales group by cust)
select min_query.cust as "CUSTOMER", minq as "MIN_Q", min_query.prod as "MIN_PROD", min_query.date as "MIN_DATE", min_query.state as "ST", maxq as "MAX_Q", max_query.prod as "MAX_PROD", max_query.date as "MAX_DATE", max_query.state as "ST", avgq as "AVG_Q"
from 
(select t1.cust, t1.minq, s.prod, s.date, s.state from t1 join sales s on t1.cust = s.cust and t1.minq = s.quant) as min_query
inner join 
(select t1.cust, t1.maxq, s.prod, s.date, s.state, t1.avgq from t1 join sales s on t1.cust = s.cust and t1.maxq = s.quant) as max_query
on min_query.cust = max_query.cust


#2


with t1 as (select year, month, sum(quant) as total from sales group by year, month),
t2 as (select year, min(total) as mintotal, max(total) as maxtotal from t1 group by year)
select t1_min.year as "YEAR", t1_max.month as "BUSIEST_MONTH", t1_max.total as "BUSIEST_TOTAL_Q", t1_min.month as "SLOWEST_MONTH", t1_min.total as "SLOWEST_TOTAL_Q"
from 
(select year, month, total from t1) as t1_min
inner join 
(select year, mintotal, maxtotal from t2) t2 on t1_min.year = t2.year and t1_min.total = t2.mintotal
inner join 
(select year, month, total from t1) as t1_max on t1_max.year = t2.year and t1_max.total = t2.maxtotal
order by t1_min.year


#3


with t1 as (select2.maxquant, s1.date, t3.maxquant, s2.date, t4.maxquant, s3.date, t5.maxquantelect prod, max(total) as maxtotal, min(total) as mintotal from t1 group by prod)
select t1_min.prod as "PRODUCT", t1_max.month as "MOST_FAV_MO", t1_min.month as "LEAST_FAV_MO"
from 
(select prod, month, total from t1) as t1_min
inner join 
(select prod, mintotal, maxtotal from t2) t2 on t1_min.prod = t2.prod and t1_min.total = t2.mintotal
inner join 
(select prod, month, total from t1) as t1_max on t1_max.prod = t2.prod and t1_max.total = t2.maxtotal


#4


with t1 as (select cust, prod, avg(quant) as avg_q, sum(quant) as total_q, count(*) as count_q from sales group by cust, prod),
t2 as (select cust, prod, avg(quant) as spring from sales where month in (3, 4, 5) group by cust, prod),
t3 as (select cust, prod, avg(quant) as summer from sales where month in (6, 7, 8) group by cust, prod),
t4 as (select cust, prod, avg(quant) as fall from sales where month in (9, 10, 11) group by cust, prod),
t5 as (select cust, prod, avg(quant) as winter from sales where month in (12, 1, 2) group by cust, prod)
select t1.cust as "CUSTOMER", t1.prod as "PRODUCT", t2.spring as "SPRING_AVG", t3.summer as "SUMMER_AVG", t4.fall as "FALL_AVG", t5.winter as "WINTER_AVG", t1.avg_q as "AVERAGE", t1.total_q as "TOTAL", t1.count_q as "COUNT"
from 
(select cust, prod, avg_q, total_q, count_q from t1) as t1
inner join 
(select cust, prod, spring from t2) t2 on t1.cust = t2.cust and t1.prod = t2.prod
inner join 
(select cust, prod, summer from t3) t3 on t1.cust = t3.cust and t1.prod = t3.prod
inner join 
(select cust, prod, fall from t4) t4 on t1.cust = t4.cust and t1.prod = t4.prod
inner join 
(select cust, prod, winter from t5) t5 on t1.cust = t5.cust and t1.prod = t5.prod


-- Update: a1: format + verify all 5 queries
