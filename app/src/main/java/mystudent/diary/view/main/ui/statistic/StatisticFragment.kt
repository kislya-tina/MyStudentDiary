package mystudent.diary.view.main.ui.statistic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import mystudent.diary.databinding.FragmentStatisticBinding
import mystudent.diary.presentation.main.ui.statistic.StatisticFragmentPresenter
import mystudent.diary.view.abstractions.fragments.IStatisticFragment
import mystudent.diary.view.main.MainActivity

class StatisticFragment :
    Fragment(),
    IStatisticFragment,
    OnClickListener{

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val statisticViewModel =
            ViewModelProvider(this)[StatisticViewModel::class.java]

        _binding = FragmentStatisticBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textStatistic
        statisticViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated(this)
        activity?.let {
            (it as MainActivity).buttonVisibility(false)
        }
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private var _binding: FragmentStatisticBinding? = null
    private val binding get() = _binding!!
    private val presenter = StatisticFragmentPresenter()
}