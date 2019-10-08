:: Beginning of hub batch file
set SERVER_VERSION=4.0.0-alpha-2
set TASK_NAME=SeleniumServerNode3
set NODE_PORT=5560
set HUB_PORT=4455
set REGISTER_IP=localhost
set CHROME_DRIVER=D:\WebDriver\chromedriver.exe
java -Dwebdriver.chrome.driver=%CHROME_DRIVER% -jar selenium-server-standalone-%SERVER_VERSION%.jar -role node -hub http://%REGISTER_IP%:%HUB_PORT%/grid/register -browser "browserName=chrome,version=63,maxInstances=5,platform=WINDOWS" -port %NODE_PORT%
:: End of hub batch file
pause