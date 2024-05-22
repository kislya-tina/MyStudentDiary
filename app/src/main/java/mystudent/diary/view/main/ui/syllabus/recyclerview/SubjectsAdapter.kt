package mystudent.diary.view.main.ui.syllabus.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mystudent.diary.R
import mystudent.diary.presentation.main.ui.syllabus.SyllabusFragmentPresenter

class SubjectsAdapter(private val presenter: SyllabusFragmentPresenter): RecyclerView.Adapter<SubjectsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.subject_fragment, parent, false)
        return SubjectsViewHolder(presenter, view)
    }

    override fun onBindViewHolder(holder: SubjectsViewHolder, position: Int) {
        holder.onBind(presenter.subjects[position])
        presenter.onBindViewItem()
    }

    override fun onViewRecycled(holder: SubjectsViewHolder){
        super.onViewRecycled(holder)
        holder.onCleanUp()
    }

    override fun getItemCount(): Int {
        return presenter.subjectsCount
    }
}