# JFS - Salt Stars Day 1

## A. Scenario

> ... and with that I just wanted to welcome you and wish you the best of luck here with us. Thank God you are here!

The CTO concludes her 4-minute introduction to the company and rises up to walk out. You haven't even taken off your jacket yet...

On her way out of the door she turns her head back towards you ever so slightly and says:

> Just clone the repo and get started, you'll find the bug I mentioned pretty fast. The team mentioned a last minute commit that Hans did. He had some unfinished things at his previous job, Yakamoto Inc.

Her voice disappears in the corridor and you stare at the blank screen.

The first day on a job is a terrifying experience where you often feel lost and as if you were thrown in at the deep end of the pool, inside a washing machine that is spinning like crazy. But don't worry - practicing to be able to take small steps through a bigger problem is a key skill for a developer.

A really good way to understand a new code base is to run the automated tests that is written. They are actually running the application different part and will help you to see how things go together. It's much easier to build something big up from small parts, than to take in a big thing in one big gulp and then try to break out the small parts.

## B. What you will be working on today

Welcome to the Introduction Weeks of the Java Full Stack Developer bootcamp!

The code base that you got does not work. Your goal for today is to fix it. This fix is not longer than 5-10 lines of code. Don't worry - you have this description and your mob mates to help you. Go slow - make sure everyone in the mob is following along.

The code base contains some tests that has been written already. This is a normal thing when you jump into an existing code base. Later on you will write your own tests, but today you can just use and run the existing tests.

Today is all about getting up and running with mob programming and getting the code-base to work on your computers.

The goal of the exercise is to:

- Clone the repository
- Import the relevant codebase into IntelliJ (Import the pom.xml file from /server)
- Run the tests - which will give you errors (run `mvn test` from your terminal inside /server)
- Fix the errors that the tests reports (this is the assignment)
- Get the application to work properly (pass the tests!)
- Run the application and see the results yourself (you need to cancel and re-run `sh runApp.sh` from the root of this repository every time you make a code change)
- While you do this - remember to follow the rules of mob programming, take breaks and take turns.

The goal of the day is to be able to get a greeting for a user that writes their name in the URL like this `http://localhost:8080/?name=Johan`. And handles the case when no name is passed in.

## C. Tools and requirements

 - Use IntelliJ
 - Make sure you have Docker installed
 - Make sure you have Java 18 and Maven installed


## D. Lab instructions

Today the instructions will be very detailed and it is for the most part a "type-along" exercise, but at some points in the exercise you will need to fix the problems.

1. Open the terminal and create a `salt-labs`-folder in a suitable location. Its a good idea to keep all the labs for the course in here. 

   ```bash
   mkdir salt-labs
   cd salt-labs
   ```

1. Clone the lab repository, which means that you make a copy of the code to your own computer

   ```bash
   git clone git@github.com:saltsthlm/jfs-fall-22-lab-salt-stars-day1.git
   cd jfs-fall-22-lab-salt-stars-day1
   ```
    Then make sure you create a new branch for your mob

   ```
   git checkout -b day-1-my-cool-mob-name
   ```

1. Open the solution in Visual Studio Code

   ```bash
    code .
   ```

   In your project you have two folders, `client` and `server` and some metadatafiles in the root. We'll mainly hang out in the server for the next two weeks, but its good to look around get familiarised with the content.


1. Open the integrated terminal in VS Code and lets run some tests . Notice that some tests are failing.


   ```bash
    cd server
    mvn test
   ```

   - Read the output from the test run and figure out what is wrong. It's one method that returns a string value that should do something different.
   - Try to find the test that is failing and see if you can understand what it is supposed to do.

1. At this point VsCode stops sbeing a good editor, lets open IntelliJ.  `⌘ + space` to open up the spotligt search and type IntelliJ

1. To open a new project from existing source select the `pom.xml` file and choose `Open as Project`.

    - hit `^ + [Shift] + R ` to run the tests inside intellij
    - you should see the same test output in the `Run` Window at the bottom

1. Now lets get to fixing that pesky test.

    - Write the code to make the test pass. 
    - You can run a specific test by hitting `^ + [Shift] + R ` when the cursor is inside a method, or an entire test file class if the cursor is outside any methods but inside the class.

    - Once a test is passing - run all the tests again. There might be other tests that fails... When all the tests are passing you are ready to continue.

1. The application consists of two main parts; a backend API and a frontend web application. The web application needs the API to work. Let's examine them a bit closer.

   1. First Start the API: From the VS code terminal type

      ```bash
      sh runApp.sh
      ```

   1. Go to `https://localhost:8080/` and see the output on the screen



1. You are ready when you can enter a name parameter in the URl and ses the value displayed on the screen. 

So if the URL is `https://localhost:8080/?name=Elon` you should get a welcome message made out to _Elon_


- Try to look through the code in the server to figure out how it fits together.

---


### Tips

- Work as a mob
- Ensure that everyone follows along
- Be sure to go slow and take break.
- Disable browser caching in the Developer tools in the Network Tab

---

Good luck and have fun!
