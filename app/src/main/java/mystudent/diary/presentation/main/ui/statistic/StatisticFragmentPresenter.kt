package mystudent.diary.presentation.main.ui.statistic

import mystudent.diary.presentation.abstractions.IPresenter
import mystudent.diary.view.abstractions.fragments.IStatisticFragment

class StatisticFragmentPresenter : IPresenter<IStatisticFragment> {
    override fun onViewCreated(view: IStatisticFragment) {
        this.view = view
    }

    override fun onDestroy() {
        this.view = null
    }

    private var view : IStatisticFragment? = null
}