package tgu.su

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.*
import kotlin.random.Random

private const val LAST_AND="Image"
private const val LAST_ME="Image"
var andImageNumber:Int=1
var myImageNumber:Int=1
class CuEFaFragment : Fragment() {
    lateinit var andImageView:ImageView
    lateinit var userImageView: ImageView
    lateinit var passButton: Button
    lateinit var stoneButton: Button
    lateinit var paperButton: Button



    private val andImageList:List<Int> = listOf(
        R.drawable.paper_pic,
        R.drawable.stone_pic,
        R.drawable.sciss_pic
    )
    private val myImageList:List<Int> = listOf(
        R.drawable.paper_pic_my,
        R.drawable.stone_pic_my,
        R.drawable.sciss_pic_my

    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cu_e_fa, container, false)
        val resultTextView:TextView
        if (savedInstanceState!=null) {
            andImageNumber=savedInstanceState.getInt(LAST_AND)
            myImageNumber =savedInstanceState.getInt(LAST_ME)
        }
        andImageView = view.findViewById(R.id.check_and_image_view)
        userImageView = view.findViewById(R.id.check_my_image_view)

        passButton = view.findViewById(R.id.pass_button)
        passButton.setOnClickListener{
            myImageNumber = 2
            andImageNumber = Random.nextInt(0,3)
            andImageView.setImageResource(andImageList[andImageNumber])
            userImageView.setImageResource((myImageList[myImageNumber]))
            if (andImageNumber == 0) ScoreFragment.MySingleton.user_Win_Count++
            if (andImageNumber == 2) ScoreFragment.MySingleton.draw_intent++
            if (andImageNumber == 1) ScoreFragment.MySingleton.android_Win_Count++

        }
        stoneButton = view.findViewById(R.id.stone_button)
        stoneButton.setOnClickListener{
            myImageNumber = 1
            andImageNumber = Random.nextInt(0,3)
            andImageView.setImageResource(andImageList[andImageNumber])
            userImageView.setImageResource((myImageList[myImageNumber]))
            if (andImageNumber == 2) ScoreFragment.MySingleton.user_Win_Count++
            if (andImageNumber == 1) ScoreFragment.MySingleton.draw_intent++
            if (andImageNumber == 0) ScoreFragment.MySingleton.android_Win_Count++

        }
        paperButton = view.findViewById(R.id.paper_button)
        paperButton.setOnClickListener{
            myImageNumber = 0
            andImageNumber = Random.nextInt(0,3)
            andImageView.setImageResource(andImageList[andImageNumber])
            userImageView.setImageResource((myImageList[myImageNumber]))
            if (andImageNumber == 1) ScoreFragment.MySingleton.user_Win_Count++
            if (andImageNumber == 0) ScoreFragment.MySingleton.draw_intent++
            if (andImageNumber == 2) ScoreFragment.MySingleton.android_Win_Count++
        }

        andImageView.setImageResource(andImageList[andImageNumber])
        userImageView.setImageResource((myImageList[myImageNumber]))


        return view


    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_AND,andImageNumber)
        outState.putInt(LAST_ME,myImageNumber)
    }




}