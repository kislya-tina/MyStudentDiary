package mystudent.diary.view.main.ui.home.dates

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mystudent.diary.R
import java.sql.Date
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DateListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun onBind(position: LocalDate) {
        date = itemView.findViewById(R.id.week)
        weekName = itemView.findViewById(R.id.day)

        val formatter = DateTimeFormatter.ofPattern("EEE")

        date?.text = position.dayOfMonth.toString()
        weekName?.text = position.format(formatter).toString()
    }

    private var date: TextView? = null
    private var weekName: TextView? = null
    private var onItemClick: ((LocalDate, Int) -> Unit)? = null
//    private var selectedItem =
}