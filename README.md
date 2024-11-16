### How to Use Swagger for API Testing  

1. **Add Swagger Dependency**:  
   Ensure the following dependency is added to your `pom.xml`:  
   ```xml
   <dependency>
       <groupId>org.springdoc</groupId>
       <artifactId>springdoc-openapi-ui</artifactId>
       <version>1.7.0</version> <!-- Use the latest version if available -->
   </dependency>
   ```  

2. **Access Swagger UI**:  
   Run the application and navigate to `http://localhost:9091/swagger-ui.html` in your browser.  

3. **View API Documentation**:  
   Explore the available endpoints, their HTTP methods, and descriptions.  

4. **Test Endpoints**:  
   - Click on an endpoint to expand its details.  
   - Use the "Try it out" button to input parameters and execute the API call.  

5. **Analyze the Response**:  
   View the status code, headers, and response body to validate the API's behavior.  

This makes API testing seamless and efficient with Swagger!
