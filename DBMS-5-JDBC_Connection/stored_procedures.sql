USE store_front;

/*
* Given the id of a user, fetch all orders (Id, Order Date, Order Total price) 
* of that user which are in shipped state. Orders should be sorted by 
* order date column in chronological order.
*/

DROP PROCEDURE shipped_State;
DROP PROCEDURE delete_product;
DROP PROCEDURE category_title;

DELIMITER $$
CREATE PROCEDURE shipped_State(shopperId INT, orderStatus VARCHAR(20))
   BEGIN
        SELECT o.order_id, o.created, c.price
        FROM order o ,cart c
        WHERE o.cart_id=c.cart_id AND
        c.cart_id = shopperId AND c.status = orderStatus;
			   END $$;
DELIMITER ;

CALL shipped_State(3,'Shipped');

/*
* Delete all those products which were not ordered by any Shopper in last 1 year. 
* Return the number of products deleted.
*/

DELIMITER $$
CREATE PROCEDURE delete_product()
BEGIN
     SET FOREIGN_KEY_CHECKS = 0;
     DELETE FROM product 
     WHERE product.product_id NOT IN(SELECT c.product_id
     FROM cart c,order o
     WHERE  c.cart_id=o.order_id AND c.status IS NOT NULL AND DATEDIFF(CURDATE(),o.created) <= 365);
END $$;
DELIMITER ;

CALL delete_product();

/*
* Select and display the category title of all top parent categories sorted 
* alphabetically and the count of their child categories.
*/
DELIMITER $$
CREATE PROCEDURE category_title()
BEGIN 
SELECT parent.category_name, COUNT(child.category_id) AS numberOfChildren 
					FROM category parent 
					LEFT JOIN category child 
					ON parent.category_id = child.parent_id
					WHERE parent.parent_id IS NULL 
					GROUP BY parent.category_id 
					ORDER BY parent.category_name;
END $$;
DELIMITER ;

CALL category_title();

