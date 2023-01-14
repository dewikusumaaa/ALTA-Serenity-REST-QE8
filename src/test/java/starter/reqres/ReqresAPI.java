package starter.reqres;

import java.io.File;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.reqres.Utils.Constant;

import static starter.reqres.Utils.Constant.BASE_URL;


public class ReqresAPI {
//    public static String BASE_URL = "https://reqres.in"; //ini base URL
//    public static final String DIR = System.getProperty("user.dir"); //ini untuk dapatkan location project
//    public static String JSON_REQUEST = DIR+"/src/test/resources/JSON/Request"; //untuk path JSON Request
//    public static String JSON_SCHEMA = DIR+"/src/test/resources/JSON/JsonSchema"; //untuk path JSON Schema

    public static String GET_LIST_USERS = BASE_URL + "/api/users?page={page}"; //untuk URL get list users

    public static String POST_CREATE_USER = BASE_URL + "/api/users"; //untuk URL create user
    public static String PUT_UPDATE_USER = BASE_URL + "/api/users/{id}"; //untuk URL update user
    public static String DELETE_USER = BASE_URL + "/api/users/{id}"; //untuk URL delete user

    public static String LOGIN_USER = BASE_URL + "/api/login"; //untuk url login user
    public static String REGISTER_USER = BASE_URL + "/api/register"; //untuk url register
    public static final String GET_LIST_RESOURCES = BASE_URL+"/api/unknown?page={page}";




    //METHOD
    //Get list users
    @Step("Get list users") //valid get list user
    public void getListUsers(int page) {

        SerenityRest.given().pathParam("page", page);
    }

    //invalid get list users
    @Step("Get list users invalid") //untuk invalid get list user
    public void getListUsersInvalid(String page) {

        SerenityRest.given().pathParam("page", page);
    }

    //create user
    @Step("Post create user")
    public void postCreateUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //updte user
    @Step("Put update user")
    public void putUpdateUser(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //delete user
    @Step("Delete user")
    public void deleteUser(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Delete user String id")
    public void deleteUserStringId(String id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    //Login
    @Step("Login user with valid id")
    public void loginUser(File json) {
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("Login invalid user")
    public void loginInvalidUser(File json) {
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    //Register
    @Step("Register valid user")
    public void RegisterValidUser(File json) {
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("Register invalid user")
    public void registerInvalidUser(File json) {
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    //Get list resource
    @Step("Get list Resource with valid parameter")
    public void getListResourceWithValidParameter(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }

    @Step("Get list Resource with invalid parameter")
    public void getListResourceWithInvalidParameter(String page){
        SerenityRest.given()
                .pathParam("page", page);
    }

}


