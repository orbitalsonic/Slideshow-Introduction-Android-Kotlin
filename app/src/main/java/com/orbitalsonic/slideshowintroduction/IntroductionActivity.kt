package com.orbitalsonic.slideshowintroduction

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.zhpan.indicator.IndicatorView

class IntroductionActivity : AppCompatActivity() {

    private lateinit var skipButton: Button
    private lateinit var btnBeforeNavigate: FloatingActionButton
    private lateinit var btnNextNavigate: FloatingActionButton
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)

        initViews()
        onclickMethod()

        val introSectionsPagerAdapter = IntroSectionsPagerAdapter(this, supportFragmentManager)
        viewPager.adapter = introSectionsPagerAdapter
        val indicatorView: IndicatorView = findViewById(R.id.indicator_view)

        indicatorView.setPageSize(viewPager.adapter!!.count)
        indicatorView. setupWithViewPager(viewPager)
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                indicatorView.onPageSelected(position)
                btnBeforeNavigate.isEnabled = position != 0
                if (position==viewPager.adapter!!.count-1){
                    btnNextNavigate.setImageResource(R.drawable.ic_baseline_done_24)
                }else if (position==viewPager.adapter!!.count-2){
                    btnNextNavigate.setImageResource(R.drawable.ic_baseline_navigate_next_24)
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })


        onclickMethod()
    }

    private fun initViews(){
        viewPager = findViewById(R.id.view_pager)
        skipButton = findViewById(R.id.btn_skip)
        btnBeforeNavigate = findViewById(R.id.navigate_before)
        btnNextNavigate = findViewById(R.id.navigate_next)
    }

    private fun onclickMethod(){

        skipButton.setOnClickListener { nextActivity() }

        btnBeforeNavigate.setOnClickListener {
            viewPager.currentItem = viewPager.currentItem - 1
        }
        btnNextNavigate.setOnClickListener {
            if (viewPager.currentItem+1 == viewPager.adapter!!.count){
                nextActivity()
            }else{
                viewPager.currentItem = viewPager.currentItem + 1
            }

        }

    }

    private fun nextActivity(){
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
}