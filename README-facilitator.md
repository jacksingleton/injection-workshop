## Presentation
The slides are html/js built using reveal.js

`open presentation/index.html` on mac

For presentation mode and speaker notes: press `s` after opening. Will open in a seperate browser window

Use right and left arrow keys to navigate forward and backwards

`esc` will bring up a side overview

## Hands on sections
Hands on sections increase participation but add a lot of extra time. Tweak the presentation to fit your needs.
* Slide #6 (Black box sql injection exercise) is optional
* Slides 9 and 10 are hands on and hands off options, respectively. Pick one

## Edit $IP placeholder
If you are doing slide #6, edit the '$IP' placeholder in `presentation/index.html`

This should be your local network ip address, check that you can communicate to it from another local computer

## Dependencies
* JDK 1.6+
* Maven 3
* ncat

## Installing ncat

The `ncat` version of netcat is bundled with `nmap`

On a mac: `brew install nmap` should get you the `ncat` program.

On debian based linux: `sudo apt-get install nmap`.

## Print / Export PDF
Open `presentation/index.html` in Chrome with the `print-pdf` query parameter

For example: `file:///injection-workshop/presentation/index.html?print-pdf`

Open the print dialog and either select a printer or export to PDF

## Black box hands on exercise (slide #6)
* everyone will need to be on the same network
* the network must allow computers to communicate to each other via tcp (check this!)
* package application: `mvn -DskipTests clean package`
* install `ncat` and start application on your machine (you must have `ncat`, not bsd or gnu `nc`)
* `ncat -lktc 'java -jar target/injection-1.0-SNAPSHOT-jar-with-dependencies.jar' $IP 8888` (substitute $IP for your local ip address)
* now participants can interact with the application using `telnet $IP 8888`

## Black box demo (slide #7)
* package application: `mvn -DskipTests clean package`
* run the app locally with: java -jar target/injection-1.0-SNAPSHOT-jar-with-dependencies.jar
* Task Answers
 * Login as Admin: `admin' or 1=1 --comment'`
 * Enumerate all passwords: `’ union all select first_name, password, last_name from users offset 1 rows -- comment` (iterate through 0,1,2...)

## Fixing the code (slides 9/10)
The problem is sql substitution via concatination in `UserRepo.java:findLastName`

Prepared Statements should be used as in `addNames`

## How to keep the session under 1 hour
With the goal of focusing on secure software development, this is how you can timebox your exercises in order to get the most out of your session.
1. 10 min of introduction to injection
2. 20 min of figuring out how to hack the program
 * We kept this small by circling around to help guide people in the right direction with hints so they’re not spending too much time exploiting the vulnerability.
 * Example: 10 minutes of learning how to complete the ‘ with another ‘ and use “OR 1=1” and the comment “--” symbol to get rid of the rest of the sql. Then give them “ ‘ OR 1=1 -- comment “ as a hint to get them to finish the task. After 15 minutes, give them the answer to getting a login as admin.
3. 30 min of fixing the code to keep this from happening by using the given unit test
