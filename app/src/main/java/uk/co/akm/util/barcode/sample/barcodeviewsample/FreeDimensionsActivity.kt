package uk.co.akm.util.barcode.sample.barcodeviewsample

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_dim_free.*
import java.text.DecimalFormat

class FreeDimensionsActivity : BaseBarcodeActivity(), AdapterView.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener {
    private val moduleWidthsDp = arrayListOf(2, 3, 4, 5, 6, 7, 8)

    private val minWidthOverHeightRatio = 0.15f
    private val maxWidthOverHeightRatio = 10f
    private val widthOverHeightRatioDisplayFormat = DecimalFormat("0.00")

    override val textInput: EditText
        get() = barcodeTextInput

    override fun onTextInputReceived(text: String) {
        barcodeView.text = text
        setVisibility(dimControls, barcodeView.hasText)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dim_free)
        setTitle(R.string.free_dimensions_title)

        barcodeModuleWidth.adapter = ArrayAdapter<Int>(this, android.R.layout.simple_spinner_item, moduleWidthsDp)
        barcodeModuleWidth.onItemSelectedListener = this
        barcodeWidthOverHeightRatio.setOnSeekBarChangeListener(this)
    }

    override fun onResume() {
        super.onResume()

        setVisibility(dimControls, barcodeView.hasText)
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        barcodeView.setModuleWidthDp(moduleWidthsDp[position])
    }

    override fun onNothingSelected(itemView: AdapterView<*>?) {}

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        val widthOverHeightRatio = getValue(progress, minWidthOverHeightRatio, maxWidthOverHeightRatio)
        barcodeView.widthOverHeightRatio = widthOverHeightRatio
        barcodeWidthOverHeightRatioTxt.text = widthOverHeightRatioDisplayFormat.format(widthOverHeightRatio)
    }

    private fun getValue(progress: Int, min: Float, max: Float): Float = min + (progress/100f)*(max - min)

    override fun onStartTrackingTouch(seekBar: SeekBar?) {}

    override fun onStopTrackingTouch(seekBar: SeekBar?) {}

    private fun setVisibility(view: View, visible: Boolean) {
        val visibility = if (visible) View.VISIBLE else View.INVISIBLE
        if (view.visibility != visibility) {
            view.visibility = visibility
        }
    }
}