use store_front;


-- DROP INDEX index_issue_date ON product;

-- DROP INDEX index_parent_id ON category;

-- DROP INDEX index_order_date ON order;


ALTER TABLE category ADD INDEX index_parent_id(parent_id);

ALTER TABLE order ADD INDEX index_order_date(created);

ALTER TABLE product ADD INDEX index_price(price);



SHOW INDEX FROM product;


-- without index search
 DROP INDEX index_price ON product;

explain SELECT * FROM product  where price >15000 ;


-- with index search

ALTER TABLE product ADD INDEX index_price(price);

explain SELECT * FROM product  where price > 15000 ;