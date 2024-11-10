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


-- Update: a1: Q2 — busiest / slowest month per year
