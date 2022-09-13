package com.example.animelover.favourite

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animelover.core.ListMemberAdapter
import com.example.animelover.favourite.databinding.ActivityMemberFavouriteBinding
import com.example.animelover.ui.detail.MemberDetailActivity
import com.example.animelover.ui.detail.MemberDetailActivity.Companion.EXTRA_DATA
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules


class FavouriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMemberFavouriteBinding
    private val memberFavouriteViewModel: MemberFavouriteViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemberFavouriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadKoinModules(favouriteModule)

        val memberAdapter = ListMemberAdapter()
        memberAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, MemberDetailActivity::class.java)
            intent.putExtra(EXTRA_DATA, selectedData)
            startActivity(intent)
        }


        memberFavouriteViewModel.getFavourite.observe(this) { dataMember ->
            memberAdapter.setData(dataMember)
        }

        with(binding.rv) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = memberAdapter
        }
    }
}