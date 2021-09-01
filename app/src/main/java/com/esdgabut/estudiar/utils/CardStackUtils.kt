package com.esdgabut.estudiar.utils

import androidx.recyclerview.widget.DiffUtil
import com.esdgabut.estudiar.callback.TentorDiffCallback
import com.esdgabut.estudiar.data.model.TentorModel
import com.esdgabut.estudiar.data.view.adapter.TentorCardStackAdapter
import com.yuyakaido.android.cardstackview.CardStackLayoutManager

class CardStackUtils(
    private val manager: CardStackLayoutManager,
    private val adapter: TentorCardStackAdapter
) {
    fun paginate() {
        val old = adapter.getTentors()
        val new = old.plus(createTentors())
        val callback = TentorDiffCallback(old, new)
        val result = DiffUtil.calculateDiff(callback)
        adapter.setTentors(new)
        result.dispatchUpdatesTo(adapter)
    }

    fun reload() {
        val old = adapter.getTentors()
        val new = createTentors()
        val callback = TentorDiffCallback(old, new)
        val result = DiffUtil.calculateDiff(callback)
        adapter.setTentors(new)
        result.dispatchUpdatesTo(adapter)
    }

    fun addFirst(size: Int) {
        val old = adapter.getTentors()
        val new = mutableListOf<TentorModel>().apply {
            addAll(old)
            for (i in 0 until size) {
                add(manager.topPosition, createTentor())
            }
        }
        val callback = TentorDiffCallback(old, new)
        val result = DiffUtil.calculateDiff(callback)
        adapter.setTentors(new)
        result.dispatchUpdatesTo(adapter)
    }

    fun addLast(size: Int) {
        val old = adapter.getTentors()
        val new = mutableListOf<TentorModel>().apply {
            addAll(old)
            addAll(List(size) { createTentor() })
        }
        val callback = TentorDiffCallback(old, new)
        val result = DiffUtil.calculateDiff(callback)
        adapter.setTentors(new)
        result.dispatchUpdatesTo(adapter)
    }

    fun removeFirst(size: Int) {
        if (adapter.getTentors().isEmpty()) {
            return
        }

        val old = adapter.getTentors()
        val new = mutableListOf<TentorModel>().apply {
            addAll(old)
            for (i in 0 until size) {
                removeAt(manager.topPosition)
            }
        }
        val callback = TentorDiffCallback(old, new)
        val result = DiffUtil.calculateDiff(callback)
        adapter.setTentors(new)
        result.dispatchUpdatesTo(adapter)
    }

    fun removeLast(size: Int) {
        if (adapter.getTentors().isEmpty()) {
            return
        }

        val old = adapter.getTentors()
        val new = mutableListOf<TentorModel>().apply {
            addAll(old)
            for (i in 0 until size) {
                removeAt(this.size - 1)
            }
        }
        val callback = TentorDiffCallback(old, new)
        val result = DiffUtil.calculateDiff(callback)
        adapter.setTentors(new)
        result.dispatchUpdatesTo(adapter)
    }

    fun replace() {
        val old = adapter.getTentors()
        val new = mutableListOf<TentorModel>().apply {
            addAll(old)
            removeAt(manager.topPosition)
            add(manager.topPosition, createTentor())
        }
        adapter.setTentors(new)
        adapter.notifyItemChanged(manager.topPosition)
    }

    fun swap() {
        val old = adapter.getTentors()
        val new = mutableListOf<TentorModel>().apply {
            addAll(old)
            val first = removeAt(manager.topPosition)
            val last = removeAt(this.size - 1)
            add(manager.topPosition, last)
            add(first)
        }
        val callback = TentorDiffCallback(old, new)
        val result = DiffUtil.calculateDiff(callback)
        adapter.setTentors(new)
        result.dispatchUpdatesTo(adapter)
    }
}