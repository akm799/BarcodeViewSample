package uk.co.akm.util.barcode.sample.barcodeviewsample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onFixedDimensions(view: View) {
        startActivity(Intent(this, FixedDimensionsActivity::class.java))
    }

    fun onFreeDimensions(view: View) {
        startActivity(Intent(this, FreeDimensionsActivity::class.java))
    }
}
