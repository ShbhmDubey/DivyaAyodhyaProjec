package svgelement;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestingSVG {
    static WebDriver driver;
	public static void main(String[] args) {
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
	      //  barChart();
	     todayProtocol();
	   //  editProtocol();
	     
	     actionAssign();
	     printTheReceipt();

	}
	public static void actionAssign() {
    	driver.findElement(By.linkText("Assign")).click();
    	Random ran=new Random();
    	WebElement policeName=driver.findElement(By.xpath("//input[@id='assign_pro']"));
    	policeName.sendKeys("Akash");
    	WebElement policeMob=driver.findElement(By.xpath("//input[@id='assign_pro_mobile']"));
    	policeMob.sendKeys("8318133512");
    //	List<WebElement>list1=driver.findElements(By.xpath("//select[@id='gate_number']"));
    	WebElement gNumber=driver.findElement(By.name("gate_number"));
    	selectOptionsFromDropDown(gNumber);
    	WebElement protocolStatus=driver.findElement(By.name("protocol_status"));
    	selectOptionsFromDropDown(protocolStatus);
    	WebElement save=driver.findElement(By.xpath("//button[normalize-space()='Save']"));
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Save']")));
          
          // Optional: Scroll into view
          ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
          
          // Click using JavaScript
          ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
          System.out.println("Assignment operation performrd successfully");
    	
    }
	public static void selectOptionsFromDropDown(WebElement ele) {
		  Select select=new Select(ele);
		  Random ran=new Random();
		  List<WebElement> option=select.getOptions() ;
		  int idx=ran.nextInt(0,option.size());
		  WebElement op=option.get(idx);
		  op.click();

	  }
	    
	 public static void editProtocol() {
	    	driver.findElement(By.linkText("Edit")).click();
	    	WebElement ww=driver.findElement(By.xpath("//input[@id='devotee_name']"));
	    	ww.clear();
	    	ww.sendKeys("Shubham");
	
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Update']")));
	        
	        // Optional: Scroll into view
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	        
	        // Click using JavaScript
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	  	
	  
	    	System.out.println("Protocol edited successfully");
	    	
	    }
   public static void todayProtocol() {
	// driver.findElement(By.xpath("//body")).click();
	   driver.get("https://divyaayodhya.com/protocol/dashboardCountList?type=todayProtocol");
		JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
   

	 System.out.println("today....");
   }
   public static void downloadPdf() {
	   driver.findElement(By.linkText(""));
   }
   public static void deleteProtocol() {
   	driver.findElement(By.linkText("Delete")).click();
   	driver.switchTo().alert().accept();
   	System.out.println("Protocol Deleted successfully");
   }
   public static void finalReceipt() {
	   driver.findElement(By.tagName("cr-button")).click();
	   driver.switchTo().alert().accept();
   }
   public static void printTheReceipt() {
   	WebElement save=driver.findElement(By.xpath("//a[normalize-space()=\"Print\"]"));
   	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()=\"Print\"]")));
         
         // Optional: Scroll into view
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
         
         // Click using JavaScript
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
   	WebElement print=driver.findElement(By.cssSelector(".btn.btn-primary"));
   	  WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
         WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-primary")));
         
         // Optional: Scroll into view
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
         
         // Click using JavaScript
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
         
         System.out.println("Printing operation of receipt is successfully");
   	
  // 	finalReceipt();
   	
   }

}
