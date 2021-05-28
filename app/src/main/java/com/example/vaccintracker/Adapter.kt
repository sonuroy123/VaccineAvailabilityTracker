package com.example.vaccintracker

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// on below line we are creating our adapter class
// in this class we are passing our array list
// and our View Holder class which we have created.
class Adapter(private val centerList: List<DataModel>) :
    RecyclerView.Adapter<Adapter.CenterRVViewHolder>() {


    // on below line we are creating our view holder class which will
    // be used to initialize each view of our layout file.
    class CenterRVViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // on below line we are initializing all our text views along with  its ids.
        val centerNameTV: TextView = itemView.findViewById(R.id.txtCenterName)
        val centerAddressTV: TextView = itemView.findViewById(R.id.txtCenterAddress)
        val centerTimings: TextView = itemView.findViewById(R.id.txtCenterTimings)
        val vaccineNameTV: TextView = itemView.findViewById(R.id.txtVaccineName)
        val centerAgeLimitTV: TextView = itemView.findViewById(R.id.txtAgeLimit)
        val centerFeeTypeTV: TextView = itemView.findViewById(R.id.txtFeeType)
        val avalabilityTV: TextView = itemView.findViewById(R.id.txtAvaliablity)
    }

    // below method is for on Create Vew Holder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CenterRVViewHolder {
        // this method is use to inflate the layout file
        // which we have created for our recycler view.
        // on below line we are inflating our layout file.
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.single_row,
            parent, false
        )
        // at last we are returning our view holder
        // class with our item View File.
        return CenterRVViewHolder(itemView)
    }

    // this method is to count the size of our array list.
    override fun getItemCount(): Int {

        // on below line we are returning
        // the size of our array list.
        return centerList.size
    }

    // below method is to set the data to each view of our recycler view item.
    override fun onBindViewHolder(holder: CenterRVViewHolder, position: Int) {

        // on below line we are getting item
        // from our list along with its position.
        val currentItem = centerList[position]

        // after getting current item we are setting
        // data from our list to our text views.
        holder.centerNameTV.text = currentItem.centerName
        holder.centerAddressTV.text = currentItem.centerAddress
        holder.centerTimings.text = ("From : " + currentItem.centerFromTime + " To : " + currentItem.centerToTime)
        holder.vaccineNameTV.text = currentItem.vaccineName
        holder.centerAgeLimitTV.text = "Age Limit : " + currentItem.ageLimit.toString()
        holder.centerFeeTypeTV.text = currentItem.fee_type
        holder.avalabilityTV.text = "Availability : " + currentItem.availableCapacity.toString()
        //if(currentItem.availableCapacity.toString().length >1)
        //   holder.avalabilityTV.setTextColor(Color.RED)
    }
}