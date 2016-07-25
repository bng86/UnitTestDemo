package tw.andyang.unittestdemo.test;

import android.support.annotation.IdRes;
import android.test.ActivityInstrumentationTestCase2;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tw.andyang.unittestdemo.livedemo.LiveDemoActivity;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

@CucumberOptions(features = "features/demo")
public class PotterUITestDemo  extends ActivityInstrumentationTestCase2<LiveDemoActivity> {

    public PotterUITestDemo() {
        super(LiveDemoActivity.class);
    }

    @Given("^打開 LiveDemoActivity$")
    public void 打開LiveDemoActivity() throws Throwable {
        assertNotNull(getActivity());
    }

    @When("^第(\\d+)集(\\d+)本$")
    public void 第集本(int episode, int amount) throws Throwable {
        throw new PendingException();
    }

    @When("^計算總價$")
    public void 計算總價() throws Throwable {
        throw new PendingException();
    }

    @Then("^總價(\\d+)元$")
    public void 總價元(int price) throws Throwable {
        throw new PendingException();
    }

    private void selectSpinner(@IdRes int id, int amount) {
        if(amount == 0)
            return;
        onView(withId(id)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is(String.valueOf(amount)))).perform(click());
    }
}
