package com.kudbi.born.Pages

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kudbi.born.R


class AstrologyPage : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val arguments = intent.extras
        val sltDayStr = arguments!!["Day"].toString()
        val sltMonthStr = arguments!!["Month"].toString()

        val sltDay = Integer.parseInt(sltDayStr)
        val sltMonth = Integer.parseInt(sltMonthStr)

        if((sltDay in 21..31 && sltMonth == 3) || (sltDay in 1..20 && sltMonth == 4)){setContentView(R.layout.activity_astrology_page_oven)}
        if((sltDay in 21..30 && sltMonth == 4) || (sltDay in 1..20 && sltMonth == 5)){setContentView(R.layout.activity_astrology_page_telec)}
        if((sltDay in 21..31 && sltMonth == 5) || (sltDay in 1..20 && sltMonth == 6)){setContentView(R.layout.activity_astrology_page_bliznecy)}
        if((sltDay in 21..30 && sltMonth == 6) || (sltDay in 1..22 && sltMonth == 7)){setContentView(R.layout.activity_astrology_page_rak)}
        if((sltDay in 23..31 && sltMonth == 7) || (sltDay in 1..22 && sltMonth == 8)){setContentView(R.layout.activity_astrology_page_lev)}
        if((sltDay in 23..31 && sltMonth == 8) || (sltDay in 1..23 && sltMonth == 9)){setContentView(R.layout.activity_astrology_page_deva)}
        if((sltDay in 24..30 && sltMonth == 9) || (sltDay in 1..23 && sltMonth == 10)){setContentView(R.layout.activity_astrology_page_vesy)}
        if((sltDay in 24..31 && sltMonth == 10) || (sltDay in 1..21 && sltMonth == 11)){setContentView(R.layout.activity_astrology_page_skorpion)}
        if((sltDay in 22..30 && sltMonth == 11) || (sltDay in 1..21 && sltMonth == 12)){setContentView(R.layout.activity_astrology_page_strelec)}
        if((sltDay in 22..31 && sltMonth == 12) || (sltDay in 1..19 && sltMonth == 1)){setContentView(R.layout.activity_astrology_page_kozerog)}
        if((sltDay in 22..31 && sltMonth == 1) || (sltDay in 1..18 && sltMonth == 2)){setContentView(R.layout.activity_astrology_page_vodoley)}
        if((sltDay in 19..29 && sltMonth == 2) || (sltDay in 1..20 && sltMonth == 3)){setContentView(R.layout.activity_astrology_page_ryby)}

    }

}