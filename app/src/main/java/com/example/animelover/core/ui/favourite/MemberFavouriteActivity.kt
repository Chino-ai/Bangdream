package com.example.animelover.core.ui.favourite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animelover.core.ui.detail.MemberDetailActivity
import com.example.animelover.core.ui.detail.MemberDetailActivity.Companion.EXTRA_DATA
import com.example.animelover.core.ui.home.ListMemberAdapter
import com.example.animelover.databinding.ActivityMemberFavouriteBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MemberFavouriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMemberFavouriteBinding
    private val memberFavouriteViewModel: MemberFavouriteViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemberFavouriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val memberAdapter = ListMemberAdapter()
        memberAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, MemberDetailActivity::class.java)
            intent.putExtra(EXTRA_DATA, selectedData)
            startActivity(intent)
        }


        memberFavouriteViewModel.getFavourite.observe(this, { dataMember ->
            memberAdapter.setData(dataMember)
        })

        with(binding.rv) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = memberAdapter
        }
    }
}