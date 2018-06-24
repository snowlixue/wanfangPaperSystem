# wanfangPaperSystem
一款对万方论文条目进行智能推荐和生成关键词故事线的系统
博客：https://blog.csdn.net/dreamtheworld1/article/details/80793228

运行环境 tomcat8，java8，mysql 
开发环境 ecplise，navicat

使用方法：1.下载    链接：https://pan.baidu.com/s/18gYUdfdCnw0JOsJi8WKdYw 密码：wtnk 
         
          是我爬取好的一个万方论文数据库，已经经过数据清洗可以直接mysql导入使用。先让程序跑起来
          
          2.下载  链接：https://pan.baidu.com/s/1LsuyZDF6gh7A2JC945P1VQ 密码：w8jy
          
          是我用java的word2vec训练好的词向量，用来推荐相似论文，和生成故事线
          
          这里要要把Word2VECKeyWords.java文件里的
          
          try {
			w1.loadJavaModel("D:\\workspace\\eclipse-workspace\\cnki\\library\\AbstractVector") ;
		} catch (IOException e) {
    
    改成下载好的AbstractVector路径。
    
         
         3.关键词按钮是推荐相关内容的论文，这里使用hanlp提取关键词，使用Word2VEC查找相关词。
         所以需要下载hanlp的字典并放在hanlp提示的路径。hanlp的使用可以自行查找。
         
         
         4.关于论文爬取和词向量训练可以参照我的项目地址：https://github.com/snowlixue/wanFangSpider-dataPretreatment
           和博客：https://blog.csdn.net/dreamtheworld1/article/details/80634611
 
