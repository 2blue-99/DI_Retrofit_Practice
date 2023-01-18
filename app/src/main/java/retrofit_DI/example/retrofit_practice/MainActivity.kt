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
import retrofit_DI.example.retrofit_practice.data.Data_Detail

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: ViewModel by viewModels()
    private val adapter = Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.root.setOnClickListener {
            downKeyBoard()
        }

        supportActionBar?.hide()



        binding.button.setOnClickListener{
            downKeyBoard()
            isLoading()
            Log.e("TAG", "onCreate: click", )
            viewModel.viewModelGetData(binding.textField.text.toString())
        }

        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter

        viewModel.dataList.observe(this){
            isComplete()
            adapter.dataList = it
        }

        binding.textField.setOnEditorActionListener(getEditActionListener(binding.button))
        startApp()
    }

    fun startApp(){
        isLoading()
        viewModel.viewModelGetData()
    }

    fun getEditActionListener(view: View): TextView.OnEditorActionListener{
        return TextView.OnEditorActionListener{ textView, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                view.callOnClick()
            }
            false
        }
    }

    fun isLoading(){
        binding.button.setBackgroundColor(Color.parseColor("#80000000"))
        binding.button.isClickable = false
        binding.view.isVisible = true
        binding.view.isClickable = true
        binding.progressBar.isVisible = true
    }

    fun isComplete(){
        binding.button.setBackgroundColor(ContextCompat.getColor(this,R.color.skyblue))
        binding.button.isClickable = true
        binding.view.isVisible = false
        binding.view.isClickable = false
        binding.progressBar.isVisible = false
    }

    fun downKeyBoard(){
        if(this.currentFocus != null){
            val inputManager: InputMethodManager = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(this.currentFocus?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }
}