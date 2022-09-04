package com.example.animelover.core.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animelover.R
import com.example.animelover.core.ui.ViewModelFactory
import com.example.animelover.core.ui.detail.MemberDetailActivity
import com.example.animelover.core.ui.detail.MemberDetailActivity.Companion.EXTRA_DATA
import com.example.animelover.core.ui.favourite.MemberFavouriteActivity
import com.example.animelover.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var memberViewModel: MemberViewModel
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

        val factory = ViewModelFactory.getInstance(this)
        memberViewModel = ViewModelProvider(this, factory)[MemberViewModel::class.java]
        memberViewModel.member.observe(this){
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
        inflater.inflate(R.menu.item_menu,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.fav-> {
                val intent = Intent(this@MainActivity, MemberFavouriteActivity::class.java)
                startActivity(intent)
            }
            R.id.refresh ->{
                finish()
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}