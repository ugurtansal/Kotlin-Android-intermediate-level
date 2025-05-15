package com.ugurtansal.kotlinandroidintermediate.context

class ContextNotes {

//    Context, Android’de "Ben şu anda hangi ortamda (sayfada, ekranda, bileşende) çalışıyorum?" bilgisini temsil eder.
//    Bir Activity içindeysen: this → o Activity'nin Context'idir.
//
//    Bir Fragment içindeysen: requireContext() → o Fragment’in bağlı olduğu Activity'nin Context'ini verir.
//
//    Uygulama genelinden işlem yapacaksan: applicationContext → tüm uygulamanın context'idir.



//    1. Application Context
//    Uygulama genelini temsil eder
//
//    Her yerden erişilebilir
//
//    Ömür boyu yaşar (uygulama kapanana kadar)
//
//    Activity’ye bağlı değildir, bu yüzden memory leak riski düşüktür
//
//    Genelde background işler ve singleton sınıflarda tercih edilir
//
//
//    2. Activity Context
//    Yalnızca ilgili Activity'e bağlıdır
//
//    Genellikle UI ile ilgili işlemlerde kullanılır (örn. Toast, AlertDialog)
//
//    Activity yok olursa Context de yok olur
//
//    Uygunsuz kullanılırsa memory leak olabilir (örneğin bir singleton sınıfta activity context tutulursa)
//
//
//
//    3. Fragment Context
//    Fragment’ta kullanılan context, bazen requireContext() veya context ile alınır
//
//    Genellikle hosting Activity’nin context’idir
//
//    Fragment yaşam döngüsüne göre dikkatli kullanılmalıdır
//
//
//
//    4. Service Context
//    Servislerde kullanılan context’tir
//
//    Service de bir Context sınıfından türediği için doğrudan this kullanılır
}