package stepDefinitions;

import pages.TextBox;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import data.User;
import net.thucydides.core.annotations.Steps;
import utils.ScreenRecorderUtil;
import utils.Utils;
import static org.junit.Assert.*;

public class FormStepDefinitions {

    @Steps
    private TextBox textBox;

    private User user = null;

    @Before
    public void setup() {
        Utils.JSONtoUserList();
    }

    @Given("user (.*) is in the form page")
    public void userIsInTheFormPage(String userId) {
        try{
            ScreenRecorderUtil.startRecord("Sodeberg");
        }catch (Exception e){
            e.printStackTrace();
        }
        user = Utils.getUserFromList(Integer.parseInt(userId));
        assertNotNull(user);
        textBox.openTextBoxPage();
    }

    @When("form is filled and submited")
    public void formIsFilledAndSubmited() {
        textBox.fillFormAndSubmit(user);
    }

    @Then("result match input data")
    public void resultMatchInputData() {

        textBox.checkResults(user);
        try{
            ScreenRecorderUtil.stopRecord();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Then("error is displayed")
    public void errorIsDisplayed()  {

        textBox.checkErrors(user);
        try{
            ScreenRecorderUtil.stopRecord();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
