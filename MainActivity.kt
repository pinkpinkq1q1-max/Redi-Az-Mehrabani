package ir.rediazmehrabani.game

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.widget.*

class MainActivity : Activity() {
 private val bg=Color.rgb(247,242,231); private val ink=Color.rgb(54,45,38)
 private val green=Color.rgb(49,78,63); private val gold=Color.rgb(174,127,58)
 private lateinit var root:LinearLayout
 private var score=0; private var stage=0
 data class Choice(val label:String,val ok:Boolean,val reply:String)
 data class Level(val title:String,val intro:String,val question:String,val choices:List<Choice>,val note:String)
 private val levels=listOf(
  Level("۱. امانت‌داری","در خاطره‌ای نقل‌شده از خانواده، محمدرضا پس از پیدا کردن کیف پولی با مبلغ قابل توجه، موضوع را با پدرش در میان گذاشت.","رفتار درست در این موقعیت چیست؟",listOf(
   Choice("پول را برای خود نگه دارد",false,"این انتخاب با خاطره نقل‌شده هم‌خوان نیست."),
   Choice("برای یافتن صاحب کیف پول اقدام کند",true,"درست است؛ در روایت گفته شده برای یافتن صاحب کیف پول پیگیری و آن را به پاسگاه تحویل دادند.")
  ),"این مرحله بر پایه خاطره‌ای است که خانواده از امانت‌داری شهید نقل کرده‌اند."),
  Level("۲. رفاقت و بخشندگی","دوستان شهید از روحیه صمیمی و دست‌ودل‌باز او گفته‌اند؛ اینکه داشته‌هایش را بی‌چشم‌داشت در اختیار دوستان می‌گذاشت.","کدام رفتار به این روایت نزدیک‌تر است؟",listOf(
   Choice("بی‌تفاوت ماندن",false,"این انتخاب با ویژگی‌ای که دوستانش توصیف کرده‌اند هماهنگ نیست."),
   Choice("کمک و همراهی در حد توان",true,"آفرین؛ دوستانش از روحیه کمک‌رسان و بی‌تکلف او یاد کرده‌اند.")
  ),"این بخش بر اساس توصیف دوستان از اخلاق و رفاقت او طراحی شده است."),
  Level("۳. مهارت و مسئولیت","محمدرضا در رشته مکانیک تحصیل کرده بود و به‌عنوان مکانیک موتورهای شناور در یگان دریایی دیر خدمت می‌کرد.","کدام کار نشان‌دهنده مسئولیت‌پذیری فنی است؟",listOf(
   Choice("بررسی موتور و گزارش دقیق ایرادها",true,"درست است؛ دقت و مسئولیت در کار فنی اهمیت دارد."),
   Choice("نادیده گرفتن ایرادهای کوچک",false,"نادیده گرفتن ایراد می‌تواند ایمنی و آمادگی شناور را به خطر بیندازد.")
  ),"اطلاعات شغلی این مرحله از شرح زندگی ارائه‌شده درباره شهید گرفته شده است."),
  Level("۴. همراهی در روزهای دشوار","دوستانش روایت کرده‌اند که در دوره‌های آموزشی و روزهای پرتنش، در کارهایی که نیاز به کمک داشتند پیش‌قدم می‌شد.","در یک گروه کاری، بهترین انتخاب چیست؟",listOf(
   Choice("فقط کار مربوط به خود را انجام دهد",false,"همکاری گروهی در این روایت جایگاه مهمی دارد."),
   Choice("در حد توان کنار دیگران بایستد",true,"درست است؛ دوستانش او را فردی مسئول و اهل همکاری توصیف کرده‌اند.")
  ),"این مرحله بازآفرینی آموزشی از توصیف دوستان است، نه نقل‌قول مستقیم.")
 )
 override fun onCreate(savedInstanceState:Bundle?){super.onCreate(savedInstanceState);window.statusBarColor=bg;window.navigationBarColor=bg;window.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;home()}
 private fun setup(sub:String){
  root=LinearLayout(this).apply{orientation=1;setPadding(24,22,24,22);setBackgroundColor(bg);layoutDirection=View.LAYOUT_DIRECTION_RTL}
  setContentView(ScrollView(this).apply{addView(root)})
  txt("ردّی از مهربانی",27,green,true,Gravity.CENTER);txt(sub,18,gold,true,Gravity.CENTER);space(16)
 }
 private fun txt(s:String,n:Int,c:Int=ink,b:Boolean=false,g:Int=Gravity.RIGHT){
  root.addView(TextView(this).apply{text=s;textSize=n.toFloat();setTextColor(c);typeface=if(b)Typeface.DEFAULT_BOLD else Typeface.DEFAULT;gravity=g;setPadding(4,10,4,10);textDirection=View.TEXT_DIRECTION_RTL;layoutDirection=View.LAYOUT_DIRECTION_RTL},LinearLayout.LayoutParams(-1,-2))
 }
 private fun space(h:Int){root.addView(View(this),LinearLayout.LayoutParams(1,h))}
 private fun btn(s:String,go:()->Unit){root.addView(Button(this).apply{text=s;textSize=15f;isAllCaps=false;setTextColor(Color.WHITE);setBackgroundColor(green);setOnClickListener{go()}},LinearLayout.LayoutParams(-1,-2).also{it.setMargins(0,7,0,7)})}
 private fun home(){
  setup("بازی داستانی و انتخاب‌محور")
  txt("به روایت خاطرات خانواده و دوستان",15,gold,true,Gravity.CENTER);space(10)
  txt("در این بازی کوتاه با چند روایت از زندگی شهید محمدرضا تمدن‌فر آشنا می‌شوید. در هر مرحله یک موقعیت پیش روی شما قرار می‌گیرد؛ انتخاب کنید و داستان را ادامه دهید.",17)
  space(8);txt("زادروز: ۱۰ شهریور ۱۳۸۱\nزادگاه: بهبهان\nمحل زندگی و رشد: استان بوشهر\nحوزه خدمت: یگان دریایی دیر\nمسئولیت: مکانیک موتورهای شناور\nتحصیلات: فوق‌دیپلم مکانیک",15)
  txt("هدف بازی، روایت ارزش‌هایی مانند امانت‌داری، رفاقت، مهارت و مسئولیت‌پذیری است. موقعیت‌های انتخابی، بازآفرینی آموزشی‌اند و نقل‌قول واقعی محسوب نمی‌شوند.",14)
  btn("شروع بازی"){score=0;stage=0;level()}
  btn("درباره بازی"){about()}
 }
 private fun about(){setup("درباره بازی");txt("«ردّی از مهربانی» نمونه اولیه یک بازی موبایلی داستانی است. مراحل آن از اطلاعات زندگی‌نامه‌ای و خاطرات نقل‌شده از پدر و دوستان شهید الهام گرفته‌اند.",16);txt("برای حفظ امانت، موقعیت‌های آموزشی به‌عنوان بازآفرینی معرفی شده‌اند و دیالوگ ساختگی به شهید نسبت داده نمی‌شود.",16);btn("بازگشت"){home()}}
 private fun level(){
  if(stage>=levels.size){finish();return};val l=levels[stage];setup("مرحله ${stage+1} از ${levels.size}")
  txt(l.title,23,green,true);txt(l.intro,16);space(6);txt(l.question,18,gold,true)
  l.choices.forEach{ch->btn(ch.label){if(ch.ok)score++;answer(ch)}}
 }
 private fun answer(ch:Choice){
  val l=levels[stage];setup("نتیجه انتخاب");txt(if(ch.ok)"آفرین!" else "بیایید دوباره فکر کنیم",22,if(ch.ok)green else gold,true)
  txt(ch.reply,17);space(8);txt(l.note,14)
  btn(if(stage==levels.lastIndex)"دیدن نتیجه نهایی" else "رفتن به مرحله بعد"){stage++;level()}
 }
 private fun finish(){
  setup("پایان مسیر");txt("امتیاز شما: $score از ${levels.size}",23,green,true,Gravity.CENTER)
  txt("در این مسیر با چند ویژگی اخلاقی و حرفه‌ای شهید محمدرضا تمدن‌فر آشنا شدید؛ امانت‌داری، بخشندگی، مهارت و مسئولیت‌پذیری.",17)
  txt("یاد و نامش گرامی",22,gold,true,Gravity.CENTER)
  btn("شروع دوباره"){score=0;stage=0;level()};btn("صفحه نخست"){home()}
 }
}
