package gauthProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.jboss.aerogear.security.otp.Totp;

public class gauthAutomate {

public static void main(String[] args) throws InterruptedException {
 System.setProperty("webdriver.chrome.driver","/home/rambabu/Downloads/chromedriver_linux64/chromedriver");
 WebDriver driver = new ChromeDriver();
 driver.manage().window().maximize();
 driver.get("https://connectors.cbwpayments.com/ledgermaster/#/login");
 driver.findElement(By.id("username")).sendKeys("r.moorthy@netxd.com"); 
 driver.findElement(By.id("password")).sendKeys("Test@1234");
 WebElement e = driver.findElement(By.xpath("//*[text()='Login']"));
 e.click();
 String gauthCode = "IMWCOA3BVUY4JUX7DQAXBAPOS7XTIMUX";
 Totp totp = new Totp(gauthCode);
 String otp = totp.now();
 Thread.sleep(500);
 WebElement otpTextbox = driver.findElement(By.id("j_otp"));
 otpTextbox.sendKeys(otp);
 WebElement verifyButton = driver.findElement(By.xpath("//*[text()='VERIFY']"));
 verifyButton.click();
 }
}