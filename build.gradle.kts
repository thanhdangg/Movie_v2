plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("com.google.dagger.hilt.android") version "2.52" apply false
    id("com.apollographql.apollo") version "4.1.0" apply false
}