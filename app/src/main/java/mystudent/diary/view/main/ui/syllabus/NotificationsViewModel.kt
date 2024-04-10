package mystudent.diary.view.main.ui.syllabus

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Syllabus Fragment"
    }
    val text: LiveData<String> = _text
}