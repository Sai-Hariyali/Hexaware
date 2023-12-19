-- task 1 database
create database hmbank;
use hmbank;
 
-- task 2 ddl
create table Customers (customer_id int primary key, first_name varchar(50), last_name varchar(50),DOB date, email varchar(100),
phone_number varchar(20),address varchar(255));

create table Accounts (account_id int primary key,customer_id int, account_type varchar(50), balance int,
foreign key(customer_id) references Customers(customer_id));

create table Transactions (transaction_id int primary key,account_id int, transaction_type varchar(50), amount int,
transaction_date date, foreign key(account_id) references Accounts(account_id));

-- task 3 dml
insert into Customers (customer_id, first_name, last_name, DOB, email, phone_number, address) values
    (101, 'arun', 'kumar', '1992-04-15', 'arun.kumar@email.com', '9876543210', 'pollachi'),
    (102, 'kavitha', 'siva', '1988-07-20', 'kavitha.siva@email.com', '7890123456', 'coimbatore'),
    (103, 'suresh', 'rajan', '1985-02-10', 'suresh.rajan@email.com', '5678901234', 'madurai'),
    (104, 'priya', 'mohan', '1990-11-22', 'priya.mohan@email.com', '1234567890', 'kaniyakumari'),
    (105, 'krishna', 'subramaniyam', '1983-06-18', 'krishna.subramaniyam@email.com', '2345678901', 'chennai'),
    (106, 'lakshmi', 'narayanan', '1995-09-25', 'lakshmi.narayanan@email.com', '6789012345', 'madurai'),
    (107, 'aravind', 'raj', '1989-08-14', 'aravind.raj@email.com', '8901234567', 'tirupur'),
    (108, 'shanmugam', 'bala', '1980-05-05', 'shanmugam.bala@email.com', '3456789012', 'cheranmadevi'),
    (109, 'kavin', 'sekar', '1998-01-30', 'kavin.sekar@email.com', '5678901234', 'kaniyakumari'),
    (110, 'vidhya', 'vijay', '1975-12-08', 'vidhya.vijay@email.com', '7890123456', 'nilgiris');
insert into Accounts (account_id, customer_id, account_type, balance) values
    (101, 101, 'savings', 5000.00),
    (102, 102, 'current', 2500.00),
    (103, 103, 'zero_balance', 0.00),
    (104, 104, 'savings', 10000.00),
    (105, 105, 'current', 7500.00),
    (106, 106, 'savings', 3000.00),
    (107, 107, 'current', 500.00),
    (108, 108, 'zero_balance', 0.00),
    (109, 109, 'savings', 8000.00),
    (110, 110, 'current', 6000.00);
insert into Transactions (transaction_id, account_id, transaction_type, amount, transaction_date) values
    (1001, 101, 'deposit', 1000.00, '2023-01-05'),
    (1002, 102, 'withdrawal', 500.00, '2023-02-10'),
    (1003, 103, 'deposit', 2000.00, '2023-03-15'),
    (1004, 104, 'withdrawal', 1500.00, '2023-04-20'),
    (1005, 105, 'deposit', 3000.00, '2023-05-25'),
    (1006, 106, 'withdrawal', 1000.00, '2023-06-30'),
    (1007, 107, 'deposit', 500.00, '2023-07-05'),
    (1008, 108, 'withdrawal', 200.00, '2023-08-10'),
    (1009, 109, 'deposit', 1200.00, '2023-09-15'),
    (1010, 110, 'withdrawal', 800.00, '2023-10-20');
    
 -- select * from customers;
 -- select * from accounts;
 -- select * from transactions;
 -- 1
select first_name, last_name, account_type, email from Customers join Accounts on Customers.customer_id = Accounts.customer_id;
-- 2
select c.customer_id, t.* from Customers c join Accounts a on c.customer_id = a.customer_id join Transactions t on a.account_id = t.account_id;
-- 3
update Accounts set balance = balance + 2500 where account_id = 106; 
-- 4
select concat(first_name, ' ', last_name) as full_name from Customers;
-- 5
delete from Accounts where balance = 0 and account_type = 'savings';
-- 6
select * from Customers where address='kaniyakumari'; 
-- 7
select account_id, balance from Accounts where account_id = 102;
-- 8
select * from Accounts where account_type = 'current' and balance > 1000;
-- 9
select * from Transactions where account_id = 107;
-- 10
select account_id, balance * 0.05 as interest_accrued from Accounts where account_type = 'savings';
-- 11
select * from Accounts where balance < 500; 
-- 12
select * from Customers where address not like 'madurai'; 

-- task 4
-- 1
select avg(balance) as average_balance from Accounts;
-- 2
select customer_id, balance from Accounts order by balance desc limit 10;
-- 3
select sum(amount) as total_deposits from Transactions where transaction_type = 'deposit' 
and transaction_date = '2023-01-05';
-- 4
select min(c.customer_id) as oldest_customer, max(c.customer_id) as newest_customer from Customers c;
-- 5
select t.*, a.account_type from Transactions t join Accounts a on t.account_id = a.account_id;
-- 6
select c.*, a.* from Customers c join Accounts a on c.customer_id = a.customer_id;
-- 7
select c.*, t.* from Customers c join Accounts a on c.customer_id = a.customer_id join Transactions t on a.account_id = t.account_id
where a.account_id = 108;
-- 8
select customer_id, count(account_id) as num_accounts from Accounts group by customer_id
having count(account_id) > 1;
-- 9
select account_id, sum(amount * (transaction_type = 'deposit') - amount * (transaction_type = 'withdrawal')) 
as transaction_difference from Transactions group by account_id;
-- 10
select c.customer_id, avg(a.balance) as avg_balance
from Customers c join Accounts a on c.customer_id = a.customer_id group by c.customer_id;
-- 11
select account_type, sum(balance) as total_balance
from Accounts group by account_type;
-- 12
select account_id, count(transaction_id) as num_transactions
from Transactions group by account_id order by num_transactions desc;
-- 13
select c.customer_id,c.first_name, a.account_type, max(a.balance) as high_avg_balance
from Customers c join Accounts a on c.customer_id = a.customer_id
group by c.customer_id,c.first_name, a.account_type;
-- 14
select amount, transaction_date, account_id, count(*) as num_duplicate
from Transactions group by amount, transaction_date, account_id having count(*) > 1;

-- task 5 subqueries
-- 1 
select customer_id,balance from accounts where balance= (select max(balance)from accounts);
-- 2
select avg(balance) AS average_balance from Accounts where customer_id 
in (select customer_id from Accounts group by customer_id having count(*) > 1) group by customer_id;
-- 3
 select transaction_id, account_id,amount from transactions where amount > All (select avg(amount) from transactions);
-- 4
select customer_id from Customers where customer_id 
not in ( select distinct customer_id from Transactions);
-- 5
-- select sum(balance),c.customer_id from Customers c
-- left join Accounts a on c.customer_id = a.customer_id
-- left join Transactions t on a.account_id = t.account_id
-- where t.transaction_id is not null
-- group by c.customer_id;

-- select sum(balance),customer_id, first_name, last_name from Customers c where not exists 
-- (select 1  from Transactions t  join Accounts a on t.account_id = a.account_id
-- where a.customer_id = c.customer_id);

-- 6
-- select min(balance) from accounts;
select transaction_id,account_id from Transactions where account_id 
in (select account_id from Accounts where balance = (select min(balance) from Accounts));
-- 7
-- select account_type,count(*) from accounts group by account_type having account_type< 1;
select customer_id from accounts where account_type in ( select count(*) from accounts group by account_type having account_type< 1);
-- 8
select account_type, count(*) * 100 / (select count(*) from Accounts)
as percentage from Accounts group by account_type;
-- 9
select * from transactions where account_id in 
(select account_id from accounts where customer_id=(select customer_id from customers where customer_id=101));
-- 10
select account_type,(select SUM(balance) from Accounts where account_type = a.account_type)
as total_balance from Accounts a group by account_type;



