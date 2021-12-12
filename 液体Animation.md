Github地址:  

> https://github.com/Cuberto/liquid-swipe-android

## 例子

要运行示例项目，请克隆 repo，然后运行 `app`(必须有自己的github账号)

### As library

#### GitHub Packages

第 1 步：为 GitHub 生成个人访问令牌

- 在您的 GitHub 帐户中：
- 设置 -> 开发者设置 -> 个人访问令牌 -> 生成新令牌
- 确保选择以下范围（“read:packages”）并生成令牌
- 生成后确保复制您的新个人访问令牌。你再也看不到了！唯一的选择是生成一个新密钥。

第 2 步：存储您的 GitHub — 个人访问令牌详细信息

- 在你的 Android 根项目中创建一个 github.properties 文件
- 如果是公共存储库，请确保将此文件添加到 .gitignore 以保持令牌私有
- 添加属性 gpr.usr=GITHUB_USERID 和 gpr.key=PERSONAL_ACCESS_TOKEN
- 将 GITHUB_USERID 替换为个人/组织 Github 用户 ID，将 PERSONAL_ACCESS_TOKEN 替换为 #Step 1 中生成的令牌

第 3 步：更新应用程序模块内的 build.gradle

- 将以下代码添加到将使用库的 app 模块内的 build.gradle

```
    def githubProperties = new Properties()
    githubProperties.load(new FileInputStream(rootProject.file("github.properties")))
    repositories {
        maven {
            name = "GitHubPackages"

            url = uri("https://maven.pkg.github.com/Cuberto/liquid-swipe-android")
            credentials {
                /** Create github.properties in root project folder file with     
                ** gpr.usr=GITHUB_USER_ID & gpr.key=PERSONAL_ACCESS_TOKEN 
                ** Or set env variable GPR_USER & GPR_API_KEY if not adding a properties file**/
                username = githubProperties['gpr.usr'] ?: System.getenv("GPR_USER")
                password = githubProperties['gpr.key'] ?: System.getenv("GPR_API_KEY")
            }
        }
    }
```

- 在app模块的build.gradle的依赖里面，使用如下代码

```
  dependencies {
        //consume library
        implementation 'com.cuberto:liquid-swipe:1.0.0'
        implementation 'com.airbnb.android:lottie:4.2.2'
        implementation 'com.cuberto:liquid-swipe:1.0.0'
        implementation 'androidx.core:core-ktx:1.3.2'
    }
```

同步项目，现在您可以使用 flashytabbar 库

## 用法

将 LiquidPager 添加到您的 xml 并像使用 ViewPager 一样使用它

```
    <com.cuberto.liquid_swipe.LiquidPager
        android:id="@+id/pager"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```


