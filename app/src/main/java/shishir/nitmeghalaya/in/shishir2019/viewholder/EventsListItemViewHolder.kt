package shishir.nitmeghalaya.`in`.shishir2019.viewholder

import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.view.View
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.event_item.view.*
import shishir.nitmeghalaya.`in`.shishir2019.R
import shishir.nitmeghalaya.`in`.shishir2019.activity.EventDetailActivity
import shishir.nitmeghalaya.`in`.shishir2019.models.ShishirEvent
import android.graphics.BitmapFactory
import android.graphics.Color
import com.bumptech.glide.request.RequestOptions
import com.google.gson.Gson
import shishir.nitmeghalaya.`in`.shishir2019.activity.EventSubListActivity
import shishir.nitmeghalaya.`in`.shishir2019.util.*
import shishir.nitmeghalaya.`in`.shishir2019.util.getImageResource

/**
 * Created by Devansh on 24/1/19.
 */

class EventsListItemViewHolder(view: View) : BaseViewHolder(view) {

    private lateinit var item: ShishirEvent
    private var imageResId = 0

    override fun bind(i: Any) {
        this.item = i as ShishirEvent

        if (item.image.isEmpty())
            item.image = "krigg"

        imageResId = getImageResource(view.context, item.image)

        view.apply {
            eventListItemTitle.text = item.name

            val options = RequestOptions().placeholder(R.drawable.loading)

            Glide.with(this).load(getImageResource(context, item.image)).apply(options).into(eventListItemImage)

            setOnClickListener {

                var intent = Intent(context, EventDetailActivity::class.java)
                intent.putExtra(EVENT_DATA, Gson().toJson(item))

                context.startActivity(intent)
            }

            if (android.os.Build.VERSION.SDK_INT >= 23) {
                eventListItemImage.foreground = item.foregroundGradient
            }
        }
    }
}