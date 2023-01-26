package retrofit_DI.example.retrofit_practice

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit_practice.R
import com.example.retrofit_practice.ViewModel
import com.example.retrofit_practice.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import retrofit_DI.example.retrofit_practice.fragment.Adapter
import retrofit_DI.example.retrofit_practice.fragment.RecyclerFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var recyclerFragment = RecyclerFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.hide()

        supportFragmentManager.beginTransaction()
            .replace(R.id.recylcerLayout, recyclerFragment)
            .addToBackStack(null)
            .show(recyclerFragment)
            .commit()
    }



    fun downKeyBoard(){
        if(this.currentFocus != null){
            val inputManager: InputMethodManager = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(this.currentFocus?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }
}