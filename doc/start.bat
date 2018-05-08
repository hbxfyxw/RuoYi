ECHO OFF
REM  RuoYi
ECHO ON
@echo off
cls

title RuoYi

set CURRENT_DIR=%cd%
set JTM_HOME=%cd%
set JAVA_HOME=%cd%\jre8
set CLASSPATH=.;%cd%\jre8\lib
set JRE_HOME=%cd%\jre8

set java="%cd%\jre8\bin\java" -classpath "%CLASSPATH%"

%java% -jar RuoYi-1.0.8.jar