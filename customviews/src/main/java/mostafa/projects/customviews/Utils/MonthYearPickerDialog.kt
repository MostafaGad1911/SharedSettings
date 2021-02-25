package mostafa.projects.customviews.Utils

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.NumberPicker
import androidx.fragment.app.DialogFragment
import appssquare.projects.cut.R
import java.util.*


class MonthYearPickerDialog : DialogFragment() {
    private var listener: DatePickerDialog.OnDateSetListener? = null
    fun setListener(listener: DatePickerDialog.OnDateSetListener?) {
        this.listener = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        val inflater: LayoutInflater = requireActivity()!!.layoutInflater
        val cal = Calendar.getInstance()
        val dialog: View = inflater.inflate(R.layout.month_year_picker_dialog, null)
        val monthPicker: NumberPicker = dialog.findViewById<View>(R.id.picker_month) as NumberPicker
        val yearPicker: NumberPicker = dialog.findViewById<View>(R.id.picker_year) as NumberPicker
        monthPicker.setMinValue(1)
        monthPicker.setMaxValue(12)
        monthPicker.setValue(cal[Calendar.MONTH] + 1)
        val year = cal[Calendar.YEAR]
        yearPicker.setMinValue(year)
        yearPicker.setMaxValue(2100)
        yearPicker.setValue(year)
        builder.setView(dialog) // Add action buttons
            .setPositiveButton(R.string.ok, object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface, id: Int) {
                    listener?.onDateSet(null, yearPicker.getValue(), monthPicker.getValue(), 0)
                }
            })
            .setNegativeButton(R.string.cancel, object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface, id: Int) {
                    this@MonthYearPickerDialog.dialog!!.cancel()
                }
            })
        return builder.create()
    }

    companion object {
        private const val MAX_YEAR = 2099
    }
}