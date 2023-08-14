# Car park
Demo for car parking

**TechStack**:
This project is maven and using SpringBoot,Spring Data JPA and Mysql.

It exposes an API : carkpark/nearest 

**How to Run**

Make sure you install Mysql 8 ,older version might not work since ST_DISTANCE function is used in query.

Please create DB name **carpark** and update username and password in src/main/resources/application.properties follow your setup.

Go to CarparkApplication.java and run that class as java.Once it's up user can send request to get closest parking location.

Example of request :

localhost:8080/carkpark/nearest?latitude=1.47326&longitude=103.897&page=1&per_page=3

**NOTE:**

There is no validation for latitude and longitude at this moment.I assume that those values will always correct.

To validate  latitude and longitude it requires fair amount of domain knowledge.

   The returned data has no latitude and longitude since they are modeled as Geometry in Mysql.Currently there is problem of convert Geometry back to latitude and longitude.There will need a converter but I don't know  at this moment !

   The unit test only cover  on JPA components at this moment,the CarParkRepo.findNearestParking() can't be tested because embbeded H2 DB doesn't support ST_DISTANCE function.

**Some points to consider**

It makes sense to cache data return to user.And we reset that cache after update car park availability data, in reality Redis could be used for this purpose.

If the process of loading and update data takes long time we could consider to extract them to seperated project,the carpark now become stateless service.

Another approach to this exercise is if the data is not to big we could keep them in memory and  do all the search with java stream.

**PS**

I hope this project meet expectation.

Thanks for your time.






