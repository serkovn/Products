CREATE DATABASE IF NOT EXISTS products
    COLLATE utf8_general_ci;
USE products;
CREATE TABLE product (
                         id BIGINT(20) NOT NULL AUTO_INCREMENT,
                         name varchar(15),
                         description varchar(50),
                         count BIGINT(20),
                         price double,
                         PRIMARY KEY (id)
) ;

INSERT INTO products.product (name, description, count, price)
VALUES
('Помидоры', 'Астраханские большие', 100, 50.8),
('Огурцы', 'Длинноплодные', 50, 20.7),
('Картошка', 'Отечествееная мытая', 450, 16.3);