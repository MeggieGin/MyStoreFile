package TestTask2;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(features = "src/Cucamber/.feature/LogInAndBuyItem.feature", plugin = {"pretty","html:out"})
    public class Task2TEST { }
