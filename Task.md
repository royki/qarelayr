1. Imagine the following situation. You need to establish a QA process in a cross-functional
team. The team builds a front-end application using REST APIs.
- 1. Where would you start? What would be your first steps?
    + To make plan for front-end UI test as well as REST API test.
    + Define test objectives, test environment, select automation tool,
    + Risk analysis.
- 2. Which process would you establish around testing new functionality? How would you want the features to be tested?
    + Identify the functionalities to be performed first. 
    + Understand the functionalities for each test cases.
    + Prepare test plans with test steps with the expected results. 
    + Check the actual results against the expected results.
- 3. Which tools would you suggest using to help your team with a daily work?
    + List of tools/apis/library to create a automation framework - 
    + For UI test - 
        * Selenium Web Driver with Java(Python)
        * Maven build tool
        * TestNG, Surefire-plugin to generate test report
        * logback/sl4j API for logs
        * Jenkins to automate the regression, scheduling, triggering build nightly.
    + For REST API test - 
        * SOAPUI(or Postman) using Groovy Script
        * Maven build tool
        * Surefire-plugin to generate test report
        * logback/sl4j API for logs
        * Jenkins to automate the regression, scheduling, triggering build
    + For Performance Test on REST API
        * Gatling with Scala
        * Surefire-plugin to generate test report
        * logback/sl4j API for logs
        * Jenkins to automate the regression, scheduling, triggering build
- 4. If you would do a test automation which techniques or best practices would you use the application?
    + UI test -
        * To perform end-to-end UI testing - create a hybrid automation framework using page object model with page factory and data driven test for multiple browser.
    + REST API test -
        * To perform REST API testing - create hybrid automation framework using field level assertion, status assertion, setup test data at scenario level and test accordingly.
    + ** (The tools and APIs for the framework are mentioned above)

2. How would you test search UI functionality of your favourite website (e.g. https://medium.com ,
https://www.google.de )?
- 1. Choose your favourite website which has search functionality.
    + https://www.stackoverflow.com
- 2. Document several test cases.
    + TestCase 1 - HomePageTest
    + TestCase 2 - QuestionsPageTest
    + TestCase 3 - DevelopersJobsPageTest
    + TestCase 4 - UsersPageTest
- 3. Implement one or two automated tests based on the test cases.
    + HomePageTest
        * 1. Go to the Home Page
        * 2. Verify Home Page Title
        * 3. Click on Job tab
        * 4. Verify Job tab url
    + JobsPageTest
        * 1. Go to the Job Page
        * 2. Verify Job Page Title
        * 3. Sort the jobs by 'newest' job
    + UserSearchTest
        * 1. Go to Users' Page
        * 2. Verify Users' Page Title
        * 3. Verify Users' Page URL
        * 4. Search a User named- 'royki'
        * 5. Verify user is found
#### To Run the Test, follow the steps
1. Clone the repository -
    - `git clone https://github.com/royki/qarelayr.git`
2. Go to the code directory
    - `cd qarelayr/uitestframework`
3. Run from command prompt
    - `mvn clean test`
4. Check the html report
    - `/qarelayr/uitestframework/target/surefire-reports/index.html`
        + com.qa.uitestframework.testcases.UsersSearchTest
            * searchUserTest
            * verifyUsersPageTitleTest
            * verifyUsersPageUrlTest 
        + com.qa.uitestframework.testcases.JobsPageTest
            * sortByNewestJobTest
            * verifyJobsPageTitleTest 
        + com.qa.uitestframework.testcases.HomePageTest
            * clickOnJobsTabTest
            * verifyHomePageTitleTest 
        
        
