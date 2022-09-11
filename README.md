# wanted_preonboarding_android
## 팀 이름
학연지연우연인연

## App Architecture
<img src ="assets/architecture.png" width="400">

Android Developers에서 권장하는 앱 아키텍처 가이드를 따랐습니다.
* 관심사 분리 원칙에 따라 View(Activity/Fragment)에서는 UI와 클릭 이벤트와 같은 상호작용에 대한 처리를 진행하고, 그 외 View에서 처리하지 않아도 되는 로직들은 분리하였습니다.

---

### UI Layer
<img src ="assets/ui-layer.png" width="400">

UI Layer는 화면에 UI를 표시하는 역할과 사용자의 상호작용을 담당합니다. 

---

### Domain Layer
<img src ="assets/domain-layer.png" width="400">

Domain Layer는 ViewModel에서 사용되는 앱 비지니스 로직의 캡슐화된 클래스가 포함됩니다.

---

### Data Layer
<img src ="assets/data-layer.png" width="400">

Data Layer는 네트워크 작업 또는 데이터베이스 작업과 같은 데이터와 관련한 앱의 비지니스 로직이 포함됩니다. 


## Package Structure
```
├── data
│   ├── datasource
│   │   ├── local
│   │   │   ├── CategoryLocalDataSourceImpl.kt
│   │   │   └── SavedNewsLocalDataSourceImpl.kt
│   │   ├── remote
│   │   │   └── NewsRemoteDataSourceImpl.kt
│   │   └── source
│   │       ├── CategoryDataSource.kt
│   │       ├── NewsDataSource.kt
│   │       └── SavedNewsDataSource.kt
│   ├── db
│   │   ├── NewsDao.kt
│   │   └── NewsDatabase.kt
│   ├── mapper
│   │   └── NewsMapper.kt
│   ├── model
│   │   ├── Article.kt
│   │   ├── NewsCategory.kt
│   │   ├── NewsResponse.kt
│   │   ├── SavedNews.kt
│   │   └── Source.kt
│   ├── network
│   │   └── NewsService.kt
│   └── repository
│       ├── CategoryRepositoryImpl.kt
│       ├── NewsRepositoryImpl.kt
│       └── SavedNewsRepositoryImpl.kt
├── di
│   ├── DBModule.kt
│   ├── DataSourceModule.kt
│   ├── NetworkModule.kt
│   ├── RepositoryModule.kt
│   ├── UseCaseModule.kt
│   └── ViewModelModule.kt
├── domain
│   ├── model
│   │   └── News.kt
│   ├── repository
│   │   ├── CategoryRepository.kt
│   │   ├── NewsRepository.kt
│   │   └── SavedNewsRepository.kt
│   └── usecase
│       ├── DeleteHeadlineNewsUseCase.kt
│       ├── GetHeadlineNewsUseCase.kt
│       ├── GetNewsCategoryUseCase.kt
│       ├── GetSavedNewsUseCase.kt
│       └── SaveHeadlineNewsUseCase.kt
├── ui
│   ├── MainActivity.kt
│   ├── WantedApplication.kt
│   ├── category
│   │   ├── CategoryGroupFragment.kt
│   │   ├── CategoryNewsFragment.kt
│   │   ├── CategoryViewModel.kt
│   │   └── adapter
│   │       ├── CategoryAdapter.kt
│   │       └── CategoryNewsAdapter.kt
│   ├── common
│   │   ├── BindingAdapter.kt
│   │   ├── DateTimeUtil.kt
│   │   ├── ItemDiffCallback.kt
│   │   ├── NavigationUtil.kt
│   │   └── base
│   │       └── BaseFragment.kt
│   ├── news
│   │   ├── NewsAdapter.kt
│   │   ├── NewsFragment.kt
│   │   └── NewsViewModel.kt
│   ├── newsdetail
│   │   ├── NewsDetailFragment.kt
│   │   └── OriginNewsFragment.kt
│   └── save
│       ├── SaveNewsFragment.kt
│       ├── SavedNewsAdapter.kt
│       └── SavedViewModel.kt
└── util
    ├── Constants.kt
    ├── Event.kt
    ├── EventObserver.kt
    └── UiState.kt
```

## Library
|Architecture|Android App Architecture + AAC-ViewModel|
|---|---|
|DI|Koin|
|Network|OkHttp3, Retrofit2|
|Asynchronous Processing|Coroutine, Flow|
|Jetpack|Navigation, Room, Lifecycle, ViewModel, DataBinding|
|Third-Party|Timber, Glide, Gson|

<br>


## Simulation

https://user-images.githubusercontent.com/51078673/189527346-c479e78c-b410-48cd-9dca-4e4668912284.mov
