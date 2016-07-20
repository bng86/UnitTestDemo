package tw.andyang.unittestdemo.test;

import android.support.annotation.IdRes;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import tw.andyang.unittestdemo.MainActivity;
import tw.andyang.unittestdemo.R;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class PotterEspressoUiTest{

    @Rule
    public ActivityTestRule<MainActivity> testRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void GetPrice_第一集買了一本_其他都沒買_價格應為100_乘_1_等於_100元() throws Exception {
        assertNotNull(testRule.getActivity());
        selectSpinner(R.id.spinnerI, 1);
        onView(withId(R.id.btnCalculate))
                .perform(click());
        onView(withId(R.id.textPrice))
                .check(matches(withText(testRule.getActivity().getString(R.string.price, 100))));
    }

    @Test
    public void GetPrice_第一集買了一本_第二集也買了一本_價格應為100_乘_2_乘_0_點_95_等於_190() throws Exception {
        assertNotNull(testRule.getActivity());
        selectSpinner(R.id.spinnerI, 1);
        selectSpinner(R.id.spinnerII, 1);
        onView(withId(R.id.btnCalculate))
                .perform(click());
        onView(withId(R.id.textPrice))
                .check(matches(withText(testRule.getActivity().getString(R.string.price, 190))));
    }

    @Test
    public void GetPrice_一二三集各買了一本_價格應為100_乘_3_乘_0_點_9_等於_270() throws Exception {
        assertNotNull(testRule.getActivity());
        selectSpinner(R.id.spinnerI, 1);
        selectSpinner(R.id.spinnerII, 1);
        selectSpinner(R.id.spinnerIII, 1);
        onView(withId(R.id.btnCalculate))
                .perform(click());
        onView(withId(R.id.textPrice))
                .check(matches(withText(testRule.getActivity().getString(R.string.price, 270))));
    }

    @Test
    public void GetPrice_一二三四集各買了一本_價格應為100_乘_4_乘_0_點_8_等於_320() throws Exception {
        assertNotNull(testRule.getActivity());
        selectSpinner(R.id.spinnerI, 1);
        selectSpinner(R.id.spinnerII, 1);
        selectSpinner(R.id.spinnerIII, 1);
        selectSpinner(R.id.spinnerIV, 1);
        onView(withId(R.id.btnCalculate))
                .perform(click());
        onView(withId(R.id.textPrice))
                .check(matches(withText(testRule.getActivity().getString(R.string.price, 320))));
    }

    @Test
    public void GetPrice_一次買了整套_一二三四五集各買了一本_價格應為100_乘_5_乘_0_點_75_等於_375() throws Exception {
        assertNotNull(testRule.getActivity());
        selectSpinner(R.id.spinnerI, 1);
        selectSpinner(R.id.spinnerII, 1);
        selectSpinner(R.id.spinnerIII, 1);
        selectSpinner(R.id.spinnerIV, 1);
        selectSpinner(R.id.spinnerV, 1);
        onView(withId(R.id.btnCalculate))
                .perform(click());
        onView(withId(R.id.textPrice))
                .check(matches(withText(testRule.getActivity().getString(R.string.price, 375))));
    }

    @Test
    public void GetPrice_一二集各買了一本_第三集買了兩本_價格應為100_乘_3_乘_0_點_9_加_100_等於_370() throws Exception {
        assertNotNull(testRule.getActivity());
        selectSpinner(R.id.spinnerI, 1);
        selectSpinner(R.id.spinnerII, 1);
        selectSpinner(R.id.spinnerIII, 2);
        onView(withId(R.id.btnCalculate))
                .perform(click());
        onView(withId(R.id.textPrice))
                .check(matches(withText(testRule.getActivity().getString(R.string.price, 370))));
    }

    private void selectSpinner(@IdRes int id, int amount) {
        onView(withId(id)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is(String.valueOf(amount)))).perform(click());
    }

}
