package com.example.hdwalpaper.fragments.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.hdwalpaper.R
import com.example.hdwalpaper.adapters.favoritesAdapter.FavoritesAdapter
import com.example.hdwalpaper.database.AppDatabase
import com.example.hdwalpaper.database.ImageEntity
import com.example.hdwalpaper.databinding.FragmentFavoritesBinding
import com.example.hdwalpaper.utils.LocaleHelper
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FavoritesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavoritesFragment : Fragment(R.layout.fragment_favorites) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
   private  val binding by viewBinding(FragmentFavoritesBinding::bind)
    lateinit var favoritesAdapter:FavoritesAdapter
    lateinit var appDatabase: AppDatabase
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            appDatabase = AppDatabase.getInstence(requireContext())
            nameFragment.text = LocaleHelper.onAttach(requireContext()).getText(R.string.yoqtirganlar_mavjud_emas)
            favoritesAdapter = FavoritesAdapter(object:FavoritesAdapter.OnItemClickListener{
                override fun onItemClick(imageEntity: ImageEntity, position: Int, image: ImageView) {
                    imageEntity.image1 = R.drawable.ic_love
                    appDatabase.imageDao().updateImage(imageEntity)
                }

                override fun onItemClickP(imageEntity: ImageEntity, position: Int) {
                    var bundle = Bundle()
                    bundle.putInt("position",-1)
                    bundle.putSerializable("imageEntity",imageEntity)
                    findNavController().navigate(R.id.imageFragmentFragment,bundle)
                }
            })
            appDatabase.imageDao().getAllImage(R.drawable.ic_love2).observe(viewLifecycleOwner, Observer {
                favoritesAdapter.submitList(it)
                if(it.isNotEmpty()) {
                    nameFragment.visibility = View.INVISIBLE
                }else{
                    nameFragment.visibility = View.VISIBLE
                }
            })
            rvImage.adapter = favoritesAdapter
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FavoritesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FavoritesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}