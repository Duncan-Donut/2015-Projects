@echo off

:run

javac %~dp0EpicC.java 

java EpicC

TIMEOUT 60

goto run

pause