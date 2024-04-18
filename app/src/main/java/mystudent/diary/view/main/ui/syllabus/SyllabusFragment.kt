package mystudent.diary.view.main.ui.syllabus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import mystudent.diary.databinding.FragmentSyllabusBinding

class SyllabusFragment : Fragment() {

    private var _binding: FragmentSyllabusBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}