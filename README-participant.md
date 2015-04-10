## Prepare for the workshop

The following commands should run without errors:

* `git clone https://github.com/jacksingleton/injection-workshop.git`
* `cd injection-workshop`
* `mvn -DskipTests clean package`
* `java -jar target/injection-1.0-SNAPSHOT-jar-with-dependencies.jar`

## Exploit the Application

Find a way to login as the administrator named “admin” without using their password.

Hint: It will be helpful to [download](https://db.apache.org/derby/derby_downloads.html) Derby and use
the ij tool to try different sql commands against a live database.

Bonus:
Enumerate all the user passwords in the database and identify whether the
application uses salts or not.

## Generate IDEA Project
* ```mvn idea:idea```

## Run tests
* ```mvn test```

## Fix the failing test
* The test fails for the simplest case of sql injection
* A passing test does not imply correctness!

## Package & Test Manually
* ```mvn clean package```
* ```java -jar target/injection-1.0-SNAPSHOT-jar-with-dependencies.jar```

## Review slides (or become a facilitator!)
* The slides are html/js
* Open presentation/index.html in a web browser

## Learn more

- sql injection prevention cheat sheet:
  *https://www.owasp.org/index.php/SQL_Injection_Prevention_Cheat_Sheet*
- owasp page: *https://www.owasp.org/index.php/Top_10_2013-A1-Injection*
- sqlmap: *http://sqlmap.org/*
