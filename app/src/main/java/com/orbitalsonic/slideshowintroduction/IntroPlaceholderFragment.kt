package com.orbitalsonic.slideshowintroduction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class IntroPlaceholderFragment : Fragment() {

    private lateinit var introPageViewModel: IntroPageViewModel
    private lateinit var introTitleList: Array<String>
    private lateinit var introMessageList: Array<String>
    private var introIMagesList = arrayOf(R.drawable.intro_image1,R.drawable.intro_image2,R.drawable.intro_image3,R.drawable.intro_image4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        introPageViewModel = ViewModelProvider(this).get(IntroPageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_introduction, container, false)
        val ivIntroImage: ImageView = root.findViewById(R.id.intro_image)
        val tvIntroTitle: TextView = root.findViewById(R.id.intro_title)
        val tvIntroMessage: TextView = root.findViewById(R.id.intro_message)
        introTitleList = requireActivity().resources.getStringArray(R.array.intro_title_list)
        introMessageList = requireActivity().resources.getStringArray(R.array.intro_message_list)
        introPageViewModel.mPosition.observe(viewLifecycleOwner, Observer<Int> {
            tvIntroTitle.text = introTitleList[it-1]
            tvIntroMessage.text = introMessageList[it-1]
            ivIntroImage.setImageResource(introIMagesList[it-1])
        })
        return root
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): IntroPlaceholderFragment {
            return IntroPlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}