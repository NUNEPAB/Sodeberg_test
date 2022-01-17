package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class TextBoxPage extends PageObject {

    @FindBy(id="userName")
    private WebElement input_userName;

    @FindBy(id="userName-label")
    private WebElement label_userName;

    @FindBy(id="userEmail")
    private WebElement input_email;

    @FindBy(id="userEmail-label")
    private WebElement label_email;

    @FindBy(id="currentAddress")
    private WebElement input_currentAddress;

    @FindBy(id="currentAddress-label")
    private WebElement label_currentAddress;

    @FindBy(id="permanentAddress")
    private WebElement input_permanentAddress;

    @FindBy(id="permanentAddress-label")
    private WebElement label_permanentAddress;

    @FindBy(id="submit")
    private WebElement button_submit;

    @FindBy(xpath = "//div[@id='output']/div")
    private WebElement resultList;

    @FindBy(id="name")
    private WebElement result_name;

    @FindBy(id="email")
    private WebElement result_email;

    @FindBy(id="currentAddress")
    private WebElement result_currentAddress;

    @FindBy(id="permanentAddress")
    private WebElement result_permanentAddress;

    private static String result_name_label = "Name:";
    private static String result_email_label = "Email:";
    private static String result_currentAddress_label = "Current Address :";
    private static String result_permanentAddress_label = "Permanent Address :";

    public void enterFullName(String value){
        input_userName.sendKeys(value);
    }

    public void enterEmail(String value){
        input_email.sendKeys(value);
    }

    public void enterCurrentAddress(String value){
        input_currentAddress.sendKeys(value);
    }

    public void enterPermanentAddress(String value){
        input_permanentAddress.sendKeys(value);
    }

    public void submitForm(){
        button_submit.click();
    }

    public boolean resultsReturned(){
        boolean returned = true;

        try{
            resultList.findElements(By.xpath(".//p"));
        }catch (ElementNotVisibleException enve){
            returned = false;
        }

        return returned;
    }

    public void checkFullNameResult(String value){
            String result_name_formatted = result_name.getText().replace(result_name_label,"");
            Assert.assertEquals("Name returned does not match",result_name_formatted,value);
    }

    public void checkEmailResult(String value){
        String result_email_formatted = result_email.getText().replace(result_email_label,"");
        Assert.assertEquals("Email successfully processed",result_email_formatted,value);
    }

    public void checkCurrentAddressResult(String value){
        String result_currentAddress_formatted = result_currentAddress.getAttribute("value").replace(result_currentAddress_label,"");
        Assert.assertEquals("Current Address successfully processed",
                result_currentAddress_formatted,value);
    }

    public void checkPermanentAddressResult(String value){
        String result_permanentAddress_formatted = result_permanentAddress.getAttribute("value").replace(result_permanentAddress_label,"");
        Assert.assertEquals("Permanent Address successfully processed",
                result_permanentAddress_formatted,value);
    }

    public void pauseInterval(int sec) {
        waitABit(sec*1000);
    }

    public void checkEmailError(){
        Assert.assertTrue("Error mark successfully displayed for "+label_email,
                input_email.getAttribute("class").contains("field-error"));
    }

}
