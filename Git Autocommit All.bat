:: @echo off
:: @echo off
REM set /p input="Enter ID: "
REM echo %input%
REM pause

:: @echo off
set /p input = "Enter Commit Text: "
set gcommand=git commit -m "%input%"
git add .
:: git commit -m "COMMIT COMPLETE A"
echo %gCommand%
%gCommand%
git pull
git push --all
echo Process Complete Press Enter...
pause