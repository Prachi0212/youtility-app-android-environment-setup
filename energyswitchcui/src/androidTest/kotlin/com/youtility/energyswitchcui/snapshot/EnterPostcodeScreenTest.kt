package com.youtility.energyswitchcui.snapshot

import android.support.test.rule.ActivityTestRule
import com.facebook.testing.screenshot.Screenshot
import com.youtility.energyswitchcui.scene.postcode.EnterPostcodeActivity
import com.youtility.energyswitchcui.scene.postcode.EnterPostcodeContract
import com.youtility.energyswitchcui.scene.postcode.EnterPostcodePresenter
import org.junit.Rule
import org.junit.Test

class EnterPostcodeScreenTest {

    @get:Rule
    public val activityTestRule: ActivityTestRule<EnterPostcodeActivity> = ActivityTestRule<EnterPostcodeActivity>(EnterPostcodeActivity::
    class.java, false, false);
    internal var name = javaClass.simpleName
    val instruction = "Let’s get started. What’s your postcode?"
    val description = "To get an energy quote we need to know your home address"

    @Test
    fun testScreenshotEntireActivity() {
        val activity = activityTestRule.launchActivity(null)
        val view: EnterPostcodeContract.View = activity
        val presenter = EnterPostcodePresenter(view)
        activity.runOnUiThread { presenter.presentInstructionAndDescription(instruction, description) }
        Screenshot.snapActivity(activity).setName(name + "Empty").record()
        activity.runOnUiThread { presenter.presentPostcode("SW21BH") }
        Screenshot.snapActivity(activity).setName(name + "Entered").record()
        activity.runOnUiThread {
            presenter.presentPostcode("4234 13131")
            presenter.presentPostcodeValidationResult("This doesn't appear to be a valid UK postcode",false)
        }
        Screenshot.snapActivity(activity).setName(name + "Validationfailed").record()
    }

}