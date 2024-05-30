package mystudent.diary.presentation.main.ui.home

import mystudent.diary.di.App
import mystudent.diary.presentation.abstractions.IPresenter
import mystudent.diary.view.abstractions.fragments.IHomeFragment

class HomeFragmentPresenter : IPresenter<IHomeFragment> {
    override fun onViewCreated(view: IHomeFragment) {
        this.view = view
    }

    override fun onDestroy() {
        this.view = null
    }

    fun onSelectItem(selected: Int){
        selectedItem = selected
    }
    fun selectedItem():Int{
        return selectedItem
    }

    fun onBindViewItem(){

    }

    val exercises = App.subjectsService.exercises
    val exercisesCount: Int
        get() = exercises.size


    private var view : IHomeFragment? = null
    private var selectedItem = -1
}