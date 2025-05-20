package runner;


import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.testng.annotations.Test;

public class TestRunner {

    @Test
    void runScenario() {
        Results results = Runner.path("classpath:KarateFeatureFiles/")
                .tags("@smoke_1")
                .outputJunitXml(true).parallel(1);
    }
}
