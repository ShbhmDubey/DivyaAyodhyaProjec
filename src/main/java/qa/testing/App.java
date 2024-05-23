package qa.testing;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
//import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import qa.testing.helper.TimeClass;

/**
 * Hello world!
 *
 */
public class App 
{
	static WebDriver driver;
	//static Random ran;
    public static void main( String[] args ) throws InterruptedException, IOException
    {
        System.out.println( "Hello World!" );
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
     
    	  String vehicle="UP 63 Q 037";
    	  String dname="Test 4 ";
    	  String mob="8318133523";
    	  String rem="add---->";
    	  addProtocol(vehicle,dname,mob,rem);
    	//  Thread.sleep(3000);
    	  
    	 
      
                 searchProtocolUsingDate(new TimeClass("15","May","2024"),new TimeClass("20","May","2024"));
	            searchedTableInfo();
	//  actionOperation();
	            scrollEventUpDown();
//	  scrollLeftRight();
               deleteProtocol();
           editProtocol();
               actionAssign();
               printTheReceipt();
               
// countValidLinks();
     
    }
    public static void countValidLinks() throws IOException, InterruptedException {
    	List<WebElement>list=driver.findElements(By.tagName("a"));
    	System.out.println("Total number of links:--"+list.size());
    	
    	for(int i=0;i<list.size();i++) {
    		WebElement element=list.get(i);
    		String url=element.getAttribute("href");
    		URL link=new URL(url);
    		HttpURLConnection urlconn=(HttpURLConnection)link.openConnection();
    				Thread.sleep(2000);
    				urlconn.connect();
    				int rescode=urlconn.getResponseCode();
    				if(rescode>=400) {
    					System.out.println(url+" this is the broken link");
    				}else {
    					System.out.println(url+"this is valid link");
    				}
    		
    	}
    }
    public static void editProtocol() {
    	driver.findElement(By.linkText("Edit")).click();
    	WebElement ww=driver.findElement(By.xpath("//input[@id='devotee_name']"));
    	ww.clear();
    	ww.sendKeys("Shubham");
    	scrollEventUpDown();
		/*
		 * WebElement w=driver.findElement(By.
		 * xpath("//header[@class='navbar navbar-expand-md navbar-light sticky-top d-print-none']"
		 * )); w.clear(); w.sendKeys("jai Shree Ram"); WebElement
		 * ww2=driver.findElement(By.xpath("//input[@id=\"pooja_date\"]")); ww2.clear();
		 * ww2.sendKeys("05/24/2024");
		 */
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Update']")));
        
        // Optional: Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        
        // Click using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
  	
  
    	System.out.println("Protocol edited successfully");
    	
    }
    public static void deleteProtocol() {
    	driver.findElement(By.linkText("Delete")).click();
    	driver.switchTo().alert().accept();
    	System.out.println("Protocol Deleted successfully");
    }
   
    public static void scrollEventUpDown() {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
   
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
    	
    	
    	
    }
    public static void searchedTableInfo() {
    	int count=0;
       driver.findElement(By.tagName("table"));
       List<WebElement>list=driver.findElements(By.tagName("tr"));
       int rows=list.size();
     for(int i=0;i<list.size();i++) {
    	 WebElement wb=list.get(i);
    	 String str=wb.getText();
    
    	 
    System.out.println("text values :"+str);	 
     }
     System.out.println("Total number of protocol deleted is :"+count);
       System.out.println("Total number of rows are : "+list.size());
       List<WebElement>list1=driver.findElements(By.tagName("th"));
       int cols=list1.size();
       System.out.println("Total number of cols in the given table are   :"+cols);
       for(int i=0;i<list1.size();i++) {
      	 WebElement wb=list1.get(i);
      	 String str=wb.getText();
      System.out.println("text values :"+str);	 
       }
       
    	
    	
    }
    public static void searchProtocolUsingDate(TimeClass from,TimeClass to) {
    	WebElement calender1=driver.findElement(By.xpath("//input[@id='f_date']"));
    	calender1.sendKeys("05/20/2024");
    	WebElement calender2=driver.findElement(By.xpath("//input[@id='t_date']"));
    	calender2.sendKeys("05/21/2024");
    	WebElement sub=driver.findElement(By.xpath("//button[normalize-space()='Search']"));
    	sub.click();
   
    }
    
  public  static void addProtocol(String vehicle,String dname,String mob,String rem) throws InterruptedException {
    	
	   System.out.println("Creating new protocol......");
	  	  driver.findElement(By.xpath("//span[normalize-space()='Create Protocol Booking']")).click();
	 
	  	  WebElement typeOfDarshan=driver.findElement(By.name("pooja_type_id"));

	  	 selectOptionsFromDropDown(typeOfDarshan);
	  	  
	  	  WebElement noOfPersons=driver.findElement(By.name("no_of_person"));
	  	 selectOptionsFromDropDown(noOfPersons);
	  	 WebElement refferedBy=driver.findElement(By.name("ref_by"));
	  	 selectOptionsFromDropDown(refferedBy);
	  	 WebElement gateNum=driver.findElement(By.name("gate_number"));
	  	selectOptionsFromDropDown(gateNum);
		 WebElement spclAssi=driver.findElement(By.name("special_assistance"));
		  	selectOptionsFromDropDown(spclAssi);
		  	WebElement darshanSlot=driver.findElement(By.name("slot_id"));
		  	selectOptionsFromDropDown(darshanSlot);
		  	driver.findElement(By.name("vehicle_number")).sendKeys(vehicle);
			driver.findElement(By.name("devotee_name")).sendKeys(dname);
			driver.findElement(By.name("devotee_mobile")).sendKeys(mob);
			driver.findElement(By.name("remark")).sendKeys(rem);
		
		driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
		  	
		  	
	  	 
	  	  
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
