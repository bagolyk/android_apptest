package com.example.neptunname;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityBlackBoxTest() {
        ViewInteraction textView = onView(
                allOf(withText("NeptunName"),
                        withParent(allOf(withId(R.id.action_bar),
                                withParent(withId(R.id.action_bar_container)))),
                        isDisplayed()));
        textView.check(matches(withText("NeptunName")));

        ViewInteraction inputText = onView(withId(R.id.myEditText));
        inputText.perform(click());
        inputText.perform(replaceText("Kuni"));
        inputText.perform(closeSoftKeyboard());

        ViewInteraction neptunButton = onView(withId(R.id.neptunButton));
        neptunButton.perform(click());

        inputText.check(matches(withText("Kuni")));

        ViewInteraction resultView = onView(withId(R.id.myTextView));
        resultView.check(matches(withText("You're result: 9uni")));

        ViewInteraction asciiButton = onView(withId(R.id.asciiButton));
        inputText.check(matches(withText("Kuni")));
        asciiButton.perform(click());
        resultView.check(matches(withText("You're result: 407")));

        neptunButton.perform(click());
        resultView.check(matches(withText("You're result: 9uni")));
    }

    @Test
    public void mainActivityUIOnlyTest() {

        String input = "K9PGL0";
        NeptunChanger nc = new NeptunChanger();

        ViewInteraction inputText = onView(withId(R.id.myEditText));
        inputText.perform(click());
        inputText.perform(replaceText(input));
        inputText.perform(closeSoftKeyboard());

        ViewInteraction neptunButton = onView(withId(R.id.neptunButton));
        neptunButton.perform(click());

        inputText.check(matches(withText(input)));

        ViewInteraction resultView = onView(withId(R.id.myTextView));
        resultView.check(matches(withText("You're result: " + nc.neptunIdchanger(input))));

        ViewInteraction asciiButton = onView(withId(R.id.asciiButton));
        inputText.check(matches(withText(input)));
        asciiButton.perform(click());
        resultView.check(matches(withText("You're result: " + nc.asciiSum(input))));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
