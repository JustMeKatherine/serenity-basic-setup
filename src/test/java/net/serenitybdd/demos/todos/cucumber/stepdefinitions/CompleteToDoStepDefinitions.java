package net.serenitybdd.demos.todos.cucumber.stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.demos.todos.serenity.ATodoUser;
import net.serenitybdd.demos.todos.tasks.CompleteItem;
import net.thucydides.core.annotations.Steps;

public class CompleteToDoStepDefinitions {

    @Steps
    ATodoUser jane;

    @When("^I mark the (.*) action as complete$")
    public void iMarkTheActionAsComplete(String action) {
//        attemptsTo( CompleteItem.called(itemName));
        jane.mark_the_action_as_complete(action);
    }

    @Then("^(.*) should appear as completed$")
    public void ShouldAppearAsCompleted(String action) {
        jane.should_see_the_todo_action_completed(action);
    }
}
