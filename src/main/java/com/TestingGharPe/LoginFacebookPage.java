package com.TestingGharPe;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFacebookPage {
public WebDriver driver;

@FindBy(id="email")
public static WebElement email;

@FindBy(id="pass")
public static WebElement password;

@FindBy(xpath="//input[@type='submit']")
public static WebElement logIn;

@FindBy(xpath=".//*[@id='globalContainer']/div[3]/div/div/div")
public static WebElement errorMsg;

public void openBrowser(String browser) throws IOException {

if(browser.equals("Firefox")) {
driver = new FirefoxDriver();
}else if(browser.equals("Chrome")){
System.setProperty("webdriver.chrome.driver","C:/SeleniumJars/chromedriver.exe");
driver = new ChromeDriver();
}else {
System.setProperty("webdriver.ie.driver","C:\\SeleniumJars\\MicrosoftWebDriver.exe");
driver = new InternetExplorerDriver();
}

driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
PageFactory.initElements(driver, this);
}

public void closeBrowser() {
driver.quit();
}

public void openFacebook() {
driver.get("https://www.facebook.com/");
}

public void enterEmail(String a) {
driver.findElement(By.id("email")).sendKeys(a);	
}

public void enterPassword(String b) throws InterruptedException {
driver.findElement(By.id("pass")).sendKeys(b);
driver.findElement(By.xpath("//input[@type='submit']")).click();
Thread.sleep(2000);
}

public String readError() {
String actualErrorMSg = driver.findElement(By.xpath(".//*[@id='globalContainer']/div[3]/div/div/div")).getText();
return actualErrorMSg;
}

 
}
