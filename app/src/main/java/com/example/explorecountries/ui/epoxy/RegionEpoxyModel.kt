package com.example.explorecountries.ui.epoxy

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.explorecountries.R
import com.example.explorecountries.data.models.Region

@EpoxyModelClass(layout = R.layout.view_holder_regions)
abstract class RegionEpoxyModel : EpoxyModelWithHolder<RegionEpoxyModel.Holder>() {

    @EpoxyAttribute
    lateinit var region: Region

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(region) {
            holder.regionName.text = region.regionName
        }
    }

    inner class Holder : EpoxyHolder() {
        lateinit var regionImage: ImageView
        lateinit var regionName: AppCompatTextView

        override fun bindView(itemView: View) {
            regionImage = itemView.findViewById(R.id.regionImageView)
            regionName = itemView.findViewById(R.id.regionName)
        }
    }
}