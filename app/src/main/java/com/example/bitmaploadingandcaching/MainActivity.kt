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
        var imagesList:MutableList<Contact> = mutableListOf()
        var count = 0
        for (i in 1..10){
            imagesList.add(Contact("Dog","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROf6UTZz7xI0CSxn0p8t8IP-tNdjz4HnV7fQ&s"))
            imagesList.add(Contact("Penguin","https://t4.ftcdn.net/jpg/05/98/80/23/240_F_598802337_8tVqpC3zWLZrRxJwayYdUTM9E3d3xoNG.jpg"))
            imagesList.add(Contact("Shark","https://thumbs.dreamstime.com/b/cute-cartoon-style-shark-ai-generated-301950258.jpg"))
            imagesList.add(Contact("Kangaroo","https://t4.ftcdn.net/jpg/07/10/35/63/240_F_710356348_SHWeoISgEgyv0UaWmfut1rlwpmmAggvu.jpg"))
            imagesList.add(Contact("Panda","https://i.natgeofe.com/k/75ac774d-e6c7-44fa-b787-d0e20742f797/giant-panda-eating_4x3.jpg"))
            imagesList.add(Contact("Zebra","https://c02.purpledshub.com/uploads/sites/62/2014/09/GettyImages-520064858-79cc024.jpg?webp=1&w=1200"))
            imagesList.add(Contact("Dragon","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRqEKYeZnBrX0Qf2ZdUZJEAka4FSQ1uYX6pXw&s"))
            imagesList.add(Contact("Whale","https://easy-peasy.ai/cdn-cgi/image/quality=80,format=auto,width=700/https://fdczvxmwwjwpwbeeqcth.supabase.co/storage/v1/object/public/images/268c4b03-533f-4e81-aec1-0c22df466a90/eebf3caa-98db-42c0-983f-d6e4b85486e4.png"))
            imagesList.add(Contact("Pegasus","https://t4.ftcdn.net/jpg/05/62/13/35/360_F_562133561_OIgHUI9hP11y6gWYxdmeNVGtjPHeHvYa.jpg"))
            imagesList.add(Contact("Cat","https//images.pexels.com/photos/104827/cat-pet-animal-domestic-104827.jpeg?cs=srgb&dl=pexels-pixabay-104827.jpg&fm=jpg"))
            imagesList.add(Contact("Griffin","https//t3.ftcdn.net/jpg/05/84/03/80/360_F_584038065_bTAe8Ly8ZBejUYsJZVJFgYVYGCwbXRtN.jpg"))
            imagesList.add(Contact("Egg","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8iPUqDUNZyP9rYqzg2JXonP7iuacq71NGmw&s"))
            imagesList.add(Contact("Alien","https://t3.ftcdn.net/jpg/06/41/40/68/360_F_641406897_saGfL8PGa3zB9LB6JRwU62nBcWQ9IvvU.jpg"))
            imagesList.add(Contact("Fish Nemo","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLOfj5r_zUKHc9c6zEf00tww8nNwm7Fe1b_Q&s"))
            imagesList.add(Contact("Octopus","https://as1.ftcdn.net/v2/jpg/05/38/90/32/1000_F_538903298_CDDXJNLeJKEamt5UsZOLViGIMBs2uhG6.jpg"))
            imagesList.add(Contact("Boat","https://i.pinimg.com/originals/9e/d8/c2/9ed8c20db316bb5e9b000485f79d1169.png"))
            imagesList.add(Contact("Ghost","https://png.pngtree.com/png-vector/20230831/ourmid/pngtree-sticker-halloween-cute-ghost-png-image_9236584.png"))
            imagesList.add(Contact("Flower","https://artincontext.org/wp-content/uploads/2022/05/lily-sketch.jpg"))
            imagesList.add(Contact("Giraffe","https://t4.ftcdn.net/jpg/07/55/79/77/360_F_755797761_syuApheTCciQYGWhH9BipcULAHb0PLGR.jpg"))
            imagesList.add(Contact("Robot","https://cdn.pixabay.com/photo/2023/05/08/08/41/ai-7977960_1280.jpg"))
            imagesList.add(Contact("Clown","https://static.vecteezy.com/system/resources/previews/026/793/431/original/3d-clown-ai-generated-png.png"))
            imagesList.add(Contact("Robot Dog","https://m.media-amazon.com/images/I/51MsPhbA9rL._AC_UF1000,1000_QL80_.jpg"))
            imagesList.add(Contact("Fox","https://as2.ftcdn.net/v2/jpg/05/46/87/85/1000_F_546878598_GrpyJuARW7ORzPTRKc2PmWHDwJXuKOaF.jpg"))
            imagesList.add(Contact("White Bat","https://i.redd.it/ai-generated-art-based-on-album-title-alone-white-bat-v0-ahrc1uudg4oa1.png?width=1024&format=png&auto=webp&s=2b7d61604812010e9830114303aedbb124ee944e"))
        }
        imagesList.sortBy {
            it.name
        }
        println("On Download the Item Size: ${imagesList.size/10}")
        rv.adapter = ImagesAdapter(imagesList,baseContext)
        rv.layoutManager = LinearLayoutManager(this)
        println("Max memory: ${ Runtime.getRuntime().maxMemory()}")
    }
}