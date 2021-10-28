package com.example.cattocat.src.addcat

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cattocat.databinding.ActivityAddCatBinding
import com.example.cattocat.src.addcat.model.AddCatInfo


class AddCatActivity : AppCompatActivity(), AddCatView{
    private lateinit var binding: ActivityAddCatBinding
    private var addCatInfolist = listOf<AddCatInfo>()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityAddCatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userId = 1

    /*    val name = binding.addcatEdName.text.toString()
        val eye = binding.addcatEdEye.text.toString()
        val hair = binding.addcatEdHair.text.toString()
        val socks= binding.addcatEdSocks.text.toString()
        val locate = binding.addcatEdLocate.text.toString()
        val catmom = 1
        val tnr= 1
        //val catmom = binding.addcatEdMom.text.toString().toInt()
        //val tnr= binding.addcatEdTnr.text.toString().toInt()
        val prefer= binding.addcatEdPrefer.text.toString()
        val special= binding.addcatEdSpecial.text.toString()
*/
        val name = "김안드레아"
        val eye = "하늘색"
        val hair = "치즈"
        val socks= "앞발에만"
        val locate = "중앙정보관"
        val catmom = 1
        val tnr= 1
        //val catmom = binding.addcatEdMom.text.toString().toInt()
        //val tnr= binding.addcatEdTnr.text.toString().toInt()
        val prefer= "템테이션 하늘색"
        val special= "쫄보임, 사람 좋아함"

        val profImg= ""
        val image= ""
        val xlocation= ""
        val ylocation= ""

        binding.addcatBtnSend.setOnClickListener {
            AddCatService(this).tryPostAddCat(AddCatInfo(userId,name, eye, hair, socks, locate, catmom, tnr, prefer, special, profImg,
                image, xlocation, ylocation))
        }
    }

    override fun onPostAddCatSuccess(result: AddCatInfo) {
        Toast.makeText(this, "등록되었습니다.", Toast.LENGTH_SHORT).show()
    }

    override fun onPostAddCatFailure(message: String) {
        Log.e("Test", "onPostAddCatFailure: $message", )
    }



}

