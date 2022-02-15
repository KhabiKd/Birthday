package com.kudbi.born.Pages

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kudbi.born.R
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;





class HobbyPage : AppCompatActivity() {




    private var mInterstitialAd: InterstitialAd? = null
    private final var TAG = "HobbyPage"





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val argumentsWork = intent.extras
        val sltDayStrWork = argumentsWork!!["Day"].toString()
        val sltMonthStrWork = argumentsWork!!["Month"].toString()

        val sltDayWork = Integer.parseInt(sltDayStrWork)
        val sltMonthWork = Integer.parseInt(sltMonthStrWork)




        MobileAds.initialize(
            this
        ) { }

        var adRequest = AdRequest.Builder().build()

        InterstitialAd.load(this,"ca-app-pub-4987981798888119/3567560670", adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                Log.d(TAG, adError?.message)
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                Log.d(TAG, "Ad was loaded.")
                mInterstitialAd = interstitialAd
            }
        })

        mInterstitialAd?.fullScreenContentCallback = object: FullScreenContentCallback() {
            override fun onAdDismissedFullScreenContent() {
                Log.d(TAG, "Ad was dismissed.")
            }

            override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                Log.d(TAG, "Ad failed to show.")
            }

            override fun onAdShowedFullScreenContent() {
                Log.d(TAG, "Ad showed fullscreen content.")
                mInterstitialAd = null;
            }
        }




        if((sltDayWork in 21..31 && sltMonthWork == 3) || (sltDayWork in 1..20 && sltMonthWork == 4)){setContentView(
            R.layout.activity_work_page_oven
        )}
        if((sltDayWork in 21..30 && sltMonthWork == 4) || (sltDayWork in 1..20 && sltMonthWork == 5)){setContentView(
            R.layout.activity_work_page_telec
        )}
        if((sltDayWork in 21..31 && sltMonthWork == 5) || (sltDayWork in 1..20 && sltMonthWork == 6)){setContentView(
            R.layout.activity_work_page_bliznecy
        )}
        if((sltDayWork in 21..30 && sltMonthWork == 6) || (sltDayWork in 1..22 && sltMonthWork == 7)){setContentView(
            R.layout.activity_work_page_rak
        )}
        if((sltDayWork in 23..31 && sltMonthWork == 7) || (sltDayWork in 1..22 && sltMonthWork == 8)){setContentView(
            R.layout.activity_work_page_lev
        )}
        if((sltDayWork in 23..31 && sltMonthWork == 8) || (sltDayWork in 1..23 && sltMonthWork == 9)){setContentView(
            R.layout.activity_work_page_deva
        )}
        if((sltDayWork in 24..30 && sltMonthWork == 9) || (sltDayWork in 1..23 && sltMonthWork == 10)){setContentView(
            R.layout.activity_work_page_vesy
        )}
        if((sltDayWork in 24..31 && sltMonthWork == 10) || (sltDayWork in 1..21 && sltMonthWork == 11)){setContentView(
            R.layout.activity_work_page_skorpion
        )}
        if((sltDayWork in 22..30 && sltMonthWork == 11) || (sltDayWork in 1..21 && sltMonthWork == 12)){setContentView(
            R.layout.activity_work_page_strelec
        )}
        if((sltDayWork in 22..31 && sltMonthWork == 12) || (sltDayWork in 1..19 && sltMonthWork == 1)){setContentView(
            R.layout.activity_work_page_kozerog
        )}
        if((sltDayWork in 22..31 && sltMonthWork == 1) || (sltDayWork in 1..18 && sltMonthWork == 2)){setContentView(
            R.layout.activity_work_page_vodoley
        )}
        if((sltDayWork in 19..29 && sltMonthWork == 2) || (sltDayWork in 1..20 && sltMonthWork == 3)){setContentView(
            R.layout.activity_work_page_ryby
        )}
    }

    override fun onBackPressed() {
        if (mInterstitialAd != null) {
            mInterstitialAd?.show(this)
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.")
        }
        super.onBackPressed()
    }


}