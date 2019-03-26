package shishir.nitmeghalaya.`in`.shishir2019.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_events_list.view.*
import shishir.nitmeghalaya.`in`.shishir2019.R
import shishir.nitmeghalaya.`in`.shishir2019.adapter.EventsListAdapter
import shishir.nitmeghalaya.`in`.shishir2019.models.ShishirEvent
import shishir.nitmeghalaya.`in`.shishir2019.util.COLLECTION_EVENTS

class EventsListFragment : Fragment() {

    private var eventsList = arrayListOf<ShishirEvent>()

    companion object {
        @JvmStatic
        fun newInstance() = EventsListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_events_list, container, false)
        getScheduleFromDatabase(view.eventsListRecyclerView)
        return view
    }

    private fun getScheduleFromDatabase(recyclerView: RecyclerView) {
        val db = FirebaseFirestore.getInstance()

        db.collection(COLLECTION_EVENTS)
            .get()
            .addOnSuccessListener {
                for (document in it) {
                    eventsList.add(document.toObject(ShishirEvent::class.java))
                }
                Log.v("List", eventsList.toString())
                setUpRecyclerView(recyclerView)
            }
            .addOnFailureListener {
                Log.v("error", "error")
            }
    }

    private fun setUpRecyclerView(recyclerView: RecyclerView) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = EventsListAdapter(context, eventsList)
        }
    }
}
