package mystudent.diary.view.main.ui.home.exercises

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mystudent.diary.R
import mystudent.diary.model.main.objects.Exercise
import mystudent.diary.presentation.main.ui.home.HomeFragmentPresenter

class ExerciseViewHolder(private val presenter: HomeFragmentPresenter, itemView: View) : RecyclerView.ViewHolder(itemView)                                                                                                                                                                        {
    fun onBind(exercise: Exercise){
        timeTextView = itemView.findViewById(R.id.time)
        subjectNameTextView = itemView.findViewById(R.id.subjectName)
        infoTextView = itemView.findViewById(R.id.info)
        completedImageView = itemView.findViewById(R.id.completed)

        timeTextView.text = exercise.time
        subjectNameTextView.text = exercise.subject
        infoTextView.text = exercise.info
        if(exercise.time == "8:45\n-\n10:20"){
            completedImageView.setImageResource(R.drawable.done)
        }
    }

    fun onCleanUp(){
        itemView.setOnClickListener(null)
    }

    private lateinit var timeTextView: TextView
    private lateinit var subjectNameTextView: TextView
    private lateinit var infoTextView: TextView
    private lateinit var completedImageView: ImageView

}