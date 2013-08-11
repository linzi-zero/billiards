@echo off
echo [INFO] 使用maven编译项目，并以目录形式部署到jetty中.

call mvn jetty:stop jetty:run
pause