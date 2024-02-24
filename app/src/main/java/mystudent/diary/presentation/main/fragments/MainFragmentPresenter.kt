package mystudent.diary.presentation.main.fragments

import mystudent.diary.presentation.abstractions.IPresenter
import mystudent.diary.view.abstractions.fragments.IMainFragment

class MainFragmentPresenter : IPresenter<IMainFragment> {
    override fun onViewCreated(view: IMainFragment) {
        this.view = view
    }

    override fun onDestroy() {
        this.view = null
    }

    private var view : IMainFragment? = null
}