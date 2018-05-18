CREATE DATABASE emi_configuration;
USE emi_configuration;

CREATE TABLE oauth_client_details (
  client_id VARCHAR(255) PRIMARY KEY,
  resource_ids VARCHAR(255),
  client_secret VARCHAR(255),
  scope VARCHAR(255),
  authorized_grant_types VARCHAR(255),
  web_server_redirect_uri VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(255),
  autoapprove VARCHAR(255)
 );

CREATE TABLE oauth_client_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication_id VARCHAR(255),
  user_name VARCHAR(255),
  client_id VARCHAR(255)
);

CREATE TABLE oauth_access_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication_id VARCHAR(255),
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication BLOB,
  refresh_token VARCHAR(255)
);
CREATE TABLE oauth_refresh_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication BLOB
);
CREATE TABLE oauth_code (
  code VARCHAR(255), authentication BLOB
);

CREATE TABLE `user_details` (
  `user_id` int(10) unsigned NOT NULL,  
  `user_name` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `secretkey` varchar(255) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `country_name` varchar(50) NOT NULL,
  `iso_country_code` varchar(4) NOT NULL,
  `is_active` varchar(1) DEFAULT 'Y',
  `crtupd_dt` datetime,
  `crtupd_user` varchar(32) DEFAULT NULL, 
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_user_details1` (`user_name`),
  UNIQUE KEY `UK_user_details2` (`email`),
  UNIQUE KEY `UK_user_details3` (`mobile`)
);

CREATE TABLE `user_roles` (
  `user_role_id` smallint(5) unsigned NOT NULL,
  `user_role_name` varchar(45) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `UK_user_roles1` (`user_role_id`,`user_role_name`),
  UNIQUE KEY `UK_user_roles2` (`user_role_name`)
);

CREATE TABLE `user_roles_mapping` (
  `user_id` int(10) unsigned NOT NULL,
  `user_role_id` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`user_id`,`user_role_id`),
  CONSTRAINT `FK_user_roles_mapping1` FOREIGN KEY (`user_role_id`) REFERENCES `user_roles` (`user_role_id`),
  CONSTRAINT `FK_user_roles_mapping2` FOREIGN KEY (`user_id`) REFERENCES `user_details` (`user_id`)
);

CREATE TABLE `manufacturers` (
  `manufacture_code` varchar(20) NOT NULL,
  `manufacture_display_name` varchar(50) NOT NULL,
  `is_active` varchar(1) DEFAULT 'Y',
  `crtupd_dt` datetime,
  `crtupd_user` varchar(32) DEFAULT NULL, 
  PRIMARY KEY (`manufacture_code`)
);

CREATE TABLE `categories` (
  `category_code` varchar(20) NOT NULL,
  `category_display_name` varchar(50) NOT NULL,
  `is_active` varchar(1) DEFAULT 'Y',
  `crtupd_dt` datetime,
  `crtupd_user` varchar(32) DEFAULT NULL, 
  PRIMARY KEY (`category_code`)
);

CREATE TABLE `models` (
  `model_code` varchar(20) NOT NULL,
  `manufacture_code` varchar(20) NOT NULL,
  `category_code` varchar(20) NOT NULL,
  `model_display_name` varchar(50) NOT NULL,
  `is_active` varchar(1) DEFAULT 'Y',
  `crtupd_dt` datetime,
  `crtupd_user` varchar(32) DEFAULT NULL, 
  PRIMARY KEY (`model_code`),
  CONSTRAINT `FK_model1` FOREIGN KEY (`category_code`) REFERENCES `categories` (`category_code`),
  CONSTRAINT `FK_model2` FOREIGN KEY (`manufacture_code`) REFERENCES `manufactures` (`manufacture_code`)
);

CREATE TABLE `emi_tenures` (
  `emi_tenure_code` varchar(5) NOT NULL,
  `emi_tenure_display_name` varchar(50) NOT NULL,
  `emi_tenure_months` varchar(5) NOT NULL,
  `is_active` varchar(1) DEFAULT 'Y',
  `crtupd_dt` datetime,
  `crtupd_user` varchar(32) DEFAULT NULL, 
   PRIMARY KEY (`emi_tenure_code`)
);


CREATE TABLE `issuer_banks` (
  `issuer_bank_code` int(5) NOT NULL,
  `issuer_bank_display_name` varchar(50) NOT NULL,
  `issuer_min_emi_amount` varchar(12) DEFAULT NULL,
  `issuer_cashback_flag` varchar(5) NOT NULL COMMENT 'PRE or POST',
  `is_active` varchar(1) DEFAULT 'Y',
  `crtupd_dt` datetime,
  `crtupd_user` varchar(32) DEFAULT NULL, 
  PRIMARY KEY (`issuer_bank_code`)
);

CREATE TABLE `issuing_bin` (
  `issuer_bin` int(10) NOT NULL,
  `issuer_bank_code` int(5) NOT NULL,
  `scheme_type` varchar(12) NOT NULL,
  `card_type` varchar(12) NOT NULL,
  `iso_country_code` varchar(12) NOT NULL,
  `is_active` varchar(1) DEFAULT 'Y',
  `crtupd_dt` datetime,
  `crtupd_user` varchar(32) DEFAULT NULL, 
  PRIMARY KEY (`issuer_bin`),
  CONSTRAINT `FK_issuing_bin` FOREIGN KEY (`issuer_bank_code`) REFERENCES `issuer_banks` (`issuer_bank_code`)
);

CREATE TABLE `issuer_schemes1` (
  `issuer_scheme_code` varchar(20) NOT NULL,
  `issuer_bank_code`  int(5) NOT NULL,
  `emi_tenure_code` varchar(5) NOT NULL,
  `issuer_scheme_display_name` varchar(50) NOT NULL,
  `advance_emi` varchar(6) DEFAULT '0',
  `issuer_scheme_processing_fees` varchar(10) DEFAULT NULL COMMENT 'like PRECENTAGE - 5P or FLAT - 50F',
  `issuer_rate_of_interest` varchar(10) DEFAULT NULL COMMENT 'like only PRECENTAGE - 5',
  `cashback` varchar(10) DEFAULT NULL COMMENT 'like PRECENTAGE - 5P or FLAT - 50F',
  `is_active` varchar(1) DEFAULT 'Y',
  `crtupd_dt` datetime,
  `crtupd_user` varchar(32) DEFAULT NULL, 
   PRIMARY KEY (`issuer_scheme_code`),
   CONSTRAINT `FK_issuer_schemes1` FOREIGN KEY (`issuer_bank_code`) REFERENCES `issuer_banks` (`issuer_bank_code`),
   CONSTRAINT `FK_issuer_schemes2` FOREIGN KEY (`emi_tenure_code`) REFERENCES `emi_tenures` (`emi_tenure_code`)
);

CREATE TABLE `issuer_scheme_model` (
  `issuer_scheme_model_code` varchar(50) NOT NULL,
  `issuer_scheme_code` varchar(20) NOT NULL,
  `model_code` varchar(20) NOT NULL,
  `is_active` varchar(1) DEFAULT 'Y',
  `crtupd_dt` datetime,
  `crtupd_user` varchar(32) DEFAULT NULL, 
   PRIMARY KEY (`issuer_scheme_model_code`),
   CONSTRAINT `FK_issuer_scheme_model1` FOREIGN KEY (`issuer_scheme_code`) REFERENCES `issuer_schemes` (`issuer_scheme_code`),
   CONSTRAINT `FK_issuer_scheme_model2` FOREIGN KEY (`model_code`) REFERENCES `models` (`model_code`)
);

CREATE TABLE `issuer_scheme_model_user` (
  `user_id` int(10) unsigned NOT NULL,
  `issuer_scheme_model_code` varchar(50) NOT NULL,
  `is_active` varchar(1) DEFAULT 'Y',
  `crtupd_dt` datetime,
  `crtupd_user` varchar(32) DEFAULT NULL, 
   PRIMARY KEY `PK_user_details1` (`user_id`,`issuer_scheme_model_code`)
);
