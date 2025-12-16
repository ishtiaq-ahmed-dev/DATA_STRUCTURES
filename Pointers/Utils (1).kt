package com.foxentech.muslim.Prefrences

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.location.LocationManager
import android.net.Uri
import android.os.Parcel
import android.os.Vibrator
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.foxentech.muslim.Ui.Activity.BaseActivity
import androidx.core.content.FileProvider
import androidx.core.view.GravityCompat
import androidx.core.widget.NestedScrollView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.LifecycleOwner
import com.batoulapps.adhan.CalculationMethod
import com.batoulapps.adhan.CalculationParameters
import com.batoulapps.adhan.Coordinates
import com.batoulapps.adhan.Madhab
import com.batoulapps.adhan.PrayerTimes
import com.batoulapps.adhan.data.DateComponents
import com.bumptech.glide.Glide
import com.bumptech.glide.signature.ObjectKey
import com.foxentech.muslim.PermissionUtil.Func
import com.foxentech.muslim.PermissionUtil.PermissionUtil
import com.foxentech.muslim.R
import com.foxentech.muslim.Ui.Activity.Prayer.Adapter.PrayerAdapter
import com.foxentech.muslim.Ui.Activity.Prayer.Model.PrayItem
import com.foxentech.muslim.Ui.Activity.Ramadan.SimpleCallback
import com.foxentech.muslim.Ui.Activity.Zakat.ViewModel.ZakatViewModel
import com.foxentech.muslim.Ui.Dialog.DialogLocation
import com.foxentech.muslim.Ui.Dialog.DialogSelectCity

import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.TimeZone
import java.util.concurrent.TimeUnit
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

object Utils {

    //  lateinit  var listDataHeader: ArrayList<String>
//   lateinit var listDataChild: java.util.HashMap<String, List<String>>
    val ASR = "Asr"
    val DHUHR = "Dhuhr"
    val FAJR = "Fajr"
    val ISHA = "Isha'a"
    val MAGHRIB = "Maghrib"
    val SUNRISE = "Sunrise"
    val calendar = Calendar.getInstance()

    fun FastingList(
        context: Context,
        listDataHeader: ArrayList<String>,
        listDataChild: java.util.HashMap<String, List<String>>
    ) {
        // listDataHeader = java.util.ArrayList<String>()
        //listDataChild = HashMap<String, List<String>>()

        listDataHeader!!.add(context.getString(R.string.intro))
        listDataHeader!!.add(context.getString(R.string.thingfast))
        listDataHeader!!.add(context.getString(R.string.haram))
        listDataHeader!!.add(context.getString(R.string.persomexempted))
        listDataHeader!!.add(context.getString(R.string.thinginvalid))
        listDataHeader!!.add(context.getString(R.string.travelerramzan))
        listDataHeader!!.add(context.getString(R.string.fastingsick))
        listDataHeader!!.add(context.getString(R.string.kaffara))


        val Introduction: List<String> = java.util.ArrayList()
        val Things_Fast: List<String> = java.util.ArrayList()
        val Haram_Fasts: List<String> = java.util.ArrayList()
        val Person_Exempted: List<String> = java.util.ArrayList()
        val Invalidating_Fast: List<String> = java.util.ArrayList()
        val Traveler: List<String> = java.util.ArrayList()
        val Sick_person: List<String> = java.util.ArrayList()
        val Breaking_Fast: List<String> = java.util.ArrayList()

        listDataChild!!.put(listDataHeader!!.get(0), Introduction)
        listDataChild!!.put(listDataHeader!!.get(1), Things_Fast)
        listDataChild!!.put(listDataHeader!!.get(2), Haram_Fasts)
        listDataChild!!.put(listDataHeader!!.get(3), Person_Exempted)
        listDataChild!!.put(listDataHeader!!.get(4), Invalidating_Fast)
        listDataChild!!.put(listDataHeader!!.get(5), Traveler)
        listDataChild!!.put(listDataHeader!!.get(6), Sick_person)
        listDataChild!!.put(listDataHeader!!.get(7), Breaking_Fast)


    }

    fun ShahadahList(
        context: Context,
        listDataHeader: ArrayList<String>,
        listDataChild: java.util.HashMap<String, List<String>>
    ) {
//        listDataHeader = java.util.ArrayList<String>()
//        listDataChild = HashMap<String, List<String>>()

        listDataHeader.add(context.getString(R.string.intro))
        listDataHeader.add(context.getString(R.string.belieingod))
        listDataHeader.add(context.getString(R.string.belivprophets))
        listDataHeader.add(context.getString(R.string.belieholy))
        listDataHeader.add(context.getString(R.string.belivingangel))
        listDataHeader.add(context.getString(R.string.believingjudgement))
        listDataHeader.add(context.getString(R.string.bfate))


        val Introduction: List<String> = java.util.ArrayList()
        val Believing_in_God: List<String> = java.util.ArrayList()
        val Believing_in_Prophets: List<String> = java.util.ArrayList()
        val Believing_in_Holy_Books: List<String> = java.util.ArrayList()
        val Believing_in_Angels: List<String> = java.util.ArrayList()
        val Believing_in_Judgement_Day: List<String> = java.util.ArrayList()
        val Believing_in_Fate: List<String> = java.util.ArrayList()


        listDataChild.put(listDataHeader.get(0), Introduction)
        listDataChild.put(listDataHeader.get(1), Believing_in_God)
        listDataChild.put(listDataHeader.get(2), Believing_in_Prophets)
        listDataChild.put(listDataHeader.get(3), Believing_in_Holy_Books)
        listDataChild.put(listDataHeader.get(4), Believing_in_Angels)
        listDataChild.put(listDataHeader.get(5), Believing_in_Judgement_Day)
        listDataChild.put(listDataHeader.get(6), Believing_in_Fate)
    }

    fun ZakatList(
        context: Context,
        listDataHeader: ArrayList<String>,
        listDataChild: java.util.HashMap<String, List<String>>
    ) {
//        listDataHeader = java.util.ArrayList<String>()
//        listDataChild = HashMap<String, List<String>>()

        // Adding child data
        listDataHeader.add(context.getString(R.string.intro))
        listDataHeader.add(context.getString(R.string.personzakt))
        listDataHeader.add(context.getString(R.string.kindzakt))
        listDataHeader.add(context.getString(R.string.zakatdis))
        listDataHeader.add(context.getString(R.string.kindswealth))
        listDataHeader.add(context.getString(R.string.zaktrec))
        listDataHeader.add(context.getString(R.string.personwho))
        listDataHeader.add(context.getString(R.string.punishmnetzakat))

        // Adding child data
        val Introduction: List<String> = java.util.ArrayList()
        val Zakat_is_Obligatory: List<String> = java.util.ArrayList()
        val Zakat_Imposed: List<String> = java.util.ArrayList()
        val Zakat_Distribution: List<String> = java.util.ArrayList()
        val Applicable_for_Zakat: List<String> = java.util.ArrayList()
        val Zakat_Recipients: List<String> = java.util.ArrayList()
        val Person: List<String> = java.util.ArrayList()
        val Punishment: List<String> = java.util.ArrayList()

        listDataChild.put(listDataHeader.get(0), Introduction) // Header, Child
        // data
        listDataChild.put(listDataHeader.get(1), Zakat_is_Obligatory)
        listDataChild.put(listDataHeader.get(2), Zakat_Imposed)
        listDataChild.put(listDataHeader.get(3), Zakat_Distribution)
        listDataChild.put(listDataHeader.get(4), Applicable_for_Zakat)
        listDataChild.put(listDataHeader.get(5), Zakat_Recipients)
        listDataChild.put(listDataHeader.get(6), Person)
        listDataChild.put(listDataHeader.get(7), Punishment)
    }


    fun SalahList(
        context: Context,
        listDataHeader: ArrayList<String>,
        listDataChild: java.util.HashMap<String, List<String>>
    ) {
//        listDataHeader = java.util.ArrayList<String>()
//        listDataChild = HashMap<String, List<String>>()

        // Adding child data
        listDataHeader.add(context.getString(R.string.intro))
        listDataHeader.add(context.getString(R.string.typenamaz))
        listDataHeader.add(context.getString(R.string.dailypr))
        listDataHeader.add(context.getString(R.string.ruleqibla))
        listDataHeader.add(context.getString(R.string.conditondress))
        listDataHeader.add(context.getString(R.string.makroohthing))
        listDataHeader.add(context.getString(R.string.thingsmake))
        listDataHeader.add(context.getString(R.string.doubtnamaz))

        // Adding child data
        val Introduction: List<String> = java.util.ArrayList()
        val Types_of_Salah: List<String> = java.util.ArrayList()
        val Daily_Prayer_Rakaats: List<String> = java.util.ArrayList()
        val Rules_of_Qibla: List<String> = java.util.ArrayList()
        val Condition_For_Dress_Worn_for_Prayers: List<String> = java.util.ArrayList()
        val Makrooh_Thing: List<String> = java.util.ArrayList()
        val Things_which_make_Prayer_Void: List<String> = java.util.ArrayList()
        val Doubts_in_Namaz: List<String> = java.util.ArrayList()

        listDataChild.put(listDataHeader.get(0), Introduction) // Header, Child
        // data
        listDataChild.put(listDataHeader.get(1), Types_of_Salah)
        listDataChild.put(listDataHeader.get(2), Daily_Prayer_Rakaats)
        listDataChild.put(listDataHeader.get(3), Rules_of_Qibla)
        listDataChild.put(listDataHeader.get(4), Condition_For_Dress_Worn_for_Prayers)
        listDataChild.put(listDataHeader.get(5), Makrooh_Thing)
        listDataChild.put(listDataHeader.get(6), Things_which_make_Prayer_Void)
        listDataChild.put(listDataHeader.get(7), Doubts_in_Namaz)
    }


    fun HajiList(
        context: Context,
        listDataHeader: ArrayList<String>,
        listDataChild: java.util.HashMap<String, List<String>>
    ) {
//        listDataHeader = java.util.ArrayList<String>()
//        listDataChild = HashMap<String, List<String>>()

        // Adding child data
        listDataHeader.add(context.getString(R.string.intro))

        listDataHeader.add(context.getString(R.string.enteringihram))
        listDataHeader.add(context.getString(R.string.perumrah))
        listDataHeader.add(context.getString(R.string.departuremina))
        listDataHeader.add(context.getString(R.string.deparafat))
        listDataHeader.add(context.getString(R.string.depmuz))
        listDataHeader.add(context.getString(R.string.returnmina))
        listDataHeader.add(context.getString(R.string.tawafifada))
        listDataHeader.add(context.getString(R.string.againmina))
        listDataHeader.add(context.getString(R.string.farewell))

        val Introduction: List<String> = java.util.ArrayList()
        val State_of_Ihram: List<String> = java.util.ArrayList()
        val Performing_Umrah: List<String> = java.util.ArrayList()
        val Departure_to_Mina: List<String> = java.util.ArrayList()
        val Departure_to_Arafat: List<String> = java.util.ArrayList()
        val Departure_to_Muzdalifa: List<String> = java.util.ArrayList()
        val Returning_to_Mina: List<String> = java.util.ArrayList()
        val Tawaf_Al_Ifada: List<String> = java.util.ArrayList()
        val Returning_Mina: List<String> = java.util.ArrayList()
        val FArewell_Tawaf: List<String> = java.util.ArrayList()

        listDataChild.put(listDataHeader.get(0), Introduction) // Header, Child
        // data
        listDataChild.put(listDataHeader.get(1), State_of_Ihram)
        listDataChild.put(listDataHeader.get(2), Performing_Umrah)
        listDataChild.put(listDataHeader.get(3), Departure_to_Mina)
        listDataChild.put(listDataHeader.get(4), Departure_to_Arafat)
        listDataChild.put(listDataHeader.get(5), Departure_to_Muzdalifa)
        listDataChild.put(listDataHeader.get(6), Returning_to_Mina)
        listDataChild.put(listDataHeader.get(7), Tawaf_Al_Ifada)
        listDataChild.put(listDataHeader.get(8), Returning_Mina)
        listDataChild.put(listDataHeader.get(9), FArewell_Tawaf)
        ///listDataChild.put(listDataHeader.get(0), Introduction); // Header, Child
        // data
        //listDataChild.put(listDataHeader.get(1), steps);
    }
    fun vibratorLong(context: Context) {
        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (vibrator != null && vibrator.hasVibrator()) {
            vibrator.vibrate(3000)
        }
    }

    fun vibrator(context: Context) {
        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (vibrator != null && vibrator.hasVibrator()) {
            vibrator.vibrate(250)
        }
    }

    fun startMapByLocal(context: Context, str: String) {
        try {
            val intent = Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=$str"))
            intent.setPackage("com.google.android.apps.maps")
            context.startActivity(intent)
        } catch (unused: Exception) {
            Toast.makeText(context, "Google Maps not install!", Toast.LENGTH_SHORT).show()
        }
    }

    fun goToNextActivity(context: Context, Activity: AppCompatActivity) {
        val intent = Intent(context, AppCompatActivity::class.java)
        context.startActivity(intent)
    }

    fun getLocalDate(): String {
        val df = SimpleDateFormat("dd-MMM-yyyy")
        val formattedDate = df.format(calendar.time)
        return formattedDate
    }

    fun dateFormatter(): SimpleDateFormat {
        val formatter = SimpleDateFormat("hh:mm")
        return formatter
    }
    fun dateFormatter2(): SimpleDateFormat {
        val formatter = SimpleDateFormat("hh:mm a")
        return formatter
    }

    fun dateFormatterAMPM(): SimpleDateFormat {
        val formatter = SimpleDateFormat("a")
        return formatter
    }


    @SuppressLint("SetWorldReadable")
    fun shareBitmap(
        context: Activity, bitmap: Bitmap, str: String?,
        simpleCallback: SimpleCallback,
        imageView: com.jsibbold.zoomage.ZoomageView,
        share: ImageView

    ) {
        object : Thread() {
            override fun run() {
                super.run()
                try {
                    val file = File(context.cacheDir, "muslim_calendar")

                    file.mkdirs()

                    val fileOutputStream = FileOutputStream("$file/muslim_calendar.png")
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)
                    fileOutputStream.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                val file2 = File(File(context.cacheDir, "muslim_calendar"), "muslim_calendar.png")
                //    Context context = context;
                val uriForFile = FileProvider.getUriForFile(
                    context,
                    context.packageName + ".fileprovider",
                    file2
                )
                //  val type =    context.contentResolver.getType(uriForFile)


                val appPlayStoreLink =
                    "https://play.google.com/store/apps/details?id=${context.packageName}"
                context.runOnUiThread {
                    share.setOnClickListener {


                        if (uriForFile != null) {
                            val intent = Intent()
                            intent.action = "android.intent.action.SEND"
                            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                            intent.setDataAndType(
                                uriForFile,
                                context.contentResolver.getType(uriForFile)
                            )
                            intent.putExtra("android.intent.extra.STREAM", uriForFile)
                            intent.putExtra(
                                Intent.EXTRA_TEXT,
                                "Get the Muslim Prayer to explore more islamic content: $appPlayStoreLink"
                            )
                            context.startActivity(Intent.createChooser(intent, str))
                        }
                    }
                    Glide.with(context)
                        .load(uriForFile)
                        .signature(ObjectKey(System.currentTimeMillis())) // Provide a unique signature
                        .into(imageView)
                }

                //    App.SimpleCallback simpleCallback = simpleCallback;
                simpleCallback.callback(simpleCallback)
            }
        }.start()
    }

    private fun getBitmapFromView(view: View, i: Int, i2: Int): Bitmap {
        val createBitmap = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(createBitmap)
        val background = view.background
        if (background != null) {
            background.draw(canvas)
        } else {
            canvas.drawColor(-1)
        }
        view.draw(canvas)
        return createBitmap
    }

    fun shareRamadanTable(
        context: Activity,
        view: NestedScrollView,
        imageView: com.jsibbold.zoomage.ZoomageView,
        share: ImageView
    ) {
        val progressDialog = ProgressDialog(context)
        progressDialog.setMessage("Loading...")
        progressDialog.setCancelable(false)


        shareBitmap(
            context,
            getBitmapFromView(
                view,
                view.getChildAt(0).height,
                view.getChildAt(0).width
            ),
            "share via", object : SimpleCallback {
                override fun describeContents(): Int {
                    return 0
                }

                override fun writeToParcel(p0: Parcel, p1: Int) {
                    TODO("Not yet implemented")
                }


                override fun callback(obj: Any?) {
                    progressDialog.dismiss()
                    // view.visibility = View.GONE

                }
            },
            imageView, share
        )



        progressDialog.show()
    }


    fun shareApp(context: Context) {
        val appPackageName = context.packageName
        val appPlayStoreLink = "https://play.google.com/store/apps/details?id=$appPackageName"

        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, context.getString(R.string.app_name))
            putExtra(
                Intent.EXTRA_TEXT,
                "Get the Muslim Prayer to explore more islamic content: $appPlayStoreLink"
            )
        }

        context.startActivity(Intent.createChooser(shareIntent, "Share via"))
    }

    fun PrayerTable(hGDate: HGDate, context: Context): PrayerTimes {
        val sharedPreferences = context.getSharedPreferences(
            "myPrefs",
            Context.MODE_PRIVATE
        )
        val instance = Calendar.getInstance()
        instance[1] = hGDate.year
        instance[2] = hGDate.month - 1
        instance[5] = hGDate.day

        val value = sharedPreferences.getString(
            Convention_ID,
            context.getString(R.string.karachi_calculation)
        ) ?: context.getString(R.string.karachi_calculation)
        val asr_method_name = sharedPreferences.getString(
            AsrMethod_Name,
            context.getString(R.string.hanfi)
        ) ?: context.getString(R.string.hanfi)
        var params: CalculationParameters = CalculationMethod.KARACHI.parameters
        val date: DateComponents =
            DateComponents.from(instance.time)

        val coordinates =
            Coordinates(LocationSave.getLat(context).toDouble(), LocationSave.getLon(context))
        var prayerTimes: PrayerTimes = PrayerTimes(coordinates, date, params)
        when (value) {
            context.getString(R.string.karachi_calculation) -> {
                params = CalculationMethod.KARACHI.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)
                // getPrayerItems(prayItems,prayerTimes,prayerAdapter)
            }

            context.getString(R.string.Egyption_genral_calculation) -> {
                params = CalculationMethod.EGYPTIAN.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)
                // getPrayerItems(prayItems,prayerTimes,prayerAdapter)
            }

            context.getString(R.string.Muslim_World_League_calculation) -> {
                params = CalculationMethod.MUSLIM_WORLD_LEAGUE.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)
                //  getPrayerItems(prayItems,prayerTimes,prayerAdapter)
            }

            context.getString(R.string.north_america_calculation) -> {
                params = CalculationMethod.NORTH_AMERICA.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)
                //  getPrayerItems(prayItems,prayerTimes,prayerAdapter)
            }

            context.getString(R.string.TheMinistryofAwqafandIslamicAffairsinKuwait) -> {
                params = CalculationMethod.KUWAIT.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)
                //getPrayerItems(prayItems,prayerTimes,prayerAdapter)
            }

            context.getString(R.string.MajlisUgamaIslamSingapuraSingapore) -> {
                params = CalculationMethod.SINGAPORE.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)
                // getPrayerItems(prayItems,prayerTimes,prayerAdapter)
            }
        }
//        val instance = Calendar.getInstance()
//        instance[1] = hGDate.year
//        instance[2] = hGDate.month - 1
//        instance[5] = hGDate.day
//        val coordinates = Coordinates(LocationSave.getLat(context), LocationSave.getLon(context))
//        val params = CalculationMethod.KARACHI.parameters
//        params!!.madhab = Madhab.HANAFI
//        val year = hGDate.year
//        val month = hGDate.month - 1
//        val day = hGDate.day
//        val date = DateComponents.from(instance.time)
//        Log.e("dgs", "${hGDate.year}:${hGDate.month-1}:${hGDate.day}")
//
//        val prayerTimes = PrayerTimes(coordinates, date, params)
        return prayerTimes
    }


    fun RamadanTable(hGDate: HGDate, context: Context): PrayerTimes {
        val sharedPreferences = context.getSharedPreferences(
            "myPrefs",
            Context.MODE_PRIVATE
        )
        val instance = Calendar.getInstance()
        instance[1] = hGDate.year
        instance[2] = hGDate.month - 1
        instance[5] = hGDate.day

        val value = sharedPreferences.getString(
            Convention_ID,
            context.getString(R.string.karachi_calculation)
        ) ?: context.getString(R.string.karachi_calculation)
        val asr_method_name = sharedPreferences.getString(
            AsrMethod_Name,
            context.getString(R.string.hanfi)
        ) ?: context.getString(R.string.hanfi)
        var params: CalculationParameters = CalculationMethod.KARACHI.parameters
        val date: DateComponents =
            DateComponents.from(instance.time)

        val coordinates =
            Coordinates(LocationSave.getLat(context).toDouble(), LocationSave.getLon(context))
        var prayerTimes: PrayerTimes = PrayerTimes(coordinates, date, params)
        when (value) {
            context.getString(R.string.karachi_calculation) -> {
                params = CalculationMethod.KARACHI.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)
                // getPrayerItems(prayItems,prayerTimes,prayerAdapter)
            }

            context.getString(R.string.Egyption_genral_calculation) -> {
                params = CalculationMethod.EGYPTIAN.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)
                // getPrayerItems(prayItems,prayerTimes,prayerAdapter)
            }

            context.getString(R.string.Muslim_World_League_calculation) -> {
                params = CalculationMethod.MUSLIM_WORLD_LEAGUE.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)
                //  getPrayerItems(prayItems,prayerTimes,prayerAdapter)
            }

            context.getString(R.string.north_america_calculation) -> {
                params = CalculationMethod.NORTH_AMERICA.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)
                //  getPrayerItems(prayItems,prayerTimes,prayerAdapter)
            }

            context.getString(R.string.TheMinistryofAwqafandIslamicAffairsinKuwait) -> {
                params = CalculationMethod.KUWAIT.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)
                //getPrayerItems(prayItems,prayerTimes,prayerAdapter)
            }

            context.getString(R.string.MajlisUgamaIslamSingapuraSingapore) -> {
                params = CalculationMethod.SINGAPORE.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)
                // getPrayerItems(prayItems,prayerTimes,prayerAdapter)
            }
        }
//        val instance = Calendar.getInstance()
//        instance[1] = hGDate.year
//        instance[2] = hGDate.month - 1
//        instance[5] = hGDate.day
//        val coordinates = Coordinates(LocationSave.getLat(context), LocationSave.getLon(context))
//        val params = CalculationMethod.KARACHI.parameters
//        params!!.madhab = Madhab.HANAFI
//        val year = hGDate.year
//        val month = hGDate.month - 1
//        val day = hGDate.day
//        val date = DateComponents.from(instance.time)
//        Log.e("dgs", "${hGDate.year}:${hGDate.month-1}:${hGDate.day}")
//
//        val prayerTimes = PrayerTimes(coordinates, date, params)
        return prayerTimes
    }

    fun formatIslamicMonthDigitToName(context: Context, monthDigits: String): String {
        var monthName = context.resources.getString(R.string.month1)
        when (monthDigits) {
            "01" -> {
                monthName = context.resources.getString(R.string.month1)
            }

            "02" -> {
                monthName = context.resources.getString(R.string.month2)
            }

            "03" -> {
                monthName = context.resources.getString(R.string.month3)
            }

            "04" -> {
                monthName = context.resources.getString(R.string.month4)
            }

            "05" -> {
                monthName = context.resources.getString(R.string.month5)
            }

            "06" -> {
                monthName = context.resources.getString(R.string.month6)
            }

            "07" -> {
                monthName = context.resources.getString(R.string.month7)
            }

            "08" -> {
                monthName = context.resources.getString(R.string.month8)
            }

            "09" -> {
                monthName = context.resources.getString(R.string.month9)
            }

            "10" -> {
                monthName = context.resources.getString(R.string.month10)
            }

            "11" -> {
                monthName = context.resources.getString(R.string.month11)
            }

            "12" -> {
                monthName = context.resources.getString(R.string.month12)
            }
        }
        return monthName
    }

    fun currentTimeMillis(): Long {
        return System.currentTimeMillis()
    }

    fun updateTitleTime(
        hgDate: HGDate,
        context: Context,
        localDatess: TextView?,
        islamicDate: TextView?,
        prayerItem: ArrayList<PrayItem>?,
        prayerAdapter: PrayerAdapter?,
        number: Int,
        c: Calendar,
        Date: Date,
        zakatViewModel: ZakatViewModel,
        owner: LifecycleOwner
    ) {
        hgDate.toGregorian()
        val convertNumberType: String =
            NumbersLocal.convertNumberType(context, hgDate.year.toString())
        hgDate.toGregorian()
        if (localDatess != null) {
//            localDatess.setText(
//                NumbersLocal.convertNumberType(
//                    context,
//                    hgDate!!.day.toString()
//                ) + " " + (Dates.gregorianMonthName(
//                    context,
//                    hgDate!!.month + -1
//                ) + "") + " " + convertNumberType
//            )
//            NumbersLocal.convertNumberType(context, hgDate.day .toString()) + " " + (Dates.gregorianMonthName(context,
//                hgDate.getMonth() + -1
//            ) + "") + " " + convertNumberType
            val groegianMonth_name = Dates.gregorianMonthName(context, hgDate.month + -1)
            localDatess.text = "$groegianMonth_name ${hgDate.day}, ${convertNumberType}"
        }

        hgDate.toHigri(zakatViewModel, context, owner)
        val convertNumberType2: String = NumbersLocal.convertNumberType(
            context,
            java.lang.String.valueOf(hgDate.day - 1).trim { it <= ' ' })
        var trim: String =
            Dates.islamicMonthName(context, hgDate.month - 1).trim()
        val convertNumberType3: String =
            NumbersLocal.convertNumberType(context, hgDate.year.toString())
        if (convertNumberType2 == "0") {
            if (islamicDate != null && localDatess != null) {
                trim = Dates.islamicMonthName(context, hgDate.month - 2).trim()
                islamicDate.text = "30 $trim $convertNumberType3"

            }
        } else {
            if (islamicDate != null && localDatess != null) {
                islamicDate.text = "$convertNumberType2 $trim $convertNumberType3"

            }
        }


        if (prayerItem != null && prayerAdapter != null) {
            getPrayer(hgDate, prayerItem, prayerAdapter, context, number, c, Date)
        }


    }

    fun getPreviousTimestamp(currentTimestamp: Long): Long {
        var previousTimestamp: Long
        try {
            val c = Calendar.getInstance()
            c.timeInMillis = currentTimestamp
            c.add(Calendar.DATE, -1)
            previousTimestamp = c.timeInMillis
        } catch (e: java.lang.Exception) {
            previousTimestamp = currentTimestamp
        }
        return previousTimestamp
    }

    fun getNextTimestamp(currentTimestamp: Long): Long {
        var previousTimestamp: Long
        try {
            val c = Calendar.getInstance()
            c.timeInMillis = currentTimestamp
            c.add(Calendar.DATE, +1)
            previousTimestamp = c.timeInMillis
        } catch (e: java.lang.Exception) {
            previousTimestamp = currentTimestamp
        }
        return previousTimestamp
    }

    private fun getDate(arrayList: java.util.ArrayList<String>, hgDate: HGDate): Array<Date?> {
        val dateArr = arrayOfNulls<Date>(6)
        for (i in arrayList.indices) {
            val split = arrayList[i].split(":".toRegex()).toTypedArray()
            val parseInt = split[0].toInt()
            val parseInt2 = split[1].toInt()
            val instance = Calendar.getInstance()
            instance[hgDate.year, hgDate.month - 1, hgDate.day, parseInt, parseInt2] =
                0
            dateArr[i] = instance.time
        }
        return dateArr
    }
//    fun getPrayerTimess(context: Context): Map<String, Pair<Long, String>> {
//        Log.d("Debugs", "Fetching prayer times...")
//
//        val sharedPreferences = context.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
//        val calculationMethod = sharedPreferences.getString(
//            Convention_ID, context.getString(R.string.karachi_calculation)
//        ) ?: context.getString(R.string.karachi_calculation)
//
//        val asrMethod = sharedPreferences.getString(
//            AsrMethod_Name, context.getString(R.string.hanfi)
//        ) ?: context.getString(R.string.hanfi)
//
//        val coordinates = Coordinates(LocationSave.getLat(context).toDouble(), LocationSave.getLon(context))
//
//        val currentCalendar = Calendar.getInstance()
//        val currentTime = currentCalendar.timeInMillis
//
//        // ✅ Default is Today’s Prayers, but if current time is past Isha, use next day's prayers
//        val prayerDate: DateComponents = if (currentCalendar.get(Calendar.HOUR_OF_DAY) >= 22) { // Assuming Isha is after 10PM
//            Log.d("Debugs", "Isha is over, switching to next day's prayers")
//            val nextDayCalendar = Calendar.getInstance()
//            nextDayCalendar.add(Calendar.DAY_OF_MONTH, 1)
//            DateComponents.from(nextDayCalendar.time)
//        } else {
//            DateComponents.from(Date()) // Today's prayers
//        }
//
//        var params: CalculationParameters = CalculationMethod.KARACHI.parameters
//
//        when (calculationMethod) {
//            context.getString(R.string.karachi_calculation) -> params = CalculationMethod.KARACHI.parameters
//            context.getString(R.string.Egyption_genral_calculation) -> params = CalculationMethod.EGYPTIAN.parameters
//            context.getString(R.string.Muslim_World_League_calculation) -> params = CalculationMethod.MUSLIM_WORLD_LEAGUE.parameters
//            context.getString(R.string.north_america_calculation) -> params = CalculationMethod.NORTH_AMERICA.parameters
//            context.getString(R.string.TheMinistryofAwqafandIslamicAffairsinKuwait) -> params = CalculationMethod.KUWAIT.parameters
//            context.getString(R.string.MajlisUgamaIslamSingapuraSingapore) -> params = CalculationMethod.SINGAPORE.parameters
//        }
//
//        // ✅ Apply Hanfi/Shafi Fiqh for Asr calculation
//        params.madhab = if (asrMethod == context.getString(R.string.hanfi)) Madhab.HANAFI else Madhab.SHAFI
//
//        Log.d("Debugs", "Calculation method: $calculationMethod | Asr Madhab: $asrMethod | Date: $prayerDate")
//
//        val prayerTimes = PrayerTimes(coordinates, prayerDate, params)
//
//        // ✅ Fetch Prayer Names from Resources
//        val fajr = context.getString(R.string.fajr)
//        val dhur = context.getString(R.string.dhur)
//        val asr = context.getString(R.string.asr)
//        val maghrib = context.getString(R.string.maghrib)
//        val isha = context.getString(R.string.isha)
//
//        // ✅ Ensure times are correctly fetched and formatted
//        val times = mapOf(
//            fajr to Pair(prayerTimes.fajr.time, FAJR),
//            dhur to Pair(prayerTimes.dhuhr.time, DHUHR),
//            asr to Pair(prayerTimes.asr.time, ASR),
//            maghrib to Pair(prayerTimes.maghrib.time, MAGHRIB),
//            isha to Pair(prayerTimes.isha.time, ISHA)
//        )
//
//        Log.d("Debugs", "Prayer times fetched: $times")
//
//        return times
//    }
//fun getPrayerTimess(context: Context): Map<String, Triple<Long, String, Int>> {
//    Log.d("Debugs", "Fetching prayer times...")
//
//    val sharedPreferences = context.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
//    val calculationMethod = sharedPreferences.getString(
//        Convention_ID, context.getString(R.string.karachi_calculation)
//    ) ?: context.getString(R.string.karachi_calculation)
//
//    val asrMethod = sharedPreferences.getString(
//        AsrMethod_Name, context.getString(R.string.hanfi)
//    ) ?: context.getString(R.string.hanfi)
//
//    val coordinates =
//        Coordinates(LocationSave.getLat(context).toDouble(), LocationSave.getLon(context))
//    val currentCalendar = Calendar.getInstance(TimeZone.getDefault())
//    val currentTime = currentCalendar.timeInMillis
//
//    var params = CalculationMethod.KARACHI.parameters
//    when (calculationMethod) {
//        context.getString(R.string.karachi_calculation) -> params =
//            CalculationMethod.KARACHI.parameters
//
//        context.getString(R.string.Egyption_genral_calculation) -> params =
//            CalculationMethod.EGYPTIAN.parameters
//
//        context.getString(R.string.Muslim_World_League_calculation) -> params =
//            CalculationMethod.MUSLIM_WORLD_LEAGUE.parameters
//
//        context.getString(R.string.north_america_calculation) -> params =
//            CalculationMethod.NORTH_AMERICA.parameters
//
//        context.getString(R.string.TheMinistryofAwqafandIslamicAffairsinKuwait) -> params =
//            CalculationMethod.KUWAIT.parameters
//
//        context.getString(R.string.MajlisUgamaIslamSingapuraSingapore) -> params =
//            CalculationMethod.SINGAPORE.parameters
//    }
//
//    params.madhab =
//        if (asrMethod == context.getString(R.string.hanfi)) Madhab.HANAFI else Madhab.SHAFI
//
//    // ✅ Get today's prayer times first
//    val todayDate = DateComponents.from(currentCalendar.time)
//    val todayPrayerTimes = PrayerTimes(coordinates, todayDate, params)
//
//    // ✅ Check if current time is after Isha
//    if (currentTime > todayPrayerTimes.isha.time) {
//        Log.d("Debugs", "Isha passed. Switching to next day's prayer times.")
//        currentCalendar.add(Calendar.DAY_OF_MONTH, 1)
//    }
//
//    // ✅ Get prayer times based on currentCalendar date (today or next day)
//    val prayerDate = DateComponents.from(currentCalendar.time)
//    val prayerTimes = PrayerTimes(coordinates, prayerDate, params)
//
//    val fajr = context.getString(R.string.fajr)
//    val dhur = context.getString(R.string.dhur)
//    val asr = context.getString(R.string.asr)
//    val maghrib = context.getString(R.string.maghrib)
//    val isha = context.getString(R.string.isha)
//
//    val times = mapOf(
//        fajr to Triple(prayerTimes.fajr.time, FAJR, 90),
//        dhur to Triple(prayerTimes.dhuhr.time, DHUHR, 91),
//        asr to Triple(prayerTimes.asr.time, ASR, 92),
//        maghrib to Triple(prayerTimes.maghrib.time, MAGHRIB, 93),
//        isha to Triple(prayerTimes.isha.time, ISHA, 94)
//    )
//
//    Log.d("Debugs", "Prayer times fetched: $times")
//    return times
//}
fun getPrayerTimess(context: Context): Map<String, Triple<Calendar, String, Int>> {
    Log.d("Debugs", "Fetching prayer times...")

    val sharedPreferences = context.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
    val calculationMethod = sharedPreferences.getString(
        Convention_ID, context.getString(R.string.karachi_calculation)
    ) ?: context.getString(R.string.karachi_calculation)

    val asrMethod = sharedPreferences.getString(
        AsrMethod_Name, context.getString(R.string.hanfi)
    ) ?: context.getString(R.string.hanfi)

    val coordinates = Coordinates(LocationSave.getLat(context).toDouble(), LocationSave.getLon(context))
    val currentCalendar = Calendar.getInstance(TimeZone.getDefault())
    val currentTime = currentCalendar.timeInMillis

    var params = CalculationMethod.KARACHI.parameters
    when (calculationMethod) {
        context.getString(R.string.karachi_calculation) -> params = CalculationMethod.KARACHI.parameters
        context.getString(R.string.Egyption_genral_calculation) -> params = CalculationMethod.EGYPTIAN.parameters
        context.getString(R.string.Muslim_World_League_calculation) -> params = CalculationMethod.MUSLIM_WORLD_LEAGUE.parameters
        context.getString(R.string.north_america_calculation) -> params = CalculationMethod.NORTH_AMERICA.parameters
        context.getString(R.string.TheMinistryofAwqafandIslamicAffairsinKuwait) -> params = CalculationMethod.KUWAIT.parameters
        context.getString(R.string.MajlisUgamaIslamSingapuraSingapore) -> params = CalculationMethod.SINGAPORE.parameters
    }

    params.madhab = if (asrMethod == context.getString(R.string.hanfi)) Madhab.HANAFI else Madhab.SHAFI

    // ✅ Get today's prayer times first
    val todayDate = DateComponents.from(currentCalendar.time)
    val todayPrayerTimes = PrayerTimes(coordinates, todayDate, params)

    // ✅ If Isha has passed, shift to next day
    if (currentTime > todayPrayerTimes.isha.time) {
        Log.d("Debugs", "Isha passed. Switching to next day's prayer times.")
        currentCalendar.add(Calendar.DAY_OF_MONTH, 1)
    }

    // ✅ Get updated prayer times
    val prayerDate = DateComponents.from(currentCalendar.time)
    val prayerTimes = PrayerTimes(coordinates, prayerDate, params)

    // ✅ Convert each prayer time to Calendar object
    fun getCalendarFromDate(base: Calendar, time: Date): Calendar {
        return Calendar.getInstance(TimeZone.getDefault()).apply {
            timeInMillis = base.timeInMillis
            val prayer = Calendar.getInstance().apply { this.time = time }
            set(Calendar.HOUR_OF_DAY, prayer.get(Calendar.HOUR_OF_DAY))
            set(Calendar.MINUTE, prayer.get(Calendar.MINUTE))
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
    }

    val fajr = context.getString(R.string.fajr)
    val dhur = context.getString(R.string.dhur)
    val asr = context.getString(R.string.asr)
    val maghrib = context.getString(R.string.maghrib)
    val isha = context.getString(R.string.isha)

    val times = mapOf(
        fajr to Triple(getCalendarFromDate(currentCalendar, prayerTimes.fajr), FAJR, 90),
        dhur to Triple(getCalendarFromDate(currentCalendar, prayerTimes.dhuhr), DHUHR, 91),
        asr to Triple(getCalendarFromDate(currentCalendar, prayerTimes.asr), ASR, 92),
        maghrib to Triple(getCalendarFromDate(currentCalendar, prayerTimes.maghrib), MAGHRIB, 93),
        isha to Triple(getCalendarFromDate(currentCalendar, prayerTimes.isha), ISHA, 94)
    )

    Log.d("Debugs", "Prayer times fetched (Calendar): ${times.mapValues { it.value.first.time }}")
    return times
}






    private fun getPrayer(
        hgDate: HGDate,
        prayItems: ArrayList<PrayItem>,
        prayerAdapter: PrayerAdapter,
        context: Context,
        number: Int,
        c: Calendar,
        Date: Date
    ): ArrayList<PrayItem> {
        val sharedPreferences = context.getSharedPreferences(
            "myPrefs",
            Context.MODE_PRIVATE
        )

        hgDate.toGregorian()
        val value = sharedPreferences.getString(
            Convention_ID,
            context.getString(R.string.karachi_calculation)
        ) ?: context.getString(R.string.karachi_calculation)
        val asr_method_name = sharedPreferences.getString(
            AsrMethod_Name,
            context.getString(R.string.hanfi)
        ) ?: context.getString(R.string.hanfi)
        val calendar = Calendar.getInstance()

// Add one day to the current date
        calendar.add(Calendar.DAY_OF_MONTH, 1)

// Get the next day
        val nextDay = calendar.time
        var params: CalculationParameters = CalculationMethod.KARACHI.parameters

        val date: DateComponents = if (number != 0) {
            DateComponents.from(Date)
        } else {
            DateComponents.from(Date())
        }
        val coordinates =
            Coordinates(LocationSave.getLat(context).toDouble(), LocationSave.getLon(context))
        var prayerTimes: PrayerTimes = PrayerTimes(coordinates, date, params)
        when (value) {
            context.getString(R.string.karachi_calculation) -> {
                params = CalculationMethod.KARACHI.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)
                // getPrayerItems(prayItems,prayerTimes,prayerAdapter)
            }

            context.getString(R.string.Egyption_genral_calculation) -> {
                params = CalculationMethod.EGYPTIAN.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)
                // getPrayerItems(prayItems,prayerTimes,prayerAdapter)
            }

            context.getString(R.string.Muslim_World_League_calculation) -> {
                params = CalculationMethod.MUSLIM_WORLD_LEAGUE.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)
                //  getPrayerItems(prayItems,prayerTimes,prayerAdapter)
            }

            context.getString(R.string.north_america_calculation) -> {
                params = CalculationMethod.NORTH_AMERICA.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)
                //  getPrayerItems(prayItems,prayerTimes,prayerAdapter)
            }

            context.getString(R.string.TheMinistryofAwqafandIslamicAffairsinKuwait) -> {
                params = CalculationMethod.KUWAIT.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)
                //getPrayerItems(prayItems,prayerTimes,prayerAdapter)
            }

            context.getString(R.string.MajlisUgamaIslamSingapuraSingapore) -> {
                params = CalculationMethod.SINGAPORE.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)
                // getPrayerItems(prayItems,prayerTimes,prayerAdapter)
            }
        }



        prayItems.clear()
        val formatter = SimpleDateFormat("hh:mm a")
        prayItems.add(
            PrayItem(
                R.drawable.ic_fa,
                context.getString(R.string.fajr),
                prayerTimes.fajr.time,
                formatter.format(prayerTimes.fajr),
                FAJR

            )
        )
        prayItems.add(
            PrayItem(
                R.drawable.ic_dx,
                context.getString(R.string.sunrise),
                prayerTimes.sunrise.time,
                formatter.format(prayerTimes.sunrise),
                SUNRISE
            )
        )
        prayItems.add(
            PrayItem(
                R.drawable.nb,
                context.getString(R.string.dhur),
                prayerTimes.dhuhr.time,
                formatter.format(prayerTimes.dhuhr),
                DHUHR
            )
        )
        prayItems.add(
            PrayItem(
                R.drawable.ic_as,
                context.getString(R.string.asr),
                prayerTimes.asr.time,
                formatter.format(prayerTimes.asr),
                ASR
            )
        )
        prayItems.add(
            PrayItem(
                R.drawable.ic_mak,
                context.getString(R.string.maghrib),
                prayerTimes.maghrib.time,
                formatter.format(prayerTimes.maghrib),
                MAGHRIB
            )
        )
        prayItems.add(
            PrayItem(
                R.drawable.isha_icon,
                context.getString(R.string.isha),
                prayerTimes.isha.time,
                formatter.format(prayerTimes.isha),
                ISHA
            )
        )
        val instance = Calendar.getInstance()
        val instance2 = Calendar.getInstance()
        instance.timeInMillis = prayerTimes.fajr.time
        if (instance[5] == instance2[5] && instance[2] == instance2[2] && instance[1] == instance2[1]) {
            val it: Iterator<PrayItem> = prayItems.iterator()
            while (true) {
                if (!it.hasNext()) {
                    break
                }
                val next: PrayItem = it.next()
                if (next.time > instance2.timeInMillis) {
                    next.isSelect = (true)
                    break
                }
            }
        }
        prayerAdapter.notifyDataSetChanged()


        Log.e("cake", "${hgDate.year} ${hgDate.month} ${hgDate.day}")





        return prayItems

    }


    fun PrayerTableMonth(hGDate: HGDate): String {
        val instance = Calendar.getInstance()
        instance[1] = hGDate.year
        instance[2] = hGDate.month
        instance[5] = hGDate.day

        val simpleDateFormat = SimpleDateFormat("LLL")
        val dateTime = simpleDateFormat.format(instance.time).toString()

        return dateTime
    }

    fun getPrayerTimes(context: Context): PrayerTimes {
        val sharedPreferences = context.getSharedPreferences(
            "myPrefs",
            Context.MODE_PRIVATE
        )

        val value = sharedPreferences.getString(
            Convention_ID,
            context.getString(R.string.karachi_calculation)
        ) ?: context.getString(R.string.karachi_calculation)
        val asr_method_name = sharedPreferences.getString(
            AsrMethod_Name,
            context.getString(R.string.hanfi)
        ) ?: context.getString(R.string.hanfi)
        var params: CalculationParameters = CalculationMethod.KARACHI.parameters

        val date = DateComponents.from(Date())

        val coordinates =
            Coordinates(LocationSave.getLat(context).toDouble(), LocationSave.getLon(context))
        var prayerTimes: PrayerTimes = PrayerTimes(coordinates, date, params)
        when (value) {
            context.getString(R.string.karachi_calculation) -> {
                params = CalculationMethod.KARACHI.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)

            }

            context.getString(R.string.Egyption_genral_calculation) -> {
                params = CalculationMethod.EGYPTIAN.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)

            }

            context.getString(R.string.Muslim_World_League_calculation) -> {
                params = CalculationMethod.MUSLIM_WORLD_LEAGUE.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)

            }

            context.getString(R.string.north_america_calculation) -> {
                params = CalculationMethod.NORTH_AMERICA.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)

            }

            context.getString(R.string.TheMinistryofAwqafandIslamicAffairsinKuwait) -> {
                params = CalculationMethod.KUWAIT.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)

            }

            context.getString(R.string.MajlisUgamaIslamSingapuraSingapore) -> {
                params = CalculationMethod.SINGAPORE.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)

            }
//        val params = CalculationMethod.KARACHI.parameters
//        params!!.madhab = Madhab.HANAFI
//        val date = DateComponents.from(Date())
//
//        val coordinates =
//            Coordinates(LocationSave.getLat(context)!!.toDouble(), LocationSave.getLon(context))
//        val prayerTimes = PrayerTimes(coordinates, date, params)

        }
        return prayerTimes
    }

    fun nextPrayerTimeSehrIftar(time: Date, prayerTimes: PrayerTimes): Date? {
        prayerTimes.nextPrayer()
        val `when` = time.time
        return if (prayerTimes.maghrib.time - `when` <= 0) {
            prayerTimes.fajr

        } else if (prayerTimes.fajr.time - `when` <= 0) {
            prayerTimes.maghrib
        } else {
            prayerTimes.fajr
        }
    }

    fun nextPrayerTime(time: Date, prayerTimess: PrayerTimes, context: Context): Date? {
        val `when` = time.time
        return if (prayerTimess.isha.time - `when` <= 0) {
            nextDayFajr(fajrPrayerTimes(context = context))


        } else if (prayerTimess.maghrib.time - `when` <= 0) {
            prayerTimess.isha
        } else if (prayerTimess.asr.time - `when` <= 0) {
            prayerTimess.maghrib
        } else if (prayerTimess.dhuhr.time - `when` <= 0) {
            prayerTimess.asr
        } else if (prayerTimess.sunrise.time - `when` <= 0) {
            prayerTimess.dhuhr
        } else if (prayerTimess.fajr.time - `when` <= 0) {
            prayerTimess.sunrise
        } else {
            // prayerTimess.sunrise
            prayerTimess.fajr
        }
    }

    fun fajrPrayerTimes(context: Context): PrayerTimes {
        val sharedPreferences = context.getSharedPreferences(
            "myPrefs",
            Context.MODE_PRIVATE
        )

        val value = sharedPreferences.getString(
            Convention_ID,
            context.getString(R.string.karachi_calculation)
        ) ?: context.getString(R.string.karachi_calculation)
        val asr_method_name = sharedPreferences.getString(
            AsrMethod_Name,
            context.getString(R.string.hanfi)
        ) ?: context.getString(R.string.hanfi)
        var params: CalculationParameters = CalculationMethod.KARACHI.parameters
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, 1)
        val nextDay = calendar.time
        val date = DateComponents.from(nextDay)
        Log.e("next_day", "${nextDay}")

        val coordinates =
            Coordinates(LocationSave.getLat(context).toDouble(), LocationSave.getLon(context))
        var prayerTimes: PrayerTimes = PrayerTimes(coordinates, date, params)
        when (value) {
            context.getString(R.string.karachi_calculation) -> {
                params = CalculationMethod.KARACHI.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)

            }

            context.getString(R.string.Egyption_genral_calculation) -> {
                params = CalculationMethod.EGYPTIAN.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)

            }

            context.getString(R.string.Muslim_World_League_calculation) -> {
                params = CalculationMethod.MUSLIM_WORLD_LEAGUE.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)

            }

            context.getString(R.string.north_america_calculation) -> {
                params = CalculationMethod.NORTH_AMERICA.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)

            }

            context.getString(R.string.TheMinistryofAwqafandIslamicAffairsinKuwait) -> {
                params = CalculationMethod.KUWAIT.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)

            }

            context.getString(R.string.MajlisUgamaIslamSingapuraSingapore) -> {
                params = CalculationMethod.SINGAPORE.parameters
                if (asr_method_name == context.getString(R.string.hanfi)) {
                    params.madhab = Madhab.HANAFI
                } else {
                    params.madhab = Madhab.SHAFI
                }
                prayerTimes = PrayerTimes(coordinates, date, params)

            }
        }
        return prayerTimes
    }

    private fun nextDayFajr(prayerTimes: PrayerTimes): Date? {
        return prayerTimes.fajr
    }

    fun goToNextActivity(
        context: Context, cls: Class<*>, key: String,
        putValue: Int
    ) {
        val intent = Intent(context, cls)
        intent.putExtra(key, putValue)
        context.startActivity(intent)
    }

    fun ShowSelectLocationDialog(
        context: AppCompatActivity,
        dialogLocation: DialogLocation,
        dialogSelectCity: DialogSelectCity
    ): PermissionUtil.PermissionRequestObject? {
        val mRequestObject = PermissionUtil.with(context).request(
            "android.permission.ACCESS_FINE_LOCATION",
            "android.permission.ACCESS_COARSE_LOCATION"
        ).onAllGranted(object : Func() {
            /* access modifiers changed from: protected */
            @SuppressLint("MissingPermission", "SetTextI18n")
            override fun call() {
                getLocations(context, dialogLocation, dialogSelectCity = dialogSelectCity)
            }
        }).ask(12)
        return mRequestObject
    }

    private fun getLocations(
        context: AppCompatActivity,
        dialogLocation: DialogLocation,
        dialogSelectCity: DialogSelectCity
    ) {
        val locationManager =
            context.getSystemService(AppCompatActivity.LOCATION_SERVICE) as LocationManager
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            var dialogLocation2 = dialogLocation
            var dialogLocation3 = dialogSelectCity
            if (dialogLocation2 == null || !dialogLocation2.isShowing) {
                dialogLocation2 = DialogLocation(context, object : DialogLocation.Callback {
                    override fun OnLoctionGetSuccess() {
                        dialogLocation2.dismiss()

                        context.finish()
                        //  recreate()
                        // savePrefsData()

                    }

                    override fun OnSelectCityClick() {
                        dialogLocation2.dismiss()
                        if (dialogLocation3 == null || dialogLocation3.isShowing) {

                            dialogLocation3 = DialogSelectCity(context)
                            val unused: DialogSelectCity = dialogSelectCity
                            dialogSelectCity.setOnDismissListener(
                                DialogInterface.OnDismissListener {

                                    context.finish()
                                    //   recreate()

                                })
                            dialogLocation3.show()
                        }
                    }

                })
            }
            dialogLocation2.show()
        } else {
            showGPSDisabledAlertToUser(context)

        }


    }

    private fun showGPSDisabledAlertToUser(context: Context) {
        val alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context)
        alertDialogBuilder.setMessage("GPS is disabled in your device. Would you like to enable it?")

            .setCancelable(false)

            .setPositiveButton("Enable GPS",
                DialogInterface.OnClickListener { dialog, id ->
                    val callGPSSettingIntent = Intent(
                        Settings.ACTION_LOCATION_SOURCE_SETTINGS
                    )
                    context.startActivity(callGPSSettingIntent)

                })
        alertDialogBuilder.setNegativeButton("Cancel",
            DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })
        val alert: AlertDialog = alertDialogBuilder.create()
        alert.show()
    }
    fun ShowRating(context: Context, drawer: DrawerLayout) {
        context.startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("market://details?id=${context.packageName}")
            )
        )
        drawer.closeDrawer(GravityCompat.START)
    }

    fun sendEmail(context: Context, drawer: DrawerLayout) {
        val intent = Intent(Intent.ACTION_SEND)

        intent.type = "message/rfc822"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(context.getString(R.string.email_address)))
        intent.putExtra(Intent.EXTRA_SUBJECT, "subject of email")
        intent.putExtra(Intent.EXTRA_TEXT, "body of email")
        try {
            context.startActivity(Intent.createChooser(intent, "Send mail"))
            drawer.closeDrawer(GravityCompat.START)
        } catch (e: Exception) {
            Toast.makeText(context, "There are no email clients installed.", Toast.LENGTH_SHORT)
                .show()
            drawer.closeDrawer(GravityCompat.START)
        }
    }

    fun nextPrayerName(time: Date, prayerTimes: PrayerTimes, context: Context): String {
        val `when` = time.time

        return if (prayerTimes.isha.time - `when` <= 0) {
            context.getString(R.string.fajr)
        } else if (prayerTimes.maghrib.time - `when` <= 0) {
            //  Prayer.Isha
            context.getString(R.string.isha)
        } else if (prayerTimes.asr.time - `when` <= 0) {
            // Prayer.Maghrib
            context.getString(R.string.maghrib)

        } else if (prayerTimes.dhuhr.time - `when` <= 0) {
            //   Prayer.Asr
            context.getString(R.string.asr)

        } else if (prayerTimes.sunrise.time - `when` <= 0) {
            //  Prayer.Dhur
            context.getString(R.string.dhur)

        } else if (prayerTimes.fajr.time - `when` <= 0) {
            //   Prayer.Sunrise

            context.getString(R.string.sunrise)
        } else {
            //  Prayer.Fajr
            context.getString(R.string.fajr)

        }
    }

    fun getSehrIftar(context: Context, SehriTiming: TextView, IftarTiming: TextView, date: Date) {


        //  val   date = DateComponents.from(Date(c.time.year, c.time.month, c.time.day))
        val dates = DateComponents.from(date)


        val params = CalculationMethod.MUSLIM_WORLD_LEAGUE.parameters
        val coordinates =
            Coordinates(LocationSave.getLat(context).toDouble(), LocationSave.getLon(context))
        val prayerTimes = PrayerTimes(coordinates, dates, params)
        var formatter = SimpleDateFormat("hh:mm a")
        SehriTiming.text = "${formatter.format(prayerTimes.fajr)}"
        IftarTiming.text = "${formatter.format(prayerTimes.maghrib)}"
    }

    fun currentPrayer(time: Date, prayerTimes: PrayerTimes, context: Context): String {
        val `when` = time.time
        return if (prayerTimes.isha.time - `when` <= 0) {
            //  Prayer.Isha
            context.getString(R.string.isha)
        } else if (prayerTimes.maghrib.time - `when` <= 0) {
            //   Prayer.Maghrib
            context.getString(R.string.maghrib)
        } else if (prayerTimes.asr.time - `when` <= 0) {
            //   Prayer.Asr
            context.getString(R.string.asr)
        } else if (prayerTimes.dhuhr.time - `when` <= 0) {
            //   Prayer.Dhur
            context.getString(R.string.dhur)
        } else if (prayerTimes.sunrise.time - `when` <= 0) {
            // Prayer.Sunrise
            context.getString(R.string.sunrise)
        } else if (prayerTimes.fajr.time - `when` <= 0) {
            //Prayer.Fajr
            context.getString(R.string.fajr)
        } else {
            context.getString(R.string.isha)
        }
    }

    fun getAllPrayer(
        context: Context,
        FajrTiming: TextView,
        SunriseTiming: TextView,
        DhurTiming: TextView,
        AsrTiming: TextView,
        MaghribTiming: TextView,
        IshaTiming: TextView,
        date: Date
    ) {


        val sharedPreferences = context.getSharedPreferences("Location", Context.MODE_PRIVATE)
        val latitides = sharedPreferences.getString("lat", "45.67")!!.toDouble()
        val longitude = sharedPreferences.getString("long", "56.45")!!.toDouble()


        //  val   date = DateComponents.from(Date(c.time.year, c.time.month, c.time.day))
        val dates = DateComponents.from(date)


        val params = CalculationMethod.MUSLIM_WORLD_LEAGUE.parameters
        val coordinates = Coordinates(latitides, longitude)
        val prayerTimes = PrayerTimes(coordinates, dates, params)
        var formatter = SimpleDateFormat("hh:mm a")
        FajrTiming.text = "${formatter.format(prayerTimes.fajr)}"
        MaghribTiming.text = "${formatter.format(prayerTimes.maghrib)}"
        SunriseTiming.text = "${formatter.format(prayerTimes.sunrise)}"
        DhurTiming.text = "${formatter.format(prayerTimes.dhuhr)}"
        AsrTiming.text = "${formatter.format(prayerTimes.asr)}"
        IshaTiming.text = "${formatter.format(prayerTimes.isha)}"
    }

    fun nextSehrIftarName(time: Date, prayerTimes: PrayerTimes): String {
        val `when` = time.time
        return if (prayerTimes.maghrib.time - `when` <= 0) {
            "Sehr"

        } else if (prayerTimes.fajr.time - `when` <= 0) {
            "Iftar"
        } else {
            "Iftar"
        }
    }

    fun PutSharedprefrenceBoolean(key: String, value: Boolean, context: Context) {
        val sharedPreferences = context.getSharedPreferences(key, Context.MODE_PRIVATE).edit()
        sharedPreferences.putBoolean(key, value)
        sharedPreferences.apply()
    }

    fun GetSharedprefrenceBoolean(key: String, default: Boolean, context: Context): Boolean {
        val sharedPreferences = context.getSharedPreferences(key, Context.MODE_PRIVATE)
        val boolean = sharedPreferences.getBoolean(key, default)
        return boolean

    }

    fun PutSharedprefrenceString(key: String, value: String, context: Context) {
        val sharedPreferences = context.getSharedPreferences(key, Context.MODE_PRIVATE).edit()
        sharedPreferences.putString(key, value)
        sharedPreferences.apply()
    }

    fun GetSharedprefrenceString(key: String, default: String, context: Context): String? {
        val sharedPreferences = context.getSharedPreferences(key, Context.MODE_PRIVATE)
        val boolean = sharedPreferences.getString(key, default)
        return boolean

    }

    fun unpackZip(path: String, zipname: String): Boolean {
        val `is`: InputStream
        val zis: ZipInputStream
        try {
            `is` = FileInputStream(path + zipname)
            zis = ZipInputStream(BufferedInputStream(`is`))
            var ze: ZipEntry
            while (zis.getNextEntry().also { ze = it } != null) {
                val baos = ByteArrayOutputStream()
                val buffer = ByteArray(1024)
                var count: Int
                val filename: String = ze.name
                val fout = FileOutputStream(path + filename)

                // reading and writing
                while (zis.read(buffer).also { count = it } != -1) {
                    baos.write(buffer, 0, count)
                    val bytes: ByteArray = baos.toByteArray()
                    fout.write(bytes)
                    baos.reset()
                }
                fout.close()
                zis.closeEntry()
            }
            zis.close()
        } catch (e: IOException) {
            e.printStackTrace()
            return false
        }
        return true
    }

    fun milliSecondsToTimer(j: Long): String {
        val str: String
        var str2 = ""
        val i = (j / 3600000).toInt()
        val j2 = j % 3600000
        val i2 = j2.toInt() / 60000
        val i3 = (j2 % 60000 / 1000).toInt()
        if (i > 0) {
            str2 = "$i:"
        }
        str = if (i3 < 10) {
            "0$i3"
        } else {
            "" + i3
        }
        return "$str2$i2:$str"
    }

    fun milliSecondsToHourMinute(j: Long): String {
        val str: String
        val str2: String
        val i = (j / 3600000).toInt()
        val i2 = (j % 3600000).toInt() / 60000
        str = if (i > 1) {
            "$i hours "
        } else if (i == 1) {
            "$i hour "
        } else {
            ""
        }
        str2 = if (i2 > 1) {
            "$i2 minutes"
        } else {
            "$i2 minute"
        }
        return str + str2
    }


    fun milliSecondsToTimerDown(j: Long): String {
        val str: String
        val str2: String
        var str3 = ""
        val i = (j / 3600000).toInt()
        val j2 = j % 3600000
        val i2 = j2.toInt() / 60000
        val i3 = (j2 % 60000 / 1000).toInt()
        if (i > 0) {
            str3 = if (i < 10) {
                "0$i:"
            } else {
                "$i:"
            }
        }
        str = if (i2 < 10) {
            "0$i2"
        } else {
            "" + i2
        }
        str2 = if (i3 < 10) {
            "0$i3"
        } else {
            "" + i3
        }
        return "$str3$str:$str2"
    }
}



