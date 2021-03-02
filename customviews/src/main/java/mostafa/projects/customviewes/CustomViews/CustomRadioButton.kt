package mostafa.projects.customviewes

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.TypedValue

class CustomRadioButton(context: Context, attrs: AttributeSet?) : androidx.appcompat.widget.AppCompatRadioButton(context, attrs) {
    var a = context.obtainStyledAttributes(
        attrs,
        R.styleable.FieldLayout,
        0, 0
    )
    init {
        try {
            this.typeface = Typeface.createFromAsset(context.assets, "arial.ttf")
            val fontSize = a.getDimensionPixelSize(R.styleable.FieldLayout_right_detail_text_size, 15)
            this.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize.toFloat())
        }catch (e:Exception){}

    }
}