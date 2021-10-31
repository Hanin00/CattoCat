package com.example.cattocat.src.addcat

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cattocat.databinding.ActivityAddCatBinding
import com.example.cattocat.src.addcat.map.MakeMarkerActivity
import com.example.cattocat.src.addcat.model.AddCatInfo


class AddCatActivity : AppCompatActivity(), AddCatView {
    private lateinit var binding: ActivityAddCatBinding
    private var addCatInfolist = listOf<AddCatInfo>()

    private var xlocation = ""
    private var ylocation = ""
    private val locatefrommap = ""


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityAddCatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addcatIvMarker.setOnClickListener {
            val intent = Intent(this, MakeMarkerActivity::class.java)
            startActivity(intent)


        }


        val userId = 1
        /*
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
     */
        val profImg = ""
        val image = ""

        binding.addcatBtnSend.setOnClickListener {

            val name = binding.addcatEdName.text.toString()
            val eye = binding.addcatEdEye.text.toString()
            val hair = binding.addcatEdHair.text.toString()
            val socks = binding.addcatEdSocks.text.toString()
            val locate = binding.addcatEdLocate.text.toString()
            val cmom = 1
            val ctnr = 1

            if (cmom == 0) {
                binding.catmomSeg1.isChecked = true
                binding.catmomSeg2.isChecked = false
                binding.catmomSeg3.isChecked = false
            }else if (cmom == 1) {
                binding.catmomSeg1.isChecked = false
                binding.catmomSeg2.isChecked = true
                binding.catmomSeg3.isChecked = false

            } else {
                binding.catmomSeg1.isChecked = false
                binding.catmomSeg2.isChecked = false
                binding.catmomSeg3.isChecked = true
            }


            if (ctnr == 0) {
                binding.cattnrSeg1.isChecked = true
                binding.cattnrSeg2.isChecked = false
                binding.cattnrSeg3.isChecked = false
            }else if (ctnr == 1) {
                binding.cattnrSeg1.isChecked = false
                binding.cattnrSeg2.isChecked = true
                binding.cattnrSeg3.isChecked = false

            } else {
                binding.cattnrSeg1.isChecked = false
                binding.cattnrSeg2.isChecked = false
                binding.cattnrSeg3.isChecked = true
            }
            //val catmom = binding.addcatEdMom.text.toString().toInt()
            //val tnr= binding.addcatEdTnr.text.toString().toInt()


            val prefer = binding.addcatEdPrefer.text.toString()
            val special = binding.addcatEdSpecial.text.toString()

            if (name != "") {
                if (eye != "") {
                    if (hair != "") {
                        if (locate != "") {

                            Log.d("Test", "xLocation : $xlocation")
                            Log.d("Test", "yLocation : $ylocation")
                            AddCatService(this).tryPostAddCat(
                                AddCatInfo(
                                    userId,
                                    name,
                                    eye,
                                    hair,
                                    socks,
                                    locate,
                                    cmom,
                                    ctnr,
                                    prefer,
                                    special,
                                    profImg,
                                    image,
                                    xlocation,
                                    ylocation
                                )
                            )

                        } else {
                            Toast.makeText(this, "위치를 설정해주세요", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this, "털 색을 입력해주세요", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "눈 색을 입력해주세요", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "이름을 입력해주세요", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (intent.hasExtra("xLocation")) {
            xlocation = intent.getStringExtra("xLocation").toString()
            ylocation = intent.getStringExtra("yLocation").toString()
            val lacationName = intent.getStringExtra("lacationName").toString()
            binding.addcatEdLocate.setText(lacationName)

            Log.d("Test", "xlocation : $xlocation")
            Log.d("Test", "ylocation : $ylocation")
            Log.d("Test", "lacationName : $lacationName")
        }
    }
/*

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == 200) {
            if (intent.hasExtra("xLocation")) {
                xlocation = intent.getStringExtra("xLocation").toString()
                ylocation = intent.getStringExtra("yLocation").toString()
                val lacationName = intent.getStringExtra("lacationName").toString()
                binding.addcatEdLocate.setText(lacationName)


                Log.d("Test", "xlocation : $xlocation")
                Log.d("Test", "ylocation : $ylocation")
                Log.d("Test", "lacationName : $lacationName")
            }
        }
    }
*/


    override fun onPostAddCatSuccess(result: AddCatInfo) {
        Toast.makeText(this, "등록되었습니다.", Toast.LENGTH_SHORT).show()

        finish()
    }

    override fun onPostAddCatFailure(message: String) {
        Log.e("Test", "onPostAddCatFailure: $message")
    }


}