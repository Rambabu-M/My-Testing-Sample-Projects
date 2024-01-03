package testPackage;

import java.awt.AWTException;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testClass {
	
	/* private static void typeWithRobot(Robot robot, String text) {
	        for (char c : text.toCharArray()) {
	            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
	            robot.keyPress(keyCode);
	            robot.keyRelease(keyCode);
	        }
	    }*/
	 
	
	
	public static void main(String[] args) throws InterruptedException, IOException, AWTException, FindFailed {
        // Setup WebDriverManager to download and manage the ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Create an instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Perform actions with the WebDriver (e.g., navigate to a website)
        driver.get("https://connectors.cbwpayments.com/ledgercustomer/#/login");
        
        driver.manage().window().maximize();

        driver.findElement(By.id("username")).sendKeys("latham@netxd.com");
        driver.findElement(By.id("password")).sendKeys("Tech@1234");
        driver.findElement(By.xpath("/html/body/app-root/div[2]/div/app-login/div/div/div[5]/div/form/button")).click();
        
        String guthSecretCode = "CFTMYCBUIHDJ2P3A77IZR42X6HV5RK6L";
        Totp totp = new Totp(guthSecretCode);
        String otp = totp.now();
        Thread.sleep(500);
        WebElement otpTextbox = driver.findElement(By.id("j_otp"));
        otpTextbox.sendKeys(otp);
        WebElement verifyButton = driver.findElement(By.xpath("//*[text()='VERIFY']"));
        verifyButton.click();
        
        Desktop.getDesktop().open(new File("/home/rambabu/Documents/p_ledger_QA/Customers/Quantum Tech/latham01.jar"));
        
     
        String imagePath = "/home/rambabu/Documents/workspace_eclipse/AutomateJarFile/src/test/resources/sikuliImages";

     
        // Open the JAR file
        Screen screen = new Screen();
        //Pattern jarIcon = new Pattern(imagePath + "latham.jar");
        //screen.doubleClick(jarIcon);

        // Type the PIN (replace "1234" with your actual PIN)
        Pattern pinInput = new Pattern(imagePath + "/pin_textbox.png");
        screen.type(pinInput, "1234");

        // Click the "Verify" button
        Pattern verifyButtonClick = new Pattern(imagePath + "/verify_button.png");
        screen.click(verifyButtonClick);
        
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
        Thread.sleep(2000);
        
        //driver.findElement(By.xpath("/html/body/app-root/header/div/div/div[1]/span/span[2]/a/span")).click();
      
        driver.findElement(By.xpath("/html/body/app-root/div[2]/div/app-generate-token-app/div/div[2]/div/div[1]/div/h2/font/span")).click();
        System.out.println("Clicked from webpage");
        
          Thread.sleep(2000);
        
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
     
        Pattern clickButton = new Pattern(imagePath + "/click_button.png");
        screen.click(clickButton);
        
        Thread.sleep(2000);
        
        Pattern approveButton = new Pattern(imagePath + "/approve_button.png");
        screen.click(approveButton); 
        
        Thread.sleep(5000);
        driver.quit();                 
    }
}


