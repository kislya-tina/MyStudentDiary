package mystudent.diary.model.services

import mystudent.diary.model.main.objects.Exercise
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

    fun getExercise(i: Int): Exercise{
        return exercises[i]
    }

    fun addExercise(exer: Exercise){
        exercises.add(exer)
    }

    fun deleteExercise(i : Int){
        exercises.removeAt(i)
    }

    var subjects = arrayListOf(
        Subject("Базы Данных", FormOfControl.Credit),
        Subject("Тестирование", FormOfControl.Credit),
        Subject("Физ-ра", FormOfControl.DifferentialCredit),
        Subject("Философия", FormOfControl.Exam)
    )
    var currentClickedSubject: Int = -1

    var exercises = arrayListOf(
        Exercise("8:45\n-\n10:20",subjects[0].name, "1 к. 205 ауд."),
        Exercise("10:30\n-\n12:05",subjects[1].name, "1 к. 120а ауд."),
        Exercise("12:45\n-\n14:20",subjects[2].name, "1 к. Спортзал"),
        Exercise("14:30\n-\n16:05",subjects[3].name, "1 к. 102 ауд.")
    )
}