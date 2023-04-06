#!/bin/sh
mvn test -D cucumber.filter.tags="@smoke" -D env=QA -D browser=chrome -D cucumber.plugin="html:target/basic-report/reportChrome.html"
mvn test -D cucumber.filter.tags="@smoke" -D env=QA -D browser=edge -D cucumber.plugin="html:target/basic-report/reportEdge.html"
mvn test -D cucumber.filter.tags="@smoke" -D env=QA -D browser=firefox -D cucumber.plugin="html:target/basic-report/reportFirefox.html"