# 🧾 Product Management System – Java SOAP Web Service + Client

This is a complete Java EE-based **SOAP Web Service and Client application** designed to perform **CRUD operations on a Product database**. The project demonstrates backend service development with JAX-WS, database integration using JDBC, and XML logging via JAXB.

---

## 📦 Project Structure

```

/ProductManagementSystem/
│
├── /WebService/         # JAX-WS SOAP web service with full backend logic
│   ├── src/
│   ├── pom.xml
│   ├── \*.xml            # Generated XML logs per request
│
├── /Client/             # Java console-based client to call the web service
│   ├── src/
│   └── ...
│
├── /database/
│   └── product.sql  # MySQL schema and sample data
│
├── README.md
└── .gitignore

````

---

## 🚀 Features

✅ View all products  
✅ Update product details  
✅ Delete a product  
✅ Logs each web service request/response in XML format  
✅ Client-server communication via WSDL  
✅ Designed using NetBeans and deployable on Apache Tomcat or GlassFish

---

## 🧰 Technologies Used

- Java 8+
- Java EE (JAX-WS, JAXB)
- MySQL
- Maven
- NetBeans
- SOAP (WSDL)
- JDBC

---

## 🛠️ Setup Instructions

### 1. 💾 Database Setup

1. Open your MySQL client (e.g., MySQL Workbench).
2. Import the provided SQL file:
   ```
   mysql -u root -p < database/product.sql
   ````

3. This creates a schema named `as1_enterprise_app` with a `product` table and 3 sample entries.

### 2. ⚙️ Web Service Setup

1. Open the `/WebService` folder in **NetBeans**.

2. Edit the file `ProductImpl.java` to use your local DB credentials:

   ```java
   String db_URL = "jdbc:mysql://localhost:3306/as1_enterprise_app";
   String db_Username = "your_username";
   String db_Password = "your_password";
   ```

3. Clean and Build the project.

4. Run on a local Tomcat/GlassFish server.

5. WSDL should be available at:

   ```
   http://localhost:8080/WebService/ProductImplService?wsdl
   ```

---

### 3. 🖥️ Client Setup

1. Open the `/Client` project in NetBeans.
2. Generate web service client from WSDL:

   * Right-click project → **New > Web Service Client**
   * Enter WSDL URL (from WebService)
   * NetBeans will generate service stubs.
3. Run the main client program to:

   * Call `getAllProducts()`
   * Update a product
   * Delete a product

> 🧪 Make sure the WebService is running before executing the client.

---

## 📂 Sample Output Logs

Every time a request is made, the WebService generates an `.xml` file in the project root capturing the request and response structure using JAXB.

---

## 💼 Why This Project?

This project showcases:

* Hands-on experience in Java EE web services
* Clean service-client architecture
* Integration of MySQL with JDBC
* Real-world service logging with JAXB

---
