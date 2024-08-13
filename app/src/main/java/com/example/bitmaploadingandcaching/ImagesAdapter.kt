package com.example.bitmaploadingandcaching

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.collection.LruCache
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout
import kotlinx.coroutines.delay
import java.net.URL
import java.sql.Time

class ImagesAdapter(private var imageList:MutableList<Contact>,private var context: Context):RecyclerView.Adapter<ImagesAdapter.ImageHolder>(){
    private var i =0
    private var bitmapCache = LruCache<String,Bitmap>((Runtime.getRuntime().maxMemory()/4).toInt())

    inner class ImageHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val imageView: ImageView = itemView.findViewById(R.id.contactImage)
        val contactName:TextView = itemView.findViewById(R.id.contactName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        return ImageHolder(LayoutInflater.from(parent.context).inflate(R.layout.image_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
//        shimmerFrameLayout.stopShimmer()
        holder.contactName.text = imageList[holder.adapterPosition].name
        val handler = Handler(Looper.getMainLooper())
        holder.itemView.apply {
            Thread{
                val img = downloadImage(imageList[holder.adapterPosition].image)
                handler.post {
                    if(holder.adapterPosition==position){
                        holder.imageView.setImageBitmap(img)
                        holder.imageView.visibility = View.VISIBLE
                    }
                }
            }.start()
        }

    }

    private fun downloadImage(imageUrl:String): Bitmap?{
        if(bitmapCache.get(imageUrl)==null){
            return try{
                val url = URL(imageUrl).openConnection()
                url.connect()
                val inputStream = url.getInputStream()
                val downloadedImage = BitmapFactory.decodeStream(inputStream)
                inputStream.close()
                bitmapCache.put(imageUrl,downloadedImage)
                println(bitmapCache.toString())
                println("Image Downloaded Successfully ${Thread.currentThread().id} ${i++}")
                println(bitmapCache.snapshot())
                Thread.sleep(10000)
//              DiskCache.saveBitMap(context,"image$i",downloadedImage)
                downloadedImage
            }
            catch (e:Exception){
                println("Exception: $e")
                null
            }
        }
        else{
            return bitmapCache.get(imageUrl)
        }
    }
}