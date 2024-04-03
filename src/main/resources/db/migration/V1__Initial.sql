CREATE TABLE `client` (
                          `client_id` bigint NOT NULL AUTO_INCREMENT,
                          `created_date` datetime(6) DEFAULT NULL,
                          `updated_date` datetime(6) DEFAULT NULL,
                          `address` varchar(255) DEFAULT NULL,
                          `created_by` bigint DEFAULT NULL,
                          `email` varchar(255) DEFAULT NULL,
                          `first_name` varchar(255) DEFAULT NULL,
                          `last_name` varchar(255) DEFAULT NULL,
                          `notification_token` varchar(255) DEFAULT NULL,
                          `password` varchar(255) DEFAULT NULL,
                          `phone_number` varchar(255) DEFAULT NULL,
                          `profile_image` varchar(255) DEFAULT NULL,
                          `updated_by` bigint DEFAULT NULL,
                          PRIMARY KEY (`client_id`)
);

CREATE TABLE `order_history` (
                                 `user_order_type` tinyint DEFAULT NULL,
                                 `created_date` datetime(6) DEFAULT NULL,
                                 `id` bigint NOT NULL AUTO_INCREMENT,
                                 `order_id` bigint DEFAULT NULL,
                                 `updated_date` datetime(6) DEFAULT NULL,
                                 `user_ordered_id` bigint DEFAULT NULL,
                                 PRIMARY KEY (`id`),
                                 CONSTRAINT `order_history_chk_1` CHECK ((`user_order_type` between 0 and 1))
);

CREATE TABLE `orders` (
                          `distance` float DEFAULT NULL,
                          `number_of_items` int DEFAULT NULL,
                          `number_of_labours` int DEFAULT NULL,
                          `number_of_trips` int DEFAULT NULL,
                          `number_of_vehicles` int DEFAULT NULL,
                          `order_by` tinyint DEFAULT NULL,
                          `status` tinyint DEFAULT NULL,
                          `total_price` double DEFAULT NULL,
                          `vehicle_type` tinyint DEFAULT NULL,
                          `weight_per_items` float DEFAULT NULL,
                          `created_date` datetime(6) DEFAULT NULL,
                          `delivered_time` datetime(6) DEFAULT NULL,
                          `order_id` bigint NOT NULL AUTO_INCREMENT,
                          `pickup_time` datetime(6) DEFAULT NULL,
                          `updated_date` datetime(6) DEFAULT NULL,
                          `user_ordered_id` bigint DEFAULT NULL,
                          `from_location` varchar(255) DEFAULT NULL,
                          `name_of_receiver` varchar(255) DEFAULT NULL,
                          `payment_method` varchar(255) DEFAULT NULL,
                          `to_location` varchar(255) DEFAULT NULL,
                          PRIMARY KEY (`order_id`),
                          CONSTRAINT `orders_chk_1` CHECK ((`order_by` between 0 and 1)),
                          CONSTRAINT `orders_chk_2` CHECK ((`status` between 0 and 3)),
                          CONSTRAINT `orders_chk_3` CHECK ((`vehicle_type` between 0 and 2))
);

CREATE TABLE `role` (
                        `created_date` datetime(6) DEFAULT NULL,
                        `role_id` bigint NOT NULL AUTO_INCREMENT,
                        `updated_date` datetime(6) DEFAULT NULL,
                        `description` varchar(255) DEFAULT NULL,
                        `role_name` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`role_id`)
);

CREATE TABLE `user` (
                        `user_type` tinyint DEFAULT NULL,
                        `created_date` datetime(6) DEFAULT NULL,
                        `updated_date` datetime(6) DEFAULT NULL,
                        `user_id` bigint NOT NULL AUTO_INCREMENT,
                        `email` varchar(255) DEFAULT NULL,
                        `first_name` varchar(255) DEFAULT NULL,
                        `last_name` varchar(255) DEFAULT NULL,
                        `notification_token` varchar(255) DEFAULT NULL,
                        `password` varchar(255) DEFAULT NULL,
                        `phone_number` varchar(255) DEFAULT NULL,
                        `profile_image` varchar(255) DEFAULT NULL,
                        `user_name` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`user_id`),
                        CONSTRAINT `user_chk_1` CHECK ((`user_type` between 0 and 2))
);

CREATE TABLE `user_role` (
                             `role_id` bigint NOT NULL,
                             `user_id` bigint NOT NULL,
                             PRIMARY KEY (`role_id`,`user_id`),
                             KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`),
                             CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
                             CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
);

CREATE TABLE `vehicle` (
                           `capacity` float DEFAULT NULL,
                           `depth` float DEFAULT NULL,
                           `length` float DEFAULT NULL,
                           `rate` double DEFAULT NULL,
                           `vehicle_type` tinyint DEFAULT NULL,
                           `width` float DEFAULT NULL,
                           `created_by` bigint DEFAULT NULL,
                           `created_date` datetime(6) DEFAULT NULL,
                           `updated_by` bigint DEFAULT NULL,
                           `updated_date` datetime(6) DEFAULT NULL,
                           `vehicle_id` bigint NOT NULL AUTO_INCREMENT,
                           `best_for_sending` varchar(255) DEFAULT NULL,
                           `health_condition` varchar(255) DEFAULT NULL,
                           `model` varchar(255) DEFAULT NULL,
                           `vehicle_name` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`vehicle_id`),
                           CONSTRAINT `vehicle_chk_1` CHECK ((`vehicle_type` between 0 and 2))
);

CREATE TABLE `worker` (
                          `identity_proof_type` tinyint DEFAULT NULL,
                          `salary` double DEFAULT NULL,
                          `worker_age` int DEFAULT NULL,
                          `worker_type` tinyint DEFAULT NULL,
                          `created_by` bigint DEFAULT NULL,
                          `created_date` datetime(6) DEFAULT NULL,
                          `updated_by` bigint DEFAULT NULL,
                          `updated_date` datetime(6) DEFAULT NULL,
                          `worker_id` bigint NOT NULL AUTO_INCREMENT,
                          `identity_number` varchar(255) DEFAULT NULL,
                          `worker_name` varchar(255) DEFAULT NULL,
                          PRIMARY KEY (`worker_id`),
                          CONSTRAINT `worker_chk_1` CHECK ((`identity_proof_type` between 0 and 4)),
                          CONSTRAINT `worker_chk_2` CHECK ((`worker_type` between 0 and 1))
);

CREATE TABLE `worker_order` (
                                `id` bigint NOT NULL AUTO_INCREMENT,
                                `order_id` bigint DEFAULT NULL,
                                `worker_id` bigint DEFAULT NULL,
                                PRIMARY KEY (`id`),
                                KEY `FKw90j6s7sv17qr8a48x90qd8y` (`order_id`),
                                KEY `FKgte6je0wxa2ncecajafhhe49y` (`worker_id`),
                                CONSTRAINT `FKgte6je0wxa2ncecajafhhe49y` FOREIGN KEY (`worker_id`) REFERENCES `worker` (`worker_id`),
                                CONSTRAINT `FKw90j6s7sv17qr8a48x90qd8y` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`)
);

CREATE TABLE `worker_salary` (
                                 `paid_date` date DEFAULT NULL,
                                 `salary_status` tinyint DEFAULT NULL,
                                 `created_date` datetime(6) DEFAULT NULL,
                                 `id` bigint NOT NULL AUTO_INCREMENT,
                                 `paid_by` bigint DEFAULT NULL,
                                 `updated_date` datetime(6) DEFAULT NULL,
                                 `worker_id` bigint DEFAULT NULL,
                                 `of_month` varchar(255) DEFAULT NULL,
                                 PRIMARY KEY (`id`),
                                 CONSTRAINT `worker_salary_chk_1` CHECK ((`salary_status` between 0 and 1))
);
