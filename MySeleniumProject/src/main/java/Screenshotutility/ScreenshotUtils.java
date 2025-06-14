package Screenshotutility;

import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtils {

    public static String captureScreenShot(WebDriver driver, String screenShotName) {
        // Add timestamp and extension
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/screenShot/" + screenShotName + "_" + timestamp + ".png";

        // Create folder if not exists
        File screenshotDir = new File(System.getProperty("user.dir") + "/screenShot/");
        if (!screenshotDir.exists()) {
            screenshotDir.mkdir();
        }

        // Take screenshot
        File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(filePath);

        try {
            FileUtils.copyFile(scr, dest);
        } catch (IOException e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }

        return filePath;
    }
}