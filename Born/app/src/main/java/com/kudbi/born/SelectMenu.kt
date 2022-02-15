package com.kudbi.born

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.android.gms.ads.*
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.kudbi.born.Pages.*


class SelectMenu : AppCompatActivity() {

    private val TAG = "SelectMenu"

    private var mRewardedAd: RewardedAd? = null

    lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_menu)


        MobileAds.initialize(this)

        var adRequest = AdRequest.Builder().build()

        RewardedAd.load(this,"ca-app-pub-4987981798888119/1919662425", adRequest, object : RewardedAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                Log.d(TAG, adError?.message)
                mRewardedAd = null
            }

            override fun onAdLoaded(rewardedAd: RewardedAd) {
                Log.d(TAG, "Ad was loaded.")
                mRewardedAd = rewardedAd
            }
        })
        mRewardedAd?.fullScreenContentCallback = object: FullScreenContentCallback() {
            override fun onAdShowedFullScreenContent() {
                // Called when ad is shown.
                Log.d(TAG, "Ad was shown.")
            }

            override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                // Called when ad fails to show.
                Log.d(TAG, "Ad failed to show.")
            }

            override fun onAdDismissedFullScreenContent() {
                // Called when ad is dismissed.
                // Set the ad reference to null so you don't show the ad a second time.
                Log.d(TAG, "Ad was dismissed.")
                mRewardedAd = null
            }

        }


        //* Назначаем имена всем view, находящиеся в activity_select_menu.xml, которые будем использовать в коде */
        val imageBtn_1 = findViewById<ImageButton>(R.id.imageButton1)
        val imageBtn_2 = findViewById<ImageButton>(R.id.imageButton2)
        val imageBtn_3 = findViewById<ImageButton>(R.id.imageButton3)
        val imageBtn_4 = findViewById<ImageButton>(R.id.imageButton4)
        val btn_sovmestimost = findViewById<ImageButton>(R.id.btn_sovmestimost)
        val btn_ad = findViewById<ImageButton>(R.id.btn_ad)

        //* Получаем значения по ключу хранящиеся в intent, переданные из MainActivity */
        val arguments = intent.extras
        val nameMonth = arguments!!["month"].toString()
        val nameDay = arguments!!["day"].toString()
        val nameYear = arguments!!["year"].toString()

        val nameMonthInt = Integer.parseInt(nameMonth)
        val nameDayInt = Integer.parseInt(nameDay)
        val nameYearInt = Integer.parseInt(nameYear)

        //* Каждой кнопки присваиваем открытие соответсвующего экрана. Также через intent передаем значения Дня, Месяца*/
        imageBtn_1.setOnClickListener(){
            val intent = Intent(this, AstrologyPage::class.java)
            intent.putExtra("Month", nameMonthInt)
            intent.putExtra("Day", nameDayInt)
            startActivity(intent)
        }
        imageBtn_2.setOnClickListener(){
            val intent = Intent(this, HobbyPage::class.java)
            intent.putExtra("Month", nameMonthInt)
            intent.putExtra("Day", nameDayInt)
            startActivity(intent)
        }
        imageBtn_3.setOnClickListener(){
            val intent = Intent(this, FamousPage::class.java)
            intent.putExtra("Month", nameMonthInt)
            intent.putExtra("Day", nameDayInt)
            startActivity(intent)
        }
        imageBtn_4.setOnClickListener(){
            val intent = Intent(this, InterestFactsPage::class.java)
            intent.putExtra("Month", nameMonthInt)
            intent.putExtra("Day", nameDayInt)
            startActivity(intent)
        }
        btn_ad.setOnClickListener {

            dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.ad_dialog_screen)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setCancelable(false)


            val btnclose: TextView = dialog.findViewById(R.id.btnclose)
            btnclose.setOnClickListener{
                dialog.dismiss()
            }


            val btncontinue: Button = dialog.findViewById(R.id.btncontinue)
            btncontinue.setOnClickListener {

                if (mRewardedAd != null) {
                    mRewardedAd?.show(this, OnUserEarnedRewardListener() {
                        fun onUserEarnedReward(rewardItem: RewardItem) {
                            var rewardAmount = startActivity(intent)
                            var rewardType = rewardItem.getType()
                            Log.d(TAG, "User earned the reward.")

                        }

                    })

                } else {
                    Log.d(TAG, "The rewarded ad wasn't ready yet.")

                }

                dialog.dismiss()

                btn_ad.isVisible = false
                btn_sovmestimost.isVisible = true
                btn_sovmestimost.isEnabled = true

            }
            dialog.show()


        }

        btn_sovmestimost.setOnClickListener{
            val intent = Intent(this, Sovmestimost::class.java)
            intent.putExtra("Month", nameMonthInt)
            intent.putExtra("Day", nameDayInt)
            intent.putExtra("Year", nameYearInt)
            startActivity(intent)
        }

    }



}



