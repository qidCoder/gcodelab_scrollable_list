package com.example.affirmations

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class) //test runner to run on a device or emulator
class AffirmationsListTests {
    //specify we want the activity to launch
    //ActivityScenarioRule comes from the AndroidX Test library. It tells the device to launch an
    //activity specified by the developer. You'll need to annotate it with @get:Rule, which specifies
    //that the subsequent rule, in this case launching an activity, should execute before every test
    //in the class. Test rules are an essential tool for testing
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun scroll_to_item(){
        onView(withId(R.id.recycler_view)).perform(
            RecyclerViewActions
                .scrollTo<RecyclerView.ViewHolder>(
                    withText(R.string.affirmation10)
                )
        )

        //make an assertion to ensure that the UI is displaying the expected information.
        // Make sure that once you have scrolled to the last item, the text associated with the final affirmation is displayed
        onView(withText(R.string.affirmation10))
            .check(matches(isDisplayed())
            )
    }

}
