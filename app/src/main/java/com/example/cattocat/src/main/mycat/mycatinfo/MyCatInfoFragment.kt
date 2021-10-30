package com.example.cattocat.src.main.mycat.mycatinfo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cattocat.Companion.Companion.USERID
import com.example.cattocat.databinding.FragmentMyCatInfoBinding
import com.example.cattocat.src.main.mycat.model.MyCatItem
import com.example.cattocat.src.main.mycat.mycatinfo.adapter.MyCatInfoRecyAdapter
import com.example.cattocat.src.main.mycat.mycatinfo.model.CatInfoItem
import okhttp3.internal.notifyAll

class MyCatInfoFragment : Fragment(), MyCatInfoView {

    private lateinit var binding: FragmentMyCatInfoBinding

    // private lateinit var binding : FragmentExBinding
    private lateinit var catInfoRecyAdapter: MyCatInfoRecyAdapter
    private var catInfoItemList = ArrayList<CatInfoItem>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyCatInfoBinding.inflate(inflater, container, false)


        val cat_id = arguments?.getInt("cid")
        val cname = arguments?.getString("cname")
        val ceye = arguments?.getString("ceye")
        val chair = arguments?.getString("chair")
        val csocks = arguments?.getString("csocks")
        val clocate = arguments?.getString("clocate")
        val cmom = arguments?.getString("cmom")
        val ctnr = arguments?.getString("ctnr")
        val cprefer = arguments?.getString("cprefer")
        val cspecial = arguments?.getString("cspecial")

        binding.mycatinfoEdName.setText(cname)

        binding.mycatEdEye.setText(ceye)
        binding.mycatEdHair.setText(chair)
        binding.mycatEdSocks.setText(csocks)
        binding.mycatinfoEdLocate.setText(clocate)
        binding.mycatinfoEdMom.setText(cmom)
        binding.mycatEdTnr.setText(ctnr)

        binding.mycatinfoEdPrefer.setText(cprefer)
        binding.mycatinfoEdSpecial.setText(cspecial)



        binding.mycatBtnModify.setOnClickListener {

            if (cat_id != null) {
                val cname = binding.mycatinfoEdName.text.toString()
                val ceye = binding.mycatEdEye.text.toString()
                val chair = binding.mycatEdHair.text.toString()
                val csocks = binding.mycatEdSocks.text.toString()
                val clocate = binding.mycatinfoEdLocate.text.toString()
                val cmom = binding.mycatinfoEdMom.text.toString()
                val ctnr = binding.mycatEdTnr.text.toString()
                val cprefer = binding.mycatinfoEdPrefer.text.toString()
                val cspecial = binding.mycatinfoEdSpecial.text.toString()

                val cprofimg = "dummy url~"
                val cimg = "dummy url~"

                //todo longitude, latitude
                val xlocation = "3.123"
                val ylocations = "3.123"
                val isactive = 1


                MyCatInfoService(
                    this, cat_id,
                    MyCatItem(cat_id, USERID, cname, ceye,chair,csocks,clocate,cmom.toInt(),ctnr.toInt(),
                    cprefer,cspecial,cprofimg,cimg,xlocation,ylocations,isactive)
                ).tryPutMyCatInfo()
            }
        }


        return binding.root
    }

    override fun onPutCatInfoSuccess(result: MyCatItem) {
        Log.d("Test", "변경되었음")
        notifyAll()
    }

    override fun onPutCatInfoFailure(message: String) {

        Log.e("Test", "onPutCatInfoFailure: $message")
    }


}






















