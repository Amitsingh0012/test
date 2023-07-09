#  Ecommerce API

This is an Ecommerce API built with Spring Boot and MySQL database. The API provides endpoints for managing users, products, addresses, and orders.

## ##  Prerequisites

- Java 11
- MySQL database
- Maven

## ##  Getting Started

1. Clone the repository:

   ```shell
   git clone https://github.com/Amitsingh0012/test/tree/test09-07-23

2.Configure the database connection in the application.properties file located in the src/main/resources directory:
    ```shell
    spring.datasource.url=jdbc:mysql://localhost:3306/Ecommerce_API_db
    spring.datasource.username=root
    spring.datasource.password=Nikita@123
    spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
    spring.jpa.hibernate.ddl-auto=update

    spring.jpa.properties.hibernate.show_sql=true
    spring.jpa.properties.hibernate.use_sql_comments=true
    spring.jpa.properties.hibernate.format_sql=true
    API Endpoints
## Users
  * POST /users: Create a new user.
  * GET /users/{id}: Get user by ID.
## Products

  * POST /products: Create a new product.

  * GET /products: Get all products.

  * GET /products?category={category}: Get products by category (query parameter).

  * DELETE /products/{id}: Delete product by ID.
## Addresses

  * POST /addresses: Create a new address.

##  Orders

  * POST /orders: Place an order using userId, productId, and addressId.

  * GET /orders/{id}: Get order by ID.

License
* This project is licensed under the GEEKSTER License.
