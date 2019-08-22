SET SQL_SAFE_UPDATES=0;


update cart set date_added = CURDATE();



/*2 Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top.*/

select pd.product_id, pd.product_name, cat.category_name, pd.price 
from test.product pd , test.category cat 
where pd.category_id =  cat.category_id and pd.isActive = true 
order by created desc;


/*3 Display the list of products which don't have any images.*/

select pd.product_id, pd.product_name, pd.category_id, pd.price, pd.stock 
from test.product pd, test.images img 
where pd.product_id = img.product_id and img.image_src is null;


/*4 Display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category Title and then Category Title. (If Category is top category then Parent Category Title column should display “Top Category” as value.)*/

select cat.category_id, cat.category_name, ifnull(cat2.category_name, 'top category') as parent_category_name 
from category cat inner join category cat2 on cat.parent_id = cat2.category_id 
order by parent_category_name, category_name; 



/*5 Display Id, Title, Parent Category Title of all the leaf Categories (categories which are not parent of any other category)*/


select cat.category_id, cat.category_name, cat.parent_id 
from category cat 
where cat.category_id not in (select distinct(parent_id) 
from category 
where parent_id is not null);






/*6 Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)*/

select pd.product_name, pd.price 
from test.product pd, test.category cat 
where pd.category_id = cat.category_id and cat.category_name = 'mobile';


/*7Display the list of Products whose Quantity on hand (Inventory) is under 50.*/

select * from product where stock < 50 and isActive = true; 




/*Question-3*/

/*1 Display Recent 50 Orders placed (Id, Order Date, Order Total).*/

select order_id, created, total_price from test.order order by created desc limit 50;

/*2 Display 10 most expensive Orders.*/

select * from test.order order by total_price desc limit 10; 


/*3 Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped.*/


select ord.order_id, ord.cart_id, ord.total_price, created from test.order ord, cart ct where ord.cart_id = ct.cart_id and ord.created < CURDATE() - INTERVAL 10 DAY and ct.status = "placed" group by ord.order_id;


/*4 Display list of shoppers which haven't ordered anything since last month.*/


select shp.shopper_id, shp.shopper_name, shp.email_id, shp.address_id 
from shopper shp 
where shp.shopper_id NOT IN (select cart_id from test.order where created > CURDATE() - INTERVAL 30 day);

/*OR*/

select shp.shopper_id, shp.shopper_name, shp.email_id, shp.address_id
from shopper shp
inner join test.order ord on shp.shopper_id != ord.cart_id and ord.created > CURDATE() - INTERVAL 30 day; 


/*5 Display list of shopper along with orders placed by them in last 15 days.*/

select * from shopper sp inner join test.order ord on sp.shopper_id = ord.cart_id where ord.created > CURDATE() - INTERVAL 15 day; 



/*6 Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))*/

select product_id, product_name from product where product_id in (select ct.product_id from cart ct where ct.cart_id = (select cart_id from test.order where order_id = 1) and ct.status = "shipped");


/*7 Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price.*/

select prd.product_id, prd.product_name, prd.price, ord.created from product prd, test.order ord where prd.price > 10 and prd.price < 100 group by product_id; 










