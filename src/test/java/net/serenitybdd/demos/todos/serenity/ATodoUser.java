package net.serenitybdd.demos.todos.serenity;

import net.serenitybdd.demos.todos.pages.TodoPage;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class ATodoUser {

    TodoPage onTheTodoHomePage;

    @Step
    public void opens_the_todo_application() {
        onTheTodoHomePage.open();
    }

    // @Step
    // public void adds_an_action_called(String actionName) {
    //     onTheTodoHomePage.addAnActionCalled(actionName);
    // }

    @Step
    public void has_added_actions_called(String... actionNames) {
        for(String actionName: actionNames) {
            onTheTodoHomePage.addAnActionCalled(actionName);
        }
    }

    @Step
    public void should_see_the_todo_action(String action) {
        assertThat(onTheTodoHomePage.getActions()).contains(action);
    }

    @Step
    public void should_see_the_todo_action_in_active_items(String action) {
        assertThat(onTheTodoHomePage.getActiveActions()).contains(action);
    }
    
    @Step
    public void should_see_remaining_todo_count_of(int count) {
        assertThat(onTheTodoHomePage.remainingTodoCount()).isEqualTo(count);
    }

    @Step
    public void mark_the_action_as_complete(String action) {
        onTheTodoHomePage.completeTheAction(action);
    }

    @Step
    public void should_see_the_todo_action_completed(String action) {
        assertThat(onTheTodoHomePage.getCompletedActions()).contains(action);
    }
}