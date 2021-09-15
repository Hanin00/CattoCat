package com.example.cattocat.src.main.mycat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cattocat.R
import com.example.cattocat.databinding.ActivityMycatBinding
import com.example.cattocat.src.main.mycat.adapter.MyCatRecyAdapter
import com.example.cattocat.src.main.mycat.model.MyCatItem
import com.example.cattocat.src.main.mycat.mycatinfo.MyCatInfoFragment


//my cat
class MyCatActivity: AppCompatActivity() {
    private lateinit var binding : ActivityMycatBinding
    private lateinit var myCatRecyAdapter: MyCatRecyAdapter
    private var myCatItemList = ArrayList<MyCatItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMycatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myCatRecyAdapter(myCatItemList)

        val fragmentManager = supportFragmentManager

        val fragmentA = MyCatInfoFragment()


        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.mycat_fl_info, fragmentA).commitAllowingStateLoss()



        myCatItemList.add(
            MyCatItem(1,"체다치즈", R.drawable.dummy_cat_05,"우리집","노란색 턱시도",
            "템테이션 하늘색","하늘색",1,13,"야생의 집사"))
        myCatItemList.add(
            MyCatItem(1,"양안드레아", R.drawable.dummy_cat_07,"우리집","노란색 턱시도",
                "템테이션 하늘색","하늘색",1,13,"야생의 집사"))
        myCatItemList.add(
            MyCatItem(1,"막시무스", R.drawable.dummy_cat_12,"우리집","노란색 턱시도",
                "템테이션 하늘색","하늘색",1,13,"야생의 집사"))
        myCatItemList.add(
            MyCatItem(1,"고다치즈", R.drawable.dummy_cat_11,"우리집","노란색 턱시도",
                "템테이션 하늘색","하늘색",1,13,"야생의 집사"))
        myCatItemList.add(
            MyCatItem(1,"고앵고앵", R.drawable.dummy_cat_08,"우리집","노란색 턱시도",
                "템테이션 하늘색","하늘색",1,13,"야생의 집사"))
        myCatItemList.add(
            MyCatItem(1,"황태", R.drawable.dummy_cat_09,"우리집","노란색 턱시도",
                "템테이션 하늘색","하늘색",1,13,"야생의 집사"))
        myCatItemList.add(
            MyCatItem(1,"복실복실", R.drawable.dummy_cat_11,"우리집","노란색 턱시도",
                "템테이션 하늘색","하늘색",1,13,"야생의 집사"))
        myCatItemList.add(
            MyCatItem(1,"솜솜", R.drawable.dummy_cat_03,"우리집","노란색 턱시도",
                "템테이션 하늘색","하늘색",1,13,"야생의 집사"))


    }

    private fun myCatRecyAdapter(myCatItem : ArrayList<MyCatItem>){
        myCatRecyAdapter = MyCatRecyAdapter(myCatItem, this)
        binding.mycatRecyMycatProfile.apply {
            adapter = myCatRecyAdapter
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false
            )
            myCatRecyAdapter.notifyDataSetChanged()
        }
    }
}