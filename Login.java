package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//WE have to call web-driver manager for the browser driver
WebDriverManager.chromedriver().setup();

//launch the browser //create a object
ChromeDriver driver = new ChromeDriver();

//Load the URL
driver.get("http://leaftaps.com/opentaps/control/main");
 
//Maximize the browser
driver.manage().window().maximize();

//input username
driver.findElement(By.id("username")).sendKeys("demosalesmanager");

//input password
driver.findElement(By.id("password")).sendKeys("crmsfa");

//Login button
driver.findElement(By.className("decorativeSubmit")).click();

//Ensure the correct login page
WebElement logout = driver.findElement(By.className("decorativeSubmit"));

//Find element 
String attribute = logout.getAttribute("value");
System.out.println(attribute);
if(attribute.contains("logout")) {
	System.out.println("successfully logged in");}
//Click CRM/SFA Link
driver.findElement(By.linkText("CRM/SFA")).click();
//Click Leads Link
driver.findElement(By.linkText("Leads")).click();
//Click Create Lead Link
driver.findElement(By.linkText("Create Lead")).click();
//Enter Company Name
driver.findElement(By.id("createLeadForm_companyName")).sendKeys("BM_Company3");
//Enter First Name
driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Maheswari3");
//Enter Last Name
driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Balu3");

//Select source dropdown
WebElement dataSourceId = driver.findElement(By.id("createLeadForm_dataSourceId"));
//convert to select class
Select select=new Select(dataSourceId);
//select by visible text
select.selectByVisibleText("Conference");

//select by value for Marketing campign
WebElement marketingCampaignId = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
//convert to select class
Select select1=new Select(marketingCampaignId);
//select by value
select1.selectByValue("9000");

//First name (local)
driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("LocalB1");

//Department
driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Dep1");

//Description
driver.findElement(By.id("createLeadForm_description")).sendKeys("Description one 1");

//Email
driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("mahe.1@gmail.com");

//State/province
driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")).sendKeys("TN1");


//Click on Create Lead
driver.findElement(By.className("smallSubmit")).click();

//Verify the view Lead Page Title
String title = driver.getTitle();
if(title.contains("View Lead")) {
	System.out.println("On View Lead Page");


}


}
	}



