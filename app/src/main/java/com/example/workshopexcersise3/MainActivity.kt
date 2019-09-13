package com.example.workshopexcersise3

import android.content.Context
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

/*
* TODO:
*   -Refactor to user different file structure
*        /layout/===fragments?===
*        /models
*        /mockData
*        /interfaces
*   -Refactor initMockData() to just val => ArrayListOf?
*   -Implement showing the images
*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        val viewManager = LinearLayoutManager(this)
        val viewAdapter = MyAdapter(this, initMockData(), object: OnClickItemListener {
            override fun onItemClick(position: Int, view: View) {
                val context = view.context
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra(ListItem.INTENT_ITEM_TITLE,initMockData()[position].title)
                    putExtra(ListItem.INTENT_ITEM_SUBTITLE,initMockData()[position].subtitle)
                }
                context.startActivity(intent)
            }
        })

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            this.setHasFixedSize(true)
            this.layoutManager = viewManager
            this.adapter = viewAdapter
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) : Boolean {
        return when (item.itemId){
            R.id.action_refresh -> {
                //Do something..
                Toast.makeText(this,"Refresh action selected",Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
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
){
    companion object {
        const val INTENT_ITEM_TITLE = "item_title"
        const val INTENT_ITEM_SUBTITLE = "item_subtitle"
    }
}

class MyAdapter(val context: Context, val items: ArrayList<ListItem>, val listener: OnClickItemListener) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
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
        holder.itemView.setOnClickListener{
            listener.onItemClick(holder.adapterPosition, it)
        }
    }
}

interface OnClickItemListener{
    fun onItemClick(position: Int, view: View)
}



