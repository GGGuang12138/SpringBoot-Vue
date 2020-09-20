# SpringBoot-Vue
SpringBoot+Vue+Element UI，实现简单的前后端分离Demo。包括图书CURD功能
## 技术栈
- SpringBoot
- Vue
- Element UI
- Spring Data JPA
- MySQL
- lombok

## 数据库
```sql
DROP TABLE IF EXISTS `book`;
SET character_set_client = utf8mb4 ;
CREATE TABLE `book` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `publish` varchar(20) DEFAULT NULL,
  `pages` int(10) DEFAULT NULL,
  `price` float(10,2) DEFAULT NULL,
  `bookcaseid` int(10) DEFAULT NULL,
  `abled` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8;


LOCK TABLES `book` WRITE;
INSERT INTO `book` VALUES (1,'解忧杂货店','东野圭吾','电子工业出版社',102,27.30,9,1),(2,'追风筝的人','卡勒德·胡赛尼','中信出版社',330,26.00,1,1),(3,'人间失格','太宰治','作家出版社',150,17.30,1,1),(4,'这就是二十四节气','高春香','电子工业出版社',220,59.00,3,1),(5,'白夜行','东野圭吾','南海出版公司',300,27.30,4,1),(6,'摆渡人','克莱儿·麦克福尔','百花洲文艺出版社',225,22.80,1,1),(7,'暖暖心绘本','米拦弗特毕','湖南少儿出版社',168,131.60,5,1),(8,'天才在左疯子在右','高铭','北京联合出版公司',330,27.50,6,1),(9,'我们仨','杨绛','生活.读书.新知三联书店',89,17.20,7,1),(10,'活着','余华','作家出版社',100,100.00,6,1),(11,'水浒传','施耐庵','三联出版社',300,50.00,1,1),(12,'三国演义','罗贯中','三联出版社',300,50.00,2,1),(13,'红楼梦','曹雪芹','三联出版社',300,50.00,5,1),(14,'西游记','吴承恩','三联出版社',300,60.00,3,1);
UNLOCK TABLES;
```
## Vue
- 推荐使用vue ui创建项目，[参考博客](https://www.cnblogs.com/jing-zhe/p/12121071.html)
```
vue ui//创建项目
npm run serve//启动vue项目
vue add axios//安装ajax
```

## Element
#### 一、安装
```bash
npm install --save element-ui
npm i element-ui -S //两个都可，或vue ui中添加也可
```
```
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);
//在main.js中添加
```
#### 二、router动态自动构建左侧菜单

1、router/index.js添加全部目标界面的routes

```vue
{
    path: '/',
    name: '导航一',
    component: Index,
    children:[
      {
        path: '/pageOne',
        name: '选项1',
        component: PageOne
      },
      {
        path: '/pageTwo',
        name: '选项2',
        component: PageTwo
      },
    ]
  },
```

2、App.vue添加

```<router-view></router-view>//router-view区域，表示内容可以改变（由url决定、动态渲染）```

3、menu和router的绑定

```vue
<el-menu :default-openeds="['0', '1']" router>
  <el-menu-item v-for="(item2,index2) in item.children" :index="item2.path">// 根据index的内容更改路径
```

4、url改变，router-view区域根据url动态渲染


##### 补充：
- 下载代码后可将demo0文件单独复制到其他位置，再用IDE打开，用```npm run serve ```运行前端项目