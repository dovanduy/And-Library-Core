
@echo off
set /p input="Enter ID: "
echo %input%
pause

git add .
git commit -am "made changes"
git pull
git push --all
echo Press Enter...
read
pause