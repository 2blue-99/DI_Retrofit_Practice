package retrofit_DI.example.retrofit_practice.fragment

import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit_practice.R
import com.example.retrofit_practice.ViewModel
import com.example.retrofit_practice.databinding.FragmentRecyclerBinding
import retrofit_DI.example.retrofit_practice.MainActivity

class RecyclerFragment : Fragment() {

    private val binding : FragmentRecyclerBinding by lazy {
        FragmentRecyclerBinding.inflate(layoutInflater)
    }
    private val adapter = Adapter()
    private val activityViewModel: ViewModel by activityViewModels()
    private val recyclerViewModel: RecylcerViewViewModel by viewModels()

    private val keyboard: InputMethodManager by lazy {
        activity?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.root.setOnClickListener {
            downKeyBoard()
        }

        binding.button.setOnClickListener{
            downKeyBoard()
            isLoading()
            Log.e("TAG", "onCreate: click", )
            activityViewModel.viewModelGetData(binding.textField.text.toString())
        }

        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        binding.recycler.adapter = adapter

        activityViewModel.dataList.observe(viewLifecycleOwner){
            isComplete()
            adapter.dataList = it
        }

        binding.textField.setOnEditorActionListener(getEditActionListener(binding.button))
        startApp()



        return binding.root
    }

    fun startApp(){
        isLoading()
        activityViewModel.viewModelGetData()
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
        binding.button.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.skyblue))
        binding.button.isClickable = true
        binding.view.isVisible = false
        binding.view.isClickable = false
        binding.progressBar.isVisible = false
    }

    fun downKeyBoard(){
        (activity as MainActivity).downKeyBoard()
    }
}