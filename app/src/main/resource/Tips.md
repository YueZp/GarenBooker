## 1.沉浸式状态栏
#### 利用Translucent System Bar的特性：
1.主要的操作都在style.xml 和 AndroidManifest.xml 中，Activity里面没有任何涉及到Translucent System Bar设置的代码;
2.要在Activity中使用 Translucent System Bar 特性，首先需要到AndroidManifest中为指定的Activity设置Theme。
但是需要注意的是，我们不能直接在values/style.xml直接去自定义 Translucet System Bar 的Theme，因为该特性兼容 Android 4.4 以上的平台，所以直接在values/style.xml声明引入，工程会报错。
建议采取的方法：建立多个SDK版本的values文件夹，系统会根据SDK的版本选择合适的Theme进行设置。如：values、values-v19、values-v21
values-v21 的存在是因为在Android 5.x需要把statusBarColor颜色设置透明，否则导航栏会呈现系统默认的浅灰色;
3.在Activity的布局文件中 要在根布局里添加属性：android:fitsSystemWindows="true"



## 零碎知识点：
1.继承AppCompatActivity，样式的话也必须使用它的子类样式，否则报错！eg>: Theme.AppCompat...