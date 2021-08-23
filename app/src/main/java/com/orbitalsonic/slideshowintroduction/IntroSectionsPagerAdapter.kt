package com.orbitalsonic.slideshowintroduction

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class IntroSectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a IntroPlaceholderFragment (defined as a static inner class below).
        return IntroPlaceholderFragment.newInstance(position + 1)
    }

    override fun getCount(): Int {
        // Show 4 total pages.
        return 4
    }
}