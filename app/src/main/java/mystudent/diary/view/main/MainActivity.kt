package mystudent.diary.view.main

import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.widget.PopupMenu
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import mystudent.diary.R
import mystudent.diary.databinding.ActivityMainBinding
import mystudent.diary.presentation.main.MainActivityPresenter
import mystudent.diary.view.abstractions.IMainActivity
import java.util.Calendar

class MainActivity :
    AppCompatActivity(),
    IMainActivity,
    View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        прячем верхний бар
        supportActionBar?.hide()
//        установка нижнего бара
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navView.setupWithNavController(navController)
        navView.selectedItemId = R.id.navigation_home

        plusButton = findViewById(R.id.plusButton)
        plusButton?.setOnClickListener {
            showPopup(plusButton)
        }
    }

    override fun onClick(item: View?) {

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    private fun showPopup(view: View?) {
        val popup = PopupMenu(view?.context, view)
        popup.inflate(R.menu.popupmenu)
        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->
            when (item!!.itemId) {
                R.id.task -> {
                    Toast.makeText(this, "Задача добавлена", Toast.LENGTH_SHORT).show()
                }
                R.id.lesson -> {
                    Toast.makeText(this, "Занятие добавлено", Toast.LENGTH_SHORT).show()
                }
            }
            return@OnMenuItemClickListener true
        })
        popup.show()
    }

    private val presenter = MainActivityPresenter()
    private var plusButton : AppCompatButton? = null
}