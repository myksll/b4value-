package com.b4value.runners;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "C:\\Users\\mesut\\IdeaProjects\\b4value-\\src\\test\\resources\\features",
        glue="com/b4value/step_definitions",
        dryRun = false,
        tags= "" ,
        publish = false
)

 public class CukesRunner {
}
