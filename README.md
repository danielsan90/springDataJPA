# springDataJPA


    <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

NB: The spring-boot-starter contains the necessary auto-configuration for Spring JPA.
Also, the spring-boot-starter-jpa project references all the necessary dependencies such as hibernate-core.

WHY?

Spring Boot configures Hibernate as the default JPA provider !!! So it's no longer necessary to define the entityManagerFactory bean
unless we want to customize it.

Spring Boot can also auto-configure the dataSource bean, depending on the database we're using.
In the case of an in-memory database of type H2, HSQLDB and Apache Derby, Boot automatically configures the DataSource if the corresponding database dependency
is present on the classpath.

If we want to use JPA with MySQL database, we need the mysql-connector-java dependency <--.
We'll also need to define the DataSource configuration.

We can do this in a @Configuration class or by using standard Spring Boot properties.

The Java configuration looks the same as it does in a standard Spring project:

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=mysqluser
spring.datasource.password=mysqlpass
spring.datasource.url=
jdbc:mysql://localhost:3306/myDb?createDatabaseIfNotExist=true

Spring Boot will automatically configure a data source based on these properties.

READ https://www.baeldung.com/the-persistence-layer-with-spring-and-jpa for more information

https://thorben-janssen.com/hibernate-features-with-spring-data-jpa/

note:
config.properties-> Hibernate crea le tabelle con  spring.jpa.hibernate.ddl-auto=create-drop  :|
 
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true  <. ??
