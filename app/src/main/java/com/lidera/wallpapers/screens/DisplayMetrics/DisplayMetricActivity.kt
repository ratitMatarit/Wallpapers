package com.lidera.wallpapers.screens.DisplayMetrics

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.lidera.wallpapers.R
import com.lidera.wallpapers.screens.MainActivity
import com.lidera.wallpapers.storage.PreferencesManager
import kotlinx.android.synthetic.main.activity_display_metric.*

class DisplayMetricActivity : AppCompatActivity() {

    private val viewModel: DisplayMetricViewModel by lazy {
        ViewModelProvider(this)[DisplayMetricViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (PreferencesManager.firstOpenApp) {
            startActivity(Intent(this, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION))
        } else {
            setContentView(R.layout.activity_display_metric)
            viewModel.getDisplaySize(this@DisplayMetricActivity)
            txtMetricPhoneName.text = viewModel.getDeviceName()
            txtMetricScreenSize.text = resources.getString(R.string.screen_metrics, viewModel.screenWidth, viewModel.screenHeight)

            btnMetricProceed.setOnClickListener {
                PreferencesManager.userScreenWidth = viewModel.screenWidth
                PreferencesManager.userScreenHeight = viewModel.screenHeight
                PreferencesManager.firstOpenApp = true
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }
}