package net.serenitybdd.demos.todos.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.demos.todos.pages.components.ToDoList;
import net.serenitybdd.screenplay.tasks.Click;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.lang.reflect.Array;
import java.util.List;

import static ch.lambdaj.Lambda.extractProperty;

@DefaultUrl("http://todomvc.com/examples/angularjs/#/")
public class TodoPage extends PageObject {

    public static final String ACTION_ROW_LABEL = "//label[contains(.,'%s')]";

    public void addAnActionCalled(String actionName) {
        $("input[class*='new-todo']").type(actionName)
                .then().sendKeys(Keys.ENTER);
    }

    private WebElementFacade inActionRowLabelFor(String action) {
        return $(String.format(ACTION_ROW_LABEL, action));
    }

    public List<String> getActions() {
        return extractProperty(findAll(".view"),"text");
    }

    public List<String> getActiveActions() {
        return extractProperty(findAll("li[class='ng-scope']"),"text");
    }

    public List<String> getCompletedActions() {
        System.out.println( "Completed actions: " + extractProperty(findAll(By.cssSelector("li[class='ng-scope completed']")),"text"));
        return extractProperty(findAll(By.cssSelector("li[class='ng-scope completed']")),"text");
    }

    // TODO: change this locator as currently it counts all TODOS, not only remaining ones
    public int remainingTodoCount() {
        int remainingFields = findAll("li[class='ng-scope']").size();
        // int remainingFields = findAll(".view").size();
        System.out.println( "Remaining TODOs: " + remainingFields);
        return remainingFields;
    }

    public void completeTheAction(String action){

        Click.on(ToDoList.completeButtonFor(action));
////        waitFor(element(find(By.xpath("//li[@class='ng-scope']/div/label"))));
//        List<WebElementFacade> actions = findAll("//li[@class='ng-scope']/div/label");
////        List<WebElementFacade> actions = findAll(By.cssSelector("li[class='ng-scope']"));
//        List<String> actionNames = extractProperty(findAll(By.cssSelector( "li[class='ng-scope']>div>label" )), "text");
//        List<WebElementFacade> actionCheckboxes = findAll(By.cssSelector("li[class='ng-scope']>div>input"));
//        System.out.println("1");
//        for( int i = 0; i <= actions.size(); i++ ) {
//            System.out.println("Actions size: " + actions);
//
//            System.out.println("2");
//            if(action == actionNames.get(i)) {
//                // if(action == String.valueOf(actionNames.get(i))) {
//                System.out.println("Action name" + actionNames.get(i));
//                System.out.println("0000000000000000000000000");
//                find(By.cssSelector("li div input")).click();
////                actionCheckboxes.get(i).click();
//                System.out.println("4");
//            }
        }
//    }
}
