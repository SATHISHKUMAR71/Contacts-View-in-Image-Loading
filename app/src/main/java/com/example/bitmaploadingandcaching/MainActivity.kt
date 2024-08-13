package com.example.bitmaploadingandcaching


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv = findViewById<RecyclerView>(R.id.recyclerView)
        var imagesList:MutableList<String> = mutableListOf()
        for (i in 1..10){
            imagesList.add("https://img.freepik.com/free-photo/painting-mountain-lake-with-mountain-background_188544-9126.jpg")
            imagesList.add("https://cdn.pixabay.com/photo/2015/01/15/16/17/hands-600497_640.jpg")
            imagesList.add("https://www.w3schools.com/howto/img_forest.jpg")
            imagesList.add("https://cdn.prod.website-files.com/5e9ebc3fff165933f19fbdbe/61b31c9d289e22335b6753b2_Ice%20Cream%202.jpg")
            imagesList.add("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/recipe-image-legacy-id-560491_11-8342908.jpg?quality=90&resize=440,400")
            imagesList.add("https://www.freecodecamp.org/news/content/images/size/w2000/2022/09/jonatan-pie-3l3RwQdHRHg-unsplash.jpg")
            imagesList.add("https://www.w3schools.com/howto/img_snow.jpg")
            imagesList.add("https://tinypng.com/images/social/website.jpg")
            imagesList.add("https://images.ctfassets.net/kftzwdyauwt9/MQfhRnDbcxc2gaHN0yKdP/fb7711a0bac4d739e415059e6d7e5a64/Anastronautridingahorseinaphotorealisticstyle6.jpg?w=3840&q=90&fm=webp")
            imagesList.add("https://d138zd1ktt9iqe.cloudfront.net/media/seo_landing_files/file-istockphoto-859550894-170667a-1600430313.jpg")
            imagesList.add("https://static.vecteezy.com/system/resources/thumbnails/022/448/309/small_2x/save-earth-day-poster-environment-day-nature-green-ai-generative-glossy-background-images-tree-and-water-free-photo.jpg")
            imagesList.add("https://static.vecteezy.com/system/resources/thumbnails/022/653/879/small_2x/fantasy-island-with-waterfalls-3d-illustration-elements-of-this-image-furnished-by-nasa-generative-ai-free-photo.jpg")
            imagesList.add("https://www.shyamparivar.com/uploads/gallery/Sky-and-Moon-Dark-Wallpaper-for-Desktop-and-Laptop.jpg")
            imagesList.add("https://images.pexels.com/photos/1108099/pexels-photo-1108099.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500")
            imagesList.add("https://static.gettyimages.com/display-sets/creative-landing/images/GettyImages-1448734171.jpg")
            imagesList.add("https://i0.wp.com/picjumbo.com/wp-content/uploads/romantic-tropical-beach-with-villa-and-palms-during-beautiful-sunset-free-photo.jpg?w=600&quality=80")
            imagesList.add("https://cdn.pixabay.com/photo/2024/03/05/10/38/boat-8614314_1280.jpg")
            imagesList.add("https://cdn.pixabay.com/photo/2013/05/12/18/55/balance-110850_640.jpg")
        }
        rv.adapter = ImagesAdapter(imagesList,baseContext)
        rv.layoutManager = LinearLayoutManager(this)
        println("Max memory: ${ Runtime.getRuntime().maxMemory()}")
    }
}