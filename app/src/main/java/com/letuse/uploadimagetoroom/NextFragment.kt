package com.letuse.uploadimagetoroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.letuse.uploadimagetoroom.Image.Adapter
import com.letuse.uploadimagetoroom.Image.Image
import com.letuse.uploadimagetoroom.Image.viewmodel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_next.*
import kotlinx.android.synthetic.main.item_list.view.*


class NextFragment : Fragment() {

    lateinit var vm : viewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ad = Adapter()
        vm = ViewModelProvider(this).get(viewmodel::class.java)

        recycerlview_img.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = ad
        }

        vm.allItem.observe(
            viewLifecycleOwner, Observer {
                it.let {
                    ad.addCategoryList(it)
                }
            }
        )
    }
}
