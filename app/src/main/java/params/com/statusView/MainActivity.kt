package params.com.statusView

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import params.com.stepview.StatusView
import params.com.stepview.StatusView.SelectionCallback
import java.util.*

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
            val statuses = mutableListOf<StatusView.StatusInfoItem>()
            for (index in 1..25) {
                val rnd = Random()
                val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
                statuses.add(StatusView.StatusInfoItem("#$index", color))
            }
            statusViewScroller.statusView.setStatusItems(statuses, 1)
        }, 4000)

    }


}
