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
* print first last name in the database: `' or 1=1 --comment'`

## Task Answers
>! lol i’m secret

## Fixing the code (slides 9/10)
The problem is sql substitution via concatination in `UserRepo.java:findLastName`

Prepared Statements should be used as in `addNames`
