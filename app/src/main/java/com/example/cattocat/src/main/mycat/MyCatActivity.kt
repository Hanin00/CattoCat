package com.example.cattocat.src.main.mycat

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cattocat.Companion.Companion.USERID
import com.example.cattocat.R
import com.example.cattocat.databinding.ActivityMycatBinding
import com.example.cattocat.src.addcat.AddCatActivity
import com.example.cattocat.src.addcat.map.MakeMarkerActivity
import com.example.cattocat.src.main.mycat.adapter.MyCatRecyAdapter
import com.example.cattocat.src.main.mycat.model.MyCatItem
import com.example.cattocat.src.main.mycat.model.MyCatResponse
import com.example.cattocat.src.main.mycat.mycatinfo.MyCatInfoFragment


//my cat
class MyCatActivity : AppCompatActivity(), MyCatView {
    private lateinit var binding: ActivityMycatBinding
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

        binding.mycatClAdd.setOnClickListener {
            val intent = Intent(this, MakeMarkerActivity::class.java)
            startActivity(intent)
        }

    }

    private fun myCatRecyAdapter(myCatItem: ArrayList<MyCatItem>) {
        myCatRecyAdapter = MyCatRecyAdapter(myCatItem, this) { myCatItem ->

            var fragment = MyCatInfoFragment()
            var bundle = Bundle()
            bundle.putInt("cid", myCatItem.cat_id)
            bundle.putString("cname", myCatItem.cat_name)
            bundle.putString("ceye", myCatItem.cat_eye)
            bundle.putString("chair", myCatItem.cat_hair)
            bundle.putString("csocks", myCatItem.cat_socks)
            bundle.putString("clocate", myCatItem.cat_locate)
            bundle.putString("cmom", myCatItem.cat_mom.toString())
            bundle.putString("ctnr", myCatItem.cat_tnr.toString())
            bundle.putString("cprefer", myCatItem.cat_prefer)
            bundle.putString("cspecial", myCatItem.cat_special)

            fragment.arguments = bundle
            this.supportFragmentManager!!.beginTransaction().replace(R.id.mycat_fl_info, fragment)
                .commit()
        }
        binding.mycatRecyMycatProfile.apply {
            adapter = myCatRecyAdapter
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false
            )
            myCatRecyAdapter.notifyDataSetChanged()
        }
    }

    override fun onGetCatSuccess(result: MyCatResponse) {
        Log.d("Test", "정상연결")
        Log.d("Test", "${result}")

        if (result.content != null) {
            val myCatItem = result.content as ArrayList<MyCatItem>
            myCatRecyAdapter(myCatItem)
        } else {
            Log.d("Test", "추가한고양이 없음 X")
        }
    }

    override fun onGetCatFailure(message: String) {
        Log.e("Test", "onGetCatFailure: $message")
    }

    override fun onResume() {
        super.onResume()
        MyCatService(this, USERID).tryGetMyCat()
    }
}