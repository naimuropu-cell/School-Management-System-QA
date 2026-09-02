package utilities;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {

        try {

            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            File dest = new File("screenshots/" + testName + "_" + timestamp + ".png");

            dest.getParentFile().mkdirs();
            FileHandler.copy(source, dest);

            return dest.getAbsolutePath();

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        }
    }

}
