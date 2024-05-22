package mystudent.diary.view.main.ui.syllabus.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mystudent.diary.R
import mystudent.diary.model.main.objects.FormOfControl
import mystudent.diary.model.main.objects.Subject
import mystudent.diary.presentation.main.ui.syllabus.SyllabusFragmentPresenter

class SubjectsViewHolder(private val presenter: SyllabusFragmentPresenter, view: View) :
    RecyclerView.ViewHolder(view) {
    fun onBind(subject: Subject) {

        subjectNameTextView = itemView.findViewById(R.id.subjectName)
        formOfControlTextView = itemView.findViewById(R.id.formOfControl)

        subjectNameTextView.text = subject.name
        formOfControlTextView.text = when(subject.formOfControl){
            FormOfControl.Exam -> "Экзамен"
            FormOfControl.Credit -> "Зачет"
            FormOfControl.DifferentialCredit -> "Дифф. зачет"
        }

        itemView.setOnClickListener {
            presenter.onItemClick(adapterPosition)
        }
    }

    fun onCleanUp(){
        itemView.setOnClickListener(null)
    }
    private lateinit var subjectNameTextView: TextView
    private lateinit var formOfControlTextView: TextView
}