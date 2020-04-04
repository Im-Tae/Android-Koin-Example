### Android Koin Example

[koin](https://github.com/InsertKoinIO/koin)은 코틀린을 위한 의존성 관리 라이브러리이다.

Dagger2에 비해서 간단한 코드로 구성할 수 있다. </br>



- **module** : koin 모듈을 정의할 때 사용함
- **factory** : 객체를 가져올 Factory 패턴을 선언하며 inject할 때마다 새로운 객체를 가져오도록 함
- **single** : 앱이 살아있는 동안 전역적으로 사용 가능한 객체를 생성함
- **bind** : 생성할 객체를 다른 타입으로 바인딩하고 싶을 때 사용함
- **get** : 주입할 각 컴포넌트끼리의 의존성을 해결하기 위해 사용함. ( 타입 추론을 통해 컴포넌트 내에서 이미 생성된 객체를 참조하게 됨 )
- **androidContext** : Koin 모듈을 생성
- **scoped** : scope 내에서 단일 객체를 반환



</br></br>

### Koin 설정!



**Project build.gradle**

```kotlin
buildscript {
    ...
    ext.koin_version= "2.1.5"
    ...
}
```



**Module build.gradle**

```kotlin
dependencies {
    ...
    // Koin AndroidX Scope feature
    implementation "org.koin:koin-androidx-scope:$koin_version"

    // Koin AndroidX ViewModel feature
    implementation "org.koin:koin-androidx-viewmodel:$koin_version"

    // Koin AndroidX Fragment Factory (unstable version)
    implementation "org.koin:koin-androidx-fragment:$koin_version"
}

```

</br></br>



### Android Koin 시작!



모든 안드로이드 클래스에서

```kotlin
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                appModule
            )
        }
    }
}
```

androidContext() 함수를 사용해서 context를 주입한다.

modules에서는 모듈을 주입한다. </br>



**appModule 코드**

```kotlin
val appModule = module {

    factory<MainContract.Presenter> { 
        (view: MainContract.View) -> MainPresenter(view) 
    }
}
```

</br>



**AndroidManifest에서 아래와 같이 추가해준다.**

```kotlin
<application
        android:name=".di.MyApplication"
        ...
    </application>
```

</br>



**Activity, Fragment, Service에서 공통으로 쓰이는 KoinComponents 구성 요소이다.**

```kotlin
class MainActivity : BaseActivity(), MainContract.View {

    override val presenter : MainContract.Presenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
```

