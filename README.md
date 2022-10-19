# SA Mini Project 2
## Members
1. Minh Thiep Ha
2. Hong Phuc Thai

### Github 
https://github.com/henryhacode/ShoppingApp

## Build project
1. Start docker.app


2. Start minikube 
```
$ cd ShoppingApp
$ start minikube
```

3. Get ip of each services
```
$ minikube service keycloak-service --url
$ minikube service account-service --url
$ minikube service product-service --url
```

4. Manual setup Keycloak

a. Loggin to keyclock using IP from step 3 > Choose Sa-mini-project2-realm-dev real > Realm settings > Tab General:

Change Frontend URL = http://keycloak-service:8080,
   <img src="./markdown/Screen Shot 2022-10-18 at 8.02.24 PM.png" alt="Alt text" title="People">

b. Loggin to keyclock using IP from step 3 > Choose Sa-mini-project2-realm-dev real > Realm settings > Tab Tokens:

Change all settings to Days
   <img src="./markdown/Screen Shot 2022-10-18 at 8.06.36 PM.png" alt="Alt text" title="People">

<br>
<br>
5. Manual insert databases into accountdb (if data not auto generated)

a. Open CLI of accountdb pod
   <img src="./markdown/Screen Shot 2022-10-18 at 8.20.25 PM.png" alt="Alt text" title="People">

b. Check if data was auto generated

```
$ mysql -u root -p
$ Enter password: dbadmin
$ mysql> SHOW DATABASES;
$ mysql> USE accountdb;
$ mysql> SELECT * FROM accounts;
```
 
c. If there is no data generated, please run below commands to insert data

```
INSERT INTO accounts(first_name, last_name, email, preferred_payment, preferred_shipping)
VALUES
  ('phat', 'nguyen', 'phatnguyen@outlook.com', 0, 0),
  ('thiep', 'ha', 'thiep@gmail.com', 0, 0),
  ('phuc', 'thai', 'thai@miu.edu', 0, 0);
```
<img src="./markdown/Screen Shot 2022-10-18 at 8.21.54 PM.png" alt="Alt text" title="People">

<br>
<br>
6. Manual insert databases into productdb (if data not auto generated)

a. Open CLI of productdb pod
   <img src="./markdown/Screen Shot 2022-10-18 at 8.10.32 PM.png" alt="Alt text" title="People">

b. Check if data was auto generated
```
$ mysql -u root -p
$ Enter password: dbadmin
$ mysql> SHOW DATABASES;
$ mysql> USE productdb;
$ mysql> SELECT * FROM products;
``` 
   c. If there is no data generated, please run below commands to insert data

```
INSERT INTO products(name, vendor, category, description, units)
VALUES
('iphone 14 pro max', 'apple', 'phone', 'description iphone', 100),
('macbook air m2', 'apple', 'laptop', 'description macbook', 10),
('samsung s22 plus', 'samsung', 'phone', 'description samsung s', 50),
('harry porter', 'amazon', 'book', 'description book', 2),
('cap', 'adidas', 'clothes', 'adidas cap', 2)
;  
``` 
   <img src="./markdown/Screen Shot 2022-10-18 at 8.18.12 PM.png" alt="Alt text" title="People">

<br>
## Run project
Start Postman, import provided file "SA.postman_collection.json"

<br>
<b>A. Keycloak Service</b>
1. Generate Token with notes:

a. Update correct IP in step 3

b. Authentication: 
```
$ Username: sa-mini-project2
$ Password: Yvhd7uSP0krdOb5fanvH1DWKIKsUyZqT
```
   <img src="./markdown/Screen Shot 2022-10-18 at 8.24.11 PM.png" alt="Alt text" title="People">

c. Body

```
$ grant_type: password
$ username: phat
$ password: 123
```
   <img src="./markdown/Screen Shot 2022-10-18 at 9.48.04 PM.png" alt="Alt text" title="People">

<br>
<b>B. Account Service</b>
1. Get Account Info:

a. Update correct IP in step 3

b. Authentication > Bearer Token
```
$ Token: <get from Keycloak token>
```
   <img src="./markdown/Screen Shot 2022-10-18 at 8.57.53 PM.png" alt="Alt text" title="People">

2. Similiar test cases for:
```
- Add Shipping Address
- Set Preferred Shipping Address
- Delete Shipping Address
- Add Payment Method
- Set Preferred Payment Method
- Delete Payment Method
```
<img src="./markdown/Screen Shot 2022-10-18 at 9.07.20 PM.png" alt="Alt text" title="People">

<br>
<br>
<b>C. Product Service</b>
1. Get Product Info:

a. Update correct IP in step 3

b. Authentication > Bearer Token
```
$ Token: <get from Keycloak token>
```
   <img src="./markdown/Screen Shot 2022-10-18 at 9.28.27 PM.png" alt="Alt text" title="People">

2. Similiar test cases for:
```
- Add Product
- Delete Product
- Update Product
```
<img src="./markdown/Screen Shot 2022-10-18 at 9.29.31 PM.png" alt="Alt text" title="People">

3. Order a product, then the remaining stock < threshold:
<img src="./markdown/Screen Shot 2022-10-18 at 9.31.45 PM.png" alt="Alt text" title="People">

There is a message sent from Notification Service
<img src="./markdown/Screen Shot 2022-10-18 at 9.34.09 PM.png" alt="Alt text" title="People">
