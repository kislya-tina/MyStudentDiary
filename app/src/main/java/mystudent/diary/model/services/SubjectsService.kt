package mystudent.diary.model.services

import mystudent.diary.model.main.objects.FormOfControl
import mystudent.diary.model.main.objects.Subject

class SubjectsService {

    fun getSubject(i: Int): Subject {
        return subjects[i]
    }

    fun addSubject(sub: Subject){
        subjects.add(sub)
    }

    fun deleteSubject(i: Int){
        subjects.removeAt(i)
    }

    var subjects = arrayListOf(
        Subject("Базы Данных", FormOfControl.Credit),
        Subject("Тестирование", FormOfControl.Credit),
        Subject("Физ-раф", FormOfControl.DifferentialCredit),
        Subject("Философия", FormOfControl.Exam)
    )
    var currentClickedSubject: Int = -1
}