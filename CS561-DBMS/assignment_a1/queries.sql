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


-- Update: a1: Q3 — most / least favourite month per product
