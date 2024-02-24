package mystudent.diary.presentation.main.fragments

import mystudent.diary.presentation.abstractions.IPresenter
import mystudent.diary.view.abstractions.fragments.ISyllabusFragment

class SyllabusFragmentPresenter : IPresenter<ISyllabusFragment> {
    override fun onViewCreated(view: ISyllabusFragment) {
        this.view = view
    }

    override fun onDestroy() {
        this.view = null
    }

    private var view : ISyllabusFragment? = null
}