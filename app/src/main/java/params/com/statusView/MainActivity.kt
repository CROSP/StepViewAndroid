package params.com.statusView

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import params.com.stepview.StatusView.SelectionCallback

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        statusViewScroller.statusView.run {
            currentCount = 2
            circleFillColorCurrent = Color.RED
        }
/*

        statusViewScroller.postDelayed({
            statusViewScroller.statusView.setSelectedItem(3)
        }, 4000)
*/

        statusViewScroller.statusView.selectionCallback = object : SelectionCallback {
            override fun onStatusItemSelected(position: Int, label: String) {
                Toast.makeText(baseContext, "HII $position $label", Toast.LENGTH_LONG).show()
            }
        }
        statusViewScroller.postDelayed({
            val statuses = mutableListOf<String>()
            statuses.add("First")
            statuses.add("Second")
            statuses.add("Third")
            statusViewScroller.statusView.setStatusItems(statuses, 1)
        }, 4000)

    }


}
