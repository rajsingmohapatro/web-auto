# web-auto
Project Description:
This project runs "AddToCart" Test parallely with both Firefox and chrome browsers using testngxml/testngxml.xml configuration.
TestNG reports and screenshots can be found under test-output folder.
The project has been designed using Page-Object-Model and keeping in mind the future maintanence costs that would arise once the number
testcases start growing past 100 or 1000. 

CI Server Integration TODOs List:

For better CI server integration a shell,powershell or grunt script can be used around mvn clean test -DsuiteXmlFile= testngxml/testngxml.xml.
Eg: Test,Staging and prod testngxmls can be created and can be wrapped using powershell scripts specific for Test,Staging,Prod. These script
files can be added to build step of CI server build configurations. This prevents having bulky Teamcity or Jenkin build steps and makes most
of the build configuration changes to be stored in source repo.
To avoid browser version dependency on CI server build agents portable firefox and chrome browsers have been used which can be found under //tools folder.
Alternatively a customDriverClass for selenium remotedriver can be added to enabled tests running against selenium grid server.
Still this project has software dependencis like Java 1.8 , Maven, nodejs(if grunt is used for CI script)on build agent
which can be removed using a base docker image packed with JRE, maven and nodejs. With a docker based image approach, the build agents
would require to have only docker capability available on them and appropriate container-host portmapping in order to connect to testwebsite,
internal maven artifactory,selenium grid server etc. A storage mapping from container to host required to make test artifacts available to
CI server build agent.

Note:
I have never tried a docker baseimage packed with all dependencies to execute automtion testing as we are still on Windows 8.1 and  it would 
require VM(win10,server16 or linux) to run docker container.

Project Components:

Pages package:
Each Page represents a Page in the website and interfaces with raw selenium webdriver calls.
All the elements on a page and page related actions actions(like select , click etc) are represented in respective page classes.
BasePage class contains all common functionalities which might be used by individual Page classes(like navigating to a page etc).

Steps package:
Steps class contains Gherkin style self descritptive methods to represent each steps in Test workflow and abstracts out low level page class methods.

Test package:
Each test class here is a TestNG class with setup, Test ,Teardown , dataprovider methods.
Just by looking at the Testclass one can figure out the testwork flow, number of pages this workflow going to touch and the excel file
the test using for test data.This makes the future maintannce less cumbersome when we are going to deal with large number of Testcases.

BaseTest class contains all common setup and teardown tasks like initializing ExtentUtil report,
Note: Take screenshot calls in Test class will be moved under Util package in future.

Util package:
Util package contains CustomDriver classes(CustomFirefoxDriver,CustomChromeDriver and RemoteWebDriver) which serve as wrappers where
desired capabilities for various drivers can be set reading directly from project.properties files.

These properties include 
setting default download location as project folder instaed C:\download.
Setting proxy address and port if we want to make the HTTP requests and responses flow through a proxy. This is useful during automated security tests
where all requests required to flow through ZAP proxy server. 

 
Yet To Add:

Classes for reading various data sources like excel,DB or some other microservices using rest client can be added to Util package.
An method interceptor for Step class methods can be added so that after execution of each step a screenshot can be taken along with logging to extent 
util html report.
<screenshot>
GivenIAmEbayLandingPage

Extent Util wrapper class can be used to create fancy HTML reports which ties every teststep along with corresponding screenshot image. These reports 
captures step by step flow of testcase along with screenshots for each step which is very useful for Business or someone who wants to validate or undertand
the workflow at a glance.

Many hardcoded values need to be moved to property files or testngxml.xml
Environment and Suite specific testngxmls can be created for differnent test environment(test,staging,prod) and for differnt groups of 
test(functional,security).



