package mystudent.diary.presentation.main

import mystudent.diary.presentation.abstractions.IPresenter
import mystudent.diary.view.abstractions.IMainActivity

class MainActivityPresenter : IPresenter<IMainActivity> {
    override fun onViewCreated(view: IMainActivity) {
        this.view = view
    }

    override fun onDestroy() {
        this.view = null
    }

    private var view :IMainActivity? = null
}