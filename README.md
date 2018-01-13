# MDReader
A simply markdown reader     
一个简洁、方便使用的 Markdown 浏览器    

### 一，概述    
仅仅是为方便个人需求而做的一个 App 😂。    
    
试了几款类似的可以浏览 Markdown 文档的App，有的界面不符合个人意思，有的不够方便，
既然自己也懂得点就班门弄斧搞了一个自己满意的 Markdown 浏览器 App。    
    
项目中是先使用 [markedj](https://github.com/gitbucket/markedj)（感谢😊）把 .md 文档解析为 Html 文本，再利用 WebView 进行展示。    
     
为了方便快速在各个不同文档之间进行切换浏览，使用了 [Intent.FLAG_ACTIVITY_NEW_DOCUMENT](https://developer.android.com/guide/components/recents.html) 
在同一 Activity 的多个实例以任务的形式显示在概览屏幕中（最近任务列表），类似 Google Docs 和微信小程序（和微信的实现方式不同，
微信是定义了5个不同进程不同任务栈的 Activity 进行加载，所以最多只能展示5个单独小程序后台卡片）。    
### 二，Screenshot     
![image](https://github.com/XYScience/MDReader/raw/master/screenshot/Markdown_Browser.gif)
