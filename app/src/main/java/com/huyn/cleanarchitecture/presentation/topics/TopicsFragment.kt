package com.huyn.cleanarchitecture.presentation.topics

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.huyn.cleanarchitecture.R
import com.huyn.cleanarchitecture.databinding.FragmentTopicsBinding
import com.huyn.cleanarchitecture.presentation.base.BaseViewBindingFragment
import com.huyn.cleanarchitecture.utils.Logger
import com.huyn.cleanarchitecture.utils.extension.beGone
import com.huyn.cleanarchitecture.utils.extension.safeCollectLatestFlow
import com.huyn.cleanarchitecture.utils.extension.safeNavigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopicsFragment : BaseViewBindingFragment<FragmentTopicsBinding, TopicsViewModel>(
    FragmentTopicsBinding::inflate) {

    override val viewModel: TopicsViewModel by viewModels()

    private val topicAdapter: PagedTopicAdapter by lazy {
        PagedTopicAdapter().apply {
            onTopicSelected = {
                findNavController().safeNavigate(TopicsFragmentDirections.actionTopicsFragmentToTopicDetailFragment(topic = it))
            }
        }
    }

    override fun initView() {
        with(viewBinding) {
            rvTopics.layoutManager = LinearLayoutManager(requireContext())
            rvTopics.adapter = topicAdapter
            with(layoutToolbar) {
                ivBack.beGone()
                tvTitle.text = getString(R.string.topics)
            }
        }
    }

    override suspend fun subscribeData() {
        safeCollectLatestFlow(viewModel.topics) {
            topicAdapter.submitData(it)
        }
        safeCollectLatestFlow(topicAdapter.loadStateFlow) {
            when (it.refresh) {
                is LoadState.Loading -> Logger.d("Loading photos")
                is LoadState.Error -> Logger.d("Loading photos error: ${(it.refresh as LoadState.Error).error}")
                else -> {}
            }
        }
    }
}
