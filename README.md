# Getting Started

## Product API

This Product API follows Hexagonal Architecture. The application domain resides in the com.example.product.application package, while the infrastructure layer resides in the com.example.product.infrastructure package.
Both layers are loosely coupled, enabling clear separation of concerns, easier maintainability, and flexibility for future changes in technology or business rules.


The inbound adapter is the @RestController (ProductController), which handles HTTP requests and delegates to the business layer (application domain).
- The inbound adapter is the RestController which handles HTTP requests and delegates to the business layer (application domain).
- The business layer applies the domain logic and interacts with the outbound adapter via dependency inversion.
- The outbound adapter is the JpaProductRepository.
- This repository interface is an output port, allowing the domain to remain independent of persistence details. The actual database interaction is handled by Spring Data JPA.
- Certain categories and special products apply **dynamic discounts** using the **Strategy Pattern**, allowing for flexible business rules without changing core code.
- A **global exception handler** is implemented to provide consistent and meaningful error responses to API clients.
- JUnit 5 test cases are provided for the business domain to ensure correctness of domain logic without depending on infrastructure code. Follows a **sociable testing approach**, verifying interactions between components in the application flow.
- Integrated **Swagger / OpenAPI** for clear, interactive documentation of all endpoints.


## Deploy

You may need the following tools.

* java17 - [Install the Java 17](https://docs.aws.amazon.com/corretto/latest/corretto-17-ug/downloads-list.html)
* Maven 3.9 - [Install Maven](https://maven.apache.org/install.html)

* To build and deploy your application, run the following in your shell:

```bash
git clone https://github.com/mozammal/product-api.git

cd product-api

mvn clean test

mvn spring-boot:run
```

Once the application is running, you can access the Swagger API documentation at:

Swagger UI: http://localhost:8080/swagger-ui.html

Example request: http://localhost:8080/v1/products?category=Clothing&sort=price&order=desc&page=2


## Improvements and Scaling Considerations

For this product catalog API, I have implemented a clean Hexagonal Architecture with Domain-Driven Design principles, ensuring separation of concerns and maintainability.

However, for **large-scale production systems**, especially read-heavy applications like product catalogs, further enhancements could be considered:

- **Change Data Capture (CDC) with Message Queues:**  
  Instead of querying the primary database directly for every read request, use CDC mechanisms (e.g., Debezium) to capture data changes and publish events to a message queue (e.g., Kafka). This allows asynchronous synchronization to other systems or services.

- **Caching Layer:**  
  Implement caching (e.g., Redis, Memcached, or in-house) with proper TTL, eviction policy, warm-up by snapshotting, and invalidation to reduce database load and improve response times for frequently accessed data products.

- **CQRS (Command Query Responsibility Segregation):**  
  Separate write operations (commands) from read operations (queries) to optimize read models for fast queries and scalability.

- **Pagination:**  
  For very large product datasets, implement pagination(e.g., Cursor based) to reduce memory footprint and response payload.

These enhancements can drastically improve scalability, resilience, and responsiveness of the product catalog service under heavy load.
