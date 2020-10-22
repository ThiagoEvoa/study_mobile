package com.example.myapplication.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.model.PersonModel
import com.example.myapplication.presentation.ui.fragment.MainFragment
import kotlinx.android.synthetic.main.item_person.view.*

class PersonAdapter(private val fragment: Fragment, private val objects: MutableList<PersonModel>) :
    RecyclerView.Adapter<PersonAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        )
    }

    override fun getItemCount(): Int = objects.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val personModel = objects[position]
        holder.personName.text = personModel.name
        holder.layoutItemPerson.setOnClickListener {
            (fragment as MainFragment).onItemClick(personModel)
        }
        holder.layoutItemPerson.setOnLongClickListener {
            (fragment as MainFragment).onItemLongClick(personModel)
            true
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var personName: TextView = view.txt_person_name
        var layoutItemPerson: LinearLayout = view.layout_item_person
    }
}