@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  RestApiIndividual startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Add default JVM options here. You can also use JAVA_OPTS and REST_API_INDIVIDUAL_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windows variants

if not "%OS%" == "Windows_NT" goto win9xME_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\RestApiIndividual-1.0-SNAPSHOT.jar;%APP_HOME%\lib\resteasy-jaxrs-3.12.1.Final.jar;%APP_HOME%\lib\httpclient-4.5.10.jar;%APP_HOME%\lib\jersey-container-jetty-servlet-2.27.jar;%APP_HOME%\lib\jetty-webapp-9.4.7.v20170914.jar;%APP_HOME%\lib\jetty-servlet-9.4.14.v20181114.jar;%APP_HOME%\lib\jetty-security-9.4.14.v20181114.jar;%APP_HOME%\lib\jersey-container-jetty-http-2.27.jar;%APP_HOME%\lib\jetty-server-9.4.14.v20181114.jar;%APP_HOME%\lib\jersey-container-servlet-2.27.jar;%APP_HOME%\lib\jersey-container-servlet-core-2.27.jar;%APP_HOME%\lib\jersey-server-2.27.jar;%APP_HOME%\lib\jersey-hk2-2.27.jar;%APP_HOME%\lib\hibernate-core-5.4.17.Final.jar;%APP_HOME%\lib\jaxb-runtime-2.3.1.jar;%APP_HOME%\lib\jaxb-api-2.3.1.jar;%APP_HOME%\lib\activation-1.1.1.jar;%APP_HOME%\lib\jersey-media-json-jackson-2.27.jar;%APP_HOME%\lib\jbcrypt-0.4.jar;%APP_HOME%\lib\mysql-connector-java-5.1.44.jar;%APP_HOME%\lib\gson-2.7.jar;%APP_HOME%\lib\httpcore-4.4.12.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\commons-codec-1.11.jar;%APP_HOME%\lib\javax.servlet-api-3.1.0.jar;%APP_HOME%\lib\jetty-http-9.4.14.v20181114.jar;%APP_HOME%\lib\jetty-io-9.4.14.v20181114.jar;%APP_HOME%\lib\jersey-client-2.27.jar;%APP_HOME%\lib\jersey-media-jaxb-2.27.jar;%APP_HOME%\lib\jersey-common-2.27.jar;%APP_HOME%\lib\jersey-entity-filtering-2.27.jar;%APP_HOME%\lib\javax.ws.rs-api-2.1.jar;%APP_HOME%\lib\hk2-locator-2.5.0-b42.jar;%APP_HOME%\lib\hk2-api-2.5.0-b42.jar;%APP_HOME%\lib\hk2-utils-2.5.0-b42.jar;%APP_HOME%\lib\javax.annotation-api-1.2.jar;%APP_HOME%\lib\javax.inject-2.5.0-b42.jar;%APP_HOME%\lib\validation-api-1.1.0.Final.jar;%APP_HOME%\lib\jackson-module-jaxb-annotations-2.8.10.jar;%APP_HOME%\lib\jackson-databind-2.8.10.jar;%APP_HOME%\lib\jackson-annotations-2.8.10.jar;%APP_HOME%\lib\hibernate-commons-annotations-5.1.0.Final.jar;%APP_HOME%\lib\jboss-logging-3.3.2.Final.jar;%APP_HOME%\lib\javax.persistence-api-2.2.jar;%APP_HOME%\lib\javassist-3.24.0-GA.jar;%APP_HOME%\lib\byte-buddy-1.10.10.jar;%APP_HOME%\lib\antlr-2.7.7.jar;%APP_HOME%\lib\jboss-transaction-api_1.2_spec-1.1.1.Final.jar;%APP_HOME%\lib\jandex-2.1.3.Final.jar;%APP_HOME%\lib\classmate-1.5.1.jar;%APP_HOME%\lib\javax.activation-api-1.2.0.jar;%APP_HOME%\lib\dom4j-2.1.3.jar;%APP_HOME%\lib\jboss-jaxrs-api_2.1_spec-2.0.1.Final.jar;%APP_HOME%\lib\jboss-jaxb-api_2.3_spec-2.0.0.Final.jar;%APP_HOME%\lib\reactive-streams-1.0.3.jar;%APP_HOME%\lib\jakarta.validation-api-2.0.2.jar;%APP_HOME%\lib\jboss-annotations-api_1.3_spec-2.0.1.Final.jar;%APP_HOME%\lib\jakarta.activation-1.2.1.jar;%APP_HOME%\lib\commons-io-2.5.jar;%APP_HOME%\lib\jcip-annotations-1.0-1.jar;%APP_HOME%\lib\jetty-xml-9.4.7.v20170914.jar;%APP_HOME%\lib\jetty-util-9.4.14.v20181114.jar;%APP_HOME%\lib\osgi-resource-locator-1.0.1.jar;%APP_HOME%\lib\jetty-continuation-9.4.7.v20170914.jar;%APP_HOME%\lib\aopalliance-repackaged-2.5.0-b42.jar;%APP_HOME%\lib\jackson-core-2.8.10.jar;%APP_HOME%\lib\txw2-2.3.1.jar;%APP_HOME%\lib\istack-commons-runtime-3.0.7.jar;%APP_HOME%\lib\stax-ex-1.8.jar;%APP_HOME%\lib\FastInfoset-1.2.15.jar;%APP_HOME%\lib\javax.inject-1.jar

@rem Execute RestApiIndividual
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %REST_API_INDIVIDUAL_OPTS%  -classpath "%CLASSPATH%" main.Start %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable REST_API_INDIVIDUAL_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%REST_API_INDIVIDUAL_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
