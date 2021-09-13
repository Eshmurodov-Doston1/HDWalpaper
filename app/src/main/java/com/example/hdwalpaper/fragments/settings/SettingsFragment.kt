package com.example.hdwalpaper.fragments.settings

import android.app.AlertDialog
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import com.example.hdwalpaper.adapters.color.RvColor
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import java.util.*
import kotlin.collections.ArrayList
import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color.*
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.FragmentContainer
import com.example.hdwalpaper.MainActivity
import com.example.hdwalpaper.R
import com.example.hdwalpaper.databinding.DialogInfoBinding
import com.example.hdwalpaper.databinding.DialogThemeBinding
import com.example.hdwalpaper.databinding.FragmentSettingsBinding
import com.example.hdwalpaper.databinding.LanguageDialogBinding
import com.example.hdwalpaper.utils.LocaleHelper


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SettingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingsFragment : Fragment(R.layout.fragment_settings) {
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

    private val binding by viewBinding(FragmentSettingsBinding::bind)
    lateinit var sharedPreferences: SharedPreferences
    lateinit var rvColor:RvColor
    lateinit var listColor:ArrayList<String>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            sharedPreferences = requireActivity().getSharedPreferences("Theme",0)
            loadColor()
            val onAttach = LocaleHelper.onAttach(requireContext())
            nameFragment.text = onAttach.getText(R.string.sozlamalar)
            text.text = onAttach.getText(R.string.temalar)
            share2.text = onAttach.getText(R.string.ulashish)
            infoApp2.text = onAttach.getText(R.string.dastur_haqida)
            tongue1.text = onAttach.getText(R.string.dastur_tili)
            when(LocaleHelper.getLanguage(requireContext()).lowercase(Locale.getDefault())){
                "uz".lowercase(Locale.getDefault())->{
                    tongue2.text = onAttach.getString(R.string.o_zbek_tili)
                }
                "ru".lowercase(Locale.getDefault())->{
                    tongue2.text = onAttach.getString(R.string.ru)
                }
                "en".lowercase(Locale.getDefault())->{
                    tongue2.text = onAttach.getString(R.string.english)
                }
            }
            tema.setOnClickListener {
                var alertDialog = AlertDialog.Builder(requireContext(),R.style.BottomSheetDialogThem)
                val create = alertDialog.create()
                var dialogThemeBinding = DialogThemeBinding.inflate(LayoutInflater.from(requireContext()),null,false)
                create.setView(dialogThemeBinding.root)
                dialogThemeBinding.apply {
                    themes.text = onAttach.getText(R.string.temalar)
                    clouse.text = onAttach.getText(R.string.orqaga)

                    rvColor = RvColor(object:RvColor.OnItemClickListener{
                        override fun onItemClick(color: String, position: Int) {
                            val string = sharedPreferences.getString("color", "")
                                val edit = sharedPreferences.edit()
                                edit.putString("color", color)
                                edit.apply()
                                create.dismiss()
                            (activity as AppCompatActivity).recreate()
                        }
                    },listColor)
                    rvTheme.adapter = rvColor
                    clouse.setOnClickListener {
                        create.dismiss()
                    }
                }
                create.show()
            }
            lan.setOnClickListener {
                var alertDialog = AlertDialog.Builder(requireContext(),R.style.BottomSheetDialogThem)
                val create = alertDialog.create()
                var languageDialogBinding = LanguageDialogBinding.inflate(LayoutInflater.from(requireContext()),null,false)
                create.setView(languageDialogBinding.root)
                languageDialogBinding.apply {
                    info.text = onAttach.getText(R.string.tilni_tanlang)
                    uz.text = onAttach.getText(R.string.o_zbek_tili)
                    en.text = onAttach.getText(R.string.english)
                    ru.text = onAttach.getText(R.string.ru)



                   val language = LocaleHelper.getLanguage(requireContext())
                    if (language!=null){
                        when(language.lowercase(Locale.getDefault())){
                            "uz".lowercase(Locale.getDefault())->{
                                uz.isChecked=true
                            }
                            "ru".lowercase(Locale.getDefault())->{
                                ru.isChecked=true
                            }
                            "en".lowercase(Locale.getDefault())->{
                                en.isChecked=true
                            }
                        }
                    }
                 ok.setOnClickListener {
                     when(grup.checkedRadioButtonId){
                         R.id.uz->{
                             val language1 = LocaleHelper.getLanguage(requireContext())
                             if (language1.lowercase(Locale.getDefault())!="uz".lowercase(Locale.getDefault())){
                                 LocaleHelper.setLocale(requireContext(),"uz")
                                 (activity as AppCompatActivity).recreate()
                                 create.dismiss()
                             }else{
                                 create.dismiss()
                             }
                         }
                         R.id.ru->{
                             val language1 = LocaleHelper.getLanguage(requireContext())
                             if (language1.lowercase(Locale.getDefault())!="ru".lowercase(Locale.getDefault())){
                                 LocaleHelper.setLocale(requireContext(),"ru")
                                 (activity as AppCompatActivity).recreate()
                                 create.dismiss()
                             }else{
                                 create.dismiss()
                             }

                         }
                         R.id.en->{
                             val language1 = LocaleHelper.getLanguage(requireContext())
                             if (language1.lowercase(Locale.getDefault())!="en".lowercase(Locale.getDefault())){
                                 LocaleHelper.setLocale(requireContext(),"en")
                                 (activity as AppCompatActivity).recreate()
                                 create.dismiss()
                             }else{
                                 create.dismiss()
                             }
                         }
                     }

                 }
                }
                create.show()
            }
            share.setOnClickListener {
                var shareIntent = Intent().apply {
                    this.action = Intent.ACTION_SEND
                    this.putExtra(Intent.EXTRA_TEXT,"No App PlayMarket")
                    this.type="text/plain"
                }
                startActivity(shareIntent)
            }
            infoApp.setOnClickListener {
                var alertDialog = AlertDialog.Builder(requireContext(),R.style.BottomSheetDialogThem)
                val create = alertDialog.create()

                var dialogInfoBinding = DialogInfoBinding.inflate(LayoutInflater.from(root.context),null,false)
                create.setView(dialogInfoBinding.root)
                val string = sharedPreferences.getString("color", "#E8E3E3")
                if (string=="#E8E3E3"){
                    dialogInfoBinding.linear.setBackgroundColor(parseColor("#706E6E"))
                }else{
                    dialogInfoBinding.linear.setBackgroundColor(WHITE)
                }
                dialogInfoBinding.apply {
                    val onAttach1 = LocaleHelper.onAttach(requireContext())
                   infoO.text = onAttach1.getText(R.string.dastur_haqida)
                   info.text = onAttach1.getText(R.string.info)
                }
                create.show()
            }
        }
    }

    private fun loadColor() {
        listColor = ArrayList()
        listColor.add("#154C79")
        listColor.add("#4C5BAF")
        listColor.add("#F85B915E")
        listColor.add("#E8E3E3")
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SettingsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SettingsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}