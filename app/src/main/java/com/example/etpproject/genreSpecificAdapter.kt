package com.example.etpproject

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.etpproject.bookdatabasepackage.Books
import kotlinx.android.synthetic.main.genrespecificrow.view.*

class genreSpecificAdapter(private val allBooks: List<Books>): RecyclerView.Adapter<genreSpecificAdapter.ViewHolder>() {
    private lateinit var mListener: onGenreItemClickListener
    interface onGenreItemClickListener{
        fun onItemClick(position: Int)

    }
    fun setOnItemClickListener(listener: onGenreItemClickListener){
        mListener = listener

    }

    class ViewHolder(val view: View, listener: onGenreItemClickListener): RecyclerView.ViewHolder(view){
        init{
            view.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.genrespecificrow,parent,false)
        return ViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val img =allBooks[position].BookImage

        holder.view.findViewById<TextView>(R.id.genrebooknametv).text = allBooks[position].BookName
        holder.view.findViewById<TextView>(R.id.genrewriternametv).text = allBooks[position].WriterName
        val rating = allBooks[position].BookRating.toString()
        holder.view.findViewById<TextView>(R.id.genreratingtv).text = "Ratings: $rating/5"
        if (img != null) {
            holder.view.findViewById<ImageView>(R.id.genrespecificiv).setImageBitmap(BitmapFactory.decodeByteArray(img, 0, img.size))
        }

    }

    override fun getItemCount() = allBooks.size

}
