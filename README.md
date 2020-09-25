# SeleniumGmailUtilities
This templates contains the selenium gmail utilities to read data from an email and extract it in a external file.

A utility which will help to read an email and extract its content.

Inputs: To set the email ,password and mail subject from the system in system variables.

Approach:

1.OpenBrowser class for launching browser using docker container as well as through selenium.

2.LoginGmail class to login in the mail,search the mail using subject and extract content from the selected mail.

3.WriteContent class for extracting the content in spreadsheet.

4.Utilities class for using the reusable functions such as Enter value,click,get content ,take screenshot.

5.To get the screenshot and the spreadsheet name includes the time in hh:mm:ss format.

6.Maintain object repository file to maintain locators.

7.URL launch for windows is docker-machine ip:port and for others localhost:port.

Output:

1.Screenshot for the the events triggered.

2.Spreadsheet with the content.

3.Execution is done with docker (windows) as well as selenium webDriver.

Execution steps:

1.Run the following command to set the user environment variable for email,password and subject to be searched: setx key “value”

2.Need to set the docker in your system according to the operating system.

3.Run following commands to create docker images for selenium webDriver and chrome browser for execution:

docker pull selenium/hub

docker pull selenium/node-chrome-debug

4.To generate docker container Id use following commands:

docker run -d -P --link selenium-hub:hub selenium/node-chrome-debug

docker run -d -p 4545:4444 --name selenium-hub selenium/hub  (Here 4545 is the port number you want to have to run the execution you can give value.

5.Import the project in IDE and set the URL in OpenBrowser.java using following command:

For LINUX: localhost:4646/wd/hub

4646:Port number

For Windows: run command docker-machine ip

URL:docker-machine ip}/wd/hub

6.Run the code and the execution and you can see the file and screenshots for the execution to path specified in code.
