JavaDepartmentsWebApp
=====================

This is first application for DA after learning Java at DA Java School.
 
##Preparing DB

###Creating DB

Please use department.ddl.sql to create structure of DB.
Please use department.dml.sql to fill in test data into DB.

You can use *nix commands:
$ mysql -udbuser -pdbpassword dbname < department.ddl.sql
$ mysql -udbuser -pdbpassword dbname < department.dml.sql

##Configure application

Need to configure access to DB. Please open web/WEB-INF/web.xml

At line 17 you can see this code:

    <context-param>
        <param-name>dbUser</param-name>
        <param-value>dbuser</param-value>
    </context-param>
    <context-param>
        <param-name>dbPassword</param-name>
        <param-value>dbuser</param-value>
    </context-param>
    <context-param>
        <param-name>dbURL</param-name>
        <param-value>jdbc:mysql://dbhost:3306/dbname?useUnicode=true&amp;characterEncoding=UTF-8</param-value>
    </context-param>
    
Replase dbuser, dbpassword, dbhost, dbname in <param-value></param-value> tag to your correct values.

##Build application

To build application use command 

    ant
    
in application root dir.

in dist/ folder you can find firstProject.war . Deploy this file to your Tomcat server.

##Software requirements

This software is tested on Ubuntu desktop and Ubuntu server version >= 12.04.
We hope it will work on any platform ;)

* Tomcat  >= 7
* Java    >= 1.7 (JEE)
* Mysql   >= 5.5

###Used java libraries 

javax.servlet-api-3.1.0.jar
jstl-1.2.jar
mysql-connector-java-5.1.31-bin.jar

##Known issues

* There is not any validations, need to input correct data in appropriate formats
* There is not validation for salary and corresponding positions
* There are CSRF or XSS vulnerabilities
* There is Employee delete function is using GET method instead POST





    

