package com.example.etpproject

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.etpproject.bookdatabasepackage.Books
import kotlinx.android.synthetic.main.demolistviewlayout.view.*
import kotlinx.android.synthetic.main.genrespecificrow.view.*

class newAdapterforbooks(private val allBooks: List<Books>): RecyclerView.Adapter<newAdapterforbooks.ViewHolder>() {

    private var mListener: onBookItemClickListener? = null

    interface onBookItemClickListener : genreSpecificAdapter.onBookItemClickListener {
        override fun onItemClick(position: Int)

    }
    fun setOnItemClickListener(listener: onBookItemClickListener){
        mListener = listener

    }

    @SuppressLint("ResourceType")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.demolistviewlayout,parent,false)
        return ViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val img =allBooks[position].BookImage

        holder.bookName.text = allBooks[position].BookName
        holder.bookAuthor.text = allBooks[position].WriterName
        if (img != null) {
            holder.bookImage.setImageBitmap(BitmapFactory.decodeByteArray(img, 0, img.size))
        }

    }

    override fun getItemCount(): Int {
        return allBooks.size
    }

    class ViewHolder(view: View, listener: onBookItemClickListener?): RecyclerView.ViewHolder(view){

        val bookName : TextView = view.booknametv
        val bookAuthor : TextView = view.bookauthortv
        val bookImage: ImageView = view.bookimageviewdemo

        init{
            view.setOnClickListener {
                if (listener != null) {
                    listener.onItemClick(adapterPosition)
                }
            }

        }
    }
}