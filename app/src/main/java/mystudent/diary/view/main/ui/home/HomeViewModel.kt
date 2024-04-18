package mystudent.diary.view.main.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Вы можете добавить задачу или занятие с помощью кнопки “+”"
    }
    val text: LiveData<String> = _text
}