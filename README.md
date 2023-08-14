# carpark
Demo for car parking

**TechStack**:
This project is maven and using SpringBoot,Spring Data JPA and Mysql.

It exposes an API : carkpark/nearest 

**How to Run**

Go to CarparkApplication.java and run that class as java.Once it's up user can send request to get closest parking location.

Example of request :

localhost:8080/carkpark/nearest?latitude=1.47326&longitude=103.897&page=1&per_page=3

**NOTE:**

There is no validation for latitude and longitude at this moment.I assume that those values will always correct.

To validate  latitude and longitude it requires fair amount of domain knowledge.

   The returned data has no latitude and longitude since they are modeled as Geometry in Mysql.Currently there is problem of convert Geometry back to latitude and longitude.There will need a converter but I don't know  at this moment !




