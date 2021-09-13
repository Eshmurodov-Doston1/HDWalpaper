package com.example.hdwalpaper.fragments.photos

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import com.example.hdwalpaper.R
import com.example.hdwalpaper.adapters.images.AdapterImages
import com.example.hdwalpaper.adapters.rvAdapter.AdapterImage
import com.example.hdwalpaper.databinding.FragmentImagesBinding
import com.example.hdwalpaper.models.Result
import com.example.hdwalpaper.utils.LocaleHelper
import com.google.android.material.tabs.TabLayoutMediator
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import java.util.*
import kotlin.collections.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ImagesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ImagesFragment : Fragment() {
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

    lateinit var fragmentImagesBinding: FragmentImagesBinding
    lateinit var root:View
    lateinit var adapterImages: AdapterImages

    lateinit var listCategory:ArrayList<String>
    lateinit var listCategory1:ArrayList<String>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentImagesBinding = FragmentImagesBinding.inflate(inflater,container,false)
        root = fragmentImagesBinding.root
        loadCategory()
        fragmentImagesBinding.apply {
            adapterImages = AdapterImages(listCategory1,requireActivity())
            viewpager2.adapter = adapterImages
            TabLayoutMediator(tabLayout,viewpager2){tab,position->
                tab.text = listCategory[position]
            }.attach()
            viewpager2.isUserInputEnabled=false
        }
        return root
    }

    private fun loadCategory() {
        val language = LocaleHelper.getLanguage(requireContext())
        listCategory = ArrayList()
        listCategory1 = ArrayList()
        when(language.lowercase(Locale.getDefault())){
            "uz".lowercase(Locale.getDefault())->{
                listCategory.add("Hammasi")
                listCategory.add("Arxitektura")
                listCategory.add("Avenyu")
                listCategory.add("Tahririyat tanlovi")
                listCategory.add("Qushlarning ko'rinishi")
                listCategory.add("Tabiat")
                listCategory.add("Bokeh")
                listCategory.add("Chiroqlar")
                listCategory.add("Gullar")
                listCategory.add("Ko'zgu")
                listCategory.add("Suv kemalari")
                listCategory.add("Ayollar")
                listCategory.add("Tennis")
                listCategory.add("Siluet")
                listCategory.add("Mushakbozlar")
                listCategory.add("Yong'in")
                listCategory.add("Sol")
                listCategory.add("Samolyotlar")
                listCategory.add("Musiqa")
                listCategory.add("Ovqat")
                listCategory.add("Xulosa")
                listCategory.add("To'qimalar")
                listCategory.add("Futbol")
                listCategory.add("Dasturlash")
                listCategory.add("Kompyuter")
                listCategory.add("Hayvonlar")
            }
            "ru".lowercase(Locale.getDefault())->{
                listCategory.add("Все")
                listCategory.add("Архитектура")
                listCategory.add("Авеню")
                listCategory.add("Выбор редактора")
                listCategory.add("С высоты птичьего полета")
                listCategory.add("Природа")
                listCategory.add("Боке")
                listCategory.add("Огни")
                listCategory.add("Цветы")
                listCategory.add("Отражение")
                listCategory.add("Плавсредства")
                listCategory.add("Женщины")
                listCategory.add("Теннис")
                listCategory.add("Силуэт")
                listCategory.add("Салют")
                listCategory.add("Огонь")
                listCategory.add("Транспортные средства")
                listCategory.add("Самолет")
                listCategory.add("Музыка")
                listCategory.add("Еда")
                listCategory.add("Абстрактный")
                listCategory.add("Текстура")
                listCategory.add("Футбол")
                listCategory.add("Программирование")
                listCategory.add("Компьютер")
                listCategory.add("Животные")
            }
            "en".lowercase(Locale.getDefault())->{
                listCategory.add("All")
                listCategory.add("Architecture")
                listCategory.add("Avenue")
                listCategory.add("Editor's Choice")
                listCategory.add("Bird's eye view")
                listCategory.add("Nature")
                listCategory.add("Bokeh")
                listCategory.add("Lights")
                listCategory.add("Flowers")
                listCategory.add("Reflection")
                listCategory.add("Watercrafts")
                listCategory.add("Women")
                listCategory.add("Tennis")
                listCategory.add("Silhouette")
                listCategory.add("Firework")
                listCategory.add("Fire")
                listCategory.add("Vehicles")
                listCategory.add("Aircraft")
                listCategory.add("Music")
                listCategory.add("Food")
                listCategory.add("Abstract")
                listCategory.add("Texture")
                listCategory.add("Football")
                listCategory.add("Programming")
                listCategory.add("Computer")
                listCategory.add("Animals")
            }
        }
        listCategory1.add("All")
        listCategory1.add("Architecture")
        listCategory1.add("Avenue")
        listCategory1.add("Editor's Choice")
        listCategory1.add("Bird's eye view")
        listCategory1.add("Nature")
        listCategory1.add("Bokeh")
        listCategory1.add("Lights")
        listCategory1.add("Flowers")
        listCategory1.add("Reflection")
        listCategory1.add("Watercrafts")
        listCategory1.add("Women")
        listCategory1.add("Tennis")
        listCategory1.add("Silhouette")
        listCategory1.add("Firework")
        listCategory1.add("Fire")
        listCategory1.add("Vehicles")
        listCategory1.add("Aircraft")
        listCategory1.add("Music")
        listCategory1.add("Food")
        listCategory1.add("Abstract")
        listCategory1.add("Texture")
        listCategory1.add("Football")
        listCategory1.add("Programming")
        listCategory1.add("Computer")
        listCategory1.add("Animals")
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ImagesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ImagesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}