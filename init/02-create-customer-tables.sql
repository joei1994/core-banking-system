# ************************************************************
# Sequel Ace SQL dump
# Version 20067
#
# https://sequel-ace.com/
# https://github.com/Sequel-Ace/Sequel-Ace
#
# Host: localhost (MySQL 8.0.37)
# Database: banking_db
# Generation Time: 2025-07-21 05:22:20 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE='NO_AUTO_VALUE_ON_ZERO', SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table customer
# ------------------------------------------------------------

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `customer_id` varchar(36) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password_hash` varchar(255) NOT NULL,
  `citizen_id` varchar(255) DEFAULT NULL,
  `thai_name` varchar(255) DEFAULT NULL,
  `english_name` varchar(255) DEFAULT NULL,
  `pin_hash` int NOT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `registered_at` datetime NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `citizen_id` (`citizen_id`),
  KEY `idx_email` (`email`),
  KEY `idx_citizen_id` (`citizen_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;

INSERT INTO `customer` (`customer_id`, `email`, `password_hash`, `citizen_id`, `thai_name`, `english_name`, `pin_hash`, `created_by`, `registered_at`, `created_at`, `updated_at`, `deleted_at`)
VALUES
	('86272bce-6222-41f2-91b1-5938020afea1','joe.i@example.com','$2a$10$UcQPzxInzw80n0/qFU8SruOR9weThsVJstl2OkuY.wFachgRmr.wi','1234567890125','โจ','joe',123456,'5e88c9d4-7d3b-4e1d-88e7-1f514e7adfa2','2025-07-20 13:28:40','2025-07-20 13:28:40','2025-07-21 05:19:31',NULL),
	('d290f1ee-6c54-4b01-90e6-d701748f0851','john.doe@example.com','$2a$10$8yV4fQHdU4mDCmGrRZWUHeFxJCHn2X.N3qREBSm1dLkN6tPLvBxuy','1101700099991','จอห์น โด','John Doe',123456,'5e88c9d4-7d3b-4e1d-88e7-1f514e7adfa2','2025-07-20 01:53:19','2025-07-20 01:53:19','2025-07-20 01:53:19',NULL),
	('f67c650b-f72f-4ef7-8854-bec35767a48f','jane.smith@example.com','$2a$10$oDt5LusBw9Fl26MbwGDSOe7N6MawAeiOa2gASsr6cNQrNU.hv5Htm','1234567890124','เจน สมิธ','Jane Smith',1234,'5e88c9d4-7d3b-4e1d-88e7-1f514e7adfa2','2025-07-20 11:09:08','2025-07-20 11:09:08','2025-07-21 05:19:17',NULL),
	('faf87936-ea20-495c-981e-0cc91679b12f','jane.doe@example.com','$2a$10$4FlAMSqsHGZpvnCS/vdrdeU8EUzON5BLv12h7tcybw3qas14dreNS','1234567890123','เจน โด','Jane Doe',1234,'5e88c9d4-7d3b-4e1d-88e7-1f514e7adfa2','2025-07-20 10:57:44','2025-07-20 10:57:44','2025-07-20 03:58:29',NULL);

/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
