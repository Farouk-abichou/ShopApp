package com.example.shopapp.screens.cart

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapp.data.DataOrException
import com.example.shopapp.model.ProductItem
import com.example.shopapp.model.Rating
import com.example.shopapp.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CartViewModel @Inject constructor(private val repository: ProductRepository, savedStateHandle: SavedStateHandle):ViewModel() {






}