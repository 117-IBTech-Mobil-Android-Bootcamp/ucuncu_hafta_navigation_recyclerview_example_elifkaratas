package com.example.week3.testresult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import com.example.week3.BaseRecyclerViewItemClickListener
import com.example.week3.R
import com.example.week3.testresult.model.Data
import com.example.week3.utils.gone
import com.example.week3.utils.visible
import kotlinx.android.synthetic.main.avatar_icon.*
import kotlinx.android.synthetic.main.fragment_set_avatar.*

class SetAvatarFragment : Fragment(){

    private lateinit var matchMakingResultAdapter: Adapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_set_avatar, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareView()
    }

    private fun prepareView(){
        recyclerView.layoutManager = GridLayoutManager(this.requireActivity(), 3)

        /*(recyclerView.layoutManager as GridLayoutManager).spanSizeLookup = object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                when (position) {
                    0,1 -> return 2
                    2, 3 -> return 3
                }
                throw IllegalStateException("internal error")
            }
        }*/

        val data = listOf(
            Data(R.drawable.ic_mask_group, R.drawable.ic_avatarbg_small),
            Data(R.drawable.ic_mask_group_2, R.drawable.ic_avatarbg_small),
            Data(R.drawable.ic_mask_group_3, R.drawable.ic_avatarbg_small),
            Data(R.drawable.ic_mask_group_4, R.drawable.ic_avatarbg_small),
            Data(R.drawable.ic_mask_group_5, R.drawable.ic_avatarbg_small),
            Data(R.drawable.ic_mask_group_6, R.drawable.ic_avatarbg_small),
            Data(R.drawable.ic_mask_group_7, R.drawable.ic_avatarbg_small),
            Data(R.drawable.ic_mask_group_8, R.drawable.ic_avatarbg_small),
            Data(R.drawable.ic_mask_group_9, R.drawable.ic_avatarbg_small)
        )

        matchMakingResultAdapter = Adapter(data,object : BaseRecyclerViewItemClickListener<Data>{
                override fun onItemClicked(clickedObject: Data, id: Int) {
                    when(id){
                        R.id.checkBox -> {
                            checkBox.setImageResource(R.drawable.ic_success_outline)
                            matchMakingResultAdapter.notifyChanges(clickedObject)
                        }
                    }
                }
            })

        recyclerView.adapter = matchMakingResultAdapter
        visibleData(data)
    }

    private fun visibleData(list : List<Data>){
        if(list.isNullOrEmpty()){
            recyclerView.gone()
            noText.visible()
        }
    }
}