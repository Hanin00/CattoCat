package com.example.cattocat.src.main.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.cattocat.R
import com.example.cattocat.databinding.FragmentHomeBinding
import com.example.cattocat.src.main.home.ad.AdActivity
import com.example.cattocat.src.main.home.notice.NoticeActivity
import com.example.cattocat.src.main.home.viewpager.AdViewRecyAdapter
import com.example.cattocat.src.main.home.viewpager.MyIntroPagerRecyAdapter
import com.example.cattocat.src.main.home.viewpager.NoticeRecyAdapter
import com.example.cattocat.src.main.home.vpmodel.HomeAdItem
import com.example.cattocat.src.main.home.vpmodel.HomeNoticeItem
import com.example.cattocat.src.main.home.vpmodel.HomePostItem
import com.example.cattocat.util.Constants
import java.lang.Math.abs

//main Home
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private var pageItemList = ArrayList<HomePostItem>()
    private var homeNoticeItemList = ArrayList<HomeNoticeItem>()
    private var homeAdItemList = ArrayList<HomeAdItem>()
    private lateinit var myIntroPagerRecyclerAdapter: MyIntroPagerRecyAdapter
    private lateinit var noticeRecyAdapter: NoticeRecyAdapter
    private lateinit var adViewRecyAdapter: AdViewRecyAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        //각 View에 접근(ex/ binding.myTextView.text = "바인딩이 잘 되었어요!!"

        pageItemList.add(
            HomePostItem(
                R.drawable.dummy_cat_01,
                "고양이가 야옹야옹",
                "고양이가 야옹하면 강아지는 멍멍",
                1,
                1,
                "야생의 캔따개"
            )
        )
        pageItemList.add(
            HomePostItem(
                R.drawable.dummy_cat_02,
                "우리 주인님만 이러나요?",
                "스트릿 출신이 아니라서 고마움을 모르는 것 같아요",
                1,
                2,
                "우리집 고양이 턱시도 고양이"
            )
        )
        pageItemList.add(
            HomePostItem(
                R.drawable.dummy_cat_03,
                "걷다가 마주친 냥이",
                "캔따개가 되거나 집사가 되거나",
                1,
                6,
                "휴지"
            )
        )
        pageItemList.add(
            HomePostItem(
                R.drawable.dummy_cat_04,
                "고양이 댄스댄스",
                "원투 냥냥냥, 원투 차차차",
                8,
                17,
                "먼지"
            )
        )
        pageItemList.add(
            HomePostItem(
                R.drawable.dummy_cat_05,
                "고양이가 이상하게 자요",
                "안녕하세요. 다름이 아니라 고양이가 너무 이상하게 자요",
                17,
                20,
                "체다"
            )
        )
        pageItemList.add(
            HomePostItem(
                R.drawable.dummy_cat_06,
                "간식 말고 이상한걸 주워먹어요",
                "템테이션 하늘색이 유명하다는데 풀을 자꾸먹어요ㅠㅠ",
                21,
                19,
                "고등어 집사"
            )
        )

        homeNoticeItemList.add(HomeNoticeItem(R.drawable.dummy_cat_06, "고양이가 좋아하는 노래 모음", 2))
        homeNoticeItemList.add(HomeNoticeItem(R.drawable.dummy_cat_07, "고양이의 날 행사", 3))
        homeNoticeItemList.add(HomeNoticeItem(R.drawable.dummy_cat_08, "당신의 고양이는 무슨 고양이인가요?", 4))

        homeAdItemList.add(HomeAdItem(R.drawable.dummy_cat_11, "고양이가 좋아하는 캣 그로스 특가", 1))
        homeAdItemList.add(HomeAdItem(R.drawable.dummy_cat_12, "생식하는 고양이 멋찐 고양이", 11))
        homeAdItemList.add(HomeAdItem(R.drawable.dummy_cat_14, "벽지 긁는 우리고양이, 이거 하나면 끝!", 21))


        setListWithData(pageItemList)
        noticeBannerAdapter(homeNoticeItemList)
        initAdBannerAdapter(homeAdItemList)

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

        return binding.root
    }

    //todo ImageView ItemClick Listener 만들어야함


    private val postClickListener = { postIdx: Int ->
        /*  val intent = Intent(context, HospitalInformationActivity::class.java)
          intent.putExtra(Constants.HOSPITAL_IDX, hospitalIdx)
          intent.putExtra(Constants.FROM_AD_BANNER, true)
          startActivity(intent)*/
    }

    private fun setListWithData(datalist: ArrayList<HomePostItem>) {
        myIntroPagerRecyclerAdapter =
            MyIntroPagerRecyAdapter(datalist, requireContext(), postClickListener)
        myIntroPagerRecyclerAdapter.notifyDataSetChanged()
    }

    private val noticeClickListener = { noticeIdx: Int ->
        val intent = Intent(context, NoticeActivity::class.java)
          intent.putExtra(Constants.NOTICE_IDX, noticeIdx)
          intent.putExtra(Constants.FROM_AD_BANNER, true)
          startActivity(intent)
    }

    private fun noticeBannerAdapter(itemList: ArrayList<HomeNoticeItem>) {
        noticeRecyAdapter = NoticeRecyAdapter(itemList, true, requireContext(), noticeClickListener)
        binding.homeVpAd.adapter = noticeRecyAdapter
        binding.homeVpAd.onIndicatorProgress = { selectingPosition, progress ->
            //  binding.homeTblIndicator.onPageScrolled(selectingPosition, progress)
        }
        // binding.homeTblIndicator.updateIndicatorCounts(binding.homeVp2Banner.indicatorCount)
    }


    private val adClickListener = { adIdx: Int ->
        val intent = Intent(context, AdActivity::class.java)
        intent.putExtra(Constants.AD_IDX, adIdx)
        intent.putExtra(Constants.FROM_AD_BANNER, true)
        startActivity(intent)
    }

    private fun initAdBannerAdapter(itemList: ArrayList<HomeAdItem>) {
        adViewRecyAdapter = AdViewRecyAdapter(itemList, true, requireContext(), adClickListener)
        binding.homeVpAd.adapter = adViewRecyAdapter
        binding.homeVpAd.onIndicatorProgress = { selectingPosition, progress ->
            //  binding.homeTblIndicator.onPageScrolled(selectingPosition, progress)
        }
        // binding.homeTblIndicator.updateIndicatorCounts(binding.homeVp2Banner.indicatorCount)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
}