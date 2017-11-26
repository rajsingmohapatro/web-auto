# web-auto
Project Description:
This project runs "AddToCart" Test parallely with both Firefox and chrome browsers using testngxml/testngxml.xml configuration.
TestNG reports and screenshots can be found under test-output folder.
The project has been designed using Page-Object-Model and keeping in mind the future maintanence costs that would arise once the number
testcases start growing past 100 or 1000.

CI Server Integration TODOs List:

For better CI server integration a shell,powershell or grunt script can be used arounf mvn clean test -DsuiteXmlFile= testngxml/testngxml.xml.
To avoid browser version dependency on CI server build agents portable firefox and chrome browsers have been used which can be found under //tools folder.
Alternatively a customDriverClass for selenium remotedriver yet to be added to enabled tests running agains selenium grid server.
Still this project has software dependencis like Java 1.8 , Maven dependency, nodejs(if grunt is used for CI script)on build agent
which can be removed using a base docker image packed with JRE, maven and nodejs running. With a docker base image the build agents
would require to have docker capability available on them and appropriate container to host portmapping in order to connect to testwebsite,
internal maven artifactory,selenium grid server etc. A storage mapping from container to host required to make test artifacts available to
CI server build agent.

Note:
I have never tried a docker baseimage packed with all dependencies to execute automtion testing as we are still in Windows 8.1 and  it would 
require VM(win10,server16 or linux) to run docker container.

Project Components:

Pages package:
Each Page represents a Page in the website and interfaces with crude WebAPi calls.
All the elements on a page and actions(like select , click etc) are represented in respective page classes.
BasePage class contains all common functionalities which might be used by individual Page classes.

Steps package:
Steps class contains Gherkin style descritptive methods to abstract out low level page class methods.

Test package:
Each test class here is a TestNG class with setup, Test ,Teardown , dataprovider methods.
Just by looking at the Testclass one can figure out the testwork flow, number of pages this workflow going to touch and the excel file
the test using for test data.This makes the future maintannce less cumbersome and faster.
BaseTest class contains all common setup and teardown tasks like initializing ExtentUtil report,
Note: Take screenshot calls in Test class will be moved under Util package in future.

Util package:
Util package contains classes for reading various data sources like excel,DB or some other microservices and taking screenshots.
It also contains interceptor for Step classes so that after execution of each step a screenshot can be taken along with logging to extent 
util html report.
<screenshot>
GivenIAmEbayLandingPage

Many hardcoded values need to be moved to property files or testngxml.xml
Environment and Suite specific testngxmls can be created for differnent test environment(test,staging,prod) and for differnt groups of 
test(functional,security)  


