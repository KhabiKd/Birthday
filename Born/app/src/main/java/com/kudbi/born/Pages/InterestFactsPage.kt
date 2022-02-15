package com.kudbi.born.Pages

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kudbi.born.R

class InterestFactsPage : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val arguments = intent.extras
        val name = arguments!!["Month"].toString()


        when(Integer.parseInt(name)){
            1 -> setContentView(R.layout.activity_interest_facts_page_january)
            2 -> setContentView(R.layout.activity_interest_facts_page_february)
            3 -> setContentView(R.layout.activity_interest_facts_page_march)
            4 -> setContentView(R.layout.activity_interest_facts_page_april)
            5 -> setContentView(R.layout.activity_interest_facts_page_may)
            6 -> setContentView(R.layout.activity_interest_facts_page_june)
            7 -> setContentView(R.layout.activity_interest_facts_page_july)
            8 -> setContentView(R.layout.activity_interest_facts_page_august)
            9 -> setContentView(R.layout.activity_interest_facts_page_september)
            10 -> setContentView(R.layout.activity_interest_facts_page_october)
            11 -> setContentView(R.layout.activity_interest_facts_page_november)
            12 -> setContentView(R.layout.activity_interest_facts_page_december)
        }
    }
}