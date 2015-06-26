android create uitest-project -n wefriends -t 1 -p .
ant build
adb push .\bin\wefriends.jar data/local/tmp
adb shell uiautomator runtest wefriends.jar -c wefriends.runner.Runner