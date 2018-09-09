package uk.co.akm.util.barcode.sample.barcodeviewsample

import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_dim_fixed.*

class FixedDimensionsActivity : BaseBarcodeActivity() {

    override val textInput: EditText
        get() = barcodeTextInput

    override fun onTextInputReceived(text: String) {
        barcodeView.text = text
        barcodeViewText.text = text
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dim_fixed)
        setTitle(R.string.fixed_dimensions_title)
    }

    override fun onResume() {
        super.onResume()

        if (barcodeView.hasText) {
            barcodeViewText.text = barcodeView.text
        }
    }
}