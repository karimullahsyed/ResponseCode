CREATE DATABASE emi_transaction_process;
USE emi_transaction_process;

CREATE TABLE `emi_transaction_process` (
  `prim_id` varchar(50) NOT NULL,
  `user_id` int(20) NOT NULL,
  `issuer_bank_code` int(5) NOT NULL,
  `issuer_scheme_code` varchar(20) NOT NULL,
  `model_code` varchar(20) NOT NULL,
  `txn_amount` varchar(12) NOT NULL,
  `txn_date_time` timestamp,
  `card_holder_name` varchar(50) NOT NULL,
  `mobile_no` varchar(20) NOT NULL,
  `mask_card_number` varchar(25) NOT NULL,
  `encrypted_card_number` varchar(255) NOT NULL,
  `invoice_number` varchar(100) NOT NULL,
  `approval_code` varchar(10) NOT NULL,
  `rrn_number` varchar(20) NOT NULL,
  `charge_slip` mediumblob NOT NULL,
  `signature` mediumblob NOT NULL,
  `emi_details` varchar(1500) NOT NULL 
   PRIMARY KEY (`prim_id`)
);


create table `kekkeys` (
	`ckey` varchar (765),
	`hasha` varchar (765),
	`hashb` varchar (765),
	`hashc` varchar (765),
	`hashe` varchar (765),
	`lastupdated` varchar (90),
	`is_active` varchar (1),
	`crtupd_dt` datetime ,
	`crtupd_user` varchar (96),
	 PRIMARY KEY (`ckey`, `hasha`, `lastupdated`)
); 

create table `dekkeys` (
	`dekkey` varchar (750),
	`lastupdated` varchar (90),
	`is_active` varchar (1),
	`crtupd_dt` datetime ,
	`crtupd_user` varchar (96),
	 PRIMARY KEY (`dekkey`,`lastupdated`)
); 
