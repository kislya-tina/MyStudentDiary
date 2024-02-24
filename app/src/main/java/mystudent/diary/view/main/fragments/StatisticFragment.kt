package mystudent.diary.view.main.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import mystudent.diary.R
import mystudent.diary.presentation.main.fragments.StatisticFragmentPresenter
import mystudent.diary.view.abstractions.fragments.IStatisticFragment

class StatisticFragment :
    Fragment(),
    IStatisticFragment,
    OnClickListener{
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_statistic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated(this)
    }

    override fun onClick(item: View?) {
        TODO("клики на фрагменте")
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    private val presenter = StatisticFragmentPresenter()
}