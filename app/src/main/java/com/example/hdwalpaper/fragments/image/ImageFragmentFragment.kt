package com.example.hdwalpaper.fragments.image

import android.annotation.SuppressLint
import android.app.WallpaperManager
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.hdwalpaper.R
import com.example.hdwalpaper.database.AppDatabase
import com.example.hdwalpaper.database.ImageEntity
import com.example.hdwalpaper.databinding.FragmentImageFragmentBinding
import com.example.hdwalpaper.models.Result
import com.example.hdwalpaper.utils.LocaleHelper
import com.google.android.material.snackbar.Snackbar
import com.kaopiz.kprogresshud.KProgressHUD
import com.squareup.picasso.Picasso
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import org.jetbrains.annotations.Nullable
import java.io.IOException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ImageFragmentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ImageFragmentFragment : Fragment(R.layout.fragment_image_fragment) {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    private val binding by viewBinding(FragmentImageFragmentBinding::bind)
    lateinit var wallpaperManager: WallpaperManager
    lateinit var appDatabase: AppDatabase
    lateinit var handler:Handler

    lateinit var result:Result
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            appDatabase = AppDatabase.getInstence(requireContext())
            val url = arguments?.getString("image")
            val position = arguments?.getInt("position")
            if (position==-1){
               var  imageEntity = arguments?.getSerializable("imageEntity") as ImageEntity
                Picasso.get().load(imageEntity.image).into(image)
                val image2 = appDatabase.imageDao().getImage(imageEntity.name.toString())
                if(image2.image1==R.drawable.ic_love2){
                    save.setImageResource(image2.image1!!)
                }
                blur3.setOnClickListener {
                    if (image2!=null){
                        if (image2.image1==R.drawable.ic_love2){
                            save.setImageResource(R.drawable.ic_love)
                            image2.image1 = R.drawable.ic_love
                            appDatabase.imageDao().updateImage(image2)
                        }else{
                            save.setImageResource(R.drawable.ic_love2)
                            image2.image1=R.drawable.ic_love2
                            appDatabase.imageDao().updateImage(image2)
                        }
                    }else{
                        save.setImageResource(R.drawable.ic_love2)
                        var imageEntity1 = ImageEntity(imageEntity.name,url,true,R.drawable.ic_love2)
                        appDatabase.imageDao().insertImage(imageEntity1)
                    }
                }
            }else {
                 result = arguments?.getSerializable("result") as Result
                val image3 = appDatabase.imageDao().getImage(result.user.username)

                if (image3!=null){
                    image3.image1?.let { save.setImageResource(it) }
                }

                blur3.setOnClickListener {
                    val image2 = appDatabase.imageDao().getImage(result.user.username)
                    if (image2!=null){
                        if (image2.image1==R.drawable.ic_love2){
                            save.setImageResource(R.drawable.ic_love)
                            image2.image1 = R.drawable.ic_love
                            appDatabase.imageDao().updateImage(image2)
                        }else{
                            save.setImageResource(R.drawable.ic_love2)
                            image2.image1=R.drawable.ic_love2
                            appDatabase.imageDao().updateImage(image2)
                        }
                    }else{
                        save.setImageResource(R.drawable.ic_love2)
                        var imageEntity = ImageEntity(result.user.username,url,true,R.drawable.ic_love2)
                        appDatabase.imageDao().insertImage(imageEntity)
                    }
                }

                Picasso.get().load(url).into(image)
            }
            clouce.setOnClickListener {
                findNavController().popBackStack()
            }
            handler = Handler(Looper.getMainLooper())
            blur1.setOnClickListener {
                val drawable = binding.image.drawable as BitmapDrawable
                val bitmap = drawable.bitmap
                val wallManager = WallpaperManager.getInstance(requireContext())
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        wallManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_LOCK)
                    }
                    Snackbar.make(
                        requireView(),
                        "Wallpaper was successfully installed on the lock screen !",
                        Snackbar.LENGTH_LONG
                    )
                        .setAction("Action", null).show()
                } catch (e: Exception) {
                    Snackbar.make(requireView(), "Setting WallPaper Failed !", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
                }
            }
            blur1.setOnClickListener {
                wallpaperManager = WallpaperManager.getInstance(requireContext())
                val show = KProgressHUD.create(requireContext())
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setLabel(LocaleHelper.onAttach(requireContext()).getString(R.string.a))
                    .setCancellable(true)
                    .setAnimationSpeed(2)
                    .setDimAmount(0.5f)
                    .show()


                handler.postDelayed({
                    show.dismiss()
                },2000)




                Glide.with(requireContext()).asBitmap().load(url)
                    .listener(object : RequestListener<Bitmap?> {
                        override fun onLoadFailed(@Nullable e: GlideException?, o: Any?, target: com.bumptech.glide.request.target.Target<Bitmap?>?, b: Boolean): Boolean {
                            Toast.makeText(requireContext(), "Fail to load image..", Toast.LENGTH_SHORT).show()
                            return false
                        }


                        override fun onResourceReady(bitmap: Bitmap?, o: Any?, target: Target<Bitmap?>?, dataSource: DataSource?, b: Boolean): Boolean {
                            // on below line we are setting wallpaper using
                            // wallpaper manager on below line.
                            try {
                                wallpaperManager.setBitmap(bitmap)
                                Toast.makeText(requireContext(), "Wallpaper Set to Home screen.", Toast.LENGTH_SHORT).show()
                            } catch (e: IOException) {
                                // on below line we are handling exception.
                                Toast.makeText(requireContext(), "Fail to set wallpaper", Toast.LENGTH_SHORT).show()
                                e.printStackTrace()
                            }
                            return false
                        }
                    }
                    ).submit()
            }

            share.setOnClickListener {
                var shareIntent = Intent().apply {
                    this.action = Intent.ACTION_SEND
                    this.putExtra(Intent.EXTRA_TEXT,url )
                    this.type="text/plain"
                }
                startActivity(shareIntent)
            }
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ImageFragmentFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ImageFragmentFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}