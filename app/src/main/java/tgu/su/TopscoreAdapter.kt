package tgu.su

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class topScoreAdapter(private val topScoreUsers:List<String>):
    RecyclerView.Adapter<TopScoreViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopScoreViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.top_score_list_item,parent,false)
        return TopScoreViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TopScoreViewHolder, position: Int) {
        val name = topScoreUsers[position]
        holder.bind(name)
    }

    override fun getItemCount(): Int {
        return topScoreUsers.size
    }
}