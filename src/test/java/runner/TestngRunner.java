package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",
				glue="AutomationProject.StepDefinitions",
				monochrome=true,
				tags="@errorvalidation",
				plugin= {"html:target/cucumber.html"})
public class TestngRunner extends AbstractTestNGCucumberTests{

}
