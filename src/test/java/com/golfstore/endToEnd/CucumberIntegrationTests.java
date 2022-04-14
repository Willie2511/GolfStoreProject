package com.golfstore.endToEnd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:test/resources/feature")
public class CucumberIntegrationTests {
}
