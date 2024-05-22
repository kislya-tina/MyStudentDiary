package mystudent.diary.model.services

import mystudent.diary.model.main.objects.FormOfControl
import mystudent.diary.model.main.objects.Subject

class SubjectsService {

    fun getSubject(i: Int): Subject {
        return subjects[i]
    }

    var subjects = listOf(
        Subject("Базы Данных", FormOfControl.Credit),
        Subject("Тестирование", FormOfControl.Credit),
        Subject("Физ-раф", FormOfControl.DifferentialCredit),
        Subject("Философия", FormOfControl.Exam)
    )
}