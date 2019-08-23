INSERT INTO `test`.`user` (`user_id`, `password`) VALUES (1, 'a');

INSERT INTO `test`.`user` (`user_id`, `password`) VALUES (2, 'b');

INSERT INTO `test`.`user` (`user_id`, `password`) VALUES (3, 'c');

INSERT INTO `test`.`user` (`user_id`, `password`) VALUES (4, 'd');

INSERT INTO `test`.`user` (`user_id`, `password`) VALUES (5, 'e');



INSERT INTO `test`.`shopper`
(`shopper_name`,
`email_id`,
`address_id`,
`shopper_id`)
VALUES
(
"rahul", "rahul.com", 1, 1
);


INSERT INTO `test`.`shopper`
(`shopper_name`,
`email_id`,
`address_id`,
`shopper_id`)
VALUES
(
"yash", "yash.com", 2, 2
);

INSERT INTO `test`.`shopper`
(`shopper_name`,
`email_id`,
`address_id`,
`shopper_id`)
VALUES
(
"vatsal", "vatsal.com", 3, 3
);


INSERT INTO `test`.`shopper`
(`shopper_name`,
`email_id`,
`address_id`,
`shopper_id`)
VALUES
(
"ajay", "ajay.com", 4, 4
);


INSERT INTO `test`.`shopper`
(`shopper_name`,
`email_id`,
`address_id`,
`shopper_id`)
VALUES
(
"shobhit", "shobhit.com", 5, 5
);


delete from shopper where shopper_id =5;

INSERT INTO `test`.`admin`
(`admin_name`,
`email_id`,
`admin_id`)
VALUES
(
"ajay",
"ajay.com",
4
);

INSERT INTO `test`.`admin`
(`admin_name`,
`email_id`,
`admin_id`)
VALUES
(
"shobhit",
"shobhit.com",
5
);




INSERT INTO `test`.`category` (`category_id`, `parent_id`, `category_name`) VALUES (1, 11, 'mobile');

INSERT INTO `test`.`category` (`category_id`, `parent_id`, `category_name`) VALUES (2, 12, 'home appliances');

INSERT INTO `test`.`category` (`category_id`, `parent_id`, `category_name`) VALUES (3, 13, 'cigarette');

INSERT INTO `test`.`category` (`category_id`, `parent_id`, `category_name`) VALUES (6, 16, 'fashion');

INSERT INTO `test`.`category` (`category_id`) VALUES (12);

UPDATE `test`.`category` SET `category_name`='rahul' WHERE `category_id`='12';

INSERT INTO `test`.`category` (`category_id`, `parent_id`, `category_name`) VALUES (13, 19, 'Tobacco');

INSERT INTO `test`.`category` (`category_id`, `parent_id`, `category_name`) VALUES (14, 18, 'home products');

INSERT INTO `test`.`category` (`category_id`, `parent_id`, `category_name`) VALUES (7, 13, 'masala');

INSERT INTO `test`.`category` (`category_id`, `parent_id`, `category_name`) VALUES (11, 20, 'electronic');

INSERT INTO `test`.`category` (`category_id`, `parent_id`) VALUES (16, NULL);




INSERT INTO `test`.`product` (`product_id`, `product_name`, `category_id`, `price`, `stock`, `isActive`, `created`) VALUES (1, 'iphone6', 1, 40000, 2, true, CURDATE());

INSERT INTO `test`.`product` (`product_id`, `product_name`, `category_id`, `price`, `stock`, `isActive`, `created`) VALUES (2, 'onePlus6T', 1, 35000, 1, true, CURDATE());

INSERT INTO `test`.`product` (`product_id`, `product_name`, `category_id`, `price`, `stock`, `isActive`, `created`) VALUES (3, 'washing machine', 2, 25000, 3, true , CURDATE());

INSERT INTO `test`.`product` (`product_id`, `product_name`, `category_id`, `price`, `stock`, `isActive`, `created`) VALUES (4, 'Rajnigandha', 7, 50, 0, true, CURDATE());

INSERT INTO `test`.`product` (`product_id`, `product_name`, `category_id`, `price`, `stock`, `isActive`, `created`) VALUES (5, 'gold flake', 3, 15, 100, false, CURDATE());

INSERT INTO `test`.`product` (`product_id`, `product_name`, `category_id`, `price`, `stock`, `isActive`, `created`) VALUES (6, 'chair', 2, 250, 60, true, CURDATE());

INSERT INTO `test`.`product` (`product_id`, `product_name`, `category_id`, `price`, `stock`, `isActive`, `created`) VALUES (7, 'sofa', 2, 30000, 5, true, CURDATE());

INSERT INTO `test`.`product` (`product_id`, `product_name`, `category_id`, `price`, `stock`) VALUES (8, 'lamp', 2, 200, 10, true, CURDATE());

INSERT INTO `test`.`product` (`product_id`, `product_name`, `category_id`, `price`, `stock`, `isActive`, `created`) VALUES (9, 'lipstick', 6, 500, 0, true, CURDATE());

INSERT INTO `test`.`product` (`product_id`, `product_name`, `category_id`, `price`, `stock`, `isActive`, `created`) VALUES (10, 'Men\'s purse', 6, 600, 15, true, CURDATE());


INSERT INTO `test`.`product` (`product_id`, `product_name`, `category_id`, `price`, `stock`, `isActive`, `created`) VALUES (3, 'washing machine', 11, 25000, 3, true , CURDATE());




INSERT INTO `test`.`address` (`address_id`, `address`) VALUES (1, 'jaipur');

INSERT INTO `test`.`address` (`address_id`, `address`) VALUES (2, 'ajmer');

INSERT INTO `test`.`address` (`address_id`, `address`) VALUES (3, 'kota');

INSERT INTO `test`.`address` (`address_id`, `address`) VALUES (4, 'udaipur');

INSERT INTO `test`.`address` (`address_id`, `address`) VALUES (5, 'bhilwara');


INSERT INTO `test`.`images`
(`product_id`,
`image_src`)
VALUES
(
1,
"abc.jpg"
);

INSERT INTO `test`.`images`
(`product_id`,
`image_src`)
VALUES
(
1,
"bcd.jpg"
);

INSERT INTO `test`.`images`
(`product_id`)
VALUES
(
2
);


INSERT INTO `test`.`images`
(`product_id`,
`image_src`)
VALUES
(
3,
"xyz.txt"
);




INSERT INTO `test`.`cart` (`cart_id`, `product_id`, `quantity`) VALUES (1, 1, 1);

INSERT INTO `test`.`cart` (`cart_id`, `product_id`, `quantity`) VALUES (1, 3, 2);

INSERT INTO `test`.`cart` (`cart_id`, `product_id`, `quantity`) VALUES (2, 2, 1);

INSERT INTO `test`.`cart` (`cart_id`, `product_id`, `quantity`) VALUES (3, 4, 2);

INSERT INTO `test`.`cart` (`cart_id`, `product_id`, `quantity`) VALUES (3, 5, 2);

INSERT INTO `test`.`cart` (`cart_id`, `product_id`, `quantity`, `price`, `status`, `date_added`) VALUES (3, 1, 1, 40000, 'cancelled', '2019-07-12');


update cart ct set ct.price = ((select price from product pd where ct.product_id = pd.product_id) * quantity); 



