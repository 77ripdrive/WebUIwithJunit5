:: Beginning of hub batch file
set SERVER_VERSION=4.0.0-alpha-2
set TASK_NAME=SeleniumServerNode4
set NODE_PORT=5558
set HUB_PORT=4455
set REGISTER_IP=localhost
set MSEDGE_DRIVER=D:\WebDriver\msedgedriver.exe
java -Dwebdriver.ie.driver=%MSEDGE_DRIVER% -jar selenium-server-standalone-%SERVER_VERSION%.jar -role node -hub http://%REGISTER_IP%:%HUB_PORT%/grid/register -browser "browserName=MicrosoftEdge,version=11,maxInstances=5,platform=WINDOWS" -port %NODE_PORT%
:: End of hub batch file
pause
