package mystudent.diary.di

import android.app.Application
import mystudent.diary.model.services.SubjectsService

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        syllabusService = SubjectsService()
    }

    companion object{
        var syllabusService = SubjectsService()
    }
}