package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;
import starter.reqres.Utils.ReqresResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ListResourceStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("get list resource with valid page {int}")
    public void getSingleResourceWithPage(int page) {
        reqresAPI.getListResourceWithValidParameter(page);
    }

    @Given("get list resource with invalid page {string}")
    public void getListResourceWithInvalidPage(String page) {
        reqresAPI.getListResourceWithInvalidParameter(page);
    }

    @When("Send request get list resources")
    public void sendRequestGetListResource() {
        SerenityRest.when()
                .get(ReqresAPI.GET_LIST_RESOURCES);
    }

    @Then("Response body should contain id {int}, name {string}, year {int}, color {string}, and pantone_value {string}")
    public void responseBodyShouldContainIdNameYearColorAndPantone_value(int id, String name, int year, String color, String pantoneValue) {
        SerenityRest.then()
                .body(ReqresResponses.ID_LIST_RESOURCES,equalTo(id))
                .body(ReqresResponses.NAME_LIST_RESOURCES,equalTo(name))
                .body(ReqresResponses.YEAR_LIST_RESOURCES,equalTo(year))
                .body(ReqresResponses.COLOR,equalTo(color))
                .body(ReqresResponses.PANTONE_VALUE,equalTo(pantoneValue));
    }

    @And("Get list resource assert json validation")
    public void getListResourceAssertJsonValidation() {
        File jsonFile = new File(Constant.JSON_SCHEMA+"/ListResource.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Then("Response body should contain name {string}, color {string}, and pantone_value {string}")
    public void responseBodyShouldContainNameColorAndPantone_value(String name, String color, String pantoneValue) {
        SerenityRest.then()
                .body(ReqresResponses.NAME_LIST_RESOURCES,equalTo(name))
                .body(ReqresResponses.COLOR,equalTo(color))
                .body(ReqresResponses.PANTONE_VALUE,equalTo(pantoneValue));
    }
}
