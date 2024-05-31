package mystudent.diary.presentation.main

import mystudent.diary.di.App
import mystudent.diary.model.main.objects.Exercise
import mystudent.diary.presentation.abstractions.IPresenter
import mystudent.diary.view.abstractions.IMainActivity

class MainActivityPresenter : IPresenter<IMainActivity> {
    override fun onViewCreated(view: IMainActivity) {
        this.view = view
    }

    fun onAddExerciseButtonClick(){
        view?.showAddExerciseDialog()
    }

    fun onDialogAddButtonClick(time: String, exerciseName: String, info: String){
        App.subjectsService.addExercise(
            Exercise(
                time,
                exerciseName,
                info
            )
        )
    }

    override fun onDestroy() {
        this.view = null
    }

    private var view :IMainActivity? = null
}