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


#2

with current_month as (select cust, prod, month, avg(quant) as during_avg from sales group by cust, prod, month), 
before_month as (select cust, prod, month + 1 as month, avg(quant) as before_avg from sales group by cust, prod, month), 
after_month as (select cust, prod, month - 1 as month, avg(quant) as after_avg from sales group by cust, prod, month), 
averages as (select c.cust, c.prod, c.month, b.before_avg, c.during_avg, a.after_avg from current_month c 
left join before_month b on c.cust = b.cust and c.prod = b.prod and c.month = b.month 
left join after_month a on c.cust = a.cust and c.prod = a.prod and c.month = a.month) 
select cust as "CUSTOMER", prod as "PRODUCT", month as "MONTH", before_avg as "BEFORE_AVG", during_avg as "DURING_AVG", after_avg as "AFTER_AVG" from averages order by cust, prod, month


#3

with base_avg as (select cust, prod, state, avg(quant) as prod_avg from sales group by cust, prod, state), 
a1 as (select b.cust, b.prod, b.state, avg(s.quant) as other_cust_avg from base_avg b join sales s on b.prod = s.prod and b.state = s.state and b.cust != s.cust group by b.cust, b.prod, b.state), 
a2 as (select b.cust, b.prod, b.state, avg(s.quant) as other_prod_avg from base_avg b join sales s on b.cust = s.cust and b.state = s.state and b.prod != s.prod group by b.cust, b.prod, b.state), 
a3 as (select b.cust, b.prod, b.state, avg(s.quant) as other_state_avg from base_avg b join sales s on b.cust = s.cust and b.prod = s.prod and b.state != s.state group by b.cust, b.prod, b.state) 
select b.cust as "CUSTOMER", b.prod as "PRODUCT", b.state as "STATE", b.prod_avg as "PROD_AVG", a1.other_cust_avg as "OTHER_CUST_AVG", a2.other_prod_avg as "OTHER_PROD_AVG", a3.other_state_avg as "OTHER_STATE_AVG" from base_avg b, a1, a2, a3 
where b.cust = a1.cust and b.prod = a1.prod and b.state = a1.state 
and b.cust = a2.cust and b.prod = a2.prod and b.state = a2.state 
and b.cust = a3.cust and b.prod = a3.prod and b.state = a3.state 
order by b.cust, b.prod, b.state


#4

with first_max as (select s.cust, max(s.quant) as max_quant from sales s where s.state = 'NJ' group by s.cust), 
second_max as (select s.cust, max(s.quant) as second_max_quant from sales s join first_max fm on s.cust = fm.cust where s.state = 'NJ' and s.quant < fm.max_quant group by s.cust), 
thrid_max as (select s.cust, max(s.quant) as third_max_quant from sales s join first_max fm on s.cust = fm.cust join second_max sm on s.cust = sm.cust where s.state = 'NJ' and s.quant < fm.max_quant and s.quant < sm.second_max_quant group by s.cust), 
top_sales as (select s.cust, s.quant, s.prod, s.date from sales s join first_max fm on s.cust = fm.cust and s.quant = fm.max_quant where s.state = 'NJ' 
union
select s.cust, s.quant, s.prod, s.date from sales s join second_max sm on s.cust = sm.cust and s.quant = sm.second_max_quant where s.state = 'NJ' 
union
select s.cust, s.quant, s.prod, s.date from sales s join thrid_max tm on s.cust = tm.cust and s.quant = tm.third_max_quant where s.state = 'NJ') 
select cust as "CUSTOMER", quant as "QUANTITY", prod as "PRODUCT", date as "DATE" from top_sales order by "CUSTOMER", "DATE"


-- Update: a2: Q5
