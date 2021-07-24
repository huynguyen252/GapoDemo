package com.ribisoft.gapodemo.ui.details.adapter.holder

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.os.Looper
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ribisoft.gapodemo.data.model.Section
import com.ribisoft.gapodemo.databinding.ItemSection2Binding
import com.ribisoft.gapodemo.ui.details.adapter.SectionAdapter
import com.ribisoft.gapodemo.utils.DeviceUtil
import java.util.logging.Handler

class Section2Holder(
    private val itemBinding: ItemSection2Binding,
    private val context: Context,
    private val callback: SectionAdapter.OnClickItemCallback
) : RecyclerView.ViewHolder(itemBinding.root) {
    lateinit var section: Section
    fun setData(section: Section, position: Int) {
        this.section = section
        setVideoView()
        itemBinding.holder = this
        itemBinding.section = section
    }

    fun playVideo() {
        section.contents?.href?.let {
            itemBinding.flVideo.visibility = View.VISIBLE
            showPause()
            itemBinding.ivPreviewImage.visibility = View.INVISIBLE
            itemBinding.videoView.start()
        }
    }

    fun pauseVideo() {
        section.contents?.href?.let {
            itemBinding.flVideo.visibility = View.INVISIBLE
            itemBinding.ivPause.visibility = View.GONE
            itemBinding.ivPreviewImage.visibility = View.VISIBLE
            itemBinding.videoView.pause()
        }
    }

    private fun setVideoView() {
        val w: Int = section.contents?.previewImage?.width!!
        val h: Int = section.contents?.previewImage?.height!!
        val widthView = DeviceUtil.getInstance().getWidthScreen(context)
        itemBinding.videoView.layoutParams.width = widthView
        if (h in 1 until w) {
            itemBinding.videoView.layoutParams.height = (widthView * h) / w
        } else {
            itemBinding.videoView.layoutParams.height = widthView
        }
        section.contents?.href?.let {
            val video = Uri.parse(it)
            itemBinding.videoView.setZOrderMediaOverlay(true)
            itemBinding.videoView.setVideoURI(video)
            itemBinding.videoView.setOnPreparedListener { mp ->
                mp.isLooping = true
            }
            itemBinding.ivPreviewImage.visibility = View.VISIBLE
            itemBinding.flVideo.visibility = View.INVISIBLE
        }
    }

    fun showPause() {
        itemBinding.ivPause.visibility = View.VISIBLE
        android.os.Handler(Looper.getMainLooper())
            .postDelayed({ itemBinding.ivPause.visibility = View.INVISIBLE }, 3000)
    }

}