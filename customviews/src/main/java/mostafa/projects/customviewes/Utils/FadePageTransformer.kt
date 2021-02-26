package mostafa.projects.customviewes.Utils

import android.view.View
import androidx.viewpager2.widget.ViewPager2

internal class FadePageTransformer : ViewPager2.PageTransformer {
    override fun transformPage(view: View, position: Float) {
        view.alpha = 1 - Math.abs(position)
        if (position < 0) {
            view.scrollX = (view.width.toFloat() * position).toInt()
        } else if (position > 0) {
            view.scrollX = (-(view.width.toFloat() * -position)).toInt()
        } else {
            view.scrollX = 0
        }
    }
}