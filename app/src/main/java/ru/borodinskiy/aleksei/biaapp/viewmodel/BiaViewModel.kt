package ru.borodinskiy.aleksei.biaapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.borodinskiy.aleksei.biaapp.entity.Task
import ru.borodinskiy.aleksei.biaapp.repository.BiaRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class BiaViewModel @Inject constructor(
    private val repository: BiaRepositoryImpl
) : ViewModel() {

//    private val _allTask = MutableLiveData<List<Task>>().apply {
//        value = repository.allTask
//    }
//    val allTask: LiveData<List<Task>> = _allTask
    val allTask = repository.allTask

//    fun insertDb() = repository.insert(listTasks)

    suspend fun insertAll() = repository.insertAll(listTasks)

    init {
        viewModelScope.launch {
            insertAll()
        }
    }
//    suspend fun insert() = repository.insert(task)

}

//private val task = Task(
//    id = 1,
//    cargoType = "Мебель",
//    city = "Москва",
//    date = "15.09.2023",
//    time = "12:00",
//    startPoint = "Лесная, 25",
//    finishPoint = "Фестивальная, 47",
//    bodyType = "Тентованный",
//    detail = "Некие, очень важные детали заказа",
//    paymentParam = "Наличные",
//    telNumber = "322-223",
//    name = "Иван Федорович Крузенштерн"
//)

private val listTasks = listOf(

    Task(
        id = 1,
        cargoType = "Мебель",
        city = "Москва",
        date = "15.09.2023",
        time = "12:00",
        startPoint = "Лесная, 25",
        finishPoint = "Фестивальная, 47",
        bodyType = "Тентованный",
        detail = "Некие, очень важные детали заказа",
        paymentParam = "Наличные",
        telNumber = "322-223",
        name = "Иван Федорович Крузенштерн"
    ),

    Task(
        id = 2,
        cargoType = "Багаж",
        city = "Санкт_Петербург",
        date = "16.09.2023",
        time = "17:00",
        startPoint = "Сенная, 1",
        finishPoint = "Набережная Фонтанки, 47",
        bodyType = "Кабриолет",
        detail = "Диван, чемодан, саквояж, картина, корзина, картонка, и маленькая собачонка",
        paymentParam = "Наличные",
        telNumber = "123-456",
        name = "Самуил Яковлевич Маршак"
    ),

    Task(
        id = 3,
        cargoType = "Цветы",
        city = "Юрмала",
        date = "17.09.2023",
        time = "19:00",
        startPoint = "Ленина, 5",
        finishPoint = "Центральная, 17",
        bodyType = "Закрытый",
        detail = "Миллион алых роз",
        paymentParam = "Оплата картой",
        telNumber = "11-22-33",
        name = "Алла Борисовна Пугачева"
    ),

    Task(
        id = 4,
        cargoType = "Одежда",
        city = "Оренбург",
        date = "18.09.2023",
        time = "21:00",
        startPoint = "Московский проспект, 5",
        finishPoint = "Заречная, 17",
        bodyType = "Тентованный",
        detail = "Оренбургские пуховые платочки",
        paymentParam = "Наличными",
        telNumber = "555-55-55",
        name = "Иван Иванович Иванов"
    ),
)