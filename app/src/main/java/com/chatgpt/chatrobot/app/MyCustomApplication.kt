package com.chatgpt.chatrobot.app

import android.app.Application
import com.smartlook.android.core.api.Smartlook

class MyCustomApplication : Application() {
  override fun onCreate() {
    super.onCreate()
        
    val smartlook = Smartlook.instance
    smartlook.preferences.projectKey = "023ae45c0bf3f300b3eb5c865dada807481804d3"
    if(applicationContext.getSharedPreferences(packageName, MODE_PRIVATE).getBoolean("islogin",false)) {
      smartlook.user.email =
        applicationContext.getSharedPreferences(packageName, MODE_PRIVATE).getString("email","")
      smartlook.user.name =
        applicationContext.getSharedPreferences(packageName, MODE_PRIVATE).getString("name","")
    }
    smartlook.start()



  }
}