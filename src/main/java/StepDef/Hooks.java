package StepDef;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import CommonFunctions.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {
	@After
	public void tear_down(Scenario scenario) throws IOException {
		File sourcePath= ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
        scenario.attach(fileContent, "image/png",scenario.getName());
		BaseTest.driver.quit();
	}
}
