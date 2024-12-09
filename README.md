# nimap_task_code

1]Spring Boot Setup:
SpringBoot developers provide many ways to create SpringBoot Application like,STS IDE,Spring Initializer,Any IDE which supports lang and need to add STS extention. You can start by creating a new Spring Boot project using Spring Initializr or your preferred IDE.Here i used spring initializer for setup folder structure and for starters.
Make sure to include the necessary dependencies for Spring Web, Spring Data JPA, and any database driver (e.g., H2, MySQL, PostgreSQL).

2]Application Layer for this task:
  Presentation Layer===>Service Layer=====>DAO Layer===>Database Respectively below annotation represent their corresponding Layers
  @RestController       @Service           @Entity       #Mysql Database is here 

3]REST Controllers:
Create REST controllers to handle the CRUD operations for both categories and products.
Annotate your controller methods with @GetMapping, @PostMapping, @PutMapping, and @DeleteMapping to define the API endpoints.

4]Database Configuration (RDB):
Configure your database connection in the application.properties or application.yml file.Here i user application.properties
Use an RDBMS as per given requirement like MySQL.
Use annotations like @Entity, @Table, @Column, and @OneToMany to define your data model and relationships.


5]One-to-Many Relationship:
Define a one-to-many relationship between categories (O) and products (M).
Annotate the appropriate fields in your entities (e.g., @OneToMany in the Category entity).

6]Server side Pagination:
Implement server-side pagination by using query parameters (e.g., page, size, sort).
In your repository, use methods like findAll(Pageable pageable) to retrieve paginated results.


7]Finally you can use postman or any api testing site for test below rest end points.

Category CRUD Operations:
Rest end urls for categories:
GET http://localhost:8080/api/categories?page=3: To get all categories (with pagination).
POST http://localhost:8080/api/categories: To create a new category.
GET http://localhost:8080/api/categories/{id}: Retrieve category by ID.
PUT http://localhost:8080/api/categories/{id}: Update category by ID.
DELETE http://localhost:8080/api/categories/{id}: Delete category by ID.

Product CRUD Operations:
Rest end urls for products:
GET http://localhost:8080/api/products?page=2: Retrieve all products (with pagination).
POST http://localhost:8080/api/products: Create a new product.
GET http://localhost:8080/api/products/{id}: Retrieve a product by ID.
PUT http://localhost:8080/api/products/{id}: Update a product by ID.
DELETE http://localhost:8080/api/products/{id}: Delete a product by ID.

Thank You.

