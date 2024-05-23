package darshanType;

import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Darshan {
   static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		   driver=new ChromeDriver();
	        driver.get("https://divyaayodhya.com/protocol/login");
	        driver.manage().window().maximize();
	        WebElement uname=driver.findElement(By.xpath("//input[@id='username']"));
	        uname.sendKeys("protocoladmin");
	        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345678");
	        String str=JOptionPane.showInputDialog("Enter Your Captcha :");
	        WebElement capt=driver.findElement(By.xpath("//input[@id='cpatchaTextBox']"));
	        capt.sendKeys(str);
	        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	        System.out.println("Login module is successfully completed");
	        updateDarshan();

	}
public	static void updateDarshan() throws InterruptedException {
	driver.get("https://divyaayodhya.com/protocol/pooja");
	System.out.println("Updation of darshan type");
	driver.findElement(By.xpath("//tbody/tr[1]/td[4]/a[1]/i[1]")).click();
	WebElement wb1=driver.findElement(By.xpath("//input[@id=\"pooja_name\"]"));
	wb1.clear();
	wb1.sendKeys("VIP ");
	WebElement wb2=driver.findElement(By.xpath("//input[@id=\"m_allow\"]"));
	wb2.clear();
	wb2.sendKeys("15");
	driver.findElement(By.xpath("//button[normalize-space()='Update']")).click();
	
//	Thread.sleep(3000);
	driver.findElement(By.xpath("//tbody/tr[1]/td[4]/a[1]/i[1]")).click();
	WebElement wb3=driver.findElement(By.xpath("//input[@id=\"pooja_name\"]")); 
    wb3.clear();
	wb3.sendKeys("VVIP ");
	WebElement wb4=driver.findElement(By.xpath("//input[@id=\"m_allow\"]"));
	wb4.clear();
	wb4.sendKeys("13");
	driver.findElement(By.xpath("//button[normalize-space()='Update']")).click();
	
}
public static void selectOptionsFromDropDown(WebElement ele) {
	  Select select=new Select(ele);
	  Random ran=new Random();
	  List<WebElement> option=select.getOptions() ;
	  int idx=ran.nextInt(0,option.size());
	  WebElement op=option.get(idx);
	  op.click();

}

}
