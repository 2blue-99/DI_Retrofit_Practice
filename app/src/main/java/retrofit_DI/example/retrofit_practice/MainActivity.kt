package retrofit_DI.example.retrofit_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit_practice.ViewModel
import com.example.retrofit_practice.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

   private val viewModel: ViewModel by viewModels()

    private val adapter = Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(ViewModel::class.java)

        supportActionBar?.hide()

        binding.button.setOnClickListener{
            Log.e("TAG", "onCreate: click", )
            //getData(binding.textField.text.toString())
            viewModel.viewModelGetData()
        }

        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter

//        CoroutineScope(Dispatchers.Default).launch {
//            var a = RetrofitImpl.getData()
//            Log.e("TAG", "onCreate: $a", )
//        }
        viewModel.viewModelGetData()
//        RetrofitImpl().getData().enqueue(object:Callback<Data>{
//            override fun onResponse(call: Call<Data>, response: Response<Data>) {
//                println(response.body()!!.list)
//            }
//
//            override fun onFailure(call: Call<Data>, t: Throwable) {
//                Log.e("TAG", "onFailure: 실패!! ${call}, $t")
//            }
//
//        })

    }

//    fun getData(gap:String = ""){
//        val imformation = ArrayList<Data_Detail>()
//        imformation.clear()
//        // 최대 대기 시간 설정.
////        val okHttpClient:OkHttpClient = OkHttpClient.Builder()
////            .connectTimeout(200,TimeUnit.MINUTES)
////            .readTimeout(300, TimeUnit.SECONDS)
////            .build()
//        val retrofit = Retrofit.Builder()
//            .baseUrl("http://data.ex.co.kr/openapi/odtraffic/")
//            //.client(okHttpClient)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        val service = retrofit.create(RetrofitInterface::class.java)
//        service.getData().enqueue(object:Callback<Data>{
//            override fun onResponse(call: Call<Data>, response: Response<Data>) {
//                println(response.body()!!.list)
//                for(i in response.body()!!.list){
//                    if(gap!="" && i.conzoneName.contains(gap)) {
//                        println("포함!")
//                        imformation.add(i)
//                    }
//                    else if (gap=="")
//                        imformation.add(i)
//                }
//                adapter.imformation = imformation
//            }
//            override fun onFailure(call: Call<Data>, t: Throwable) {
//                Log.e("TAG", "onFailure: 실패!! ${call}, $t")
//            }
//        })
//    }
}