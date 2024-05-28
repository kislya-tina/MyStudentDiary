package mystudent.diary.view.main.dialogs.syllabus.subject

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.DialogFragment
import mystudent.diary.R
import mystudent.diary.presentation.main.ui.syllabus.SubjectPresenter

open class DeleteDialog(private val presenter: SubjectPresenter) : DialogFragment(),
    View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.delete_dialog, container, false)

        view.setBackgroundColor(Color.TRANSPARENT)

        deleteButton = view.findViewById(R.id.deleteBtn)
        cancelButton = view.findViewById(R.id.cancelBtn)

        deleteButton.setOnClickListener(this)
        cancelButton.setOnClickListener(this)

        return view
    }


    override fun onClick(view: View?) {
        if (view === deleteButton) {
            presenter.onDialogDeleteButtonClick()
            dismiss()
        }
        if (view === cancelButton) {
            dismiss()
        }
    }


    private lateinit var deleteButton: AppCompatButton
    private lateinit var cancelButton: AppCompatButton


}