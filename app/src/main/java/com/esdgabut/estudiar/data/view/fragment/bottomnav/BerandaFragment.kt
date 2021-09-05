package com.esdgabut.estudiar.data.view.fragment.bottomnav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import com.esdgabut.estudiar.R
import com.esdgabut.estudiar.data.view.adapter.TentorCardStackAdapter
import com.esdgabut.estudiar.databinding.FragmentBerandaBinding
import com.esdgabut.estudiar.utils.CardStackUtils
import com.esdgabut.estudiar.utils.createTentors
import com.yuyakaido.android.cardstackview.*
import timber.log.Timber

class BerandaFragment : Fragment(), CardStackListener {

    private lateinit var binding: FragmentBerandaBinding
    private lateinit var manager: CardStackLayoutManager
    private lateinit var utils: CardStackUtils
    private val adapter by lazy { TentorCardStackAdapter(createTentors()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBerandaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialized()
        setupNavigation()
        setupCardStackView()
        setupButton()
    }

    private fun initialized() {
        manager = CardStackLayoutManager(requireActivity().applicationContext, this)
        utils = CardStackUtils(manager, adapter)
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {
        Timber.d("onCardDragging: d = ${direction?.name}, r = $ratio")
    }

    override fun onCardSwiped(direction: Direction?) {
        Timber.d("onCardSwiped: p = ${manager.topPosition}, d = $direction")
        if (manager.topPosition == adapter.itemCount - 5) {
            utils.paginate()
        }
    }

    override fun onCardRewound() {
        Timber.d("onCardRewound: ${manager.topPosition}")
    }

    override fun onCardCanceled() {
        Timber.d("onCardCanceled: ${manager.topPosition}")
    }

    override fun onCardAppeared(view: View?, position: Int) {
        Timber.d("onCardAppeared: ($position)")
    }

    override fun onCardDisappeared(view: View?, position: Int) {
        Timber.d("onCardDisappeared: ($position)")
    }

    private fun setupNavigation() {
        val navigationView = binding.layoutCardTentor.navigationView
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.reload -> utils.reload()
                R.id.add_spot_to_first -> utils.addFirst(1)
                R.id.add_spot_to_last -> utils.addLast(1)
                R.id.remove_spot_from_first -> utils.removeFirst(1)
                R.id.remove_spot_from_last -> utils.removeLast(1)
                R.id.replace_first_spot -> utils.replace()
                R.id.swap_first_for_last -> utils.swap()
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

}