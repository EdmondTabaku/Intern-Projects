-- Find the Customer who has the most orders. If more than 1 customer has the most orders then all customers should be displayed */

SELECT customers.customerName, orderdetails.quantityOrdered
from orders
INNER JOIN customers
ON customers.customerNumber = orders.customerNumber
INNER JOIN orderdetails
ON orderdetails.orderNumber = orders.orderNumber
HAVING orderdetails.quantityOrdered = (SELECT MAX(quantityOrdered) FROM orderdetails);


-- View all “Germany” customers and their orderdetails. If a customer has not made any orders then he should not be included in the result.

SELECT customers.customerName, customers.country, orderdetails.orderNumber, orderdetails.productCode, orderdetails.quantityOrdered, orderdetails.priceEach, orderdetails.orderLineNumber
from orders
INNER JOIN customers
ON customers.customerNumber = orders.customerNumber
INNER JOIN orderDetails
ON orderDetails.orderNumber = orders.orderNumber
WHERE customers.country = 'Germany';


-- List all employees and the their revenue amount (based on payments table)

SELECT employees.firstName, employees.lastName, payments.amount
from customers
INNER JOIN employees
ON employees.employeeNumber = customers.salesRepEmployeeNumber
INNER JOIN payments
ON payments.customerNumber = customers.customerNumber


-- List all products which have been ordered the last month. (since the database is a bit old we assume we are now at 2005-01-01 )

SELECT products.productName, orders.orderDate
from orderdetails
INNER JOIN products
ON products.productCode = orderdetails.productCode
INNER JOIN orders
ON orders.orderNumber = orderdetails.orderNumber
WHERE orders.orderDate LIKE '2004-12%';


-- Create a new table named employeedetails

CREATE TABLE `employeedetails`(
`bankAccount` varchar(50) NOT NULL,
`address` varchar(50) NOT NULL,
`phoneNumber` varchar(50) NOT NULL,
`personalEmail` varchar(50) NOT NULL,
)