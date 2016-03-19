/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Mahendra
 * Created: Mar 19, 2016
 */

CREATE DATABASE `officialwears` /*!40100 DEFAULT CHARACTER SET latin1 */;


CREATE TABLE `customerinfo` (
  `cusId` varchar(10) NOT NULL,
  `username` varchar(15) DEFAULT NULL,
  `lastName` varchar(25) DEFAULT NULL,
  `firstName` varchar(15) DEFAULT NULL,
  `email` varchar(15) DEFAULT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `dateOfBirth` date DEFAULT NULL,
  PRIMARY KEY (`cusId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `customerlogininfo` (
  `cusid` varchar(10) DEFAULT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `cusid` (`cusid`),
  CONSTRAINT `customerlogininfo_ibfk_1` FOREIGN KEY (`cusid`) REFERENCES `customerinfo` (`cusId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `customerlogininfo` (
  `cusid` varchar(10) DEFAULT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `cusid` (`cusid`),
  CONSTRAINT `customerlogininfo_ibfk_1` FOREIGN KEY (`cusid`) REFERENCES `customerinfo` (`cusId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `designdata` (
  `designId` varchar(10) NOT NULL,
  `productName` varchar(20) DEFAULT NULL,
  `category` varchar(20) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `imageName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`designId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
