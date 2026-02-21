-keep class com.google.gson.annotations.** { *; }
-keep class com.google.gson.** { *; }
-keep class * extends com.google.gson.TypeAdapter { *; }
-keep class * implements com.google.gson.TypeAdapterFactory { *; }
-keep class * implements com.google.gson.JsonSerializer { *; }
-keep class * implements com.google.gson.JsonDeserializer { *; }

-dontwarn okio.**
-dontwarn com.google.errorprone.annotations.**
-dontwarn javax.annotation.**
