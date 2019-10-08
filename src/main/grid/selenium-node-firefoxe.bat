:: Beginning of hub batch file
set SERVER_VERSION=4.0.0-alpha-2
set TASK_NAME=SeleniumServerNode3
set NODE_PORT=5557
set HUB_PORT=4455
set REGISTER_IP=localhost
set GECKO_DRIVER=D:\WebDriver\geckodriver.exe
java -Dwebdriver.gecko.driver=%GECKO_DRIVER% -jar selenium-server-standalone-%SERVER_VERSION%.jar -role node -hub http://%REGISTER_IP%:%HUB_PORT%/grid/register -browser "browserName=firefox,version=67.0.2,maxInstances=5,platform=WINDOWS" -port %NODE_PORT%
:: End of hub batch file
pause