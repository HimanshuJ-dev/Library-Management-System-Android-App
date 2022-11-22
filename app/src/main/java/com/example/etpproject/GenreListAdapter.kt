package com.example.etpproject

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class GenreListAdapter(private val genrenames : ArrayList<genreList>) : RecyclerView.Adapter<GenreListAdapter.MyViewHolder>() {

    private lateinit var mListener: onGenreItemClickListener

    interface onGenreItemClickListener{

        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener: onGenreItemClickListener){

        mListener = listener

    }



    @SuppressLint("ResourceType")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.genrelistview, parent, false)
        return MyViewHolder(itemView, mListener)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = genrenames[position]
        holder.genreimage.setImageResource(currentItem.genreImage)
        holder.genretitle.text = currentItem.genreTitle
    }

    override fun getItemCount(): Int {
        return genrenames.size
    }

    class MyViewHolder(itemView: View, listener: onGenreItemClickListener): RecyclerView.ViewHolder(itemView){

        val genreimage : ShapeableImageView = itemView.findViewById(R.id.genrelistitemimage)
        val genretitle : TextView = itemView.findViewById(R.id.genrenameinlist)

        init{

            itemView.setOnClickListener {

                listener.onItemClick(adapterPosition)

            }

        }

    }

}