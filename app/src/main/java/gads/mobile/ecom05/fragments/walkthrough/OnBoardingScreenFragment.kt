package gads.mobile.ecom05.fragments.walkthrough

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.tabs.TabLayoutMediator
import gads.mobile.ecom05.R
import gads.mobile.ecom05.adapters.WalkThroughScreenPagerAdapter
import kotlinx.android.synthetic.main.fragment_onboarding_screen.view.*

const val ONBOARDING_PREF="gads.mobile.ecom05.onboarding"
class OnBoardingScreenFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_onboarding_screen,container,false)


      view.viewpager.adapter= WalkThroughScreenPagerAdapter(requireActivity())
        TabLayoutMediator(view.tablayout,view.viewpager,true) { _, _ ->

        }.attach()
        view.button_get_started.setOnClickListener {
            onBoardingFinished()
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_onBoardingScreenFragment_to_welcomeAuthPromptFragment)
        }
        return view

    }





    private fun onBoardingFinished() {
        val sharePreferences= requireActivity().getSharedPreferences(ONBOARDING_PREF, Context.MODE_PRIVATE)
        val editor=sharePreferences.edit()
        editor.putBoolean("firstTime",true)
        editor.apply()
    }
}