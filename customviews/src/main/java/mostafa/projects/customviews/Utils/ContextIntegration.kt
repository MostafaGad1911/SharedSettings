package mostafa.projects.customviews.Utils

import android.app.Application
import java.lang.ref.WeakReference

object ContextIntegration {

    private lateinit var applicationReference : WeakReference<Application>

    fun with(application: Application){
        applicationReference = WeakReference(application)
    }

    fun getApplication() = applicationReference.get()

}