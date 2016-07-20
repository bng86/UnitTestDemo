package tw.andyang.unittestdemo.test;

import android.support.annotation.IdRes;
import android.test.ActivityInstrumentationTestCase2;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tw.andyang.unittestdemo.MainActivity;
import tw.andyang.unittestdemo.R;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

@CucumberOptions(features = "features")
public class PotterUiTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public PotterUiTest() {
        super(MainActivity.class);
    }

    @Given("^打開 MainActivity$")
    public void 打開MainActivity() throws Throwable {
        assertNotNull(getActivity());
    }

//    @When("^買第(\\d+)集(\\d+)本$")
//    public void 買第集本(int episode, int amount) throws Throwable {
//        switch (episode) {
//            case 1:
//                selectSpinner(R.id.spinnerI, amount);
//                break;
//            case 2:
//                selectSpinner(R.id.spinnerII, amount);
//                break;
//            case 3:
//                selectSpinner(R.id.spinnerIII, amount);
//                break;
//            case 4:
//                selectSpinner(R.id.spinnerIV, amount);
//                break;
//            case 5:
//                selectSpinner(R.id.spinnerV, amount);
//                break;
//        }
//    }

    private void selectSpinner(@IdRes int id, int amount) {
        onView(withId(id)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is(String.valueOf(amount)))).perform(click());
    }


    @When("^計算價格$")
    public void 計算價格() throws Throwable {
        onView(withId(R.id.btnCalculate))
                .perform(click());
    }

    @Then("^總共(\\d+)元$")
    public void 總共元(int total) throws Throwable {
        onView(withId(R.id.textPrice))
                .check(matches(withText(getActivity().getString(R.string.price, total))));
    }

    @When("^買第一集(\\d+)本第二集(\\d+)本第三集(\\d+)本第四集(\\d+)本第五集(\\d+)本$")
    public void 買第一集Book1本第二集Book2本第三集Book3本第四集Book4本第五集Book5本(int book1, int book2, int book3, int book4, int book5) throws Throwable {
        selectSpinner(R.id.spinnerI, book1);
        selectSpinner(R.id.spinnerII, book2);
        selectSpinner(R.id.spinnerIII, book3);
        selectSpinner(R.id.spinnerIV, book4);
        selectSpinner(R.id.spinnerV, book5);
    }
}
