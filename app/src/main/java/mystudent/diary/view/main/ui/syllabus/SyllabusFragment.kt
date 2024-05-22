package mystudent.diary.view.main.ui.syllabus

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mystudent.diary.R
import mystudent.diary.databinding.FragmentSyllabusBinding
import mystudent.diary.presentation.main.ui.syllabus.SyllabusFragmentPresenter
import mystudent.diary.view.abstractions.fragments.ISyllabusFragment
import mystudent.diary.view.main.MainActivity
import mystudent.diary.view.main.ui.syllabus.recyclerview.SubjectsAdapter


class SyllabusFragment :
    Fragment(),
    ISyllabusFragment,
    OnClickListener{

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val syllabusViewModel =
            ViewModelProvider(this)[SyllabusViewModel::class.java]

        _binding = FragmentSyllabusBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSyllabus
        syllabusViewModel.text.observe(viewLifecycleOwner) {
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

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerViewSubjects)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = subjectsAdapter


//        recyclerView.findViewById<RecyclerView>(R.id.recyclerViewSubjects)?.apply{
//            adapter = this@SyllabusFragment.subjectsAdapter
//        }
//        recyclerView.layoutManager = LinearLayoutManager(activity)
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    override fun startSubjectActivity(){
        val intent = Intent(activity, SubjectActivity::class.java)
        startActivity(intent)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun notifyDataChanged() {
        subjectsAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private var _binding: FragmentSyllabusBinding? = null
    private val binding get() = _binding!!
    private val presenter = SyllabusFragmentPresenter()
    private lateinit var recyclerView: RecyclerView
    private val subjectsAdapter = SubjectsAdapter(presenter)
}