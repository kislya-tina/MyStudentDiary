package mystudent.diary.view.main.ui.syllabus.subject

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mystudent.diary.R
import mystudent.diary.di.App
import mystudent.diary.presentation.main.ui.syllabus.SubjectPresenter
import mystudent.diary.view.main.dialogs.syllabus.subject.DeleteDialog

class SubjectActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_subject)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        presenter.onViewCreated(this)
        subject = App.subjectsService.getSubject(App.subjectsService.currentClickedSubject).name
        subjectTextView = findViewById(R.id.subjectTextView)
        subjectTextView.text = "Дисциплина: \"$subject\""
        title = subject

        deleteButton = findViewById(R.id.deleteButton)
        deleteButton.setOnClickListener{
            presenter.onDeleteButtonClick()
        }
    }

    fun showDeleteDialog(){
        dialog.show(supportFragmentManager, "")
    }

    private lateinit var subjectTextView: TextView
    private var subject = ""
    private lateinit var deleteButton: AppCompatButton
    private var presenter = SubjectPresenter()
    private val dialog = DeleteDialog(presenter)
}