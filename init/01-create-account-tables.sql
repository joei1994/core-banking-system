# ************************************************************
# Sequel Ace SQL dump
# Version 20067
#
# https://sequel-ace.com/
# https://github.com/Sequel-Ace/Sequel-Ace
#
# Host: localhost (MySQL 8.0.37)
# Database: banking_db
# Generation Time: 2025-07-21 05:20:05 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE='NO_AUTO_VALUE_ON_ZERO', SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table account
# ------------------------------------------------------------

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `account_id` varchar(36) NOT NULL,
  `account_number` varchar(255) NOT NULL,
  `customer_id` varchar(36) NOT NULL,
  `balance` decimal(38,2) NOT NULL,
  `account_type` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `account_number` (`account_number`),
  UNIQUE KEY `UK66gkcp94endmotfwb8r4ocxm9` (`account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;

INSERT INTO `account` (`account_id`, `account_number`, `customer_id`, `balance`, `account_type`, `status`, `created_at`, `created_by`, `updated_at`, `deleted_at`)
VALUES
	('06d2f340-4223-431d-95da-bcf7162ffbdc','5810452','86272bce-6222-41f2-91b1-5938020afea1',5700.00,'SAVING','ACTIVE','2025-07-20 14:04:44','33d49f8a-14b8-46b2-9df8-5e58fc3cd7d2','2025-07-20 14:04:44',NULL),
	('45a9b72d-71cc-4fad-bf6f-dd030adcce1b','5190732','86272bce-6222-41f2-91b1-5938020afea1',6200.00,'SAVING','ACTIVE','2025-07-20 17:48:11','33d49f8a-14b8-46b2-9df8-5e58fc3cd7d2','2025-07-20 17:48:11',NULL),
	('eabda1b3-ccd5-4f90-a6d8-400065447645','2952547','d290f1ee-6c54-4b01-90e6-d701748f0851',3000.00,'SAVING','ACTIVE','2025-07-20 12:53:54','33d49f8a-14b8-46b2-9df8-5e58fc3cd7d2','2025-07-20 12:53:54',NULL);

/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
