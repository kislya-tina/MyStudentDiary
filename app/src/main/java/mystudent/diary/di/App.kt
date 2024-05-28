package mystudent.diary.di

import android.app.Application
import mystudent.diary.model.services.SubjectsService

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        subjectsService = SubjectsService()
    }

    companion object{
        var subjectsService = SubjectsService()
    }
}