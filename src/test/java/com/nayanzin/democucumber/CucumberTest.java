package com.nayanzin.democucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

// The JUnit runner uses the JUnit framework to run the Cucumber Test.
@RunWith(Cucumber.class)

// The location of the Gherkin file
@CucumberOptions(
        strict = false,
        features = "src/test/resources",
        format = {
                "pretty",
                "html:target/site/cucumber-pretty",
                "json:target/cucumber.json",
        },
        tags = {"~@ignore"})

public class CucumberTest {
}
