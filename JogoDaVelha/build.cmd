@echo off
cls
echo.
echo.
echo  Building app
echo.
echo.

set "pkg=jardelnovaes/games/samples/velha/"
set "src=src/%pkg%"
set "classes=%pkg%*.class"

javac -d classes -sourcepath %src% %src%/*.java
cd classes
jar -cvfm ../bin/JogoDaVelha.jar ../assets/manifest %classes%
copy ..\assets\run.cmd ..\bin\run.cmd /Y
cd ..

echo.
echo  finished
echo.

pause
cls
exit
