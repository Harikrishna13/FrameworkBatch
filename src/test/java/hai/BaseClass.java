package hai;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

WebDriver driver;
Actions a;
JavascriptExecutor c;
Select s;
public void getDriver(String browser){
  	if(browser.equalsIgnoreCase("chrome")){
	System.setProperty("webdriver.chrome.driver","path");
	 driver = new ChromeDriver();
	driver.manage().window().maximize();
}	else if (browser.equalsIgnoreCase("Firefox")){
	System.setProperty("webdriver.gecko.driver","path");
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
}}
public void getUrl(String name){
	driver.get(name);
}
public void enterText(WebElement element,String data){
	element.sendKeys(data);
}

    public void getTitle() {
    driver.getTitle();
    }
    public void currentUrl(String name) {
		driver.getCurrentUrl();
}
    public void btnclick(WebElement element) {
    	element.click();
    }
    public void getValue(WebElement element , String value) {
    String attribute=element.getAttribute(value); 
    System.out.println(attribute);   
}
    public void toClose() {
    	driver.close();
 }
    public void toQuit() {
    	driver.quit();
 }
    public void navigateTo(String url) {
    	driver.navigate().to(url);
     }
    public void refresh() {
    	driver.navigate().refresh();
    }
    public void forward() {
    	driver.navigate().forward();
 }
    public void back() {
    	driver.navigate().back();
 }
   public void moveTOElement(WebElement element) {
	   a=new Actions(driver);
	   a.moveToElement(element).perform();
}
   public void rightClick(WebElement element) {
	   a=new Actions(driver);
	   a.contextClick(element).perform();
}
   public void doubleClick(WebElement element) {
	   a=new Actions(driver);
	   a.doubleClick(element).perform();
	   }
   public void dragAndDrop(WebElement element1,WebElement element2) {
	   a=new Actions(driver);
	   a.dragAndDrop(element1, element2).perform();
     }
   public void dropBySelect(WebElement element,String data,String Value){
   Select s=new Select(element);
   if(data.equalsIgnoreCase("value")){
   s.selectByValue("value");
}else if(data.equalsIgnoreCase("text")){ 
  s.selectByVisibleText("value");
}else if(data.equalsIgnoreCase("index")){
  s.selectByIndex(Integer.parseInt("value"));
}
}
public void dropBydeSelect(WebElement element,String data,String Value){
   Select s=new Select(element);
   if(data.equalsIgnoreCase("value")){
   s.deselectByValue("value");
}else if(data.equalsIgnoreCase("text")){ 
  s.deselectByVisibleText("value");
}else if(data.equalsIgnoreCase("index")){
  s.deselectByIndex(Integer.parseInt("value"));
}
}
   public void Options(WebElement element) {
	   s=new Select(element);
	   s.getOptions();
   }
   public void AllSlectedOps(WebElement element) {
	   s=new Select(element);
	   s.getAllSelectedOptions();
   }
   public void FirstSelectedOp(WebElement element) {
	   s=new Select(element);
	   s.getFirstSelectedOption();
   }
   public void Multiple(WebElement element) {
	   s=new Select(element);
	   s.isMultiple();
   }
   public void deselectAll(WebElement element) {
	   s=new Select(element);
	   s.deselectAll();
 }
   public void getWindowHandle() {
	   driver.getWindowHandle();
 }
   public void getWindowHandles() {
	   driver.getWindowHandles();
	   }
public WebElement locators(String loc,String data) {
		WebElement element=null;
		if(loc.equalsIgnoreCase("id")) {
			element=driver.findElement(By.id(data));
		}else if(loc.equalsIgnoreCase("xpath")) {
			element=driver.findElement(By.xpath(data));
		}else if(loc.equalsIgnoreCase("name")) {
			element=driver.findElement(By.name(data));
		}
		return element;
		}
     public void scrollDown(WebElement element) {
	  c=(JavascriptExecutor)driver;
	  c.executeScript("arguments[o].scrollIntoView(true)",element);
	  c.executeScript("arguments[o].scrollIntoView(false)",element);
 }
public void enterTextByJs(WebElement element,String data){
 c=(JavascriptExecutor)driver;
c.executeScript("arguments[0].setAttribute('value','"+ data +"')",element);
}
public String returnTextByJs(WebElement element){
  String executescript=(String)c.executeScript("return arguments[0].getAttribute('value')",element);
return executescript;
}
  public void simpleAlert() {
	  driver.switchTo().alert().accept();
}
  public void conformationAlert() {
	  driver.switchTo().alert().dismiss();
}
  public void sendkeysAlert(String value) {
	  driver.switchTo().alert().sendKeys(value);
	  driver.switchTo().alert().accept();
}
  public void screenShot() {
	  TakesScreenshot ts =(TakesScreenshot)driver;
	   ts.getScreenshotAs(OutputType.FILE);
}
public void toEnterIframe(WebElement element){
driver.switchTo().frame(element);
}
//allframeexit
public void allFrameExit(){
driver.switchTo().defaultContent();
}
//tocountiframe
public List<WebElement> toCount(String td,String data){
List<WebElement> li=driver.findElements(By.tagName(data));

return li;
}
//webdriver wait
 
public String getcellvalue(String sheet, int rowIndex, int cellIndex) throws IOException {
	String value=null;
	File file=new File("C:\\Users\\harik\\Documents\\mhk.xlsx");
	FileInputStream stream=new FileInputStream(file);
	Workbook w=new XSSFWorkbook(stream);
	Sheet s = w.getSheet(sheet);
	Row r = s.getRow(rowIndex);
	Cell c = r.getCell(cellIndex);
	int type = c.getCellType();
	if (type==1) {
		value = c.getStringCellValue();
		}
	if (type==0) {
		if (DateUtil.isCellDateFormatted(c)) {
			Date date = c.getDateCellValue();
			SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
			value = sim.format(date);		
		}
		else {
			double d = c.getNumericCellValue();
			long l=(long) d;
			value  = String.valueOf(l);	
		}
		}
	return value;		 
		}
 public void updateDataInExcel(String sheet, int rownum, int cellnum, String data) throws IOException {
	File file=new File("C:\\Users\\harik\\Documents\\mhk.xlsx");
	FileInputStream stream=new FileInputStream(file);
	Workbook w=new XSSFWorkbook(stream);
	Sheet s = w.getSheet(sheet);
	Row r = s.getRow(rownum);
	Cell c = r.createCell(cellnum);
	c.setCellValue(data);
	FileOutputStream outputStream=new FileOutputStream(file);
	w.write(outputStream);
	
} 
 }



}

