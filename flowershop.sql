CREATE TABLE `customer` (
   `customerID` int(11) NOT NULL AUTO_INCREMENT,
   `name` varchar(45) DEFAULT NULL,
   `address` varchar(45) DEFAULT NULL,
   `distance` double DEFAULT NULL,
   PRIMARY KEY (`customerID`)
 ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8

CREATE TABLE `product_type` (
   `typeID` int(11) NOT NULL AUTO_INCREMENT,
   `typeName` varchar(45) DEFAULT NULL,
   PRIMARY KEY (`typeID`)
 ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8


CREATE TABLE `product` (
   `productID` int(11) NOT NULL AUTO_INCREMENT,
   `productName` varchar(45) DEFAULT NULL,
   `typeID` int(11) DEFAULT NULL,
   `price` double DEFAULT NULL,
   `quantity` int(11) DEFAULT NULL,
   PRIMARY KEY (`productID`)
 ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8


CREATE TABLE `customer_order` (
   `orderID` int(11) NOT NULL AUTO_INCREMENT,
   `customerID` int(11) NOT NULL,
   `totalAmount` double DEFAULT NULL,
   `mode` int(11) DEFAULT NULL,
   `pickupdeliverydate` varchar(45) DEFAULT NULL,
   PRIMARY KEY (`orderID`),
   KEY `FK_CustOrder` (`customerID`),
   CONSTRAINT `FK_CustOrder` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`)
 ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8

CREATE TABLE `order_product` (
   `opID` int(11) NOT NULL AUTO_INCREMENT,
   `orderID` int(11) DEFAULT NULL,
   `productID` int(11) DEFAULT NULL,
   `quantity` int(11) DEFAULT NULL,
   `amount` double DEFAULT NULL,
   PRIMARY KEY (`opID`),
   KEY `FK_OPOrder` (`orderID`),
   KEY `FK_OPProduct` (`productID`),
   CONSTRAINT `FK_OPOrder` FOREIGN KEY (`orderID`) REFERENCES `customer_order` (`orderID`),
   CONSTRAINT `FK_OPProduct` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`)
 ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8
