package gads.mobile.ecom05.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

import androidx.viewpager2.adapter.FragmentStateAdapter
import gads.mobile.ecom05.fragments.walkthrough.WalkThroughScreenFragment
import gads.mobile.ecom05.fragments.walkthrough.WalkThroughScreenThreeFragment
import gads.mobile.ecom05.fragments.walkthrough.WalkThroughScreenTwoFragment


class WalkThroughScreenPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
     return  when(position){
           0-> WalkThroughScreenFragment()


               1-> WalkThroughScreenTwoFragment()
             else-> WalkThroughScreenThreeFragment()

       }
    }
}