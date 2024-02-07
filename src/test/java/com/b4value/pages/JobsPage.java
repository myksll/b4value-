package com.b4value.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobsPage extends Homepage{

    @FindBy(xpath="/html/body/div[2]/main/div[4]/div/div/div[1]/div/div[2]/div/div[2]/a")
    public static  WebElement jobPortalBtn;

    @FindBy(css="#\\33 -20")
    public static WebElement searchInput;

    @FindBy(xpath="//*[@id=\"65-21\"]")
    public static WebElement searchBtn ;

    @FindBy(xpath = "//*[@id=\"5-5\"]/a/h2")
    public  static WebElement firstResultTitle ;

    @FindBy(xpath = "//*[@id=\"weshalbb4\"]/div/div/div[1]")
    public static WebElement iframe ;

    @FindBy(xpath = "//*[@id=\"3-103\"]")
    public static WebElement jobPortaliFRAME ;


}