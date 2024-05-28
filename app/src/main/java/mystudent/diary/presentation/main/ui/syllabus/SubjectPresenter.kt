package mystudent.diary.presentation.main.ui.syllabus

import mystudent.diary.di.App
import mystudent.diary.presentation.abstractions.IPresenter
import mystudent.diary.view.main.ui.syllabus.subject.SubjectActivity

class SubjectPresenter: IPresenter<SubjectActivity> {
    override fun onViewCreated(view: SubjectActivity) {
        this.view = view
    }

    fun onDeleteButtonClick(){
        view?.showDeleteDialog()
    }

    fun onDialogDeleteButtonClick(){
        App.subjectsService.deleteSubject(
            App.subjectsService.currentClickedSubject
        )
        view?.finish()
    }

    override fun onDestroy() {
        view = null
    }

    private var view: SubjectActivity? = null
}