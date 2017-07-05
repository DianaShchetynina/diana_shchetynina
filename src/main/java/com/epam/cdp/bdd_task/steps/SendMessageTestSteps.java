package com.epam.cdp.bdd_task.steps;

import com.epam.cdp.bdd_task.core.BaseSteps;
import com.epam.cdp.bdd_task.pages.LoginPage;
import com.epam.cdp.bdd_task.pages.MessageDetailsPage;
import com.epam.cdp.bdd_task.pages.MessagePage;
import com.epam.cdp.bdd_task.util.Constants;
import com.epam.cdp.bdd_task.util.PropertiesReader;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class SendMessageTestSteps extends BaseSteps {
    private LoginPage loginPage;
    private MessagePage messagePage;
    private MessageDetailsPage messageDetailsPage;

    @BeforeScenario
    public void beforeMethod() {
        loginPage = new LoginPage(getDriver());
        messagePage = new MessagePage(getDriver());
        messageDetailsPage = new MessageDetailsPage(getDriver());
    }

    @Given("I am on www.mail.google.com")
    public void navigateToGmail() {
        loginPage.openUrl(Constants.URL);
    }

    @When("I login into gmail account with valid credentials ${email} ${password}")
    public void loginInGmail(String email, String password) {
        loginPage.typeEmail(email)
                .typePassword(password)
                .signIn();
    }

    @When("I click 'write' button so then message popup should be open and i could fill in all needed fields to send created mail  with ${recipient} ${subject} ${message} data")
    public void sendMessage(String recipient, String subject, String message) {
        messagePage.sendMessage(recipient, subject, message);
        messagePage.openAllMessage();
    }

    @When("I find sent message  by sender ${sender} and open it")
    public void openSentMessage(String sender) {
        messagePage.openSentMessage(sender);
    }

    @Then("I verify correctness of sent message by subject ${subject}")
    public void checkSentMessage(String subject) {
        Assert.assertEquals(subject, messageDetailsPage.getMessageSubject());
    }

}
