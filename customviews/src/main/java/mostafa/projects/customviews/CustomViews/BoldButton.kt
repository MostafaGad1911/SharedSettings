package mostafa.projects.customviews

import android.content.Context
import android.graphics.Typeface
import android.text.InputType
import android.util.AttributeSet
import android.util.TypedValue
import mostafa.projects.customviews.R

class BoldButton(context: Context, attrs: AttributeSet?) : androidx.appcompat.widget.AppCompatButton(context, attrs) {
    var a = context.obtainStyledAttributes(
        attrs,
        R.styleable.FieldLayout,
        0, 0
    )
    init {
        try {
            this.inputType = InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS
            this.typeface = Typeface.createFromAsset(context.assets, "popin_sb.ttf")
             val fontSize = a.getDimensionPixelSize(R.styleable.FieldLayout_right_detail_text_size, 15)
            this.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize.toFloat())
        }catch (e:Exception){}
    }
}