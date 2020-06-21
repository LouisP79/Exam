# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable
# If you keep the line number information, uncomment this to
# hide the original source file name.
-renamesourcefileattribute SourceFile
# # -------------------------------------------
# #  ############### MODELS ###############
# # -------------------------------------------
-keepclassmembers class com.notbank.restServices.banks.model.** {*;}
-keepclassmembers class com.notbank.data.chikiLoan.model.** {*;}
-keepclassmembers class com.notbank.data.chikiLoan.request.** {*;}
-keepclassmembers class com.notbank.restServices.disposition.requests.** {*;}
-keepclassmembers class com.notbank.restServices.evaluation.requests.** {*;}
-keepclassmembers class com.notbank.restServices.exchange.model.** {*;}
-keepclassmembers class com.notbank.restServices.exchange.requests.** {*;}
-keepclassmembers class com.notbank.data.firebaseToken.requests.** {*;}
-keepclassmembers class com.notbank.restServices.history.model.** {*;}
-keepclassmembers class com.notbank.restServices.menu.model.** {*;}
-keepclassmembers class com.notbank.data.pos.model.** {*;}
-keepclassmembers class com.notbank.data.pos.request.** {*;}
-keepclassmembers class com.notbank.restServices.slider.model.** {*;}
-keepclassmembers class com.notbank.restServices.token.model.** {*;}
-keepclassmembers class com.notbank.restServices.user.model.** {*;}
-keepclassmembers class com.notbank.restServices.user.requests.** {*;}
# # -------------------------------------------
# #  ############### Glide ###############
# # -------------------------------------------
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
 **[] $VALUES;
 public *;
}
# # -------------------------------------------
# #  ############### Retrofit ###############
# # -------------------------------------------
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions

-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}
# # -------------------------------------------
# #  ############### Jackson ###############
# # -------------------------------------------
-keep class com.fasterxml.jackson.databind.ObjectMapper {
    public <methods>;
    protected <methods>;
}
-keep class com.fasterxml.jackson.databind.ObjectWriter {
    public * writeValueAsString(*);
}
# # -------------------------------------------
# #  ############### KOIN ###############
# # -------------------------------------------
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-verbose
# # -------------------------------------------
# #  ############### Okhttp3 ###############
# # -------------------------------------------
-keepattributes Signature
-keepattributes Annotation
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-dontwarn okhttp3.**
# # -------------------------------------------
# #  ############### Okio ###############
# # -------------------------------------------
-dontwarn org.codehaus.mojo.animal_sniffer.*
# # -------------------------------------------
# #  ############### RXKotlin ###############
# # -------------------------------------------
-keep class rx.schedulers.Schedulers {
     public static <methods>;
 }
 -keep class rx.schedulers.ImmediateScheduler {
     public <methods>;
 }
 -keep class rx.schedulers.TestScheduler {
     public <methods>;
 }
 -keep class rx.schedulers.Schedulers {
     public static ** test();
 }
