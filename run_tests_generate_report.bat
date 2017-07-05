set /P storyName="Select story file name (names divided by ','):"
call mvn clean test -Dstory=%storyName% -Dthreads=1
java -jar reporter/reporter.jar target/jbehave
start"" .//report//index.html
