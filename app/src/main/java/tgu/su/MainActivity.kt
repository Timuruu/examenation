package tgu.su

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val CHOOSED_FRAGMENT="item"
private val CUEFA_FRAGMENT=CuEFaFragment().javaClass.name
private val TOPSCORE_FRAGMENT=ScoreFragment().javaClass.name

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bottom_navigation_bar)
        bottomNavigationView.setOnItemSelectedListener {item ->
            var fragment:Fragment? = null
            when(item.itemId){
                R.id.pass_case -> {
                    fragment = if (savedInstanceState != null) supportFragmentManager.getFragment(
                            savedInstanceState, CUEFA_FRAGMENT
                        ) else CuEFaFragment()
                }
                R.id.top_score -> {
                    fragment = if (savedInstanceState != null) supportFragmentManager.getFragment(
                            savedInstanceState, TOPSCORE_FRAGMENT
                        ) else ScoreFragment()
                }
            }
            replacveFragment(fragment!!)
            true
        }
        bottomNavigationView.selectedItemId =
            savedInstanceState?.getInt(CHOOSED_FRAGMENT) ?: R.id.pass_case

        }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(CHOOSED_FRAGMENT,bottomNavigationView.selectedItemId)

        val currentFragment = supportFragmentManager.fragments.last()
        supportFragmentManager.putFragment(
            outState,
            currentFragment.javaClass.name,
            currentFragment)
    }


    private fun replacveFragment(fragment:Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .commit()
    }

}