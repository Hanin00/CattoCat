package com.example.cattocat.src.main.mycat.mycatinfo

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.cattocat.Companion.Companion.USERID
import com.example.cattocat.R
import com.example.cattocat.databinding.FragmentMyCatInfoBinding
import com.example.cattocat.src.main.mycat.MyCatActivity
import com.example.cattocat.src.main.mycat.model.MyCatItem
import com.example.cattocat.src.main.mycat.mycatinfo.adapter.MyCatInfoRecyAdapter
import com.example.cattocat.src.main.mycat.mycatinfo.model.CatInfoItem
import okhttp3.internal.notify
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

                val mDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_cat_modify, null)
                val mBuilder = AlertDialog.Builder(context)
                    .setView(mDialogView)
                  //  .setTitle("Login Form")

                val  mAlertDialog = mBuilder.show()

                val okButton = mDialogView.findViewById<AppCompatButton>(R.id.dialog_modify_btn)
                okButton.setOnClickListener {
                    mAlertDialog.dismiss()
                    // Fragment 클래스에서 사용 시

                }
            }
        }
        return binding.root
    }

    override fun onPutCatInfoSuccess(result: MyCatItem) {
        Log.d("Test", "변경되었음")
        var fragment = MyCatInfoFragment()

    }



    override fun onPutCatInfoFailure(message: String) {

        Log.e("Test", "onPutCatInfoFailure: $message")
    }



}






















