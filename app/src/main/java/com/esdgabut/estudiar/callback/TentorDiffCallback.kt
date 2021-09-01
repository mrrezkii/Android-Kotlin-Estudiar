package com.esdgabut.estudiar.callback

import androidx.recyclerview.widget.DiffUtil
import com.esdgabut.estudiar.data.model.TentorModel

class TentorDiffCallback(
    private val old: List<TentorModel>,
    private val new: List<TentorModel>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return old.size
    }

    override fun getNewListSize(): Int {
        return new.size
    }

    override fun areItemsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return old[oldPosition].id == new[newPosition].id
    }

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return old[oldPosition] == new[newPosition]
    }

}
