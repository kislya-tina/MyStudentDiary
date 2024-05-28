package mystudent.diary.view.main.dialogs.syllabus

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import mystudent.diary.R
import mystudent.diary.model.main.objects.FormOfControl
import mystudent.diary.presentation.main.ui.syllabus.SyllabusFragmentPresenter

open class AddDialog(private val presenter: SyllabusFragmentPresenter) : DialogFragment(),
    View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_dialog, container, false)

        view.setBackgroundColor(Color.TRANSPARENT)


        addButton = view.findViewById(R.id.addButton)
        cancelButton = view.findViewById(R.id.cancelButton)
        subjectNameEditText = view.findViewById(R.id.subjectNameEditText)
        formOfControlSpinner = view.findViewById(R.id.formOfControlSpinner)

        addButton.setOnClickListener(this)
        cancelButton.setOnClickListener(this)

        return view
    }


    override fun onClick(view: View?) {
        if (view === addButton) {
            presenter.onDialogAddButtonClick(
                subjectNameEditText.text.toString(),
                getFOC()
            )
            subjectNameEditText.text.clear()
            formOfControlSpinner.setSelection(0)
            dismiss()
        }
        if (view === cancelButton) {
            subjectNameEditText.text.clear()
            formOfControlSpinner.setSelection(0)
            dismiss()
        }
    }

    private fun getFOC(): FormOfControl{
        when(formOfControlSpinner.selectedItem.toString()){
            "Экзамен" -> return FormOfControl.Exam
            "Зачет" -> return FormOfControl.Credit
            "Дифф. зачет" -> return FormOfControl.DifferentialCredit
        }
        return FormOfControl.Exam
    }

    private lateinit var addButton: AppCompatButton
    private lateinit var cancelButton: AppCompatButton
    private lateinit var subjectNameEditText: EditText
    private lateinit var formOfControlSpinner: Spinner
}