package mystudent.diary.presentation.main.ui.home

import mystudent.diary.presentation.abstractions.IPresenter
import mystudent.diary.view.abstractions.fragments.IHomeFragment

class HomeFragmentPresenter : IPresenter<IHomeFragment> {
    override fun onViewCreated(view: IHomeFragment) {
        this.view = view
    }

    override fun onDestroy() {
        this.view = null
    }

    private var view : IHomeFragment? = null
}