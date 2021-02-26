package  mostafa.projects.customviewes

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.TypedValue

class TitleMediumTextView(context: Context, attrs: AttributeSet?) : androidx.appcompat.widget.AppCompatTextView(context, attrs) {
    var a = context.obtainStyledAttributes(
        attrs,
        R.styleable.FieldLayout,
        0, 0
    )
    init {
        try {
            this.typeface = Typeface.createFromAsset(context.assets, "poppins_medium.ttf")
            val fontSize = a.getDimensionPixelSize(R.styleable.FieldLayout_right_detail_text_size, 13)
            this.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize.toFloat())
        }catch (e:Exception){}
    }
}