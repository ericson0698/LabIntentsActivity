import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.provider.Settings.ACTION_DISPLAY_SETTINGS
import android.widget.Button
import android.widget.Toast
import com.example.LabIntentsActivity.R


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        findViewById<Button>(R.id.openDate).setOnClickListener { openDateSettings() }
        findViewById<Button>(R.id.openDis).setOnClickListener { openDisplay() }
        findViewById<Button>(R.id.openWifi).setOnClickListener { openWifiSettings() }
        findViewById<Button>(R.id.openInstagram).setOnClickListener { openIG() }
        findViewById<Button>(R.id.openMozila).setOnClickListener { openMozillaBrowser() }

    }


    private fun openDateSettings() {
        val intent = Intent(Settings.ACTION_DATE_SETTINGS)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun openDisplay() {
        val intent = Intent(ACTION_DISPLAY_SETTINGS)
        startActivity(intent)
    }

    private fun openWifiSettings() {
        val intent = Intent(Settings.ACTION_WIFI_SETTINGS)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun openIG() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.setPackage("com.android.instagram")
        if (intent.resolveActivity(this.packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(
                applicationContext,
                "The intent failed due to application not recognized.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun openMozillaBrowser() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.setPackage("com.android.mozilla")
        if (intent.resolveActivity(this.packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(
                applicationContext,
                "The intent failed due to application not recognized.",
                Toast.LENGTH_SHORT
            ).show()
        }

    }


}

