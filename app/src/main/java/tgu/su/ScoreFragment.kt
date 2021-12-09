package tgu.su

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ScoreFragment : Fragment() {
lateinit var topScoreRecyclerView: RecyclerView
lateinit var shareButton:Button

object MySingleton{
    var android_Win_Count:Int=0
    var user_Win_Count:Int=0
    var draw_intent:Int=0

}


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_score, container, false)
        var and_Win:String  = "Android: "+MySingleton.android_Win_Count.toString()+" Wins"
        var user_Win:String = "User: "+MySingleton.user_Win_Count.toString()+" Wins"
        var drawCount:String = "Draw was: "+MySingleton.draw_intent.toString()+" singles"

        val topScoreUsers:List<String> = listOf(and_Win,user_Win,drawCount)

        shareButton = view.findViewById(R.id.share_button)
        topScoreRecyclerView = view.findViewById(R.id.top_score_recycler_view)
        topScoreRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        topScoreRecyclerView.adapter = topScoreAdapter(topScoreUsers)

        shareButton.setOnClickListener{
            var shared_Text = "Hey there! Look on my score in a cool game Rock paper scissors: I won "+
                    MySingleton.user_Win_Count.toString()+" times and lost "+
                    MySingleton.android_Win_Count.toString()+" and there were "+
                    MySingleton.draw_intent.toString()+" draws. Download game on click: "
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT, shared_Text)
            sendIntent.type = "text/plain"
            startActivity(sendIntent)
        }
        return view
    }
}