### Model used - MVC

1. Model : database-> Mongo
2. View: presentation -> React
3. Controller: business -> SpringBoot


in git
- pull request
- compare
- merge

SPRINGBOOT
creation:
- while creating the application choose the following
    - go to spring initializr
    - maven version (3.5.5)
    - war file (jar is for standalone, war is for web)
    - if the url is abc.com -> com.abc
    - add the proper names and description
    - add dependencies - spring-AI, mongo and spring-web? spring-JPA(for SQL)
    - for further dependencies addition (later on), go to maven repository
    
server - tomcat - jetty server

```text 
spring.data.mongodb.uri=mongodb+srv://sinchana1705_db_user:N8tOrNSl1q6PAwI3@sdpsep2025.sugn6zw.mongodb.net/ecom_db?retryWrites=true&w=majority```

controller -> service -> repository -> Mongo (ecom_db)

adding dependencies:
maven repository -> search for proper dependecy -> add to pom.xml


THE BUILD IN SPRINGBOOT:
1. Products in models contains the skeleton
2. ProductController contains the Request-Response methods (contains the url)
3. ProductService is the service layer. Does the actual work. When i call on a method from the controller layer, the service layer will make it happen
4. ProductRepository