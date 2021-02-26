package mostafa.projects.customviewes

import android.content.Context
import android.graphics.Typeface
import android.text.InputType
import android.util.AttributeSet
import android.util.TypedValue


class LabelTextView(context: Context, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatTextView(
        context,
        attrs
    ) {

    init {
        try {
            var a = context.obtainStyledAttributes(
                attrs,
                R.styleable.FieldLayout,
                0, 0
            )
            this.inputType = InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS
            this.typeface = Typeface.createFromAsset(context.assets, "popin_sb.ttf")
            this.typeface = Typeface.DEFAULT_BOLD
            val fontSize =
                a.getDimensionPixelSize(R.styleable.FieldLayout_right_detail_text_size, 14)
            this.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize.toFloat())
        } catch (e: Exception) {
        }

    }
}