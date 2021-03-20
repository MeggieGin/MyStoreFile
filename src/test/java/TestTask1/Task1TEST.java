package TestTask1;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;




    @RunWith(Cucumber.class)
    @CucumberOptions(features = "src/Cucamber/.feature/LogInAndAddAddress.feature", plugin = {"pretty","html:out"})
    public class Task1TEST { }
