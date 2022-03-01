package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import objectRepository.RecipePageObjects;
import utils.ExcelUtils;

public class Commonscrapping {
	
	 WebDriver driver;
	 public String category;
	 
	 public Commonscrapping(WebDriver driver) {
		 this.driver=driver;
	 }

	public void scrapAndWriteExcel(String excelPath,String sheetName) throws IOException {
	
	RecipePageObjects recipePageObj = new RecipePageObjects(driver);
	ExcelUtils xlUtils= new ExcelUtils(excelPath,sheetName);
	
    xlUtils.writeheader();			

	List<String> allLinksInRecipe =new ArrayList<String>();
	List<WebElement> links = recipePageObj.getAllLinksInRecipesPage();
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", links.get(1));
	
	for(int i=1;i<=links.size();i++)//links.size()
	   
	 {
		
		recipePageObj.selectLinkInRecipeListPage(i);
		
		String ingredients = recipePageObj.getIngredients();
		 System.out.println("Ingredients are:\n" + ingredients);
		category = recipePageObj.getcategory();
		 System.out.println("Category is :\n" + category);
		String title = recipePageObj.getTitle();
		 System.out.println("title is:\n" + title);
		String recipeSteps = recipePageObj.getRecipeSteps();
		 System.out.println("recipeSteps are:\n" + recipeSteps);
		String imageLink =recipePageObj.getImageLink() ;
		 System.out.println("imageLink are:\n" + imageLink);
		String nutriotionVal =recipePageObj.getNutritionValues();
		 System.out.println("nutriotionVal are:\n" + nutriotionVal);
		String recipeLink= recipePageObj.getRecipeLink();
		 System.out.println("recipeLink are:\n" + recipeLink);
		
		xlUtils.setCellData( i, 0, title);
		xlUtils.setCellData( i, 1, category);
		xlUtils.setCellData( i, 2, ingredients);
		xlUtils.setCellData( i, 3, recipeSteps);
		xlUtils.setCellData( i, 4, nutriotionVal);
		xlUtils.setCellData( i, 5, imageLink);
		xlUtils.setCellData( i, 6, recipeLink);
		
		driver.navigate().back();
	
	 }
	 System.out.println(category+"  Recipes has been scrapped");
//	 driver.close();
	 }
	
}
