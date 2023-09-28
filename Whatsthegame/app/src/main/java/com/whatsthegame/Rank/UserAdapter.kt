package com.whatsthegame.Rank

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.whatsthegame.R


class UserAdapter(private var userList: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val usernameTextView: TextView = itemView.findViewById(R.id.username)
        val rankTextView: TextView = itemView.findViewById(R.id.rank)
        val divisionTextView: TextView = itemView.findViewById(R.id.division)
        val pointsTextView: TextView = itemView.findViewById(R.id.points)
        val iconImageView: ImageView = itemView.findViewById(R.id.iconImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(itemView)
    }

    private val rankIconsPodium = listOf(
        R.drawable.firstposition,
        R.drawable.secondposition,
        R.drawable.thirdposition
    )

    private val rankIconsMap = mapOf(
        "Bronze" to R.drawable.bronze,
        "Prata" to R.drawable.prata,
        "Ouro" to R.drawable.ouro,
        "Platina" to R.drawable.platina,
        "Diamante" to R.drawable.diamante
    )
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentUser = userList[position]

        holder.usernameTextView.text = currentUser.username
        holder.rankTextView.text = currentUser.rank
        holder.divisionTextView.text = currentUser.division
        holder.pointsTextView.text = "${currentUser.points} Pontos"

        if (position < 3) {
            holder.iconImageView.setImageResource(rankIconsPodium[position])
        } else {
            if (rankIconsMap.containsKey(currentUser.rank)) {
                holder.iconImageView.setImageResource(rankIconsMap[currentUser.rank]!!)
            } else {
                holder.iconImageView.setImageResource(R.drawable.bronze)
            }
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun updateUserList(newList: List<User>) {
        userList = newList
        notifyDataSetChanged()
    }

}