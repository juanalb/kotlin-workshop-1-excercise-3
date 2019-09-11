package com.example.workshopexcersise3

import android.content.Context
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

/*
* TODO:
*   -Refactor to user different file structure
*        /layout/===fragments?===
*        /models
*        /mockData
*   -Refactor to use fragment for list_item layout
*    https://developer.android.com/guide/components/fragments
*   -Refactor initMockData() to just val
*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewManager = LinearLayoutManager(this)
        val viewAdapter = MyAdapter(this, initMockData())

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            this.setHasFixedSize(true)
            this.layoutManager = viewManager
            this.adapter = viewAdapter
        }
    }
}
fun initMockData() : ArrayList<ListItem>{
    val mockData : ArrayList<ListItem> = ArrayList()

    val listItem1 = ListItem(null,"Title1","Subtitle1")
    val listItem2 = ListItem(null,"Title2","Subtitle2")
    val listItem3 = ListItem(null,"Title3","Subtitle3")
    val listItem4 = ListItem(null,"Title4","Subtitle4")
    val listItem5 = ListItem(null,"Title5","Subtitle5")
    val listItem6 = ListItem(null,"Title6","Subtitle6")
    val listItem7 = ListItem(null,"Title7","Subtitle7")
    val listItem8 = ListItem(null,"Title8","Subtitle8")
    val listItem9 = ListItem(null,"Title9","Subtitle9")
    val listItem10 = ListItem(null,"Title10","Subtitle10")
    val listItem11 = ListItem(null,"Title11","Subtitle11")

    mockData.add(listItem1)
    mockData.add(listItem2)
    mockData.add(listItem3)
    mockData.add(listItem4)
    mockData.add(listItem5)
    mockData.add(listItem6)
    mockData.add(listItem7)
    mockData.add(listItem8)
    mockData.add(listItem9)
    mockData.add(listItem10)
    mockData.add(listItem11)

    return mockData
}


data class ListItem(
    val image: Image?,
    val title: String,
    val subtitle: String
)

class MyAdapter(val context: Context, val items: ArrayList<ListItem>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.list_item_imageView
        val title: TextView = itemView.list_item_title
        val subtitle: TextView = itemView.list_item_subtitle
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.subtitle.text = item.subtitle
    }
}