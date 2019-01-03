package com.felipe.spotifyconsult.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.felipe.spotifyconsult.R
import com.felipe.spotifyconsult.api.EResponseStatus
import com.felipe.spotifyconsult.api.endpoints.ProfileApi
import com.felipe.spotifyconsult.listeners.ProfileListener
import com.felipe.spotifyconsult.model.Profile
import com.felipe.spotifyconsult.preferences.PreferencesUtil
import com.felipe.spotifyconsult.spotify.config.ConfigurateCredentials
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(), ProfileListener {

    private lateinit var smallImageView: ImageView
    private lateinit var largeImageView: ImageView

    private val DEFAULT_IMAGE =
        "https://img.washingtonpost.com/wp-apps/imrs.php?src=https://img.washingtonpost.com/news/comic-riffs/wp-content/uploads/sites/15/2017/07/RICKMORTY-rickshank-art.jpg&w=480"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_profile, container, false)

        setupView(view)

        return view
    }

    override fun onCurrentProfileLoaded(profile: Profile, code: EResponseStatus) {
        setInfo(profile, code)
    }

    override fun onCurrentProfileFailed() {
        setEmptyInfo()
    }

    override fun onProfileLoadedById(profile: Profile, code: EResponseStatus) {
        setInfo(profile, code)
    }

    override fun onProfileFailedById() {
        setEmptyInfo()
    }

    private fun setupView(view: View) {

        largeImageView = view.findViewById(R.id.ivProfilePictureLarge) as ImageView
        smallImageView = view.findViewById(R.id.ivProfilePictureSmall) as ImageView

        ConfigurateCredentials.verifyCredentials(activity!!)
        ProfileApi.instance.getCurrentProfile(this, getToken())
    }

    private fun getToken(): String {
        return PreferencesUtil.getInstance(context!!).token!!
    }

    private fun setImage(url: String = DEFAULT_IMAGE) {
        Glide.with(this).load(url).into(largeImageView)
        Glide.with(this).load(url).into(smallImageView)
    }

    private fun setEmptyInfo() {
        tv_profile_name.text = "-"
        tv_profile_birthdate.text = "-"
        tv_profile_country.text = "-"
        tv_profile_email.text = "-"
        tv_profile_followers.text = "-"
        tv_profile_product.text = "-"

        setImage()
    }

    private fun setInfo(profile: Profile, code: EResponseStatus) {
        tv_profile_name.text = profile.displayName
        tv_profile_birthdate.text = profile.birthdate
        tv_profile_country.text = profile.country
        tv_profile_email.text = profile.email
        tv_profile_followers.text = profile.followers!!.total.toString()
        tv_profile_product.text = profile.product

        if (profile.images.isNullOrEmpty()) {
            setImage()
        } else {
            setImage(profile.images!![0].url)
        }
    }
}
