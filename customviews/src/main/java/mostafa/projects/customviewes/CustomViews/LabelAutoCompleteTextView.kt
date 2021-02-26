package mostafa.projects.customviewes

import android.content.Context
import android.graphics.Typeface
import android.text.InputType
import android.util.AttributeSet
import android.util.TypedValue
import android.view.ViewGroup
import android.view.WindowManager


class LabelAutoCompleteTextView(context: Context, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatAutoCompleteTextView(
        context,
        attrs
    ) {
    var a = context.obtainStyledAttributes(
        attrs,
        R.styleable.FieldLayout,
        0, 0
    )

    init {
        try {
            this.inputType = InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS
            this.typeface = Typeface.createFromAsset(context.assets, "arial.ttf")
            val fontSize =
                a.getDimensionPixelSize(R.styleable.FieldLayout_right_detail_text_size, 14)
            this.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize.toFloat())
            this.maxLines = 1
            this.setLines(1)
            this.isSingleLine = true
            this.layoutParams = ViewGroup.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, 45)
        } catch (e: Exception) {
        }

    }
}