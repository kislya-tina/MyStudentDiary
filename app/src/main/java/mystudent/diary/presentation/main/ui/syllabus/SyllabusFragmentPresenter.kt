package mystudent.diary.presentation.main.ui.syllabus

import mystudent.diary.di.App
import mystudent.diary.model.main.objects.FormOfControl
import mystudent.diary.model.main.objects.Subject
import mystudent.diary.presentation.abstractions.IPresenter
import mystudent.diary.view.abstractions.fragments.ISyllabusFragment

class SyllabusFragmentPresenter : IPresenter<ISyllabusFragment> {
    override fun onViewCreated(view: ISyllabusFragment) {
        this.view = view
        view.notifyDataChanged()
    }

    fun onBindViewItem() {

    }

    fun onItemClick(position: Int){
        App.subjectsService.currentClickedSubject = position
        view?.startSubjectActivity()
    }

    fun onAddButtonClick(){
        view?.showAddDialog()
    }

    fun onDialogAddButtonClick(subjectName : String, formOfControl: FormOfControl){
        App.subjectsService.addSubject(
            Subject(
                subjectName,
                formOfControl
            )
        )

    }

    override fun onDestroy() {
        this.view = null
    }

    val subjects = App.subjectsService.subjects

    val subjectsCount: Int
        get() = subjects.size

    private var view: ISyllabusFragment? = null
    private var currentClickedPosition = App.subjectsService.currentClickedSubject


}