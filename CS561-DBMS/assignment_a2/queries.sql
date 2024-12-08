Name : Ankit BhagwatiPrasad Dhandharia
CWID : 20033031


#1

with monthly_avg as (select cust, prod, month, avg(quant) avg_quant from sales group by cust, prod, month), 
before_avg as (select m1.cust, m1.prod, m1.month, m2.avg_quant as before_avg from monthly_avg m1 left join monthly_avg m2 on m1.cust = m2.cust and m1.prod = m2.prod and m1.month - 1 = m2.month), 
after_avg as (select m1.cust, m1.prod, m1.month, m2.avg_quant as after_avg from monthly_avg m1 left join monthly_avg m2 on m1.cust = m2.cust and m1.prod = m2.prod and m1.month + 1 = m2.month), 
transaction as (select s.cust, s.prod, s.month, count(*) as transaction_count from sales s 
join before_avg b on s.cust = b.cust and s.prod = b.prod and s.month = b.month 
join after_avg a on s.cust = a.cust and s.prod = a.prod and s.month = a.month 
where s.quant between b.before_avg and a.after_avg or s.quant between a.after_avg and b.before_avg group by s.cust, s.prod, s.month) 
select m.cust as "CUSTOMER", m.prod as "PRODUCT", m.month as "MONTH", t.transaction_count as "SALES_COUNT_BETWEEN_AVGS" from monthly_avg m 
left join transaction t on m.cust = t.cust and m.prod = t.prod and m.month = t.month 
order by m.cust, m.prod, m.month


-- Update: a2: Q2 — before / during / after moving-window averages
