# GolfStoreProject

This is a personal project created primarily using Java, JavaScript, HTML and CSS. It is a project I have developed twice using different programming languages. Secured the end points, encrypted passwords, developed a vibrant front end and a large database. To create the database run the script.sql file. This project was deployed locally using a wildfly server, therefore you must specify the database path in the standalone.xml file, along with username and password for access.


The project was created as a maven project, which is a software project management and comprehension tool. Based on the concept of a project object model (POM). Once the source code is downloaded, run maven clean to clean up artifacts created by prior builds. maven compile then compiles the source code of the project, and run maven install to install the package into the local repository, for use as a dependency in other projects locally. 


To build the project run mvn package. This builds the project in a step wise fashion 1. validate 2. generate-sources 3. process-sources 4. generate-resources 5. process-resources 6.compile.

You can then run the newly compiled and packaged .jar file.



Testing was extremely important therefore I performed unit testing, functional testing and end to end testing using technologies such as junit, selenium and cucumber. This resulted in a very high code coverage percentage and provided fucntional as well as non functional testing. The dependencies for each testing package are included in the dependency management section of the pom.xml file.
