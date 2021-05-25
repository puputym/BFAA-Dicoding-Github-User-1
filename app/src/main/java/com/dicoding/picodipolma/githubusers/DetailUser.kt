package com.dicoding.picodipolma.githubusers

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.picodipolma.githubusers.databinding.ActivityDetailUserBinding

class DetailUser : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }
    private lateinit var binding: ActivityDetailUserBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val data = intent.getParcelableExtra<GithubModel>(EXTRA_DATA) as GithubModel

        binding.tvNameDetail.text = data.name
        binding.tvUsernameDetail.text = data.username
        binding.tvCompany.text = data.company
        binding.tvLocation.text = data.location
        binding.tvRepository.text = data.repository
        binding.tvFollowers.text =  data.followers
        binding.tvFollowings.text = data.followings

        binding.tvNameDetail.setOnClickListener(this)
        Glide.with(this)
            .load(data.avatar)
            .apply(RequestOptions().override(200, 200))
            .into(binding.imgUserDetail)
    }


    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.tv_name_detail ->{
                val moveIntent = Intent(this@DetailUser, MainActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }


}