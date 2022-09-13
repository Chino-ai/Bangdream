package com.example.animelover.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animelover.BuildConfig
import com.example.animelover.R
import com.example.animelover.core.ListMemberAdapter
import com.example.animelover.databinding.ActivityMainBinding
import com.example.animelover.ui.detail.MemberDetailActivity
import com.example.animelover.ui.detail.MemberDetailActivity.Companion.EXTRA_DATA
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private val memberViewModel: MemberViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val listMemberAdapter = ListMemberAdapter()
        listMemberAdapter.onItemClick = { selectedData ->
            val intent = Intent(this@MainActivity, MemberDetailActivity::class.java)
            intent.putExtra(EXTRA_DATA, selectedData)
            startActivity(intent)
        }



        memberViewModel.member.observe(this) {
            listMemberAdapter.setData(it.data)
        }


        with(mainBinding.rv) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = listMemberAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.item_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.fav -> {
                startActivity(
                    (intent.setClassName(
                        BuildConfig.APPLICATION_ID,
                        "com.example.animelover.favourite.FavouriteActivity"
                    ))
                )
            }
            R.id.refresh -> {
                finish()
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}