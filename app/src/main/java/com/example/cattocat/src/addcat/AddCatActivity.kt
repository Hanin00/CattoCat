package com.example.cattocat.src.addcat

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cattocat.Companion.Companion.USERID
import com.example.cattocat.databinding.ActivityAddCatBinding
import com.example.cattocat.src.addcat.map.MakeMarkerActivity
import com.example.cattocat.src.addcat.model.AddCatInfo


class AddCatActivity : AppCompatActivity(), AddCatView {
    private lateinit var binding: ActivityAddCatBinding
    private var addCatInfolist = listOf<AddCatInfo>()

    private var xlocation = ""
    private var ylocation = ""
    private val locatefrommap = ""
    private var cmom: Int = 0
    private var ctnr: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityAddCatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClick()
        binding.addcatIvMarker.setOnClickListener {
            val intent = Intent(this, MakeMarkerActivity::class.java)
            startActivity(intent)
        }


        val profImg = ""
        val image = ""

        binding.addcatIvClose.setOnClickListener {
            finish()
        }




        binding.addcatBtnSend.setOnClickListener {

            val name = binding.addcatEdName.text.toString()
            val eye = binding.addcatEdEye.text.toString()
            val hair = binding.addcatEdHair.text.toString()
            val socks = binding.addcatEdSocks.text.toString()
            val locate = binding.addcatEdLocate.text.toString()


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
                                    USERID,
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

    private fun initClick(){
        binding.catmomSeg1.setOnClickListener {
            cmom == 0
            binding.catmomSeg1.isChecked = true
            binding.catmomSeg2.isChecked = false
            binding.catmomSeg3.isChecked = false

        }
        binding.catmomSeg2.setOnClickListener {
            cmom == 1
            binding.catmomSeg1.isChecked = false
            binding.catmomSeg2.isChecked = true
            binding.catmomSeg3.isChecked = false

        }
        binding.catmomSeg3.setOnClickListener {
            cmom == 2
            binding.catmomSeg1.isChecked = false
            binding.catmomSeg2.isChecked = false
            binding.catmomSeg3.isChecked = true

        }

        binding.cattnrSeg1.setOnClickListener {
            ctnr == 0
            binding.cattnrSeg1.isChecked = true
            binding.cattnrSeg2.isChecked = false
            binding.cattnrSeg3.isChecked = false

        }
        binding.cattnrSeg2.setOnClickListener {
            ctnr == 1
            binding.cattnrSeg1.isChecked = false
            binding.cattnrSeg2.isChecked = true
            binding.cattnrSeg3.isChecked = false

        }
        binding.cattnrSeg3.setOnClickListener {
            ctnr == 2
            binding.cattnrSeg1.isChecked = false
            binding.cattnrSeg2.isChecked = false
            binding.cattnrSeg3.isChecked = true

        }
    }


    override fun onPostAddCatSuccess(result: AddCatInfo) {
        Toast.makeText(this, "등록되었습니다.", Toast.LENGTH_SHORT).show()

        finish()
    }

    override fun onPostAddCatFailure(message: String) {
        Log.e("Test", "onPostAddCatFailure: $message")
    }


}