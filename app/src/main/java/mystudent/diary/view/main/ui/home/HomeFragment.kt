package mystudent.diary.view.main.ui.home

import android.graphics.Color
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

//        val adapter = ArrayAdapter.createFromResource(
//            activity as Context,
//            R.array.month,
//            android.R.layout.simple_spinner_item
//        )

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
        rcView = view.findViewById<RecyclerView?>(R.id.date_list).apply {
            adapter = this@HomeFragment.adapter
        }
        rcView?.layoutManager = LinearLayoutManager(this.requireActivity(), LinearLayoutManager.HORIZONTAL, false)

        val formatter = DateTimeFormatter.ofPattern("MM")
        val current = LocalDateTime.now().format(formatter)

        spinner?.setSelection(current.toInt()-1)

    }


    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private var _binding: FragmentHomeBinding? = null //
    private val binding get() = _binding!!
    private val presenter = HomeFragmentPresenter()

    private var spinner: Spinner? = null
    private var rcView: RecyclerView? = null
    private var adapter = DateListAdapter()
}