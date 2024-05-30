package mystudent.diary.view.main.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mystudent.diary.R
import mystudent.diary.databinding.FragmentHomeBinding
import mystudent.diary.presentation.main.ui.home.HomeFragmentPresenter
import mystudent.diary.view.abstractions.fragments.IHomeFragment
import mystudent.diary.view.main.MainActivity
import mystudent.diary.view.main.ui.home.dates.DateListAdapter
import mystudent.diary.view.main.ui.home.exercises.ExerciseAdapter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class HomeFragment :
    Fragment(),
    IHomeFragment,
    OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated(this)

        this.spinner = view.findViewById(R.id.spinner)
        recyclerView = view.findViewById<RecyclerView?>(R.id.date_list).apply {
            adapter = this@HomeFragment.adapter
        }
        recyclerView?.layoutManager = LinearLayoutManager(this.requireActivity(), LinearLayoutManager.HORIZONTAL, false)

        val formatter = DateTimeFormatter.ofPattern("MM")
        val current = LocalDateTime.now().format(formatter)

        spinner?.setSelection(current.toInt()-1)
        presenter.onSelectItem(0)
        recyclerView?.findViewHolderForAdapterPosition(1)

        activity?.let {
            (it as MainActivity).buttonVisibility(true)
        }

        val layoutManager = LinearLayoutManager(context)
        exRecyclerView = view.findViewById(R.id.exerciseRecyclerView)
        exRecyclerView.layoutManager = layoutManager
        exRecyclerView.adapter = exAdapter
    }


    override fun onClick(p0: View?) {

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private var _binding: FragmentHomeBinding? = null //
    private val binding get() = _binding!!
    private val presenter = HomeFragmentPresenter()
    private var spinner: Spinner? = null

    private var recyclerView: RecyclerView? = null
    private var adapter = DateListAdapter()

    private lateinit var exRecyclerView: RecyclerView
    private var exAdapter = ExerciseAdapter(presenter)
}