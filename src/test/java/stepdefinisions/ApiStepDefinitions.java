package stepdefinisions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pages.ReqresApipage;

public class ApiStepDefinitions {

    ReqresApipage reqresApiPage = new ReqresApipage();
    private String respondBody;
    private String requestBody;
    private Response response;

    @Given("I set the GET request for endpoint {string}")
    public void setupGETEndpoint(String endpoint) {
        reqresApiPage.setEndpoint(endpoint);
    }

    @Given("I set the POST request for endpoint {string}")
    public void setupPOSTEndpoint(String endpoint) {
        reqresApiPage.setEndpoint(endpoint);
    }

    @When("I send the GET request")
    public void sendGetRequest() {
        response = reqresApiPage.sendGetRequest();
        System.out.println(response.getBody().asString());
    }

    @Then("I should receive status code {int}")
    public void verifyreceivestatuscode(int expectedreceivestatuscode) {
        int actualreceivestatuscode = response.getStatusCode();
        System.out.println("actual receive status code : " + actualreceivestatuscode);
        Assert.assertEquals(expectedreceivestatuscode, actualreceivestatuscode);
    }

    @Then("the response body should contain {string}")
    public void verifyRespondContainsText(String text) {
        String respondBody = response.getBody().asString();
        Assert.assertTrue(respondBody.contains(text));

    }

    @Given("the resquest body  is:")
    public void theResquestBodyIs(String requestBody) {
        this.requestBody = requestBody;
    }

    @When("I send the POST request")
    public void iSendThePOSTRequest() {
        response = ReqresApipage.sendPOSTRequest(this.requestBody);
        System.out.println(response.getBody().asString());
    }
}