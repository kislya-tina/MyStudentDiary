package mystudent.diary.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import mystudent.diary.R
import mystudent.diary.presentation.main.MainActivityPresenter
import mystudent.diary.view.abstractions.IMainActivity
import mystudent.diary.view.main.fragments.MainFragment
import mystudent.diary.view.main.fragments.StatisticFragment
import mystudent.diary.view.main.fragments.SyllabusFragment

class MainActivity :
    AppCompatActivity(),
    IMainActivity,
    OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        statisticButton = findViewById(R.id.statistic_button)
        statisticButton.setOnClickListener(this)
        mainButton = findViewById(R.id.main_button)
        mainButton.setOnClickListener(this)
        syllabusButton = findViewById(R.id.syllabus_button)
        syllabusButton.setOnClickListener(this)

        statisticFragment = supportFragmentManager.findFragmentById(R.id.statistic_fragment)!!
        mainFragment = supportFragmentManager.findFragmentById(R.id.main_fragment)!!
        syllabusFragment = supportFragmentManager.findFragmentById(R.id.syllabus_fragment)!!

        presenter.onViewCreated(this)
    }

    override fun onClick(item: View?) {
        
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    private lateinit var statisticFragment: Fragment
    private lateinit var mainFragment: Fragment
    private lateinit var syllabusFragment: Fragment

    private val presenter = MainActivityPresenter()

    private lateinit var statisticButton: AppCompatButton
    private lateinit var mainButton: AppCompatButton
    private lateinit var syllabusButton: AppCompatButton
}