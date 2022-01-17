package pages;

import data.User;
import net.thucydides.core.annotations.Step;

public class TextBox {

    TextBoxPage textBoxPage;

    @Step("Opening the TextBox page")
    public void openTextBoxPage(){
        textBoxPage.open();
    }

    @Step("Filling the TextBox form and submitting the info")
    public void fillFormAndSubmit(User user){
        if(user.getFull_name()!=null){
            textBoxPage.enterFullName(user.getFull_name());
        }
        if(user.getEmail()!=null){
            textBoxPage.enterEmail(user.getEmail());
        }
        if(user.getCurrent_address()!=null){
            textBoxPage.enterCurrentAddress(user.getCurrent_address());
        }
        if(user.getPermanent_address()!=null){
            textBoxPage.enterPermanentAddress(user.getPermanent_address());
        }
        textBoxPage.submitForm();
    }

    @Step("Checking results returned after submitting the form")
    public void checkResults(User user) {

        if (textBoxPage.resultsReturned()){
            if(user.getFull_name()!=null){
                textBoxPage.checkFullNameResult(user.getFull_name());
            }
            if(user.getEmail()!=null){
                textBoxPage.checkEmailResult(user.getEmail());
            }
            if(user.getCurrent_address()!=null){
                textBoxPage.checkCurrentAddressResult(user.getCurrent_address());
            }
            if(user.getPermanent_address()!=null){
                textBoxPage.checkPermanentAddressResult(user.getPermanent_address());
            }
        }
        textBoxPage.pauseInterval(5);
    }

    @Step("Checking error after submitting invalid piece of indfo")
    public void checkErrors(User user) {
        if (!textBoxPage.resultsReturned()){
            if(user.getEmail()!=null){
                textBoxPage.checkEmailError();
            }
        }
        textBoxPage.pauseInterval(5);
    }
}
