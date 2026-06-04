# H2 Database Usage Guide

## Overview

This project uses an H2 in-memory database for local development and testing.

The database is automatically created when the application starts and removed when the application stops.

---

## Prerequisites

* Java 17+
* Maven
* Application is running successfully

Start the application:

```bash
mvn spring-boot:run
```

or run the application from your IDE.

---

## Access H2 Console

Open your browser and navigate to:

```text
http://localhost:8080/h2-console
```

---

## Connection Settings

Use the following values to connect:

| Property     | Value              |
| ------------ | ------------------ |
| JDBC URL     | jdbc:h2:mem:testdb |
| User Name    | sa                 |
| Password     | *(leave empty)*    |
| Driver Class | org.h2.Driver      |

Example:

```text
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password:
```

Click **Connect**.

---

## View Database Tables

After connecting, execute:

```sql
SHOW TABLES;
```

Example tables:

```text
ORDERS
ORDER_ITEMS
```

---

## Query Data

Retrieve all orders:

```sql
SELECT * FROM ORDERS;
```

Retrieve all order items:

```sql
SELECT * FROM ORDER_ITEMS;
```

Example join query:

```sql
SELECT
    o.ID,
    o.CUSTOMER_ID,
    o.TOTAL,
    i.PRODUCT_CODE,
    i.QUANTITY,
    i.UNIT_PRICE
FROM ORDERS o
LEFT JOIN ORDER_ITEMS i
ON o.ID = i.ORDER_ID;
```

---

## Important Notes

### 1. In-Memory Database

This project uses:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
```

The database exists only while the application is running.

### 2. Data Is Lost After Restart

When the application stops or restarts:

* All data is removed.
* Tables are recreated automatically.

### 3. Schema Recreation

The project is configured with:

```properties
spring.jpa.hibernate.ddl-auto=create-drop
```

Therefore:

* Tables are created on startup.
* Tables are dropped on shutdown.

---

## Troubleshooting

### Error: Database not found

Make sure the JDBC URL is exactly:

```text
jdbc:h2:mem:testdb
```

Do not use:

```text
jdbc:h2:~/test
```

or

```text
jdbc:h2:file:testdb
```

### Cannot access H2 Console

Verify that:

```properties
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

and the application is running.

---

## Useful SQL Commands

List tables:

```sql
SHOW TABLES;
```

Describe table structure:

```sql
SHOW COLUMNS FROM ORDERS;
```

Count records:

```sql
SELECT COUNT(*) FROM ORDERS;
```

Delete all records:

```sql
DELETE FROM ORDER_ITEMS;
DELETE FROM ORDERS;
```
