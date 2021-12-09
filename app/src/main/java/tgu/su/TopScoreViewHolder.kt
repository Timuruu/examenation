package tgu.su

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TopScoreViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    private val topScoreTextView: TextView =
        itemView.findViewById(R.id.top_score_name_view)
    fun bind (name: String){
        topScoreTextView.text = name
    }
}