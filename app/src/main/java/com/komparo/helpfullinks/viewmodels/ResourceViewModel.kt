package com.komparo.helpfullinks.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.komparo.helpfullinks.data.AppDatabase
import com.komparo.helpfullinks.data.model.One
import com.komparo.helpfullinks.domain.models.OneD
import com.komparo.helpfullinks.domain.usecase.OneDeleteAllUseCase
import com.komparo.helpfullinks.domain.usecase.OneGetTitleUseCase
import com.komparo.helpfullinks.domain.usecase.OneInsertUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
//class ResourceViewModel @Inject constructor(
//     var oneDeleteAllUseCase : OneDeleteAllUseCase,
//     var oneInsertUseCase : OneInsertUseCase,
//     var oneGetTitleUseCase : OneGetTitleUseCase
//) : ViewModel() {
//
//
//     fun insert(oneD : OneD){
//         viewModelScope.launch(Dispatchers.Main) {
//            oneInsertUseCase.execute(oneD)
//         }
//     }
//
//    fun deleteAll(){
//        viewModelScope.launch(Dispatchers.Main) {
//            oneDeleteAllUseCase.execute()
//        }
//    }
//    fun getTitle(id : Int){
//        viewModelScope.launch(Dispatchers.Main) {
//            oneGetTitleUseCase.execute(id)
//        }
//    }
//}