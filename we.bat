call android create uitest-project -n wefriends -t 1 -p .
call ant build
call adb push .\bin\wefriends.jar data/local/tmp
call adb shell uiautomator runtest wefriends.jar -c wefriends.runner.Runner