package com.example.cattocat.src.main.mycat.mycatinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cattocat.R
import com.example.cattocat.databinding.FragmentExBinding
import com.example.cattocat.databinding.FragmentMyCatInfoBinding
import com.example.cattocat.src.main.home.vpmodel.HomePostItem
import com.example.cattocat.src.main.mycat.adapter.MyCatRecyAdapter
import com.example.cattocat.src.main.mycat.model.MyCatItem
import com.example.cattocat.src.main.mycat.mycatinfo.adapter.MyCatInfoRecyAdapter
import com.example.cattocat.src.main.mycat.mycatinfo.model.CatInfoItem
import okhttp3.internal.notify

class MyCatInfoFragment : Fragment() {

    private lateinit var binding : FragmentMyCatInfoBinding
   // private lateinit var binding : FragmentExBinding
    private lateinit var catInfoRecyAdapter: MyCatInfoRecyAdapter
    private var catInfoItemList = ArrayList<CatInfoItem>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentMyCatInfoBinding.inflate(inflater,container, false)
        //    binding = FragmentExBinding.inflate(inflater,container, false)


        catInfoItemList.add(CatInfoItem(1,"문어", R.drawable.dummy_cat_05))
        catInfoItemList.add(CatInfoItem(4,"휴지", R.drawable.dummy_cat_06))
        catInfoItemList.add(CatInfoItem(22,"집에갈고양", R.drawable.dummy_cat_15))
        catInfoItemList.add(CatInfoItem(13,"김갑영", R.drawable.dummy_cat_10))
        catInfoItemList.add(CatInfoItem(14,"콜로소", R.drawable.dummy_cat_11))
        catInfoItemList.add(CatInfoItem(41,"페페", R.drawable.dummy_cat_07))

       // catInfoRecyAdapter(catInfoItemList)


        return binding.root
    }

    private val catClickListener = { postIdx: Int ->
        /*  val intent = Intent(context, HospitalInformationActivity::class.java)
          intent.putExtra(Constants.HOSPITAL_IDX, hospitalIdx)
          intent.putExtra(Constants.FROM_AD_BANNER, true)
          startActivity(intent)*/
    }

/*    private fun catInfoRecyAdapter(catInfoItem : ArrayList<CatInfoItem>){
        catInfoRecyAdapter = MyCatInfoRecyAdapter(catInfoItem, requireContext(), catClickListener)
        binding.mycatInfoRecy.apply {
            adapter = catInfoRecyAdapter
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL, false
            )
            catInfoRecyAdapter.notifyDataSetChanged()
        }
    }*/


}