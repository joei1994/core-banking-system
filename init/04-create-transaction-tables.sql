# ************************************************************
# Sequel Ace SQL dump
# Version 20067
#
# https://sequel-ace.com/
# https://github.com/Sequel-Ace/Sequel-Ace
#
# Host: localhost (MySQL 8.0.37)
# Database: banking_db
# Generation Time: 2025-07-21 05:23:46 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE='NO_AUTO_VALUE_ON_ZERO', SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table transaction
# ------------------------------------------------------------

DROP TABLE IF EXISTS `transaction`;

CREATE TABLE `transaction` (
  `transaction_id` varchar(36) NOT NULL,
  `account_id` varchar(36) NOT NULL,
  `amount` decimal(38,2) DEFAULT NULL,
  `transaction_type` varchar(255) DEFAULT NULL,
  `reference_account` varchar(255) DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `performed_by` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `account_id` (`account_id`),
  CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;

INSERT INTO `transaction` (`transaction_id`, `account_id`, `amount`, `transaction_type`, `reference_account`, `timestamp`, `performed_by`, `status`)
VALUES
	('08466884-914d-47d2-91b5-8fb1fc965287','06d2f340-4223-431d-95da-bcf7162ffbdc',500.00,'WITHDRAW',NULL,'2025-07-20 14:43:16','33d49f8a-14b8-46b2-9df8-5e58fc3cd7d2','SUCCESS'),
	('18a3b83d-a9af-4e8a-ac02-1822e9469b77','06d2f340-4223-431d-95da-bcf7162ffbdc',5000.00,'DEPOSIT',NULL,'2025-07-20 17:43:41','33d49f8a-14b8-46b2-9df8-5e58fc3cd7d2','SUCCESS'),
	('257c6f00-382e-415f-ae0d-abbdd41f0d91','06d2f340-4223-431d-95da-bcf7162ffbdc',1000.00,'TRANSFER','eabda1b3-ccd5-4f90-a6d8-400065447645','2025-07-20 17:28:42','06d2f340-4223-431d-95da-bcf7162ffbdc','SUCCESS'),
	('2f3702b6-ad70-4bda-ba1d-5ad111840b33','06d2f340-4223-431d-95da-bcf7162ffbdc',500.00,'WITHDRAW',NULL,'2025-07-20 17:43:56','33d49f8a-14b8-46b2-9df8-5e58fc3cd7d2','SUCCESS'),
	('311a95d9-1db3-48f6-998f-7d92356f3c63','06d2f340-4223-431d-95da-bcf7162ffbdc',500.00,'DEPOSIT',NULL,'2025-07-20 14:42:39','33d49f8a-14b8-46b2-9df8-5e58fc3cd7d2','SUCCESS'),
	('641795c6-c3ba-4361-9eb6-d324e827c62f','06d2f340-4223-431d-95da-bcf7162ffbdc',1000.00,'DEPOSIT',NULL,'2025-07-20 14:43:30','33d49f8a-14b8-46b2-9df8-5e58fc3cd7d2','SUCCESS'),
	('87d79169-729f-4517-ab9c-87621db5504b','06d2f340-4223-431d-95da-bcf7162ffbdc',1000.00,'DEPOSIT',NULL,'2025-07-20 14:42:17','33d49f8a-14b8-46b2-9df8-5e58fc3cd7d2','SUCCESS'),
	('8ea44af3-49e1-41e0-9ca3-15c220daf71d','06d2f340-4223-431d-95da-bcf7162ffbdc',1000.00,'DEPOSIT',NULL,'2025-07-20 14:06:49','33d49f8a-14b8-46b2-9df8-5e58fc3cd7d2','PENDING'),
	('ccdc4e49-c204-4c7c-be1a-a8380d640a2d','06d2f340-4223-431d-95da-bcf7162ffbdc',500.00,'DEPOSIT',NULL,'2025-07-20 14:42:44','33d49f8a-14b8-46b2-9df8-5e58fc3cd7d2','SUCCESS'),
	('cd906719-fcf8-4361-b92f-42bd520f1e2f','06d2f340-4223-431d-95da-bcf7162ffbdc',500.00,'WITHDRAW',NULL,'2025-07-20 14:43:21','33d49f8a-14b8-46b2-9df8-5e58fc3cd7d2','SUCCESS'),
	('d1dc8a6a-9f98-4f5f-8659-dec072365ba9','06d2f340-4223-431d-95da-bcf7162ffbdc',5000.00,'TRANSFER','45a9b72d-71cc-4fad-bf6f-dd030adcce1b','2025-07-20 17:49:38','06d2f340-4223-431d-95da-bcf7162ffbdc','SUCCESS'),
	('f5acbbae-7fb3-4c0d-b2d8-e1580de8d338','06d2f340-4223-431d-95da-bcf7162ffbdc',5000.00,'DEPOSIT',NULL,'2025-07-20 17:44:05','33d49f8a-14b8-46b2-9df8-5e58fc3cd7d2','SUCCESS'),
	('f7750f25-4088-4dc2-b651-6d8949ac27e3','06d2f340-4223-431d-95da-bcf7162ffbdc',1000.00,'TRANSFER','eabda1b3-ccd5-4f90-a6d8-400065447645','2025-07-20 14:44:05','33d49f8a-14b8-46b2-9df8-5e58fc3cd7d2','SUCCESS');

/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
