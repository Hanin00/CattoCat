package com.example.cattocat.src.main.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cattocat.databinding.FragmentMycatBinding
import com.example.cattocat.databinding.FragmentSettingBinding


//설정
class SettingFragment : Fragment() {
    private lateinit var binding : FragmentSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSettingBinding.inflate(inflater, container,false)
        //각 View에 접근(ex/ binding.myTextView.text = "바인딩이 잘 되었어요!!"
        return binding.root
    }
}