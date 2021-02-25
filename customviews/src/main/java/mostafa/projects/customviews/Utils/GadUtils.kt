package mostafa.projects.customviews.Utils

import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayout
import java.util.regex.Pattern
import javax.inject.Inject


class GadUtils @Inject constructor() {


    fun tst() {
        println("Utils connection done")
        Log.i("CutUtilsTest", "Testing")
    }

    fun getDeviceType(): String {
        return "android"
    }

    fun enableTabs(tabLayout: TabLayout?, enable: Boolean?) {
        val viewGroup: ViewGroup = getTabViewGroup(tabLayout)!!
        if (viewGroup != null) for (childIndex in 0 until viewGroup.childCount) {
            val tabView = viewGroup.getChildAt(childIndex)
            if (tabView != null) tabView.isEnabled = enable!!
        }
    }





    private fun getTabViewGroup(tabLayout: TabLayout?): ViewGroup? {
        var viewGroup: ViewGroup? = null
        if (tabLayout != null && tabLayout.childCount > 0) {
            val view = tabLayout.getChildAt(0)
            if (view != null && view is ViewGroup) viewGroup = view
        }
        return viewGroup
    }


    private fun isEmailValid(email: String): Boolean {
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }

    fun HideView(view: View) {
        view.visibility = View.GONE
    }

    fun NotEmpty(value: String): Boolean {
        return !TextUtils.isEmpty(value)
    }

    fun isPhoneValid(phone: String): Boolean {
        var valid: Boolean? = false
        if (phone.trim().length < 11 || phone.trim().length > 15) {
            valid = false
        } else {
            valid = true
        }
        return valid
    }

    fun strongPass(pass: String): Boolean {
        val PASSWORD_REGEX = """(?=.*[A-Z]).{8,}""".toRegex()
        if (pass.matches(regex = PASSWORD_REGEX))
            return true
        else
            return false
    }

    
    fun getAcceptHeader(): String {
        return "application/json"
    }

    fun getContentType(): String {
        return "application/json"
    }

    fun DoubleWord(input: String): String? {
        return input.split(" ".toRegex())
            .toTypedArray()[1] // Create array of words and return the 0th word
    }


}