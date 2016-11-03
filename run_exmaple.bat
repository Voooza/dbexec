@echo off
java -cp sqlitejdbc-0.5.6.jar;dbexec.jar dbexec.core conn.txt sql.text
