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
        }    }

    private fun loadUserData(){
        userList.add(UserPost("1","Kumar",
                "https://www.google.com/search?q=kim+soo+hyun&sxsrf=ALeKk03PmiQBr6JG2aEJia4ZOp652Ab3Hg:1609938043848&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjatNrJrofuAhXVXisKHb5gBJIQ_AUoAXoECBsQAw&biw=1366&bih=625#imgrc=UAKxBcHpivCrHM",
                "https://www.google.com/search?q=kim+soo+hyun&sxsrf=ALeKk03PmiQBr6JG2aEJia4ZOp652Ab3Hg:1609938043848&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjatNrJrofuAhXVXisKHb5gBJIQ_AUoAXoECBsQAw&biw=1366&bih=625#imgrc=UAKxBcHpivCrHM",
       "https://www.searchpng.com/wp-content/uploads/2019/02/Instagram-Like-Icon-1.png",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZHQeZ0qXJkpDkiRD5Pk1ojZA6FI_FaI583w&usqp=CAU",
            "https://www.pngkit.com/png/full/188-1882778_icon-icon-icon-icon-instagram-share-icon-png.png",
            "https://img.flaticon.com/icons/png/512/61/61140.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF"))


        userList.add(UserPost("2","Ritesh",
                "https://www.google.com/search?q=ritesh+agarwal&tbm=isch&ved=2ahUKEwiI_MbMrofuAhUOCHIKHelgCswQ2-cCegQIABAA&oq=Ritesh&gs_lcp=CgNpbWcQARgBMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADoECCMQJzoFCAAQsQM6BAgAEENQi7YJWM7CCWDJ1AloAHAAeACAAaECiAGSCZIBBTAuNS4xmAEAoAEBqgELZ3dzLXdpei1pbWfAAQE&sclient=img&ei=gbT1X8i3MY6QyAPpwangDA&bih=625&biw=1366#imgrc=cE-Ba2CbyzFbjM",
                "https://www.google.com/search?q=ritesh+agarwal&tbm=isch&ved=2ahUKEwiI_MbMrofuAhUOCHIKHelgCswQ2-cCegQIABAA&oq=Ritesh&gs_lcp=CgNpbWcQARgBMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADoECCMQJzoFCAAQsQM6BAgAEENQi7YJWM7CCWDJ1AloAHAAeACAAaECiAGSCZIBBTAuNS4xmAEAoAEBqgELZ3dzLXdpei1pbWfAAQE&sclient=img&ei=gbT1X8i3MY6QyAPpwangDA&bih=625&biw=1366#imgrc=cE-Ba2CbyzFbjM",
                "https://www.searchpng.com/wp-content/uploads/2019/02/Instagram-Like-Icon-1.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZHQeZ0qXJkpDkiRD5Pk1ojZA6FI_FaI583w&usqp=CAU",
                "https://www.pngkit.com/png/full/188-1882778_icon-icon-icon-icon-instagram-share-icon-png.png",
                "https://img.flaticon.com/icons/png/512/61/61140.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF"))

        userList.add(UserPost("3","Natalia",
                "https://www.google.com/search?q=natalia+barulich&tbm=isch&ved=2ahUKEwiXre2Zr4fuAhVYy3MBHZ1ICRQQ2-cCegQIABAA&oq=Natalia&gs_lcp=CgNpbWcQARgAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIAFD3oQZY96EGYPuxBmgAcAB4AIABrAGIAawBkgEDMC4xmAEAoAEBqgELZ3dzLXdpei1pbWfAAQE&sclient=img&ei=I7X1X9ePONiWz7sPnZGloAE&bih=625&biw=1366#imgrc=1mALW1UcXAvVLM",
                "https://www.google.com/search?q=natalia+barulich&tbm=isch&ved=2ahUKEwiXre2Zr4fuAhVYy3MBHZ1ICRQQ2-cCegQIABAA&oq=Natalia&gs_lcp=CgNpbWcQARgAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIAFD3oQZY96EGYPuxBmgAcAB4AIABrAGIAawBkgEDMC4xmAEAoAEBqgELZ3dzLXdpei1pbWfAAQE&sclient=img&ei=I7X1X9ePONiWz7sPnZGloAE&bih=625&biw=1366#imgrc=1mALW1UcXAvVLM",
                "https://www.searchpng.com/wp-content/uploads/2019/02/Instagram-Like-Icon-1.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZHQeZ0qXJkpDkiRD5Pk1ojZA6FI_FaI583w&usqp=CAU",
                "https://www.pngkit.com/png/full/188-1882778_icon-icon-icon-icon-instagram-share-icon-png.png",
                "https://img.flaticon.com/icons/png/512/61/61140.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF"))

        userList.add(UserPost("4","Limbu Shanu",
                "https://www.google.com/search?q=shanu&tbm=isch&ved=2ahUKEwic-6vMr4fuAhW4HbcAHalwBXQQ2-cCegQIABAA&oq=shanu&gs_lcp=CgNpbWcQAzICCAAyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCAA6BAgjECc6BAgAEEM6BQgAELEDOgcIABCxAxBDOggIABCxAxCDAVDevwRY7MgEYMzVBGgAcAB4AIABvwKIAe0HkgEHMC40LjAuMZgBAKABAaoBC2d3cy13aXotaW1nwAEB&sclient=img&ei=jbX1X9yAMbi73LUPqeGVoAc&bih=625&biw=1366#imgrc=ZuergmQ5OOGQvM",
                "https://www.google.com/search?q=shanu&tbm=isch&ved=2ahUKEwic-6vMr4fuAhW4HbcAHalwBXQQ2-cCegQIABAA&oq=shanu&gs_lcp=CgNpbWcQAzICCAAyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCAA6BAgjECc6BAgAEEM6BQgAELEDOgcIABCxAxBDOggIABCxAxCDAVDevwRY7MgEYMzVBGgAcAB4AIABvwKIAe0HkgEHMC40LjAuMZgBAKABAaoBC2d3cy13aXotaW1nwAEB&sclient=img&ei=jbX1X9yAMbi73LUPqeGVoAc&bih=625&biw=1366#imgrc=ZuergmQ5OOGQvM",
                "https://www.searchpng.com/wp-content/uploads/2019/02/Instagram-Like-Icon-1.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZHQeZ0qXJkpDkiRD5Pk1ojZA6FI_FaI583w&usqp=CAU",
                "https://www.pngkit.com/png/full/188-1882778_icon-icon-icon-icon-instagram-share-icon-png.png",
                "https://img.flaticon.com/icons/png/512/61/61140.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF"))

        userList.add(UserPost("5","Adhikari Rita",
                "https://www.google.com/search?q=Adhikari+Rita&tbm=isch&ved=2ahUKEwic-6vMr4fuAhW4HbcAHalwBXQQ2-cCegQIABAA&oq=Adhikari+Rita&gs_lcp=CgNpbWcQAzIGCAAQCBAeUILVBFiC1QRg--oEaABwAHgAgAGmAYgBpgGSAQMwLjGYAQCgAQGqAQtnd3Mtd2l6LWltZ8ABAQ&sclient=img&ei=jbX1X9yAMbi73LUPqeGVoAc&bih=625&biw=1366#imgrc=K-uCkyHtUODZdM",
                "https://www.google.com/search?q=Adhikari+Rita&tbm=isch&ved=2ahUKEwic-6vMr4fuAhW4HbcAHalwBXQQ2-cCegQIABAA&oq=Adhikari+Rita&gs_lcp=CgNpbWcQAzIGCAAQCBAeUILVBFiC1QRg--oEaABwAHgAgAGmAYgBpgGSAQMwLjGYAQCgAQGqAQtnd3Mtd2l6LWltZ8ABAQ&sclient=img&ei=jbX1X9yAMbi73LUPqeGVoAc&bih=625&biw=1366#imgrc=K-uCkyHtUODZdM",
                "https://www.searchpng.com/wp-content/uploads/2019/02/Instagram-Like-Icon-1.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZHQeZ0qXJkpDkiRD5Pk1ojZA6FI_FaI583w&usqp=CAU",
                "https://www.pngkit.com/png/full/188-1882778_icon-icon-icon-icon-instagram-share-icon-png.png",
                "https://img.flaticon.com/icons/png/512/61/61140.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF"))


        userList.add(UserPost("6","Lee Merry",
                "https://www.google.com/search?q=Lee+Merry&tbm=isch&ved=2ahUKEwij6764sIfuAhWaBbcAHQ9MCwAQ2-cCegQIABAA&oq=Lee+Merry&gs_lcp=CgNpbWcQAzICCAAyBggAEAUQHjIGCAAQBRAeMgYIABAFEB4yBggAEAUQHjIGCAAQBRAeMgYIABAFEB4yBggAEAUQHjIGCAAQCBAeMgYIABAIEB5QmqcEWJqnBGDWsQRoAHAAeACAAagBiAGoAZIBAzAuMZgBAKABAaoBC2d3cy13aXotaW1nwAEB&sclient=img&ei=cLb1X6PzJJqL3LUPj5gt&bih=625&biw=1366#imgrc=5l6rS_mFhv8zbM",
                "https://www.google.com/search?q=Lee+Merry&tbm=isch&ved=2ahUKEwij6764sIfuAhWaBbcAHQ9MCwAQ2-cCegQIABAA&oq=Lee+Merry&gs_lcp=CgNpbWcQAzICCAAyBggAEAUQHjIGCAAQBRAeMgYIABAFEB4yBggAEAUQHjIGCAAQBRAeMgYIABAFEB4yBggAEAUQHjIGCAAQCBAeMgYIABAIEB5QmqcEWJqnBGDWsQRoAHAAeACAAagBiAGoAZIBAzAuMZgBAKABAaoBC2d3cy13aXotaW1nwAEB&sclient=img&ei=cLb1X6PzJJqL3LUPj5gt&bih=625&biw=1366#imgrc=5l6rS_mFhv8zbM",
                "https://www.searchpng.com/wp-content/uploads/2019/02/Instagram-Like-Icon-1.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZHQeZ0qXJkpDkiRD5Pk1ojZA6FI_FaI583w&usqp=CAU",
                "https://www.pngkit.com/png/full/188-1882778_icon-icon-icon-icon-instagram-share-icon-png.png",
                "https://img.flaticon.com/icons/png/512/61/61140.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF"))

        userList.add(UserPost("7","Kim Junho",
                "https://www.google.com/search?q=Kim+Junho&tbm=isch&ved=2ahUKEwjU3rvbsIfuAhXd2nMBHe0tC1QQ2-cCegQIABAA&oq=Kim+Junho&gs_lcp=CgNpbWcQAzICCAAyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAUIzkBFiM5ARgte4EaABwAHgAgAGsAYgBrAGSAQMwLjGYAQCgAQGqAQtnd3Mtd2l6LWltZ8ABAQ&sclient=img&ei=ubb1X5SeOt21z7sP7dusoAU&bih=625&biw=1366#imgrc=pXP45n83QiBhgM",
                "https://www.google.com/search?q=Kim+Junho&tbm=isch&ved=2ahUKEwjU3rvbsIfuAhXd2nMBHe0tC1QQ2-cCegQIABAA&oq=Kim+Junho&gs_lcp=CgNpbWcQAzICCAAyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAUIzkBFiM5ARgte4EaABwAHgAgAGsAYgBrAGSAQMwLjGYAQCgAQGqAQtnd3Mtd2l6LWltZ8ABAQ&sclient=img&ei=ubb1X5SeOt21z7sP7dusoAU&bih=625&biw=1366#imgrc=pXP45n83QiBhgM",
                "https://www.searchpng.com/wp-content/uploads/2019/02/Instagram-Like-Icon-1.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZHQeZ0qXJkpDkiRD5Pk1ojZA6FI_FaI583w&usqp=CAU",
                "https://www.pngkit.com/png/full/188-1882778_icon-icon-icon-icon-instagram-share-icon-png.png",
                "https://img.flaticon.com/icons/png/512/61/61140.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF"))

        userList.add(UserPost("8","Cristiano Riyasa",
                "https://www.google.com/search?q=Cristiano+Riyasa&tbm=isch&ved=2ahUKEwizlJWCsYfuAhWRkuYKHRW5DMEQ2-cCegQIABAA&oq=Cristiano+Riyasa&gs_lcp=CgNpbWcQAzoECCMQJzoECAAQQzoCCAA6BwgjEOoCECdQ14kEWK6YBGDJngRoAXAAeASAAekCiAG6DJIBBzAuMi4xLjOYAQCgAQGqAQtnd3Mtd2l6LWltZ7ABCsABAQ&sclient=img&ei=C7f1X_PiBpGlmgeV8rKIDA&bih=625&biw=1366#imgrc=6ThR-OMhI2F5gM",
                "https://www.google.com/search?q=Cristiano+Riyasa&tbm=isch&ved=2ahUKEwizlJWCsYfuAhWRkuYKHRW5DMEQ2-cCegQIABAA&oq=Cristiano+Riyasa&gs_lcp=CgNpbWcQAzoECCMQJzoECAAQQzoCCAA6BwgjEOoCECdQ14kEWK6YBGDJngRoAXAAeASAAekCiAG6DJIBBzAuMi4xLjOYAQCgAQGqAQtnd3Mtd2l6LWltZ7ABCsABAQ&sclient=img&ei=C7f1X_PiBpGlmgeV8rKIDA&bih=625&biw=1366#imgrc=6ThR-OMhI2F5gM",
                "https://www.searchpng.com/wp-content/uploads/2019/02/Instagram-Like-Icon-1.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZHQeZ0qXJkpDkiRD5Pk1ojZA6FI_FaI583w&usqp=CAU",
                "https://www.pngkit.com/png/full/188-1882778_icon-icon-icon-icon-instagram-share-icon-png.png",
                "https://img.flaticon.com/icons/png/512/61/61140.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF"))

        userList.add(UserPost("9","Lionel Soo",
                "https://www.google.com/search?q=kim+soo+young&tbm=isch&ved=2ahUKEwjH0uDqsYfuAhXa43MBHXEfAJ0Q2-cCegQIABAA&oq=kim+soo+young&gs_lcp=CgNpbWcQAzICCAAyAggAMgIIADIGCAAQBxAeMgYIABAHEB4yBggAEAcQHjIGCAAQBxAeMgYIABAHEB4yBggAEAcQHjIGCAAQBxAeUKFoWMhrYL99aABwAHgAgAHGAYgBiwSSAQMwLjOYAQCgAQGqAQtnd3Mtd2l6LWltZ8ABAQ&sclient=img&ei=5rf1X8fHG9rHz7sP8b6A6Ak&bih=625&biw=1366#imgrc=FnvZQCNEnnhzBM",
                "https://www.google.com/search?q=kim+soo+young&tbm=isch&ved=2ahUKEwjH0uDqsYfuAhXa43MBHXEfAJ0Q2-cCegQIABAA&oq=kim+soo+young&gs_lcp=CgNpbWcQAzICCAAyAggAMgIIADIGCAAQBxAeMgYIABAHEB4yBggAEAcQHjIGCAAQBxAeMgYIABAHEB4yBggAEAcQHjIGCAAQBxAeUKFoWMhrYL99aABwAHgAgAHGAYgBiwSSAQMwLjOYAQCgAQGqAQtnd3Mtd2l6LWltZ8ABAQ&sclient=img&ei=5rf1X8fHG9rHz7sP8b6A6Ak&bih=625&biw=1366#imgrc=FnvZQCNEnnhzBM",
                "https://www.searchpng.com/wp-content/uploads/2019/02/Instagram-Like-Icon-1.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZHQeZ0qXJkpDkiRD5Pk1ojZA6FI_FaI583w&usqp=CAU",
                "https://www.pngkit.com/png/full/188-1882778_icon-icon-icon-icon-instagram-share-icon-png.png",
                "https://img.flaticon.com/icons/png/512/61/61140.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF"))

        userList.add(UserPost("10","Clari Shim",
               "https://www.google.com/search?q=shim+eun-kyung&tbm=isch&ved=2ahUKEwjXmpqlsofuAhWihuYKHWgWBxYQ2-cCegQIABAA&oq=Shim&gs_lcp=CgNpbWcQARgBMgQIABBDMgQIABBDMgQIABBDMgQIABBDMgQIABBDMgIIADICCAAyAggAMgIIADICCABQnTFYnTFgvURoAHAAeACAAbEBiAGxAZIBAzAuMZgBAKABAaoBC2d3cy13aXotaW1nwAEB&sclient=img&ei=Ybj1X5fmAaKNmgforJywAQ&bih=625&biw=1366#imgrc=zSvr3e9qVYOdHM",
                "https://www.google.com/search?q=shim+eun-kyung&tbm=isch&ved=2ahUKEwjXmpqlsofuAhWihuYKHWgWBxYQ2-cCegQIABAA&oq=Shim&gs_lcp=CgNpbWcQARgBMgQIABBDMgQIABBDMgQIABBDMgQIABBDMgQIABBDMgIIADICCAAyAggAMgIIADICCABQnTFYnTFgvURoAHAAeACAAbEBiAGxAZIBAzAuMZgBAKABAaoBC2d3cy13aXotaW1nwAEB&sclient=img&ei=Ybj1X5fmAaKNmgforJywAQ&bih=625&biw=1366#imgrc=zSvr3e9qVYOdHM",
                "https://www.searchpng.com/wp-content/uploads/2019/02/Instagram-Like-Icon-1.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZHQeZ0qXJkpDkiRD5Pk1ojZA6FI_FaI583w&usqp=CAU",
                "https://www.pngkit.com/png/full/188-1882778_icon-icon-icon-icon-instagram-share-icon-png.png",
                "https://img.flaticon.com/icons/png/512/61/61140.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF"))


    }
    private fun loadStoryImg(){
        userStoryList.add(UserStory("1","Kumar","https://www.google.com/search?q=kim+soo+hyun&sxsrf=ALeKk03PmiQBr6JG2aEJia4ZOp652Ab3Hg:1609938043848&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjatNrJrofuAhXVXisKHb5gBJIQ_AUoAXoECBsQAw&biw=1366&bih=625#imgrc=UAKxBcHpivCrHM"))
        userStoryList.add(UserStory("2","Ritesh","https://www.google.com/search?q=ritesh+agarwal&tbm=isch&ved=2ahUKEwiI_MbMrofuAhUOCHIKHelgCswQ2-cCegQIABAA&oq=Ritesh&gs_lcp=CgNpbWcQARgBMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADoECCMQJzoFCAAQsQM6BAgAEENQi7YJWM7CCWDJ1AloAHAAeACAAaECiAGSCZIBBTAuNS4xmAEAoAEBqgELZ3dzLXdpei1pbWfAAQE&sclient=img&ei=gbT1X8i3MY6QyAPpwangDA&bih=625&biw=1366#imgrc=cE-Ba2CbyzFbjM"))
        userStoryList.add(UserStory("3","Natalia","https://www.google.com/search?q=natalia+barulich&tbm=isch&ved=2ahUKEwiXre2Zr4fuAhVYy3MBHZ1ICRQQ2-cCegQIABAA&oq=Natalia&gs_lcp=CgNpbWcQARgAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIAFD3oQZY96EGYPuxBmgAcAB4AIABrAGIAawBkgEDMC4xmAEAoAEBqgELZ3dzLXdpei1pbWfAAQE&sclient=img&ei=I7X1X9ePONiWz7sPnZGloAE&bih=625&biw=1366#imgrc=1mALW1UcXAvVLM"))
        userStoryList.add(UserStory("4","Shanu","https://www.google.com/search?q=shanu&tbm=isch&ved=2ahUKEwic-6vMr4fuAhW4HbcAHalwBXQQ2-cCegQIABAA&oq=shanu&gs_lcp=CgNpbWcQAzICCAAyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCAA6BAgjECc6BAgAEEM6BQgAELEDOgcIABCxAxBDOggIABCxAxCDAVDevwRY7MgEYMzVBGgAcAB4AIABvwKIAe0HkgEHMC40LjAuMZgBAKABAaoBC2d3cy13aXotaW1nwAEB&sclient=img&ei=jbX1X9yAMbi73LUPqeGVoAc&bih=625&biw=1366#imgrc=ZuergmQ5OOGQvM"))
        userStoryList.add(UserStory("5","Rita","https://www.google.com/search?q=Adhikari+Rita&tbm=isch&ved=2ahUKEwic-6vMr4fuAhW4HbcAHalwBXQQ2-cCegQIABAA&oq=Adhikari+Rita&gs_lcp=CgNpbWcQAzIGCAAQCBAeUILVBFiC1QRg--oEaABwAHgAgAGmAYgBpgGSAQMwLjGYAQCgAQGqAQtnd3Mtd2l6LWltZ8ABAQ&sclient=img&ei=jbX1X9yAMbi73LUPqeGVoAc&bih=625&biw=1366#imgrc=K-uCkyHtUODZdM"))
        userStoryList.add(UserStory("6","Merry","https://www.google.com/search?q=Lee+Merry&tbm=isch&ved=2ahUKEwij6764sIfuAhWaBbcAHQ9MCwAQ2-cCegQIABAA&oq=Lee+Merry&gs_lcp=CgNpbWcQAzICCAAyBggAEAUQHjIGCAAQBRAeMgYIABAFEB4yBggAEAUQHjIGCAAQBRAeMgYIABAFEB4yBggAEAUQHjIGCAAQCBAeMgYIABAIEB5QmqcEWJqnBGDWsQRoAHAAeACAAagBiAGoAZIBAzAuMZgBAKABAaoBC2d3cy13aXotaW1nwAEB&sclient=img&ei=cLb1X6PzJJqL3LUPj5gt&bih=625&biw=1366#imgrc=5l6rS_mFhv8zbM"))
        userStoryList.add(UserStory("7","Junho","https://www.google.com/search?q=Kim+Junho&tbm=isch&ved=2ahUKEwjU3rvbsIfuAhXd2nMBHe0tC1QQ2-cCegQIABAA&oq=Kim+Junho&gs_lcp=CgNpbWcQAzICCAAyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAUIzkBFiM5ARgte4EaABwAHgAgAGsAYgBrAGSAQMwLjGYAQCgAQGqAQtnd3Mtd2l6LWltZ8ABAQ&sclient=img&ei=ubb1X5SeOt21z7sP7dusoAU&bih=625&biw=1366#imgrc=pXP45n83QiBhgM"))
        userStoryList.add(UserStory("8","Riyasa","https://www.google.com/search?q=Cristiano+Riyasa&tbm=isch&ved=2ahUKEwizlJWCsYfuAhWRkuYKHRW5DMEQ2-cCegQIABAA&oq=Cristiano+Riyasa&gs_lcp=CgNpbWcQAzoECCMQJzoECAAQQzoCCAA6BwgjEOoCECdQ14kEWK6YBGDJngRoAXAAeASAAekCiAG6DJIBBzAuMi4xLjOYAQCgAQGqAQtnd3Mtd2l6LWltZ7ABCsABAQ&sclient=img&ei=C7f1X_PiBpGlmgeV8rKIDA&bih=625&biw=1366#imgrc=6ThR-OMhI2F5gM"))
        userStoryList.add(UserStory("9","Soo","https://www.google.com/search?q=kim+soo+young&tbm=isch&ved=2ahUKEwjH0uDqsYfuAhXa43MBHXEfAJ0Q2-cCegQIABAA&oq=kim+soo+young&gs_lcp=CgNpbWcQAzICCAAyAggAMgIIADIGCAAQBxAeMgYIABAHEB4yBggAEAcQHjIGCAAQBxAeMgYIABAHEB4yBggAEAcQHjIGCAAQBxAeUKFoWMhrYL99aABwAHgAgAHGAYgBiwSSAQMwLjOYAQCgAQGqAQtnd3Mtd2l6LWltZ8ABAQ&sclient=img&ei=5rf1X8fHG9rHz7sP8b6A6Ak&bih=625&biw=1366#imgrc=FnvZQCNEnnhzBM"))
        userStoryList.add(UserStory("10","Shim","https://www.google.com/search?q=shim+eun-kyung&tbm=isch&ved=2ahUKEwjXmpqlsofuAhWihuYKHWgWBxYQ2-cCegQIABAA&oq=Shim&gs_lcp=CgNpbWcQARgBMgQIABBDMgQIABBDMgQIABBDMgQIABBDMgQIABBDMgIIADICCAAyAggAMgIIADICCABQnTFYnTFgvURoAHAAeACAAbEBiAGxAZIBAzAuMZgBAKABAaoBC2d3cy13aXotaW1nwAEB&sclient=img&ei=Ybj1X5fmAaKNmgforJywAQ&bih=625&biw=1366#imgrc=zSvr3e9qVYOdHM"))
    }

}