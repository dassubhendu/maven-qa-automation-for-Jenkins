Maven download
==============
    - https://maven.apache.org/download.cgi
    - Download Binary zip archive
    - Unzip this file
    - Go to Windows system environment.
    - In User variable section
    - Click on New
    - Put Variable name - 'MAVEN_HOME'
    - Put Variable value as - maven parent folder path in your machine.
    - Go to System variable section and click on existing 'path' variable.
    - Click on Edit and click on 'new'
    - Now specify the path value for maven parent folder/bin

Create Maven Project
====================

Maven Repository
================
    - https://mvnrepository.com/

Maven build life cycle
======================
    - Validate 
    - Compile
    - Test
    - package
    - Install
    - Deploy

Maven compiler plugin details
=============================
    - https://maven.apache.org/plugins/maven-compiler-plugin/
    - Go for this link in documentation - 'Compile Using -source and -target javac Options'
        - https://maven.apache.org/plugins/maven-compiler-plugin/examples/set-compiler-source-and-target.html
    -
Maven sure fire plugin
======================
    - https://maven.apache.org/surefire/maven-surefire-plugin/

Maven code execute
==================
    - mvn clean test
    - mvn clean test -DsuiteXmlFile=testng.xml [For making dynamic call for testng file as variable]
        - <suiteXmlFiles>
        - <suiteXmlFile>${suiteXmlFile}</suiteXmlFile>
        - </suiteXmlFiles>