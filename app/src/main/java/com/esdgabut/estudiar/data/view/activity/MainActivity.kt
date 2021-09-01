package com.esdgabut.estudiar.data.view.activity

import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DiffUtil
import com.esdgabut.estudiar.R
import com.esdgabut.estudiar.callback.TentorDiffCallback
import com.esdgabut.estudiar.data.model.TentorModel
import com.esdgabut.estudiar.data.view.adapter.TentorCardStackAdapter
import com.esdgabut.estudiar.databinding.ActivityMainBinding
import com.yuyakaido.android.cardstackview.*
import java.util.*

class MainActivity : AppCompatActivity(), CardStackListener {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(
            layoutInflater
        )
    }
    private val manager by lazy { CardStackLayoutManager(this, this) }
    private val adapter by lazy { TentorCardStackAdapter(createTentors()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupNavigation()
        setupCardStackView()
        setupButton()
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {

    }

    override fun onCardSwiped(direction: Direction?) {
        if (manager.topPosition == adapter.itemCount - 5) {
            paginate()
        }
    }

    override fun onCardRewound() {

    }

    override fun onCardCanceled() {

    }

    override fun onCardAppeared(view: View?, position: Int) {

    }

    override fun onCardDisappeared(view: View?, position: Int) {

    }

    private fun setupNavigation() {
        // Toolbar
        setSupportActionBar(binding.layoutCardTentor.toolbar)

        // DrawerLayout
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.layoutCardTentor.drawerLayout,
            binding.layoutCardTentor.toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )
        actionBarDrawerToggle.syncState()
        binding.layoutCardTentor.drawerLayout.addDrawerListener(actionBarDrawerToggle)

        // NavigationView
        val navigationView = binding.layoutCardTentor.navigationView
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.reload -> reload()
                R.id.add_spot_to_first -> addFirst(1)
                R.id.add_spot_to_last -> addLast(1)
                R.id.remove_spot_from_first -> removeFirst(1)
                R.id.remove_spot_from_last -> removeLast(1)
                R.id.replace_first_spot -> replace()
                R.id.swap_first_for_last -> swap()
            }
            binding.layoutCardTentor.drawerLayout.closeDrawers()
            true
        }
    }

    private fun setupCardStackView() {
        manager.setStackFrom(StackFrom.None)
        manager.setVisibleCount(3)
        manager.setTranslationInterval(8.0f)
        manager.setScaleInterval(0.95f)
        manager.setSwipeThreshold(0.3f)
        manager.setMaxDegree(20.0f)
        manager.setDirections(Direction.HORIZONTAL)
        manager.setCanScrollHorizontal(true)
        manager.setCanScrollVertical(true)
        manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
        manager.setOverlayInterpolator(LinearInterpolator())

        binding.layoutCardTentor.cardStackView.layoutManager = manager
        binding.layoutCardTentor.cardStackView.adapter = adapter
        binding.layoutCardTentor.cardStackView.itemAnimator.apply {
            if (this is DefaultItemAnimator) {
                supportsChangeAnimations = false
            }
        }
    }

    private fun setupButton() {
        val skip = binding.layoutCardTentor.skipButton
        skip.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Left)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(AccelerateInterpolator())
                .build()
            manager.setSwipeAnimationSetting(setting)
            binding.layoutCardTentor.cardStackView.swipe()
        }

        val rewind = binding.layoutCardTentor.rewindButton
        rewind.setOnClickListener {
            val setting = RewindAnimationSetting.Builder()
                .setDirection(Direction.Bottom)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(DecelerateInterpolator())
                .build()
            manager.setRewindAnimationSetting(setting)
            binding.layoutCardTentor.cardStackView.rewind()
        }

        val like = binding.layoutCardTentor.likeButton
        like.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Right)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(AccelerateInterpolator())
                .build()
            manager.setSwipeAnimationSetting(setting)
            binding.layoutCardTentor.cardStackView.swipe()
        }
    }


    private fun paginate() {
        val old = adapter.getTentors()
        val new = old.plus(createTentors())
        val callback = TentorDiffCallback(old, new)
        val result = DiffUtil.calculateDiff(callback)
        adapter.setTentors(new)
        result.dispatchUpdatesTo(adapter)
    }

    private fun reload() {
        val old = adapter.getTentors()
        val new = createTentors()
        val callback = TentorDiffCallback(old, new)
        val result = DiffUtil.calculateDiff(callback)
        adapter.setTentors(new)
        result.dispatchUpdatesTo(adapter)
    }

    private fun addFirst(size: Int) {
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

    private fun addLast(size: Int) {
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

    private fun removeFirst(size: Int) {
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

    private fun removeLast(size: Int) {
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

    private fun replace() {
        val old = adapter.getTentors()
        val new = mutableListOf<TentorModel>().apply {
            addAll(old)
            removeAt(manager.topPosition)
            add(manager.topPosition, createTentor())
        }
        adapter.setTentors(new)
        adapter.notifyItemChanged(manager.topPosition)
    }

    private fun swap() {
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

    private fun createTentor(): TentorModel {
        return TentorModel(
            name = "Yasaka Shrine",
            city = "Kyoto",
            url = "https://source.unsplash.com/Xq1ntWruZQI/600x800"
        )
    }

    private fun createTentors(): List<TentorModel> {
        val tentors = ArrayList<TentorModel>()
        tentors.add(
            TentorModel(
                name = "Yasaka Shrine",
                city = "Kyoto",
                url = "https://source.unsplash.com/Xq1ntWruZQI/600x800"
            )
        )
        tentors.add(
            TentorModel(
                name = "Fushimi Inari Shrine",
                city = "Kyoto",
                url = "https://source.unsplash.com/NYyCqdBOKwc/600x800"
            )
        )
        tentors.add(
            TentorModel(
                name = "Bamboo Forest",
                city = "Kyoto",
                url = "https://source.unsplash.com/buF62ewDLcQ/600x800"
            )
        )
        tentors.add(
            TentorModel(
                name = "Brooklyn Bridge",
                city = "New York",
                url = "https://source.unsplash.com/THozNzxEP3g/600x800"
            )
        )
        tentors.add(
            TentorModel(
                name = "Empire State Building",
                city = "New York",
                url = "https://source.unsplash.com/USrZRcRS2Lw/600x800"
            )
        )
        tentors.add(
            TentorModel(
                name = "The statue of Liberty",
                city = "New York",
                url = "https://source.unsplash.com/PeFk7fzxTdk/600x800"
            )
        )
        tentors.add(
            TentorModel(
                name = "Louvre Museum",
                city = "Paris",
                url = "https://source.unsplash.com/LrMWHKqilUw/600x800"
            )
        )
        tentors.add(
            TentorModel(
                name = "Eiffel Tower",
                city = "Paris",
                url = "https://source.unsplash.com/HN-5Z6AmxrM/600x800"
            )
        )
        tentors.add(
            TentorModel(
                name = "Big Ben",
                city = "London",
                url = "https://source.unsplash.com/CdVAUADdqEc/600x800"
            )
        )
        tentors.add(
            TentorModel(
                name = "Great Wall of China",
                city = "China",
                url = "https://source.unsplash.com/AWh9C-QjhE4/600x800"
            )
        )
        return tentors
    }

}