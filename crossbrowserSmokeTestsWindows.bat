call mvn test -D cucumber.filter.tags="@smoke" -D env=QA -D browser=chrome
call mvn test -D cucumber.filter.tags="@smoke" -D env=QA -D browser=edge
call mvn test -D cucumber.filter.tags="@smoke" -D env=QA -D browser=firefox