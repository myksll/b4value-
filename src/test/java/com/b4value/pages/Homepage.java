package com.b4value.pages;

import com.b4value.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Homepage {

    public Homepage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

	@FindBy(xpath = "//*[@id=\"module-93\"]/li[5]/a")
	public static WebElement jobsBtn;

    @FindBy(xpath = "//*[@id=\"ccm-widget\"]/div/div[2]/div[2]/button[3]")
    public static WebElement cookie;




}
