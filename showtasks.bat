call runcrud.bat
if "%ERRORLEVEL%" == "0" goto openbrowser
echo.
echo There is an error.
goto fail

:openbrowser
@echo off
cd %CHROME_HOME%
start chrome.exe http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
@echo on
echo.
echo There was an error while opening browser.
goto fail

:fail
echo.
echo Process has failed.

:end
echo.
echo Good job.

