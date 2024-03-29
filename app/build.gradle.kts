import org.gradle.api.JavaVersion.VERSION_17

plugins {
  alias(libs.plugins.androidApplication)
  alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
  namespace = "com.example.bottomnavtest"
  compileSdk = 34

  defaultConfig {
    applicationId = "com.example.bottomnavtest"
    minSdk = 24
    targetSdk = 33
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isMinifyEnabled = true
      isShrinkResources = true
      proguardFiles(getDefaultProguardFile(
        "proguard-android-optimize.txt"),
        "proguard-rules.pro")
      signingConfig = signingConfigs.getByName("debug")
    }
  }

  packagingOptions {
    resources {
      excludes += setOf("/META-INF/{AL2.0,LGPL2.1}", "META-INF/NOTICE.txt", "guardit4j.fin")
    }
    // Exclude these files

    //LoyalKit
    jniLibs.pickFirsts += setOf(
      "**/librsjni_androidx.so",
      "META-INF/androidx.*",
      "**/libRSSupport.so",
      "**/librsjni.so"
    )
  }

  compileOptions {
    sourceCompatibility = VERSION_17
    targetCompatibility = VERSION_17
  }

  kotlinOptions {
    jvmTarget = "17"
  }

  buildFeatures {
    viewBinding = true
  }
}

dependencies {

  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.appcompat)
  implementation(libs.material)
  implementation(libs.androidx.constraintlayout)
  implementation(libs.androidx.lifecycle.livedata.ktx)
  implementation(libs.androidx.lifecycle.viewmodel.ktx)
  implementation(libs.androidx.navigation.fragment.ktx)
  implementation(libs.androidx.navigation.ui.ktx)
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)
  implementation(libs.sdk.test)
}