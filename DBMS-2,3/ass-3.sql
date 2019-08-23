/* Question 1 */
/*1 Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.*/

SELECT
product_id, product_name,
COUNT(product_id) as categoryCount
FROM product 
GROUP BY product_id
HAVING categoryCount > 1;


/*2 Display Count of products as per below price range:*/


SELECT count(*) as count FROM product WHERE price BETWEEN 0 AND 100 ;

SELECT count(*) as count FROM product WHERE price BETWEEN 101 AND 500 ;

SELECT count(*) as count FROM product WHERE price > 500 ;


/*3 Display the Categories along with number of products under each category.*/

select cat.category_id, (select count(*) from product pd where pd.category_id = cat.category_id) as count from category cat;


/*Question 2*/
/*1 Display Shopper’s information along with number of orders he/she placed during last 30 days.*/

select sp.shopper_id, sp.shopper_name, sp.email_id, sp.address_id, (select count(*) from test.order ord where sp.shopper_id = ord.cart_id and ord.created > CURDATE() - INTERVAL 30 day) as numberOfOrders from shopper sp;   


/*2 Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.*/

select sp.shopper_name, ord.total_price from shopper sp inner join test.order ord on sp.shopper_id = ord.cart_id where created > CURDATE() - INTERVAL 30 day order by ord.total_price desc limit 10;


/*3 Display top 20 Products which are ordered most in last 60 days along with numbers.*/

select product_id, sum(quantity) as total_quantity, date_added, status 
from cart 
GROUP BY product_id 
having date_added > CURDATE() - INTERVAL 60 day and status = "shipped" 
order by total_quantity desc limit 20;

/*OR*/

SELECT cart.product_id , product.product_name ,COUNT(cart.product_id) AS top_product
FROM cart INNER JOIN product ON cart.product_id = product.product_id
WHERE cart.date_added >= CURRENT_TIMESTAMP - INTERVAL 60 DAY 
GROUP BY cart.product_id
ORDER BY top_product DESC
LIMIT 20;


/*4 Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.*/

SELECT MONTHNAME(created) AS month , SUM(total_price) AS total 
FROM test.order
WHERE created >= CURDATE() - INTERVAL 6 month
GROUP BY month(created);


/*5 Mark the products as Inactive which are not ordered in last 90 days.*/

update product set isActive = false where product_id NOT IN (select product_id from cart where cart_id IN (select cart_id from test.order where created > CURDATE() - INTERVAL 90 DAY));
    

/*6 Given a category search keyword, display all the Products present in this category/categories.*/

select p.product_id, p.product_name from product p, category c where p.category_id = c.category_id and category_name LIKE "%home appliances%";


/*7 Display top 10 Items which were cancelled most.*/

select p.product_id, p.product_name, count(c.product_id) as count from product p inner join cart c on p.product_id = c.product_id where c.status = "cancelled" group by c.product_id order by count DESC;

    



/*Question 4  Create appropriate tables and relationships for the same and write a SQL
         query for that returns a Resultset containing Zip Code, City Names and
         States ordered by State Name and City Name.
*/

create table ZipCode(
zipCode int NOT NULL,
city_id int NOT NULL,
primary key (`zipCode`),
foreign key (`city_id`) references city(`city_id`)
);

create table city(
city_id int NOT NULL,
city_name varchar(45),
state_id int,
primary key (`city_id`),
foreign key (`state_id`) references state(`state_id`)
);

create table state(
state_id int NOT NULL,
state_name varchar(45),
primary key (`state_id`)
);


INSERT INTO `dbms-ass-3-q4`.`state` (`state_id`, `state_name`) VALUES (1, 'Rajasthan');

INSERT INTO `dbms-ass-3-q4`.`state` (`state_id`, `state_name`) VALUES (2, 'Haryana');

INSERT INTO `dbms-ass-3-q4`.`state` (`state_id`, `state_name`) VALUES (3, 'Karnataka');

INSERT INTO `dbms-ass-3-q4`.`state` (`state_id`, `state_name`) VALUES (4, 'Kerala');

INSERT INTO `dbms-ass-3-q4`.`state` (`state_id`, `state_name`) VALUES (5, 'Assam');

INSERT INTO `dbms-ass-3-q4`.`state` (`state_id`, `state_name`) VALUES (6, 'West Bengal');


INSERT INTO `dbms-ass-3-q4`.`city` (`city_id`, `city_name`, `state_id`) VALUES (1, 'Ajmer', 1);

INSERT INTO `dbms-ass-3-q4`.`city` (`city_id`, `city_name`, `state_id`) VALUES (2, 'Jaipur', 1);

INSERT INTO `dbms-ass-3-q4`.`city` (`city_id`, `city_name`, `state_id`) VALUES (3, 'Udaipur', 1);

INSERT INTO `dbms-ass-3-q4`.`city` (`city_id`, `city_name`, `state_id`) VALUES (4, 'kolkata', 6);

INSERT INTO `dbms-ass-3-q4`.`city` (`city_id`, `city_name`, `state_id`) VALUES (5, 'dispur', 5);

INSERT INTO `dbms-ass-3-q4`.`city` (`city_id`, `city_name`, `state_id`) VALUES (6, 'Thiruvanthpuram', 4);

INSERT INTO `dbms-ass-3-q4`.`city` (`city_id`, `city_name`, `state_id`) VALUES (7, 'bangalore', 3);



INSERT INTO `dbms-ass-3-q4`.`zipcode` (`zipCode`, `city_id`) VALUES (305001, 1);

INSERT INTO `dbms-ass-3-q4`.`zipcode` (`zipCode`, `city_id`) VALUES (302001, 2);

INSERT INTO `dbms-ass-3-q4`.`zipcode` (`zipCode`, `city_id`) VALUES (313001, 3);

INSERT INTO `dbms-ass-3-q4`.`zipcode` (`zipCode`, `city_id`) VALUES (700001, 4);

INSERT INTO `dbms-ass-3-q4`.`zipcode` (`zipCode`, `city_id`) VALUES (781005, 5);

INSERT INTO `dbms-ass-3-q4`.`zipcode` (`zipCode`, `city_id`) VALUES (605036, 6);




select z.zipCode, c.city_name, s.state_name 
from zipcode z 
inner join city c on z.city_id = c.city_id 
inner join state s on c.state_id = s.state_id
order by s.state_name, c.city_name;



/*Question 5.1 Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) with latest ordered items should be displayed first for last 60 days.
5.2 Use the above view to display the Products(Items) which are in ‘shipped’ state.
5.3 Use the above view to display the top 5 most selling products.*/

/*5.1*/

create view v as select o.order_id, p.product_id, p.product_name, c.quantity,
(p.price * c.quantity) as price,
s.shopper_name, s.email_id, o.created, c.status 
from product p 
inner join cart c on p.product_id = c.product_id
inner join shopper s on s.shopper_id = c.cart_id
inner join test.order o on o.cart_id = c.cart_id
where o.created > CURDATE() - INTERVAL 60 DAY
group by o.order_id,p.product_id
order by o.created DESC;



/*5.2*/


select product_id, product_name, status from v where status = "shipped"; 


/*5.3*/


select product_id, count(quantity) as count from v group by product_id order by count DESC;





