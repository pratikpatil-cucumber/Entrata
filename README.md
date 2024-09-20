Created a Maven project and added the necessary dependencies for Selenium and TestNG
Check the pom.xml file to see the dependencies
Under src/test/java folder have created two packages "testcases.pg" and "testcases.utils"
Under testcases.utils created two classes i.e. Commondriver.java and TestCaseConstants.java
Under Commondriver.java using Test Annotations(@BeforeSuite and @AfterSuite) created two methods for Opening the browser before executing test cases and closing the browser after executing the test cases 
Under TestcaseConstants added the constant files which will reusable
Under testcases.pg created main test class named as TestRunner.java
Under TestRunner.java created created three different merthods for different operations
First method i.e validateTile()- After opening Entrata website it validate the title of  home page to check that it opened correct page or not
Second method i.e. handleDynamicElement()- It handles dynamic dropdown and click  one of the option and validate title of that page to check it opens correctly
third method i.e. moveToForm()- It opens Home page and scrolll the page until the demo form which is to be visible. It scrollls genericaly until that element
Finally to run the script have created the testng.xml file
After running the project output will be displayed under testoutput folder in .html file
