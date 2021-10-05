package tn.esprit.leagueoflegends

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var btnChampion: Button
    private lateinit var btnSpells: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.app_bar)
        setSupportActionBar(toolbar)

        btnChampion = findViewById(R.id.btnChampions)
        btnSpells = findViewById(R.id.btnSpells)

        btnSpells.setOnClickListener {
            changeFragment(SpellsFragment(), "")
        }

        btnChampion.setOnClickListener {
            changeFragment(ChampionFragment(), "")
        }

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, ChampionFragment()).commit()
    }

    private fun changeFragment(fragment: Fragment, name: String) {

        if (name.isEmpty())
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
        else
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(name).commit()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.info -> changeFragment(AboutMeFragment(), "AboutMe")
        }

        return super.onOptionsItemSelected(item)
    }
}