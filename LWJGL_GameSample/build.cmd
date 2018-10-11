@echo off
cls
echo.
echo.
echo  Building app
echo.
echo.

set "pkg=jardelnovaes/games/samples/slick2d/"
set "src=src/%pkg%"
set "classes=%pkg%*.class"

javac -cp assets\lib\* -d classes -sourcepath %src% %src%\*.java
cd classes
jar -cvfm ../bin/JardaGame.jar ../assets/manifest %classes%
copy ..\assets\run.cmd ..\bin\run.cmd /Y
XCOPY ..\assets\gamedata ..\bin\gamedata\ /S /Y
XCOPY ..\assets\lib ..\bin\lib\ /S /Y
cd ..

echo.
echo  finished
echo.

pause
cls
exit
