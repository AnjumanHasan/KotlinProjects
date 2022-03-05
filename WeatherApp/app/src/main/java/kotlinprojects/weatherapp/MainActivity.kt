package kotlinprojects.weatherapp

import android.os.AsyncTask
import android.os.AsyncTask.execute
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    val city : String = "New Delhi,IN"
    val API : String = "e7919300e189ee64e9624a1d94739939"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weatherTask().execute()
    }

    inner class weatherTask () : AsyncTask<String, Void, String>()
    {
        override fun onPreExecute() {
            super.onPreExecute()
            findViewById<ProgressBar>(R.id.loader).visibility =  View. VISIBLE
            findViewById<ConstraintLayout>(R.id.maincontainer).visibility = View.GONE
            findViewById<TextView>(R.id.errortext).visibility = View.GONE

        }

        override fun doInBackground(vararg p0: String?): String {

        }
    }

}