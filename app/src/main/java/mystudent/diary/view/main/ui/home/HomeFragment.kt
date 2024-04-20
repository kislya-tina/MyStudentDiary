package mystudent.diary.view.main.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import mystudent.diary.R
import mystudent.diary.databinding.FragmentHomeBinding
import mystudent.diary.presentation.main.ui.home.HomeFragmentPresenter
import mystudent.diary.view.abstractions.fragments.IHomeFragment
import java.util.Calendar
import java.util.Date


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

        spinner?.findViewById<Spinner>(R.id.spinner)

       val adapter = ArrayAdapter.createFromResource(activity as Context, R.array.month, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner?.adapter = adapter
        spinner?.setSelection(Calendar.MONTH)
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
    
    private  val spinner: Spinner? = null
}