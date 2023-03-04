package TestRunnerPayback;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( features={"src\\test\\resources\\Paybacklogin1.feature"},
                 
                  tags="@tag3",
                  
               glue="StepDefinitionPayback") 
//tags="@Login")
public class TestPayback {

}
