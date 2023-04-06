#!/bin/sh
mvn test -D cucumber.filter.tags="@smoke" -D env=QA -D browser=chrome
mvn test -D cucumber.filter.tags="@smoke" -D env=QA -D browser=edge
mvn test -D cucumber.filter.tags="@smoke" -D env=QA -D browser=firefox