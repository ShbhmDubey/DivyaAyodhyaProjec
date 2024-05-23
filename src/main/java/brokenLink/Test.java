package brokenLink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
static WebDriver driver; 

	public static void main(String[] args) throws IOException, InterruptedException {
		 driver=new ChromeDriver();
	        driver.get("https://divyaayodhya.com/protocol/officerList");
	        driver.manage().window().maximize();
	        countValidLinks();

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

}
