package web;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Test;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions (
                     features =  "src/test/resources/features",
                     glue     =  "web",
                     plugin   =  { "pretty",
                                 "html:extent.extentreports",
                                 "json:extent.extentreports.json"
                     }
)

public class Runner {
}
