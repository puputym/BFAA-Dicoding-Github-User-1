package com.dicoding.picodipolma.githubusers

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(){
    private val listItemUser = ArrayList<GithubModel>()
    private lateinit var recycle_view: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getResourcesToList()

        recycle_view = findViewById(R.id.rv_user_github)
        recycle_view.setHasFixedSize(true)
        showRecycleList()

    }

    private fun showRecycleList() {
        recycle_view.layoutManager = LinearLayoutManager(this)
        val githubAdapter = GithubAdapter(getResourcesToList())
        recycle_view.adapter = githubAdapter
        githubAdapter.setOnItemClickCallback(object : GithubAdapter.OnItemClickCallback {
            override fun onItemClicked(data: GithubModel) {
                val intent = Intent(this@MainActivity, DetailUser::class.java)
                intent.putExtra(DetailUser.EXTRA_DATA, data)
                startActivity(intent)
            }
        })

//        githubAdapter.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                val search = findViewById<SearchView>(R.id.search)
//                search.clearFocus()
//            }
//        })
    }

    private fun getResourcesToList(): ArrayList<GithubModel> {
        val rscUsername : Array<String> = resources.getStringArray(R.array.username)
        val rscName : Array<String> = resources.getStringArray(R.array.name)
        val rscLocation : Array<String> = resources.getStringArray(R.array.location)
        val rscRepository : Array<String> = resources.getStringArray(R.array.repository)
        val rscCompany : Array<String> = resources.getStringArray(R.array.company)
        val rscFollowers : Array<String> = resources.getStringArray(R.array.followers)
        val rscFollowings : Array<String> = resources.getStringArray(R.array.following)
        val rscAvatar : TypedArray = resources.obtainTypedArray(R.array.avatar)

        for (i in rscName.indices){
            val listItem = GithubModel(
                rscUsername[i],
                rscName[i],
                rscLocation[i],
                rscRepository[i],
                rscCompany[i],
                rscFollowers[i],
                rscFollowings[i],
                rscAvatar.getResourceId(i, -1),
            )
            listItemUser.add(listItem)
        }
        return listItemUser
    }


}