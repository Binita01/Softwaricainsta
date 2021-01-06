package com.binitasimbu.assignment5

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.binitasimbu.assignment5.UserAdapter.PostAdapter
import com.binitasimbu.assignment5.UserAdapter.StoryAdapter
import com.binitasimbu.assignment5.UserModel.AddPost
import com.binitasimbu.assignment5.UserModel.UserPost
import com.binitasimbu.assignment5.UserModel.ProfileData
import com.binitasimbu.assignment5.UserModel.UserStory
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Home_Activity : AppCompatActivity() {
    var name = "";
    var postImage = "";
    var profileImg = "";
    private var userStoryList= ArrayList<UserStory>()
    private   var userList = ArrayList<UserPost>()
    private val addnewpost=ArrayList<AddPost>();
    private lateinit var PostrecyclerView: RecyclerView
    private lateinit var StoryrecyclerView:RecyclerView
    private lateinit var floatingActionButton: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_)
        PostrecyclerView = findViewById(R.id.PostrecyclerView)
        StoryrecyclerView= findViewById(R.id.StoryrecyclerView)
        floatingActionButton = findViewById(R.id.floatingActionButton)


        loadUserData()

        val adapter = StoryAdapter(userStoryList, this)

        val mLayoutManager = LinearLayoutManager(applicationContext)
        mLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        StoryrecyclerView.layoutManager = mLayoutManager
        StoryrecyclerView.adapter = adapter;

        floatingActionButton.setOnClickListener {
            val req=1
            startActivityForResult(Intent(this,NewPost_Activity::class.java),req)

        }
        loadStoryImg()
        val adapter1 = PostAdapter(userList, this)
        PostrecyclerView.layoutManager = LinearLayoutManager(this)
        PostrecyclerView.adapter = adapter1;
        val intent = Intent()
        if (intent.extras != null) {
            name= intent.getStringExtra("name").toString()
            postImage = intent.getStringExtra("postimg").toString()
            profileImg = intent.getStringExtra("profileimg").toString()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                var post = data?.getParcelableExtra<AddPost>("UserPost")
                ProfileData(fname = "")
                addnewpost.add(post!!)
                postImage = addnewpost.get(0).postimg.toString()
                profileImg = addnewpost.get(0).profileimg.toString()
                name = addnewpost.get(0).name.toString()
                userList.add(UserPost(
                    "1",
                    "$name",
                    "$profileImg",
                    "$postImage",
                    "https://www.searchpng.com/wp-content/uploads/2019/02/Instagram-Like-Icon-1.png",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZHQeZ0qXJkpDkiRD5Pk1ojZA6FI_FaI583w&usqp=CAU",
                    "https://www.pngkit.com/png/full/188-1882778_icon-icon-icon-icon-instagram-share-icon-png.png",
                    "https://img.flaticon.com/icons/png/512/61/61140.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF"

                )
                )
                PostrecyclerView.adapter?.notifyDataSetChanged()
                userList.reverse()
            }
        }
    }

 fun loadUserData(){
        userList.add(UserPost("1","Kumar",
                "https://scontent.fktm3-1.fna.fbcdn.net/v/t31.0-0/c56.0.206.206a/p206x206/17038531_1579738105387414_3325740768316483283_o.jpg?_nc_cat=107&ccb=2&_nc_sid=2d5d41&_nc_ohc=FzvNJbu14ggAX8bKVqK&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=a0478fd735fadefb73a6d00cbc8cf969&oe=601AF62A",
                "https://scontent.fktm3-1.fna.fbcdn.net/v/t1.0-9/12143143_907060572719763_2377817478426527983_n.jpg?_nc_cat=104&ccb=2&_nc_sid=09cbfe&_nc_ohc=7RU-WQhfKhcAX-GOrRU&_nc_ht=scontent.fktm3-1.fna&oh=e7abf21d87c2ba52e01790bd0705efdd&oe=601B477E",
                "https://www.searchpng.com/wp-content/uploads/2019/02/Instagram-Like-Icon-1.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZHQeZ0qXJkpDkiRD5Pk1ojZA6FI_FaI583w&usqp=CAU",
                "https://www.pngkit.com/png/full/188-1882778_icon-icon-icon-icon-instagram-share-icon-png.png",
                "https://img.flaticon.com/icons/png/512/61/61140.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF"))


        userList.add(UserPost("2","Ritesh",
                "https://scontent.fktm3-1.fna.fbcdn.net/v/t1.0-0/c50.0.206.206a/p206x206/122145824_2856351607932931_9069710470856880478_o.jpg?_nc_cat=105&ccb=2&_nc_sid=110474&_nc_ohc=swKr8vC-u1EAX9EdNQR&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=90e1b2f3037e7a83c9ba1d7eb75cac94&oe=601B2E20",
                "https://scontent.fktm3-1.fna.fbcdn.net/v/t1.0-0/c0.12.206.206a/p206x206/119434035_718344025558468_334403912694068199_n.jpg?_nc_cat=110&ccb=2&_nc_sid=110474&_nc_ohc=wENLzBxU5MsAX986fJw&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=bf8c92ac172c535c13d850e47522e5ea&oe=601C0252",
                "https://www.searchpng.com/wp-content/uploads/2019/02/Instagram-Like-Icon-1.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZHQeZ0qXJkpDkiRD5Pk1ojZA6FI_FaI583w&usqp=CAU",
                "https://www.pngkit.com/png/full/188-1882778_icon-icon-icon-icon-instagram-share-icon-png.png",
                "https://img.flaticon.com/icons/png/512/61/61140.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF"))

        userList.add(UserPost("3","Natalia",
                "https://scontent.fktm3-1.fna.fbcdn.net/v/t1.0-0/p206x206/10676235_10152396153981750_8266625386103664897_n.jpg?_nc_cat=104&ccb=2&_nc_sid=2d5d41&_nc_ohc=hB7NMLrTafcAX_2L4fH&_nc_ht=scontent.fktm3-1.fna&tp=6&oh=6a3ba0266ba8f7e538313ecc867e5622&oe=601D1608",
                "https://scontent.fktm3-1.fna.fbcdn.net/v/t31.0-0/c0.0.206.206a/p206x206/10355618_10152359623701750_1060050015030848330_o.jpg?_nc_cat=105&ccb=2&_nc_sid=2d5d41&_nc_ohc=Jyp_W-0cdqsAX-qiddL&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=5f2e95e0b82a60ae80761501a325b3e2&oe=601B5DC8",
                "https://www.searchpng.com/wp-content/uploads/2019/02/Instagram-Like-Icon-1.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZHQeZ0qXJkpDkiRD5Pk1ojZA6FI_FaI583w&usqp=CAU",
                "https://www.pngkit.com/png/full/188-1882778_icon-icon-icon-icon-instagram-share-icon-png.png",
                "https://img.flaticon.com/icons/png/512/61/61140.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF"))

        userList.add(UserPost("4","Limbu Shanu",
                "https://scontent.fktm3-1.fna.fbcdn.net/v/t1.0-0/c0.6.206.206a/p206x206/118174938_919785335176908_3743045350490994227_n.jpg?_nc_cat=108&ccb=2&_nc_sid=0be424&_nc_ohc=MkqT6gKzUNwAX8sqMQC&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=9f3feef80892e79f6424f3a066c6ddc9&oe=601B0BE8",
                "https://scontent.fktm3-1.fna.fbcdn.net/v/t1.0-0/c0.6.206.206a/p206x206/118174938_919785335176908_3743045350490994227_n.jpg?_nc_cat=108&ccb=2&_nc_sid=0be424&_nc_ohc=MkqT6gKzUNwAX8sqMQC&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=9f3feef80892e79f6424f3a066c6ddc9&oe=601B0BE8",
                "https://www.searchpng.com/wp-content/uploads/2019/02/Instagram-Like-Icon-1.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZHQeZ0qXJkpDkiRD5Pk1ojZA6FI_FaI583w&usqp=CAU",
                "https://www.pngkit.com/png/full/188-1882778_icon-icon-icon-icon-instagram-share-icon-png.png",
                "https://img.flaticon.com/icons/png/512/61/61140.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF"))

        userList.add(UserPost("5","Adhikari Rita",
                "https://scontent.fktm3-1.fna.fbcdn.net/v/t1.0-0/p206x206/1924395_10152287829721750_1899781893127375844_n.jpg?_nc_cat=104&ccb=2&_nc_sid=2d5d41&_nc_ohc=Lt5tDWyfGFkAX-AmPcu&_nc_ht=scontent.fktm3-1.fna&tp=6&oh=62a181fe39c3eb3b0dd82d2ccd7b7174&oe=601CBACD",
                "https://scontent.fktm3-1.fna.fbcdn.net/v/t1.0-0/c0.69.206.206a/p206x206/1505025_10202502827547593_699545079_n.jpg?_nc_cat=104&ccb=2&_nc_sid=da1649&_nc_ohc=N5X8ScvaWNcAX-KfoBb&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=725780a79405f81d709cbdd5d14c154c&oe=601B5A46",
                "https://www.searchpng.com/wp-content/uploads/2019/02/Instagram-Like-Icon-1.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZHQeZ0qXJkpDkiRD5Pk1ojZA6FI_FaI583w&usqp=CAU",
                "https://www.pngkit.com/png/full/188-1882778_icon-icon-icon-icon-instagram-share-icon-png.png",
                "https://img.flaticon.com/icons/png/512/61/61140.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF"))


        userList.add(UserPost("6","Lee Merry",
                "https://scontent.fktm3-1.fna.fbcdn.net/v/t1.0-0/c0.23.206.206a/p206x206/1012801_501004093303779_301220954_n.jpg?_nc_cat=109&ccb=2&_nc_sid=110474&_nc_ohc=rIzG_jvdbgYAX9uG_vE&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=9f2e2cc55612609278f768e4590a7cda&oe=601BFC5A",
                "https://scontent.fktm3-1.fna.fbcdn.net/v/t1.0-0/c0.0.206.206a/p206x206/122552117_2671618193104205_7814938179917194511_n.jpg?_nc_cat=108&cb=846ca55b-ee17756f&ccb=2&_nc_sid=0be424&_nc_ohc=5c0sRiM3VScAX-lp7gN&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=cb88f57fe126f4701eead0f616667a1e&oe=601D13C3",
                "https://www.searchpng.com/wp-content/uploads/2019/02/Instagram-Like-Icon-1.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZHQeZ0qXJkpDkiRD5Pk1ojZA6FI_FaI583w&usqp=CAU",
                "https://www.pngkit.com/png/full/188-1882778_icon-icon-icon-icon-instagram-share-icon-png.png",
                "https://img.flaticon.com/icons/png/512/61/61140.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF"))

        userList.add(UserPost("7","Kim Junho",
                "https://scontent.fktm3-1.fna.fbcdn.net/v/t1.0-0/c61.0.206.206a/p206x206/11037474_934537929912515_5157433975125917824_n.jpg?_nc_cat=105&ccb=2&_nc_sid=110474&_nc_ohc=1nZFhT360WQAX-Z9kaL&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=b63e2000dd079a20216178fdc5ffc310&oe=601A2C97",
                "https://scontent.fktm3-1.fna.fbcdn.net/v/t31.0-0/c34.0.206.206a/p206x206/178128_114742982013636_1744682384_o.jpg?_nc_cat=105&ccb=2&_nc_sid=da1649&_nc_ohc=EUC1ej2zZccAX_VWg4G&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=838b30c07f538dc03946d8d22c168182&oe=601CC6DC",
                "https://www.searchpng.com/wp-content/uploads/2019/02/Instagram-Like-Icon-1.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZHQeZ0qXJkpDkiRD5Pk1ojZA6FI_FaI583w&usqp=CAU",
                "https://www.pngkit.com/png/full/188-1882778_icon-icon-icon-icon-instagram-share-icon-png.png",
                "https://img.flaticon.com/icons/png/512/61/61140.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF"))

        userList.add(UserPost("8","Cristiano Riyasa",
                "https://scontent.fktm3-1.fna.fbcdn.net/v/t1.0-0/c0.0.206.206a/p206x206/10553341_10152288376086750_9182926240357642728_n.jpg?_nc_cat=107&ccb=2&_nc_sid=2d5d41&_nc_ohc=rA_tyhL-IhcAX8rF6LJ&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=23039329d3bdbfe86124d26347e3f492&oe=601B82AE",
                "https://scontent.fktm3-1.fna.fbcdn.net/v/t1.0-0/c0.0.206.206a/p206x206/249064_489204067817115_1882533361_n.jpg?_nc_cat=108&ccb=2&_nc_sid=110474&_nc_ohc=T0XHAfSqeI4AX9KtVXB&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=1af05b1afb53d08a259d1ead7bd4457c&oe=601B915A",
                "https://www.searchpng.com/wp-content/uploads/2019/02/Instagram-Like-Icon-1.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZHQeZ0qXJkpDkiRD5Pk1ojZA6FI_FaI583w&usqp=CAU",
                "https://www.pngkit.com/png/full/188-1882778_icon-icon-icon-icon-instagram-share-icon-png.png",
                "https://img.flaticon.com/icons/png/512/61/61140.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF"))

        userList.add(UserPost("9","Lionel Soo",
                "https://scontent.fktm3-1.fna.fbcdn.net/v/t1.0-0/c0.0.206.206a/p206x206/10731168_780346045373629_5612336220471971066_n.jpg?_nc_cat=106&ccb=2&_nc_sid=43edb5&_nc_ohc=sAWZyh6GRLUAX9krH6K&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=416cd136fcf8882b0726d02aa6a3b002&oe=6019B8DF",
                "https://scontent.fktm3-1.fna.fbcdn.net/v/t1.0-0/c0.21.206.206a/p206x206/14632983_919850651493172_1510515541362366795_n.jpg?_nc_cat=106&ccb=2&_nc_sid=2d5d41&_nc_ohc=vFOAf3kBxEUAX-DDgCP&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=19ee8aa446c98e3ae5a50cddd5b3943d&oe=6019930A",
                "https://www.searchpng.com/wp-content/uploads/2019/02/Instagram-Like-Icon-1.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZHQeZ0qXJkpDkiRD5Pk1ojZA6FI_FaI583w&usqp=CAU",
                "https://www.pngkit.com/png/full/188-1882778_icon-icon-icon-icon-instagram-share-icon-png.png",
                "https://img.flaticon.com/icons/png/512/61/61140.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF"))

        userList.add(UserPost("10","Clari Shim",
                "https://scontent.fktm3-1.fna.fbcdn.net/v/t1.0-0/c0.0.206.206a/p206x206/10710876_698618690245425_2735429249894758111_n.jpg?_nc_cat=102&ccb=2&_nc_sid=2d5d41&_nc_ohc=9DaRwWYUogAAX8sm3QI&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=adaa93268e974b876055f55d23826098&oe=601AB3D4",
                "https://scontent.fktm3-1.fna.fbcdn.net/v/t31.0-0/c0.0.206.206a/p206x206/11046470_10155443022905193_1625275631221638043_o.jpg?_nc_cat=103&ccb=2&_nc_sid=2d5d41&_nc_ohc=wv44hndaB-oAX96hvFJ&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=d277bb23d0d1f210d2e74622e8a22758&oe=601AB362",
                "https://www.searchpng.com/wp-content/uploads/2019/02/Instagram-Like-Icon-1.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZHQeZ0qXJkpDkiRD5Pk1ojZA6FI_FaI583w&usqp=CAU",
                "https://www.pngkit.com/png/full/188-1882778_icon-icon-icon-icon-instagram-share-icon-png.png",
                "https://img.flaticon.com/icons/png/512/61/61140.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF"))


    }
    private fun loadStoryImg(){
        userStoryList.add(UserStory("1","Kumar","https://scontent.fktm3-1.fna.fbcdn.net/v/t31.0-0/c56.0.206.206a/p206x206/17038531_1579738105387414_3325740768316483283_o.jpg?_nc_cat=107&ccb=2&_nc_sid=2d5d41&_nc_ohc=FzvNJbu14ggAX8bKVqK&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=a0478fd735fadefb73a6d00cbc8cf969&oe=601AF62A"))
        userStoryList.add(UserStory("2","Ritesh","https://scontent.fktm3-1.fna.fbcdn.net/v/t1.0-9/12143143_907060572719763_2377817478426527983_n.jpg?_nc_cat=104&ccb=2&_nc_sid=09cbfe&_nc_ohc=7RU-WQhfKhcAX-GOrRU&_nc_ht=scontent.fktm3-1.fna&oh=e7abf21d87c2ba52e01790bd0705efdd&oe=601B477E"))
        userStoryList.add(UserStory("3","Natalia","https://scontent.fktm3-1.fna.fbcdn.net/v/t31.0-0/c0.0.206.206a/p206x206/10355618_10152359623701750_1060050015030848330_o.jpg?_nc_cat=105&ccb=2&_nc_sid=2d5d41&_nc_ohc=Jyp_W-0cdqsAX-qiddL&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=5f2e95e0b82a60ae80761501a325b3e2&oe=601B5DC8"))
        userStoryList.add(UserStory("4","Shanu","https://scontent.fktm3-1.fna.fbcdn.net/v/t1.0-0/c0.69.206.206a/p206x206/1505025_10202502827547593_699545079_n.jpg?_nc_cat=104&ccb=2&_nc_sid=da1649&_nc_ohc=N5X8ScvaWNcAX-KfoBb&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=725780a79405f81d709cbdd5d14c154c&oe=601B5A46"))
        userStoryList.add(UserStory("5","Rita","https://scontent.fktm3-1.fna.fbcdn.net/v/t1.0-0/c0.0.206.206a/p206x206/123359789_213662486793201_7932384198417025161_o.jpg?_nc_cat=100&ccb=2&_nc_sid=8024bb&_nc_ohc=9qj_hkpAk7wAX8uz9GT&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=86af78da8ca53c8191ed734c4a6c9e16&oe=601B6027"))
        userStoryList.add(UserStory("6","Merry","https://scontent.fktm3-1.fna.fbcdn.net/v/t1.0-0/c0.0.206.206a/p206x206/122552117_2671618193104205_7814938179917194511_n.jpg?_nc_cat=108&cb=846ca55b-ee17756f&ccb=2&_nc_sid=0be424&_nc_ohc=5c0sRiM3VScAX-lp7gN&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=cb88f57fe126f4701eead0f616667a1e&oe=601D13C3"))
        userStoryList.add(UserStory("7","Junho","https://scontent.fktm3-1.fna.fbcdn.net/v/t1.0-0/c61.0.206.206a/p206x206/11037474_934537929912515_5157433975125917824_n.jpg?_nc_cat=105&ccb=2&_nc_sid=110474&_nc_ohc=1nZFhT360WQAX-Z9kaL&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=b63e2000dd079a20216178fdc5ffc310&oe=601A2C97"))
        userStoryList.add(UserStory("8","Riyasa","https://scontent.fktm3-1.fna.fbcdn.net/v/t1.0-0/c0.0.206.206a/p206x206/249064_489204067817115_1882533361_n.jpg?_nc_cat=108&ccb=2&_nc_sid=110474&_nc_ohc=T0XHAfSqeI4AX9KtVXB&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=1af05b1afb53d08a259d1ead7bd4457c&oe=601B915A"))
        userStoryList.add(UserStory("9","Soo","https://scontent.fktm3-1.fna.fbcdn.net/v/t1.0-0/c0.0.206.206a/p206x206/10731168_780346045373629_5612336220471971066_n.jpg?_nc_cat=106&ccb=2&_nc_sid=43edb5&_nc_ohc=sAWZyh6GRLUAX9krH6K&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=416cd136fcf8882b0726d02aa6a3b002&oe=6019B8DF"))
        userStoryList.add(UserStory("10","Shim","https://scontent.fktm3-1.fna.fbcdn.net/v/t1.0-0/c0.0.206.206a/p206x206/10710876_698618690245425_2735429249894758111_n.jpg?_nc_cat=102&ccb=2&_nc_sid=2d5d41&_nc_ohc=9DaRwWYUogAAX8sm3QI&_nc_ht=scontent.fktm3-1.fna&tp=27&oh=adaa93268e974b876055f55d23826098&oe=601AB3D4"))
    }

}
