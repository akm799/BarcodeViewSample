package uk.co.akm.util.barcode.sample.barcodeviewsample

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.SeekBar
import uk.co.akm.util.barcode.lib.barcodeviewlib.view.BarcodeView
import java.text.DecimalFormat

abstract class BaseBarcodeActivity : AppCompatActivity() {

    abstract val textInput: EditText

    fun onShow(view: View) {
        val text = textInput.text.toString()
        if (text.isNotEmpty() && text.isNotBlank()) {
            onTextInputReceived(text)
        }

        dismissKeyboard(view)
    }

    abstract fun onTextInputReceived(text: String)

    // https://stackoverflow.com/questions/1109022/close-hide-the-android-soft-keyboard
    private fun dismissKeyboard(view: View) {
        val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0)
    }
}