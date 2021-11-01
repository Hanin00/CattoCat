package com.example.cattocat.src.main.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.cattocat.Companion.Companion.USERID
import com.example.cattocat.R
import com.example.cattocat.databinding.FragmentHomeBinding
import com.example.cattocat.src.main.MainActivity
import com.example.cattocat.src.main.board.posting.PostActivity
import com.example.cattocat.src.main.home.model.*
import com.example.cattocat.src.main.home.viewpager.InfoViewRecyAdapter
import com.example.cattocat.src.main.home.viewpager.MyIntroPagerRecyAdapter
import com.example.cattocat.src.main.home.viewpager.NoticeRecyAdapter
import com.example.cattocat.src.main.setting.notice.viewer.ViewerActivity
import com.example.cattocat.util.Constants
import java.lang.Math.abs

//main Home
class HomeFragment : Fragment(), HomeView {
    private lateinit var binding: FragmentHomeBinding
    private var pageItemList = ArrayList<HomePostItem>()
    private var homeNoticeItemList = ArrayList<HomeNoticeItem>()
    private var homeAdItemList = ArrayList<HomeInfoItem>()
    private lateinit var myIntroPagerRecyclerAdapter: MyIntroPagerRecyAdapter
    private lateinit var noticeRecyAdapter: NoticeRecyAdapter
    private lateinit var infoRecyAdapter: InfoViewRecyAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        //각 View에 접근(ex/ binding.myTextView.text = "바인딩이 잘 되었어요!!"
        return binding.root
    }


    //todo ImageView ItemClick Listener 만들어야함

    override fun onResume() {
        super.onResume()
        HomeService(this).tryGetHome()
    }

    private val postClickListener = { postIdx: Int ->
        val intent = Intent(context, PostActivity::class.java)
        Log.d("Test", "postIdx $postIdx")
        intent.putExtra("isPostIdx", postIdx)
        intent.putExtra("isUserIdx", USERID)
        startActivity(intent)
    }

    private fun setListWithData(datalist: ArrayList<HomePostItem?>) {
        myIntroPagerRecyclerAdapter =
            MyIntroPagerRecyAdapter(datalist, requireContext(), postClickListener)
        myIntroPagerRecyclerAdapter.notifyDataSetChanged()
    }

    private val noticeClickListener = { noticeIdx: Int ->
        val intent = Intent(context, ViewerActivity::class.java)
        intent.putExtra(Constants.TEXT_ID, noticeIdx)
        intent.putExtra(Constants.FROM_NOTICE, true)
        startActivity(intent)
    }

    private fun noticeBannerAdapter(itemList: ArrayList<HomeNoticeItem?>) {
        noticeRecyAdapter = NoticeRecyAdapter(itemList, true, requireContext(), noticeClickListener)
        binding.homeVpAd.adapter = noticeRecyAdapter
        binding.homeVpAd.onIndicatorProgress = { selectingPosition, progress ->
            //  binding.homeTblIndicator.onPageScrolled(selectingPosition, progress)
        }
        // binding.homeTblIndicator.updateIndicatorCounts(bindinghomeVp2Banner.indicatorCount)
    }

    private val infoClickListener = { infoIdx: Int ->
        val intent = Intent(context, ViewerActivity::class.java)
        intent.putExtra(Constants.TEXT_ID, infoIdx)
        intent.putExtra(Constants.FROM_INFO, true)
        startActivity(intent)
    }

    private fun initInfoBannerAdapter(itemList: ArrayList<HomeInfoItem?>) {
        infoRecyAdapter = InfoViewRecyAdapter(itemList, true, requireContext(), infoClickListener)
        binding.homeVpAd.adapter = infoRecyAdapter
        binding.homeVpAd.onIndicatorProgress = { selectingPosition, progress ->
            //  binding.homeTblIndicator.onPageScrolled(selectingPosition, progress)
        }
        // binding.homeTblIndicator.updateIndicatorCounts(binding.homeVp2Banner.indicatorCount)
    }

    private fun initAdapter() {
        // 뷰페이저에 설정
        binding.homeVpPost.apply {
            adapter = myIntroPagerRecyclerAdapter
            //띄우는 페이지 수 default =` 1
            offscreenPageLimit = 4
            val offsetBetweenPages =
                resources.getDimensionPixelOffset(R.dimen.offsetBetweenPages).toFloat()
            setPageTransformer { page, position ->
                val myOffset = position * -(2 * offsetBetweenPages)
                if (position < -1) {
                    page.translationX = -myOffset
                } else if (position <= 1) {
                    // Paging 시 Y축 Animation 배경색을 약간 연하게 처리
                    val scaleFactor = 0.8f.coerceAtLeast(1 - abs(position))
                    page.translationX = myOffset
                    page.scaleY = scaleFactor
                    page.alpha = scaleFactor
                } else {
                    page.alpha = 0f
                    page.translationX = myOffset
                }
            }
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    Log.d("HomeFragment - ViewPager", "Page ${position + 1}")
                }
            })
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            binding.homeDotsIndicatorPost.setViewPager2(this)
        }

        binding.homeVpNotice.apply {
            adapter = noticeRecyAdapter
            offscreenPageLimit = 4
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onGetHomeSuccess(result: HomeResponse) {
        Log.d("Test", "정상연결")
        Log.d("Test", "${result}")

        setListWithData(result.bestpost as ArrayList<HomePostItem?>)
        noticeBannerAdapter(result.noticelist as ArrayList<HomeNoticeItem?>)
        initInfoBannerAdapter(result.infolist as ArrayList<HomeInfoItem?>)
        initAdapter()

    }

    override fun onGetHomeFailure(message: String) {
        Log.e("Test", "onPostAddCatFailure: $message")
    }
}