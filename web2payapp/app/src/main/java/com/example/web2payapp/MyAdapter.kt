package com.example.web2payapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
private var items: List<Transferecias> = ArrayList()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val valor: TextView = itemView.findViewById(com.example.web2payapp.R.id.valor_cad)
        private val  cd: TextView = itemView.findViewById(R.id.c_d)
        private val tipo: TextView = itemView.findViewById(R.id.tipo_cad)
    }





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
            return MyViewHolder(itemView)
        }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        when(holder){
            is MyViewHolder ->{
                
            }
        }

        }

    override fun getItemCount(): Int {
        return items.size
    }



}