@echo off
:: @echo off
REM set /p input="Enter ID: "
REM echo %input%
REM pause

@echo off
set /p input = "Enter Commit Text: "
git add .
git commit -m echo %input%
git pull
git push --all
echo Process Complete Press Enter...
pause