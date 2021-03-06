# Some considerations
1. Well, I think it would be easier building the same application without Jersey. I mean, using default Spring's RestController. But I kept Jersey as the text suggested. 
2. After coding, I ran FindBugs pluggins in order to find potentials bugs.
3. The code is idented with 2 spaces because of Google's Java Style plugin.
4. Some other considerations is writen across the text inside quote block such as the following:
> this is a quote


# Skills in Spring, Data manipulation and JAX RS
Here you will find a scaffold of a project that aims to expose a REST service to list cities.
You need to upgrade the project to the newest versions and implement this service using any necessary means.

> Ok. Upgraded to Spring Boot latest (2.0.1.RELEASE)

- Java (preferably Java 8 and Functional programming as much as possible)
- RESTFull service
- Data manipulation layer
- Spring-boot (upgrade to the latest version)
- Maven

# Database
The actual implementation uses H2 in memory as the database. You will find also the scripts 
for MySQL. The scripts insert a few entries in each table.

> I kept using H2 for this test.

# Proposed exercise
The candidate must:
- Create Entity classes for the tables, including relationships
   > Ok. I created entity classes under br.com.cinq.spring.data.sample.entity packages, as it was suggested by test files.

- Create the data manipulation layer. Feel free to use structure or framework you like (JPA, JDBC, Spring Data, etc).
   > Ok. I used JPA through Spring Data.

- Create a GET REST service to retrieve the list of cities in the database, and return them as a JSON object.
   > Ok. I created the get resource with Jersey framework.

- The service may receive the query param "country" as a String, to restrict the search. The parameter may be part of the Country name
   http://server:port/rest/cities[?country=name]
   > Ok. Resource created. As the bullet ponint mentioned "restrict search" and the brackets suggest that parameters were optional, when you request without `?country` it will retrieve all cities.

- Create an operation to load data into the database (Here you're free to be creative. You can load data from a simple CSV, a spreadsheet, a rest service, etc...)
   > Ok. I created a POST resource to create new cities.
   > I also changed the `application[.*].yml` to load data during tests/deploy.

Feel free to modify the files included, upgrade frameworks, add or remove packages, in every aspect you want. Just check the note regarding JUnit tests below.
   > I included Lombok, 'cos it simplifies writing POJOs.

# Expected results
After the implementation, the application should run after the following command line:

	java -jar target/spring-jpa-jersey.jar
    
or 

    mvn spring-boot:run
    
or deploy on Tomcat, or Jetty or an Application Server, as long as you include instructions for the deploy.


Then, open a browser and type :

    http://localhost:8090/rest/cities?country=Uni


It must return, at least the following (ids may vary) :

    [
        {
            "id":86,
            "name":"New York",
            "country":{
                "id":2,
                "name":"United States"
            }
        },
        {
            "id":87,
            "name":"Los Angeles",
            "country":{
                "id":2,
                "name":"United States"
            }
        },
        {
            "id":88,
            "name":"Atlanta",
            "country":{
                "id":2,
                "name":"United States"
            }
        }
    ]


# Unit tests

Included you will find JUnit tests, with commented lines. Those tests must run after the lines
are uncommented. 

## Challenge

Post the percentage of line covered by tests of your application.


** PLUS: It would be great if you can come up with unit and integration tests separately in their apropriate building phases.
