package mystudent.diary.view.main.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mystudent.diary.R
import java.time.LocalDate
import java.time.Month
import java.time.format.DateTimeFormatter

class DateListAdapter : RecyclerView.Adapter<DateListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.date_item_list, parent, false)
        for (i in 1..10){
            dateList = dateList.plus(dateList.last().plusDays(1))
        }
        return DateListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dateList.count()
    }

    override fun onBindViewHolder(holder: DateListViewHolder, position: Int) {
        holder.onBind(dateList[position])
    }

    private var dateList: List<LocalDate> = listOf(LocalDate.now())
}