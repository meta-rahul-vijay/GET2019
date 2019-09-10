USE test
-- DROP FUNCTION order_in_month;
-- DROP FUNCTION maximum_orders_in_month;


#1.Function to calculate number of orders in a month.


DELIMITER $$
CREATE FUNCTION order_in_month(month INT, year INT) RETURNS INT
   BEGIN
       DECLARE order_count INT;
       
SELECT COUNT(*) INTO order_count
       FROM order o
       WHERE MONTH(o.created) = month AND YEAR(o.created) = year
       
GROUP BY MONTH(o.created);
       RETURN (order_count);
   END $$
DELIMITER ;


SELECT order_in_month(08,2019) ;




#2.Function to return month in a year having maximum orders.

DELIMITER $$
CREATE FUNCTION maximum_orders_in_month(year INT) RETURNS VARCHAR(20)
       
BEGIN
           DECLARE month_of_max_orders VARCHAR(20);
           
SELECT MONTHNAME(o.created) INTO month_of_max_orders
           FROM order o
           
WHERE YEAR(o.created) = year
           ORDER BY MONTH(o.created) DESC
           
LIMIT 1;
           RETURN (month_of_max_orders);
       END$$
DELIMITER ;



SELECT maximum_orders_in_month(2019);
