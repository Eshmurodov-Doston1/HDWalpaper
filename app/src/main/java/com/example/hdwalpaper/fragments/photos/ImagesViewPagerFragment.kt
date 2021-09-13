package com.example.hdwalpaper.fragments.photos

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.FragmentContainer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.hdwalpaper.R
import com.example.hdwalpaper.adapters.rvAdapter.*
import com.example.hdwalpaper.databinding.FragmentImagesViewPagerBinding
import com.example.hdwalpaper.models.Result
import com.example.hdwalpaper.retrofit.ApiClient
import com.example.hdwalpaper.utils.LocaleHelper
import com.example.hdwalpaper.viewmodel.*
import com.kaopiz.kprogresshud.KProgressHUD
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ImagesViewPagerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ImagesViewPagerFragment : Fragment(R.layout.fragment_images_view_pager) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getInt(ARG_PARAM2)
        }
    }

    private val binding by viewBinding(FragmentImagesViewPagerBinding::bind)

    lateinit var appViewModel:AppViewModel
    lateinit var appViewModel1: AppViewModel1
    lateinit var appViewModel2: AppViewModel2
    lateinit var appViewModel3: AppViewModel3
    lateinit var appViewModel4: AppViewModel4
    lateinit var appViewModel5: AppViewModel5
    lateinit var appViewModel6: AppViewModel6
    lateinit var appViewModel7: AppViewModel7
    lateinit var appViewModel8: AppViewModel8
    lateinit var appViewModel9: AppViewModel9
    lateinit var appViewModel10: AppViewModel10


    lateinit var adapterImage:AdapterImage
    lateinit var adapterImage1:AdapterImage1
    lateinit var adapterImage2: AdapterImage2
    lateinit var adapterImage3: AdapterImage3
    lateinit var adapterImage4: AdapterImage4
    lateinit var adapterImage5: AdapterImage5
    lateinit var adapterImage6: AdapterImage6
    lateinit var adapterImage7: AdapterImage7
    lateinit var adapterImage8: AdapterImage8
    lateinit var adapterImage9: AdapterImage9
    lateinit var adapterImage10: AdapterImage10
    lateinit var adapterImageRv: AdapterImageRv


    lateinit var handler: Handler
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handler = Handler(Looper.getMainLooper())
        binding.apply {
            val onAttach = LocaleHelper.onAttach(requireContext())
            nested.visibility = View.GONE
            when(param2){
                0->{
                    nested.visibility = View.VISIBLE
                    val show = KProgressHUD.create(requireContext())
                        .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                        .setLabel(onAttach.getString(R.string.a))
                        .setCancellable(true)
                        .setAnimationSpeed(2)
                        .setDimAmount(0.5f)
                        .show()
                    handler.postDelayed({
                        show.dismiss()
                    },3000)

                    appViewModel = ViewModelProviders.of(
                        this@ImagesViewPagerFragment,
                        ViewModelFactory("News", ApiClient.apiService)
                    )[AppViewModel::class.java]

                    adapterImage = AdapterImage(object: AdapterImage.OnItemClickListener{
                        override fun onItemClick(result: Result, position: Int) {
                            var bundle = Bundle()
                            bundle.putSerializable("result",result)
                            bundle.putInt("position",position)
                            bundle.putString("image",result.urls.regular)
                            findNavController().navigate(R.id.imageFragmentFragment,bundle)
                        }

                        override fun leekClick(result: Result, position: Int) {

                        }
                    })
                    adapterImage1 = AdapterImage1(object: AdapterImage1.OnItemClickListener{
                        override fun onItemClick(result: Result, position: Int) {
                            var bundle = Bundle()
                            bundle.putSerializable("result",result)
                            bundle.putInt("position",position)
                            bundle.putString("image",result.urls.regular)
                            findNavController().navigate(R.id.imageFragmentFragment,bundle)
                        }

                        override fun leekClick(result: Result, position: Int) {

                        }
                    })
                    adapterImage2 = AdapterImage2(object: AdapterImage2.OnItemClickListener{
                        override fun onItemClick(result: Result, position: Int) {
                            var bundle = Bundle()
                            bundle.putSerializable("result",result)
                            bundle.putInt("position",position)
                            bundle.putString("image",result.urls.regular)
                            findNavController().navigate(R.id.imageFragmentFragment,bundle)
                        }

                        override fun leekClick(result: Result, position: Int) {

                        }
                    })
                    adapterImage3 = AdapterImage3(object: AdapterImage3.OnItemClickListener{
                        override fun onItemClick(result: Result, position: Int) {
                            var bundle = Bundle()
                            bundle.putSerializable("result",result)
                            bundle.putInt("position",position)
                            bundle.putString("image",result.urls.regular)
                            findNavController().navigate(R.id.imageFragmentFragment,bundle)
                        }

                        override fun leekClick(result: Result, position: Int) {

                        }
                    })
                    adapterImage4 = AdapterImage4(object: AdapterImage4.OnItemClickListener{
                        override fun onItemClick(result: Result, position: Int) {
                            var bundle = Bundle()
                            bundle.putSerializable("result",result)
                            bundle.putInt("position",position)
                            bundle.putString("image",result.urls.regular)
                            findNavController().navigate(R.id.imageFragmentFragment,bundle)
                        }

                        override fun leekClick(result: Result, position: Int) {

                        }
                    })
                    adapterImage5 = AdapterImage5(object: AdapterImage5.OnItemClickListener{
                        override fun onItemClick(result: Result, position: Int) {
                            var bundle = Bundle()
                            bundle.putInt("position",position)
                            bundle.putSerializable("result",result)
                            bundle.putString("image",result.urls.regular)
                            findNavController().navigate(R.id.imageFragmentFragment,bundle)
                        }

                        override fun leekClick(result: Result, position: Int) {

                        }
                    })
                    adapterImage6 = AdapterImage6(object: AdapterImage6.OnItemClickListener{
                        override fun onItemClick(result: Result, position: Int) {
                            var bundle = Bundle()
                            bundle.putSerializable("result",result)
                            bundle.putInt("position",position)
                            bundle.putString("image",result.urls.regular)
                            findNavController().navigate(R.id.imageFragmentFragment,bundle)
                        }

                        override fun leekClick(result: Result, position: Int) {

                        }
                    })
                    adapterImage7 = AdapterImage7(object: AdapterImage7.OnItemClickListener{
                        override fun onItemClick(result: Result, position: Int) {
                            var bundle = Bundle()
                            bundle.putInt("position",position)
                            bundle.putSerializable("result",result)
                            bundle.putString("image",result.urls.regular)
                            findNavController().navigate(R.id.imageFragmentFragment,bundle)
                        }

                        override fun leekClick(result: Result, position: Int) {

                        }
                    })
                    adapterImage8 = AdapterImage8(object: AdapterImage8.OnItemClickListener{
                        override fun onItemClick(result: Result, position: Int) {
                            var bundle = Bundle()
                            bundle.putInt("position",position)
                            bundle.putSerializable("result",result)
                            bundle.putString("image",result.urls.regular)
                            findNavController().navigate(R.id.imageFragmentFragment,bundle)
                        }

                        override fun leekClick(result: Result, position: Int) {

                        }
                    })
                    adapterImage9 = AdapterImage9(object: AdapterImage9.OnItemClickListener{
                        override fun onItemClick(result: Result, position: Int) {
                            var bundle = Bundle()
                            bundle.putSerializable("result",result)
                            bundle.putInt("position",position)
                            bundle.putString("image",result.urls.regular)
                            findNavController().navigate(R.id.imageFragmentFragment,bundle)
                        }

                        override fun leekClick(result: Result, position: Int) {

                        }
                    })
                    adapterImage10 = AdapterImage10(object: AdapterImage10.OnItemClickListener{
                        override fun onItemClick(result: Result, position: Int) {
                            var bundle = Bundle()
                            bundle.putSerializable("result",result)
                            bundle.putInt("position",position)
                            bundle.putString("image",result.urls.regular)
                            findNavController().navigate(R.id.imageFragmentFragment,bundle)
                        }

                        override fun leekClick(result: Result, position: Int) {

                        }
                    })
                    tv1.text=onAttach.getText(R.string.news)
                    tv2.text=onAttach.getText(R.string.car)
                    tv3.text=onAttach.getText(R.string.man)
                    tv4.text=onAttach.getText(R.string.basketball)
                    tv5.text=onAttach.getText(R.string.ocean)
                    tv6.text=onAttach.getText(R.string.animals)
                    tv7.text=onAttach.getText(R.string.women)
                    tv8.text=onAttach.getText(R.string.love)
                    tv9.text=onAttach.getText(R.string.galaxy)
                    tv10.text=onAttach.getText(R.string.macro)
                    tv11.text=onAttach.getText(R.string.aircraft)
                    appViewModel1 = ViewModelProviders.of(
                        this@ImagesViewPagerFragment,
                        ViewModelFactory("Car", ApiClient.apiService)
                    )[AppViewModel1::class.java]

                    appViewModel2 = ViewModelProviders.of(
                        this@ImagesViewPagerFragment,
                        ViewModelFactory("Man", ApiClient.apiService)
                    )[AppViewModel2::class.java]

                    appViewModel3 = ViewModelProviders.of(
                        this@ImagesViewPagerFragment,
                        ViewModelFactory("basketball", ApiClient.apiService)
                    )[AppViewModel3::class.java]

                    appViewModel4 = ViewModelProviders.of(
                        this@ImagesViewPagerFragment,
                        ViewModelFactory("Ocean", ApiClient.apiService)
                    )[AppViewModel4::class.java]

                    appViewModel5 = ViewModelProviders.of(
                        this@ImagesViewPagerFragment,
                        ViewModelFactory("animals", ApiClient.apiService)
                    )[AppViewModel5::class.java]

                    appViewModel6 = ViewModelProviders.of(
                        this@ImagesViewPagerFragment,
                        ViewModelFactory("women", ApiClient.apiService)
                    )[AppViewModel6::class.java]

                    appViewModel7 = ViewModelProviders.of(
                        this@ImagesViewPagerFragment,
                        ViewModelFactory("love", ApiClient.apiService)
                    )[AppViewModel7::class.java]

                    appViewModel8 = ViewModelProviders.of(
                        this@ImagesViewPagerFragment,
                        ViewModelFactory("Galaxy", ApiClient.apiService)
                    )[AppViewModel8::class.java]

                    appViewModel9 = ViewModelProviders.of(
                        this@ImagesViewPagerFragment,
                        ViewModelFactory("Macro", ApiClient.apiService)
                    )[AppViewModel9::class.java]

                    appViewModel10 = ViewModelProviders.of(
                        this@ImagesViewPagerFragment,
                        ViewModelFactory("Aircraft", ApiClient.apiService)
                    )[AppViewModel10::class.java]
                    lifecycleScope.launch {
                        appViewModel1.unsplashImage.collect {
                            adapterImage1.submitData(it)
                        }
                    }
                    lifecycleScope.launch {
                        appViewModel.unsplashImage.collect {
                            adapterImage.submitData(it)
                        }
                    }
                    lifecycleScope.launch {
                        appViewModel2.unsplashImage.collect {
                            adapterImage2.submitData(it)
                        }
                    }
                    lifecycleScope.launch {
                        appViewModel3.unsplashImage.collect {
                            adapterImage3.submitData(it)
                        }
                    }
                    lifecycleScope.launch {
                        appViewModel4.unsplashImage.collect {
                            adapterImage4.submitData(it)
                        }
                    }
                    lifecycleScope.launch {
                        appViewModel5.unsplashImage.collect {
                            adapterImage5.submitData(it)
                        }
                    }
                    lifecycleScope.launch {
                        appViewModel6.unsplashImage.collect {
                            adapterImage6.submitData(it)
                        }
                    }
                    lifecycleScope.launch {
                        appViewModel7.unsplashImage.collect {
                            adapterImage7.submitData(it)
                        }
                    }
                    lifecycleScope.launch {
                        appViewModel8.unsplashImage.collect {
                            adapterImage8.submitData(it)
                        }
                    }
                    lifecycleScope.launch {
                        appViewModel9.unsplashImage.collect {
                            adapterImage9.submitData(it)
                        }
                    }
                    lifecycleScope.launch {
                        appViewModel10.unsplashImage.collect {
                            adapterImage10.submitData(it)
                        }
                    }
                    rvMy.adapter = adapterImage
                    rvMy1.adapter = adapterImage1
                    rvMy2.adapter = adapterImage2
                    rvMy3.adapter = adapterImage3
                    rvMy4.adapter = adapterImage4
                    rvMy5.adapter = adapterImage5
                    rvMy6.adapter = adapterImage6
                    rvMy7.adapter = adapterImage7
                    rvMy8.adapter = adapterImage8
                    rvMy9.adapter = adapterImage9
                    rvMy10.adapter = adapterImage10
                }
            }

            if (param2!=0){
                adapterImageRv = AdapterImageRv(object:AdapterImageRv.OnItemClickListener{
                    override fun onItemClick(result: Result, position: Int) {
                        var bundle = Bundle()
                        bundle.putInt("position",position)
                        bundle.putSerializable("result",result)
                        bundle.putString("image",result.urls.regular)
                        findNavController().navigate(R.id.imageFragmentFragment,bundle)
                    }

                    override fun leekClick(result: Result, position: Int) {

                    }

                })
                appViewModel = ViewModelProviders.of(
                    this@ImagesViewPagerFragment,
                    ViewModelFactory(param1.toString(), ApiClient.apiService)
                )[AppViewModel::class.java]
                lifecycleScope.launch {
                    appViewModel.unsplashImage.collect {
                        adapterImageRv.submitData(it)
                    }
                }
                rv.adapter = adapterImageRv
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
         * @return A new instance of fragment ImagesViewPagerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: Int) =
            ImagesViewPagerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putInt(ARG_PARAM2, param2)
                }
            }
    }
}