package mystudent.diary.view.main.ui.home.exercises

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mystudent.diary.R
import mystudent.diary.presentation.main.ui.home.HomeFragmentPresenter

class ExerciseAdapter(private val presenter : HomeFragmentPresenter) : RecyclerView.Adapter<ExerciseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.exercise_fragment, parent, false)
        return ExerciseViewHolder(presenter, view)
    }

    override fun getItemCount(): Int {
        return presenter.exercisesCount
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        holder.onBind(presenter.exercises[position])
        presenter.onBindViewItem()
    }

    override fun onViewRecycled(holder: ExerciseViewHolder){
        super.onViewRecycled(holder)
        holder.onCleanUp()
    }
}