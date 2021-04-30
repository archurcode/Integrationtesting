package com.archur.integrationtesting;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityEspressoTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule=
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void changeTextNewActivity(){
        //type text
        onView(withId(R.id.first)).perform(typeText("1"));
        onView(withId(R.id.second)).perform(typeText("1"));

        //press the button
        onView(withId(R.id.button)).perform(click());

        //check the result
        onView(withId(R.id.second_res)).check(matches(withText("结果是：2")));
    }
}
