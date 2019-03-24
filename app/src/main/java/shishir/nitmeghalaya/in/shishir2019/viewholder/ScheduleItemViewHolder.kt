package shishir.nitmeghalaya.`in`.shishir2019.viewholder

import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_schedule.view.*
import shishir.nitmeghalaya.`in`.shishir2019.models.EventScheduleItem
import shishir.nitmeghalaya.`in`.shishir2019.util.getImageResource

/**
 * Created by Devansh on 24/3/19.
 */
class ScheduleItemViewHolder(view: View): BaseViewHolder(view) {

    private lateinit var item: EventScheduleItem

    override fun bind(i: Any) {
        item = i as EventScheduleItem

        view.apply {
            startTimeTV.text = item.startTime
            endTimeTV.text = item.endTime
            eventTitleTV.text = item.name
            Glide.with(context).load(item.imageResId).into(imageView)
        }
    }
}