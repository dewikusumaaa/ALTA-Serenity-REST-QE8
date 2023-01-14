package starter.reqres.StepDef;

import java.io.File;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;
import starter.reqres.Utils.ReqresResponses;

import static org.hamcrest.Matchers.equalTo;

public class CreateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(Constant.JSON_REQUEST+"/RequestUser.json");
        reqresAPI.postCreateUser(json);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @And("Response body name should be {string} and job {string}")
    public void responseBodyNameShouldBeAndJob(String name, String job) {
        SerenityRest.then()
                    .body(ReqresResponses.NAME,equalTo(name))
                    .body(ReqresResponses.JOB,equalTo(job));
    }

    @And("Validate json schema create user")
    public void validateJsonSchemaCreateUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/CreateUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
