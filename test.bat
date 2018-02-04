@echo off
set date=%DATE%
set var=%date% A Date
set /p UserInputPath=What Directory would you like?
echo %UserInputPath%
:: test.bat < test.bat
:: %UserInputPath%
:: %DATE%
echo %var%
echo %date% %time% %TIME%
pause
:: https://superuser.com/questions/837344/how-to-accept-user-input-command-in-batch-file
:: https://stackoverflow.com/questions/18972156/how-to-pass-input-to-exe-in-batch-file
:: https://stackoverflow.com/questions/1223721/in-windows-cmd-how-do-i-prompt-for-user-input-and-use-the-result-in-another-com
:: Test