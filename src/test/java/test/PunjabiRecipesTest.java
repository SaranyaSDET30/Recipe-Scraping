package test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import config.ScrappingConfig;
import objectRepository.RecipePageObjects;

public class PunjabiRecipesTest {
	
	public static String category;
    WebDriver driver=null;
    


@Test

   public void recipeScrappingPunjabi() throws Exception {

	System.setProperty("webdriver.chrome.driver", ScrappingConfig.DRIVER_PATH);
	Map<String, Object> prefs = new HashMap<String, Object>();

	prefs.put("profile.managed_default_content_settings.images", 2);

	ChromeOptions op = new ChromeOptions();
	op.setExperimentalOption("prefs", prefs);
	WebDriver driver= new ChromeDriver(op);

	driver.get(ScrappingConfig.URL);
	
	driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);
	
	RecipePageObjects recipePageObj = new RecipePageObjects(driver);
	Commonscrapping commonScrapPageObj=new Commonscrapping(driver);
	recipePageObj.textbox(ScrappingConfig.PunjabiText);
	recipePageObj.search();
	recipePageObj.linkclick();
	commonScrapPageObj.scrapAndWriteExcel(ScrappingConfig.excelPath,ScrappingConfig.PunjabisheetName);
	
     }

	

}
