package app.mumandroidassignment.lesson6.byKotlin.question1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem

import app.mumandroidassignment.R

class MainActivity : AppCompatActivity() {

    private val FRAGMENT_HOME = "fragment_home"
    private val FRAGMENT_ABOUT = "fragment_about"
    private val FRAGMENT_WORK = "fragment_work"
    private val FRAGMENT_CONTACT = "fragment_contact"

    private val fragmentHome by lazy { HomeFragment() }
    private val fragmentAbout by lazy { AboutFragment() }
    private val fragmentWork by lazy { WorkFragment() }
    private val fragmentContact by lazy { ContactFragment() }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportFragmentManager.beginTransaction().add(R.id.root, fragmentHome , FRAGMENT_HOME).commit()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_lesson6_1, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        Log.d("zhq.debug","onOptionsItemSelected")
        when (item!!.itemId) {
            R.id.mi_home -> {
                Log.d("zhq.debug","mi_home")
                supportFragmentManager.beginTransaction()
                        .replace(R.id.root, fragmentHome , FRAGMENT_HOME)
                        .commit()
            }
            R.id.mi_about_me ->{
                supportFragmentManager.beginTransaction()
                        .replace(R.id.root, fragmentAbout , FRAGMENT_ABOUT)
                        .commit()
            }
            R.id.mi_Work ->{
                supportFragmentManager.beginTransaction()
                        .replace(R.id.root, fragmentWork , FRAGMENT_WORK)
                        .commit()
            }
            R.id.mi_contact ->{
                supportFragmentManager.beginTransaction()
                        .replace(R.id.root, fragmentContact , FRAGMENT_CONTACT)
                        .commit()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
