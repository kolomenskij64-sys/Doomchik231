package com.example.hd2wartracker
import android.widget.PopupWindow
import
private var centerPopup: PopupWindow? = null

private fun showCenteredPopup() {
    // 1. Инфлейтим layout
    val inflater = LayoutInflater.from()
    val popupView = inflater.inflate(R.layout.popup_center_scrollable, null)

    // 2. Получаем TextView и устанавливаем длинный текст
    val textView = popupView.findViewById<TextView>(R.id.tv_content)
    textView.text = """
        Это пример длинного текста внутри всплывающего окна.

        • PopupWindow можно настроить под любые задачи.
        • Он не является DialogFragment, но даёт больше контроля над позиционированием.
        • Чтобы текст прокручивался — его нужно обернуть в ScrollView.
        • Высота окна ограничена, поэтому длинные тексты не "вырвутся" за экран.

        Android позволяет легко управлять всплывающими элементами. 
        Главное — не забывать вызывать dismiss(), чтобы избежать утечек памяти.

        Попробуйте потянуть вниз — текст прокручивается! ✅
        А окно при этом остаётся по центру и не двигается.

        Ещё немного текста для демонстрации скролла...
        Строка 1
        Строка 2
        Строка 3
        Строка 4
        Строка 5
        Строка 6
        Строка 7
        Строка 8
        Строка 9
        Строка 10 — конец.
    """.trimIndent()

    // 3. Рассчитываем максимальную высоту: 80% от высоты экрана
    val displayMetrics = resources.displayMetrics
    val maxHeight = (displayMetrics.heightPixels * 0.8).toInt() // 80% высоты экрана
    val maxWidth = (displayMetrics.widthPixels * 0.9).toInt()  // 90% ширины (если нужно)

    // 4. Создаём PopupWindow
    centerPopup = PopupWindow(
        popupView,
        ViewGroup.LayoutParams.WRAP_CONTENT,   // ширина из layout (300dp)
        ViewGroup.LayoutParams.WRAP_CONTENT,   // высота — по содержимому, НО ограничим ниже
        true
    ).apply {
        isOutsideTouchable = true
        isFocusable = true
        elevation = 8f

        // 🔑 ВАЖНО: устанавливаем максимальную высоту ПОСЛЕ создания
        this.height = maxHeight // ← вот как ограничить высоту!
    }

    // 5. Обработчик кнопки "Понятно"
    popupView.findViewById<Button>(R.id.btn_close).setOnClickListener {
        centerPopup?.dismiss()
    }

    // 6. Показываем popup ПО ЦЕНТРУ экрана
    // Используем showAtLocation с Gravity.CENTER
    centerPopup?.showAtLocation(
        window.decorView,      // родительская View — декор всей активности
        Gravity.CENTER,
        0, 0                   // смещение по X и Y (в пикселях)
    )
}
class popup {
}