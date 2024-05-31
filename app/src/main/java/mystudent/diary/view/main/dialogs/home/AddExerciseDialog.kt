package mystudent.diary.view.main.dialogs.home

import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.DialogFragment
import mystudent.diary.R
import mystudent.diary.presentation.main.MainActivityPresenter
import mystudent.diary.view.main.MainActivity
import java.util.Calendar


open class AddExerciseDialog(private val presenter: MainActivityPresenter) : DialogFragment(),
    View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_exercise_dialog, container, false)

        view.setBackgroundColor(Color.TRANSPARENT)


        addButton = view.findViewById(R.id.addButton)
        cancelButton = view.findViewById(R.id.cancelButton)
        timeEditText = view.findViewById(R.id.timeEditText)
        exerciseEditText = view.findViewById(R.id.exerciseNameEditText)
        infoEditText = view.findViewById(R.id.infoEditText)

        addButton.setOnClickListener(this)
        cancelButton.setOnClickListener(this)

        return view
    }

    override fun onClick(view: View?) {
        if (view === addButton) {
            presenter.onDialogAddButtonClick(
                timeEditText.text.toString(),
                exerciseEditText.text.toString(),
                infoEditText.text.toString()
            )
            exerciseEditText.text.clear()
            infoEditText.text.clear()
            timeEditText.text.clear()
            dismiss()
        }
        if (view === cancelButton) {
            exerciseEditText.text.clear()
            infoEditText.text.clear()
            timeEditText.text.clear()
            dismiss()
        }
    }

    private lateinit var addButton: AppCompatButton
    private lateinit var cancelButton: AppCompatButton
    private lateinit var timeEditText: EditText
    private lateinit var exerciseEditText: EditText
    private lateinit var infoEditText: EditText
}
