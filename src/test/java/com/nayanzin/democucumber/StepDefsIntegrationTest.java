package com.nayanzin.democucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.http.HttpStatus;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StepDefsIntegrationTest extends SpringIntegrationTest {

    @When("^клиент делает запрос на GET /version$")
    public void the_client_issues_GET_version() {
        executeGet(VERSION);
    }

    @Then("^response code (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws IOException {
        HttpStatus currentStatusCode = latestResponse.getResponse().getStatusCode();
        assertThat("Status code is incorrect : " +
                latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
    }

    @And("^клиент получает версию (.+)$")
    public void the_client_receives_server_version_body(String version) {
        assertThat("Непрвильная версия: " + latestResponse.getBody(),
                latestResponse.getBody(), is(version));
    }
}
