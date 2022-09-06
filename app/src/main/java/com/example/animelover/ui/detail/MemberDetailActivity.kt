package com.example.animelover.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.animelover.R
import com.example.animelover.core.domain.model.Member
import com.example.animelover.databinding.ActivityMemberDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MemberDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var memberDetailBinding: ActivityMemberDetailBinding
    private val memberDetailViewModel: MemberDetailViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        memberDetailBinding = ActivityMemberDetailBinding.inflate(layoutInflater)
        setContentView(memberDetailBinding.root)


        val detailMember= intent.getParcelableExtra<Member>(EXTRA_DATA)
        showDetailMember(detailMember)
    }

    private fun showDetailMember(detailMember: Member?) {
        detailMember?.let {
            supportActionBar?.title = detailMember.name
            memberDetailBinding.name.text = detailMember.name
            Glide.with(this)
                .load(detailMember.image)
                .into(memberDetailBinding.avatarHeader)

            var statusFavorite = detailMember.isFavourite
            setStatusFavorite(statusFavorite)
            memberDetailBinding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
               memberDetailViewModel.setFavouriteMember(detailMember, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            memberDetailBinding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24))
        } else {
            memberDetailBinding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24))
        }
    }
}