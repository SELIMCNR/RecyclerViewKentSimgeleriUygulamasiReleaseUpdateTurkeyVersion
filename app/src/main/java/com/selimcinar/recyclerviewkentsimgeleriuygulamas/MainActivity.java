package com.selimcinar.recyclerviewkentsimgeleriuygulamas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.selimcinar.recyclerviewkentsimgeleriuygulamas.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    //Global kapsamlar
    private ActivityMainBinding binding;
    ArrayList<Landmark> landmarkArrayList;

    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



            binding = ActivityMainBinding.inflate(getLayoutInflater());
            View view = binding.getRoot();
            setContentView(view);
            //Listeyi initilaze etme yükleme
            landmarkArrayList=new ArrayList<>();

                mediaPlayer = MediaPlayer.create(this, R.raw.turkiyem); // raw klasöründeki ses dosyasını belirtin

            //Classta tutulan datalar veriler.
            Landmark anitkabir=new Landmark("Anıtkabir","Türkiye","Anıtkabir, Türkiye'nin başkenti Ankara'da yer alan bir anıt ve anıt mezar kompleksidir. Türkiye Cumhuriyeti'nin kurucusu Mustafa Kemal Atatürk'ün mozolesidir ve aynı zamanda Cumhuriyet'in ilk Cumhurbaşkanı olan Atatürk'ün anısına yapılmış bir ulusal anıttır. Anıtkabir, Türkiye'nin en önemli tarihî ve kültürel simgelerinden biridir.  İşte Anıtkabir'in temel özellikleri:  Konum: Anıtkabir, Ankara'nın Çankaya ilçesinde, Atatürk Orman Çiftliği'nin üzerinde, Anıttepe adı verilen bir tepe üzerinde yer almaktadır. Bu konum, Anıtkabir'e çevre şehirlerden ve ziyaretçilerden geniş bir görüş açısı sunmaktadır.",R.drawable.anitkabir);
            Landmark saatkulesi=new Landmark("İzmir Saat Kulesi","Türkiye","\n" +
                    "İzmir Saat Kulesi, Türkiye'nin batısındaki İzmir şehrinin simgelerinden biridir. İzmir Saat Kulesi, Konak Meydanı'nda yer alır ve kentin tarihî ve kültürel önemini yansıtan bir yapıdır. ",R.drawable.izmir_saat_kulesi);
            Landmark kizkulesi=new Landmark("Kız kulesi","Türkiye","\n" +
                    "Kız Kulesi, İstanbul Boğazı'nın güney girişinde, Üsküdar sahilinde yer alan tarihi bir kule ve ada üzerinde bulunan yapıdır. Türkiye'nin en ünlü sembollerinden biri olan Kız Kulesi, tarih boyunca çeşitli amaçlar için kullanılmış ve birçok efsane ve hikayeye ev sahipliği yapmıştır.",R.drawable.kiz_kulesi);
            Landmark SelimiyeCami=new Landmark("Selimiye Cami","Türkiye","\n" +
                    "Selimiye Camii, Osmanlı İmparatorluğu'nun ünlü mimarı Mimar Sinan tarafından 1568-1574 yılları arasında inşa edilen bir camidir. Osmanlı mimarisinin en önemli örneklerinden biri olan Selimiye Camii, Edirne'de bulunmaktadır. 2011 yılında UNESCO tarafından Dünya Mirası olarak kabul edilmiştir.",R.drawable.selimiye_camii);
            Landmark Ayasofya = new Landmark("Ayasofya","Türkiye","İstanbul'un simgelerinden biri olan Ayasofya, Bizans İmparatorluğu döneminden bu yana pek çok önemli olaya tanıklık etmiştir. İlk olarak kilise olarak inşa edilen yapı daha sonra cami olarak kullanılmış, sonrasında ise müze olarak hizmet vermiştir.",R.drawable.ayasofya);
            Landmark Topkapı = new Landmark("Topkapı Sarayı","Türkiye"," Osmanlı İmparatorluğu'nun hükümet merkezi olarak kullanılan Topkapı Sarayı, muazzam mimarisi ve içerdiği tarihî eserleriyle ziyaretçileri kendisine çeker. Saray, saray bahçeleri, harem ve çeşitli galerileri içerir.",R.drawable.topkapi);
            Landmark pamukkale = new Landmark("Pamukkale Travatenleri","Türkiye","\"Pamukkale\" adı, üzerindeki beyaz traverten teraslarından gelir. Sıcak su kaynaklarından çıkan kireçli su, zamanla bu beyaz terasları oluşturmuştur. Pamukkale, antik Hierapolis kenti ile birlikte UNESCO Dünya Mirası olarak kabul edilmiştir.",R.drawable.pamukkale);
            Landmark efesAntikkent = new Landmark("Efes Antikenti","Türkiye","Efes, antik Roma İmparatorluğu'nun en önemli liman şehirlerinden biridir. Artemis Tapınağı, Celsus Kütüphanesi, Büyük Tiyatro gibi önemli tarihî kalıntıları içerir.",R.drawable.efesantikenti);
            Landmark nemrut = new Landmark("Nemrut Dağı","Türkiye","\n" +
                    "Nemrut Dağı, Türkiye'nin güneydoğusunda, Adıyaman iline bağlı Kahta ilçesinde yer alan bir dağdır. Adıyaman şehir merkezinin yaklaşık 40 kilometre doğusunda bulunan bu dağ, Kommagene Krallığı'na ait antik kalıntılarıyla ünlüdür. Nemrut Dağı Milli Parkı içinde yer almaktadır.\n" +
                    "\n" +
                    "Nemrut Dağı'nda en dikkat çeken özellik, M.Ö. 1. yüzyılda Kommagene Kralı I. Antiochus'un emriyle yapılmış devasa bir anıt mezar tepesidir. Bu anıt mezarın zirvesinde, dev heykeller ve dikilitaşlar bulunmaktadır. Heykeller, tanrılar, krallar ve aslanlar gibi figürlerle süslenmiştir. Bu anıt, günümüze kadar kalabilmiş önemli bir arkeolojik eserdir ve birçok turistin ziyaret ettiği bir turistik noktadır.\n" +
                    "\n" +
                    "Nemrut Dağı, UNESCO Dünya Mirası Listesi'nde de yer almaktadır. Ancak, zamanla çevresel etkiler, hava koşulları ve insan müdahalesi gibi faktörlerle heykellerde erozyon ve hasar meydana gelmiştir. Bu nedenle, ziyaretçilere duyarlı davranma ve koruma önlemlerine uyma önemlidir.",R.drawable.nemrut);

            Landmark manyas = new Landmark("Manyas Kuş Cenneti","Türkiye","\n" +
                    "Manyas Kuş Cenneti, Türkiye'nin kuzeybatısında, Balıkesir il sınırları içinde yer alan önemli bir sulak alan ve kuş gözlem bölgesidir. Türkiye'nin en eski ve en büyük kuş cennetlerinden biridir. Adını Manyas Gölü'nden almaktadır. Manyas Gölü, kuşların göç yolları üzerinde yer aldığı için özellikle göç mevsimlerinde birçok farklı kuş türüne ev sahipliği yapar.\n" +
                    "\n" +
                    "Manyas Kuş Cenneti, 1959 yılında \"Manyas Kuş Gözlemevi ve Milli Parkı\" olarak koruma altına alınmıştır. Daha sonra \"Manyas Kuş Cenneti\" olarak adlandırılmıştır. Alan, Ramsar Sözleşmesi kapsamında koruma altına alınmış sulak alanlardan biridir.\n" +
                    "Göl ve çevresindeki sulak alanlar, flamingo, bataklık kırlangıcı, kaşıkgaga, angıt, bahri, elmabaş patka gibi birçok su kuşu türüne ev sahipliği yapmaktadır. Özellikle bahar ve sonbahar dönemlerinde, göç eden kuşların uğrak noktası olarak bilinir. Kuş gözlemevi, ziyaretçilere göl ve çevresindeki kuşları gözlemleme imkanı sunar.\n" +
                    "Manyas Kuş Cenneti, hem doğa severler hem de kuş gözlemcileri için önemli bir destinasyondur. Bu alan, biyolojik çeşitliliğin korunması ve kuşların doğal yaşam alanlarının sürdürülebilir şekilde korunması amacıyla çalışmalar yürüten bir koruma alanıdır.",R.drawable.manyascenneti);

            Landmark anıt = new Landmark("Çanakkale Şehitler Anıtı","Türkiye",
                    "Çanakkale Şehitler Anıtı, Türkiye'nin Çanakkale ilinde yer alan, I. Dünya Savaşı'nda yaşanan Çanakkale Savaşları'nda hayatını kaybeden askerlerin anısına inşa edilmiş büyük bir anıttır. Bu anıt, Gelibolu Yarımadası üzerinde, Çanakkale Boğazı'nın Asya kıyısında yer almaktadır.\n" +
                    "Çanakkale Şehitler Anıtı, 1954 yılında dönemin Başbakanı Adnan Menderes tarafından açılmıştır. Anıt, 41.000 metrekarelik bir alanda inşa edilmiştir ve üzerindeki kule 41 metre yüksekliğindedir. Anıtın tasarımını ünlü Türk mimar Doğan Erginbaş yapmıştır. Anıt, Türk ve dünya tarihinde önemli bir dönemeç olan Çanakkale Savaşları'nda hayatını kaybeden Türk askerlerine ithaf edilmiştir.\n" +
                    "Anıtın etrafında, savaşta hayatını kaybeden askerlere ait kabirler, şehitlikler ve anıt mezarlar bulunmaktadır. Ziyaretçilere, Çanakkale Savaşları ve bu savaşa katılan askerlerle ilgili bilgiler sunan müzeler de ziyaret edilebilir.\n" +
                    "Çanakkale Şehitler Anıtı, Türk milletinin bağımsızlık mücadelesi ve vatan sevgisi ile ilgili önemli bir sembol olup, her yıl 18 Mart Çanakkale Zaferi'nin anıldığı törenlerde önemli bir rol oynamaktadır. Aynı zamanda, ziyaretçilere tarihî bir perspektif sunan önemli bir turistik ve kültürel mekan olarak bilinir.\n" +
                    "\n" +
                    "\n",R.drawable.cannakkale);

            Landmark erzurum = new Landmark("Erzurum Üç Kümbetler","Türkiye","Üç Kümbetler, Erzurum'da bulunan 12. yüzyıl ile 14. yüzyıl tarihleri arasında yapıldıkları düşünülen kümbetlerdir. Anadolu eserlerinin arasında Devlet adamlarına ya da alimlerin mezar, türbe mimarisindeki önemli yapılarından biri olduğu sanılan Üç Kümbetler, 12 ve 14. yüzyıl arasında inşa edildiğini sanılmaktadır.",R.drawable.erzurum);

            Landmark kale = new Landmark("Kahramanmaraş Kalesi","Türkiye","\n" +
                    "Kahramanmaraş Kalesi, Türkiye'nin Kahramanmaraş şehrinde bulunan tarihi bir kaledir. Kale, Kahramanmaraş'ın merkezinde, Dulkadiroğulları Beyliği'nin kurucusu olan Süleyman Şah'ın oğlu Halil Bey tarafından 1160-1170 yılları arasında inşa edilmiştir. Daha sonra Osmanlı İmparatorluğu tarafından onarılmış ve kullanılmıştır.\n" +
                    "\n" +
                    "Kahramanmaraş Kalesi, konumu itibariyle şehri yüksek bir noktadan gözetleme ve savunma amacıyla inşa edilmiştir. Kale, Osmanlı ve Selçuklu mimarisinin etkilerini taşıyan bir yapıdır. Dikdörtgen planlı olan kale, etrafında surlarla çevrilidir. Kale içinde birçok tarihi yapı, cami ve depo gibi binalar yer almaktadır.\n" +
                    "\n" +
                    "Kale, zaman içinde birçok onarımdan geçmiştir. Günümüzde, Kahramanmaraş Kalesi şehrin tarihî ve turistik önemini koruyan bir yapı olarak bilinir. Ziyaretçiler, kaleyi gezip tarihî atmosferini deneyimleyebilir ve çevresindeki şehir manzarasını görebilirler. Kale çevresinde ayrıca çeşitli tarihi eserler ve mekanlar da bulunmaktadır, bu da ziyaretçilere zengin bir kültürel deneyim sunmaktadır.",R.drawable.kale);

            //Listeye classta tutulan verileri ekleme
            landmarkArrayList.add(anitkabir);
            landmarkArrayList.add(saatkulesi);
            landmarkArrayList.add(kizkulesi);
            landmarkArrayList.add(SelimiyeCami);
            landmarkArrayList.add(Ayasofya);
            landmarkArrayList.add(Topkapı);
            landmarkArrayList.add(pamukkale);
            landmarkArrayList.add(efesAntikkent);
            landmarkArrayList.add(nemrut);
            landmarkArrayList.add(manyas);
            landmarkArrayList.add(anıt);
            landmarkArrayList.add(erzurum);
            landmarkArrayList.add(kale);
            /*
            //Adapter : Layoutu ve veriyi birbirine bağlar.
            //Listview

            //mapping : Bir yapıyı başka bir yapıya döndürür classı yazıya dönüştürme gibi örnek
            ArrayAdapter arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,landmarkArrayList.stream().map(landmark -> landmark.name ).collect(Collectors.toList()));
            binding.listView.setAdapter(arrayAdapter);

            //Listviewde herhangi biryere tıklanınca ne olsunu =   binding.listView.setOnClickListener();
            //Listview içerisinde iteme nesneye tıklanınca neolsun  binding.listView.setOnItemClickListener();
            //Listview içerisinde uzun tıklanınca ne olsun binding.listView.setOnLongClickListener();
            binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //Tıklanan liste elemanınını toast mesajı olarak gösterme
                    Toast.makeText(MainActivity.this, landmarkArrayList.get(position).name, Toast.LENGTH_SHORT).show();
                    //Tıklanan liste elemanının adını diğer aktiviteye veri olarak yollama
                    Intent intent =new Intent(MainActivity.this,DetailsActivity.class);
                    intent.putExtra("landmark",landmarkArrayList.get(position));
                    startActivity(intent);
                }
            });
             */

        /*Recycler View Kent simgeleri uygulaması */
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landmarkArrayList);
        binding.recyclerView.setAdapter(landmarkAdapter);
        //Liner layout yada grid layout çeşitleri var görünümde xmli grid layout yaparsan new GridLayoutManager(this) yazmalısın
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        }


    @Override
    protected void onStart() {
        super.onStart();
        mediaPlayer.start(); // Ses çalmaya başla
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.release();
    }
}


